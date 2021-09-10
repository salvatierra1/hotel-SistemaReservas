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
import Logica.Huesped;
import Logica.Usuario;
import Logica.Habitacion;
import Logica.Reserva;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor Salvatierra
 */
public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ReservaJpaController(){
         emf = Persistence.createEntityManagerFactory("salvatierra_VictorFinalPU");
     }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Huesped huespeR = reserva.getHuespeR();
            if (huespeR != null) {
                huespeR = em.getReference(huespeR.getClass(), huespeR.getId_huespede());
                reserva.setHuespeR(huespeR);
            }
            Usuario usurioR = reserva.getUsurioR();
            if (usurioR != null) {
                usurioR = em.getReference(usurioR.getClass(), usurioR.getId_usuario());
                reserva.setUsurioR(usurioR);
            }
            Habitacion habitacionR = reserva.getHabitacionR();
            if (habitacionR != null) {
                habitacionR = em.getReference(habitacionR.getClass(), habitacionR.getId_habitacion());
                reserva.setHabitacionR(habitacionR);
            }
            em.persist(reserva);
            if (huespeR != null) {
                huespeR.getReservaHuesped().add(reserva);
                huespeR = em.merge(huespeR);
            }
            if (usurioR != null) {
                usurioR.getReservaUser().add(reserva);
                usurioR = em.merge(usurioR);
            }
            if (habitacionR != null) {
                habitacionR.getReservaHabitacion().add(reserva);
                habitacionR = em.merge(habitacionR);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getId_reserva());
            Huesped huespeROld = persistentReserva.getHuespeR();
            Huesped huespeRNew = reserva.getHuespeR();
            Usuario usurioROld = persistentReserva.getUsurioR();
            Usuario usurioRNew = reserva.getUsurioR();
            Habitacion habitacionROld = persistentReserva.getHabitacionR();
            Habitacion habitacionRNew = reserva.getHabitacionR();
            if (huespeRNew != null) {
                huespeRNew = em.getReference(huespeRNew.getClass(), huespeRNew.getId_huespede());
                reserva.setHuespeR(huespeRNew);
            }
            if (usurioRNew != null) {
                usurioRNew = em.getReference(usurioRNew.getClass(), usurioRNew.getId_usuario());
                reserva.setUsurioR(usurioRNew);
            }
            if (habitacionRNew != null) {
                habitacionRNew = em.getReference(habitacionRNew.getClass(), habitacionRNew.getId_habitacion());
                reserva.setHabitacionR(habitacionRNew);
            }
            reserva = em.merge(reserva);
            if (huespeROld != null && !huespeROld.equals(huespeRNew)) {
                huespeROld.getReservaHuesped().remove(reserva);
                huespeROld = em.merge(huespeROld);
            }
            if (huespeRNew != null && !huespeRNew.equals(huespeROld)) {
                huespeRNew.getReservaHuesped().add(reserva);
                huespeRNew = em.merge(huespeRNew);
            }
            if (usurioROld != null && !usurioROld.equals(usurioRNew)) {
                usurioROld.getReservaUser().remove(reserva);
                usurioROld = em.merge(usurioROld);
            }
            if (usurioRNew != null && !usurioRNew.equals(usurioROld)) {
                usurioRNew.getReservaUser().add(reserva);
                usurioRNew = em.merge(usurioRNew);
            }
            if (habitacionROld != null && !habitacionROld.equals(habitacionRNew)) {
                habitacionROld.getReservaHabitacion().remove(reserva);
                habitacionROld = em.merge(habitacionROld);
            }
            if (habitacionRNew != null && !habitacionRNew.equals(habitacionROld)) {
                habitacionRNew.getReservaHabitacion().add(reserva);
                habitacionRNew = em.merge(habitacionRNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = reserva.getId_reserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
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
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getId_reserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Huesped huespeR = reserva.getHuespeR();
            if (huespeR != null) {
                huespeR.getReservaHuesped().remove(reserva);
                huespeR = em.merge(huespeR);
            }
            Usuario usurioR = reserva.getUsurioR();
            if (usurioR != null) {
                usurioR.getReservaUser().remove(reserva);
                usurioR = em.merge(usurioR);
            }
            Habitacion habitacionR = reserva.getHabitacionR();
            if (habitacionR != null) {
                habitacionR.getReservaHabitacion().remove(reserva);
                habitacionR = em.merge(habitacionR);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
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

    public Reserva findReserva(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
