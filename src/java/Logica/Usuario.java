/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Victor Salvatierra
 */
@Entity
public class Usuario implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_usuario;
    @Basic
    private String nombreUsuario;
    private String contraseña;
    @OneToOne
    Empleado empleadoU;
    @OneToMany
    List<Reserva> reservaUser = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombreUsuario, String contraseña, Empleado empleadoU) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.empleadoU = empleadoU;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Empleado getEmpleadoU() {
        return empleadoU;
    }

    public void setEmpleadoU(Empleado empleadoU) {
        this.empleadoU = empleadoU;
    }

    public List<Reserva> getReservaUser() {
        return reservaUser;
    }

    public void setReservaUser(List<Reserva> reservaUser) {
        this.reservaUser = reservaUser;
    }
    
    
}
