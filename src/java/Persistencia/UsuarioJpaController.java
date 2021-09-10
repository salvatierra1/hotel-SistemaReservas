/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor Salvatierra
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public UsuarioJpaController(){
         emf = Persistence.createEntityManagerFactory("salvatierra_VictorFinalPU");
     }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getReservaUser() == null) {
            usuario.setReservaUser(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Reserva> attachedReservaUser = new ArrayList<Reserva>();
            for (Reserva reservaUserReservaToAttach : usuario.getReservaUser()) {
                reservaUserReservaToAttach = em.getReference(reservaUserReservaToAttach.getClass(), reservaUserReservaToAttach.getId_reserva());
                attachedReservaUser.add(reservaUserReservaToAttach);
            }
            usuario.setReservaUser(attachedReservaUser);
            em.persist(usuario);
            for (Reserva reservaUserReserva : usuario.getReservaUser()) {
                Usuario oldUsurioROfReservaUserReserva = reservaUserReserva.getUsurioR();
                reservaUserReserva.setUsurioR(usuario);
                reservaUserReserva = em.merge(reservaUserReserva);
                if (oldUsurioROfReservaUserReserva != null) {
                    oldUsurioROfReservaUserReserva.getReservaUser().remove(reservaUserReserva);
                    oldUsurioROfReservaUserReserva = em.merge(oldUsurioROfReservaUserReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId_usuario());
            List<Reserva> reservaUserOld = persistentUsuario.getReservaUser();
            List<Reserva> reservaUserNew = usuario.getReservaUser();
            List<Reserva> attachedReservaUserNew = new ArrayList<Reserva>();
            for (Reserva reservaUserNewReservaToAttach : reservaUserNew) {
                reservaUserNewReservaToAttach = em.getReference(reservaUserNewReservaToAttach.getClass(), reservaUserNewReservaToAttach.getId_reserva());
                attachedReservaUserNew.add(reservaUserNewReservaToAttach);
            }
            reservaUserNew = attachedReservaUserNew;
            usuario.setReservaUser(reservaUserNew);
            usuario = em.merge(usuario);
            for (Reserva reservaUserOldReserva : reservaUserOld) {
                if (!reservaUserNew.contains(reservaUserOldReserva)) {
                    reservaUserOldReserva.setUsurioR(null);
                    reservaUserOldReserva = em.merge(reservaUserOldReserva);
                }
            }
            for (Reserva reservaUserNewReserva : reservaUserNew) {
                if (!reservaUserOld.contains(reservaUserNewReserva)) {
                    Usuario oldUsurioROfReservaUserNewReserva = reservaUserNewReserva.getUsurioR();
                    reservaUserNewReserva.setUsurioR(usuario);
                    reservaUserNewReserva = em.merge(reservaUserNewReserva);
                    if (oldUsurioROfReservaUserNewReserva != null && !oldUsurioROfReservaUserNewReserva.equals(usuario)) {
                        oldUsurioROfReservaUserNewReserva.getReservaUser().remove(reservaUserNewReserva);
                        oldUsurioROfReservaUserNewReserva = em.merge(oldUsurioROfReservaUserNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuario.getId_usuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId_usuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Reserva> reservaUser = usuario.getReservaUser();
            for (Reserva reservaUserReserva : reservaUser) {
                reservaUserReserva.setUsurioR(null);
                reservaUserReserva = em.merge(reservaUserReserva);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
