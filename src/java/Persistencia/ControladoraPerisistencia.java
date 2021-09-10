/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Salvatierra
 */
public class ControladoraPerisistencia {
    
    //Instacias jpaController
    
    EmpleadoJpaController jpaEmpleado = new EmpleadoJpaController();
    HabitacionJpaController jpaHabitacion = new HabitacionJpaController();
    HuespedJpaController jpaHuesped = new HuespedJpaController();
    ReservaJpaController jpaReserva = new ReservaJpaController();
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();

    public void empleAlta(Empleado empleado) {
        jpaEmpleado.create(empleado);
    }

    public void usuAlta(Usuario usuE) {
        jpaUsuario.create(usuE);
    }

    public List<Usuario> RecogerUsuarios() {
        return jpaUsuario.findUsuarioEntities();
    }

    public void altaHuesped(Huesped huesped) {
        jpaHuesped.create(huesped);
    }

    public void altaHabi(Habitacion cuarto) {
        jpaHabitacion.create(cuarto);
    }

    public Usuario traerUsarios(String openSession) {
         List<Usuario> myList = jpaUsuario.findUsuarioEntities();
        for (Usuario usuario1 : myList) {
            if (usuario1.getNombreUsuario().equals(openSession)) {
                return usuario1;
            }
        }return null;  
    }

    public void resAlta(Reserva res) {
        jpaReserva.create(res);
    }

    public List<Huesped> listaHuesped() {
         List<Huesped>listHuesped = jpaHuesped.findHuespedEntities();
        return listHuesped;
    }

    public List<Reserva> traerR() {
         return jpaReserva.findReservaEntities();
    }

    public List<Empleado> traerEmpleados() {
         return jpaEmpleado.findEmpleadoEntities();
    }

    public void modificarEmpleado(Empleado emple) {
        
        try {
            jpaEmpleado.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPerisistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public Empleado explorarEmpleado(int id) {
        return jpaEmpleado.findEmpleado(id);
    }

    public void borrarEmpleado(int id) {
        try {
            jpaEmpleado.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPerisistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUsuario(int id) {
        try {
            jpaUsuario.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPerisistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> traerUsuario() {
        return jpaUsuario.findUsuarioEntities();
    }

    public Usuario explorarUsuario(int id) {
        return jpaUsuario.findUsuario(id);
    }

    public void modificarUsuario(Usuario usu) {
        try {
            jpaUsuario.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPerisistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
