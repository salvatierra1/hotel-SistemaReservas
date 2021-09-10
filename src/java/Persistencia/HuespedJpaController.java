/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Huesped;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Reserva;
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
public class HuespedJpaController implements Serializable {

    public HuespedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public HuespedJpaController(){
         emf = Persistence.createEntityManagerFactory("salvatierra_VictorFinalPU");
     }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Huesped huesped) {
        if (huesped.getReservaHuesped() == null) {
            huesped.setReservaHuesped(new ArrayList<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Reserva> attachedReservaHuesped = new ArrayList<Reserva>();
            for (Reserva reservaHuespedReservaToAttach : huesped.getReservaHuesped()) {
                reservaHuespedReservaToAttach = em.getReference(reservaHuespedReservaToAttach.getClass(), reservaHuespedReservaToAttach.getId_reserva());
                attachedReservaHuesped.add(reservaHuespedReservaToAttach);
            }
            huesped.setReservaHuesped(attachedReservaHuesped);
            em.persist(huesped);
            for (Reserva reservaHuespedReserva : huesped.getReservaHuesped()) {
                Huesped oldHuespeROfReservaHuespedReserva = reservaHuespedReserva.getHuespeR();
                reservaHuespedReserva.setHuespeR(huesped);
                reservaHuespedReserva = em.merge(reservaHuespedReserva);
                if (oldHuespeROfReservaHuespedReserva != null) {
                    oldHuespeROfReservaHuespedReserva.getReservaHuesped().remove(reservaHuespedReserva);
                    oldHuespeROfReservaHuespedReserva = em.merge(oldHuespeROfReservaHuespedReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Huesped huesped) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huesped persistentHuesped = em.find(Huesped.class, huesped.getId_huespede());
            List<Reserva> reservaHuespedOld = persistentHuesped.getReservaHuesped();
            List<Reserva> reservaHuespedNew = huesped.getReservaHuesped();
            List<Reserva> attachedReservaHuespedNew = new ArrayList<Reserva>();
            for (Reserva reservaHuespedNewReservaToAttach : reservaHuespedNew) {
                reservaHuespedNewReservaToAttach = em.getReference(reservaHuespedNewReservaToAttach.getClass(), reservaHuespedNewReservaToAttach.getId_reserva());
                attachedReservaHuespedNew.add(reservaHuespedNewReservaToAttach);
            }
            reservaHuespedNew = attachedReservaHuespedNew;
            huesped.setReservaHuesped(reservaHuespedNew);
            huesped = em.merge(huesped);
            for (Reserva reservaHuespedOldReserva : reservaHuespedOld) {
                if (!reservaHuespedNew.contains(reservaHuespedOldReserva)) {
                    reservaHuespedOldReserva.setHuespeR(null);
                    reservaHuespedOldReserva = em.merge(reservaHuespedOldReserva);
                }
            }
            for (Reserva reservaHuespedNewReserva : reservaHuespedNew) {
                if (!reservaHuespedOld.contains(reservaHuespedNewReserva)) {
                    Huesped oldHuespeROfReservaHuespedNewReserva = reservaHuespedNewReserva.getHuespeR();
                    reservaHuespedNewReserva.setHuespeR(huesped);
                    reservaHuespedNewReserva = em.merge(reservaHuespedNewReserva);
                    if (oldHuespeROfReservaHuespedNewReserva != null && !oldHuespeROfReservaHuespedNewReserva.equals(huesped)) {
                        oldHuespeROfReservaHuespedNewReserva.getReservaHuesped().remove(reservaHuespedNewReserva);
                        oldHuespeROfReservaHuespedNewReserva = em.merge(oldHuespeROfReservaHuespedNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = huesped.getId_huespede();
                if (findHuesped(id) == null) {
                    throw new NonexistentEntityException("The huesped with id " + id + " no longer exists.");
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
            Huesped huesped;
            try {
                huesped = em.getReference(Huesped.class, id);
                huesped.getId_huespede();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The huesped with id " + id + " no longer exists.", enfe);
            }
            List<Reserva> reservaHuesped = huesped.getReservaHuesped();
            for (Reserva reservaHuespedReserva : reservaHuesped) {
                reservaHuespedReserva.setHuespeR(null);
                reservaHuespedReserva = em.merge(reservaHuespedReserva);
            }
            em.remove(huesped);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Huesped> findHuespedEntities() {
        return findHuespedEntities(true, -1, -1);
    }

    public List<Huesped> findHuespedEntities(int maxResults, int firstResult) {
        return findHuespedEntities(false, maxResults, firstResult);
    }

    private List<Huesped> findHuespedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Huesped.class));
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

    public Huesped findHuesped(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Huesped.class, id);
        } finally {
            em.close();
        }
    }

    public int getHuespedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Huesped> rt = cq.from(Huesped.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
