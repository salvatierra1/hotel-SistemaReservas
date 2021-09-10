/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Victor Salvatierra
 */
@Entity
public class Huesped implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_huespede;
    @Basic
    private String nombre;
    private String apellido; 
    private String dni;
    private String direccion;
    private String profesion;
    @Temporal(TemporalType.DATE)
    private Date fechaNHuesped;
    
    @OneToMany
    List<Reserva>reservaHuesped = new ArrayList<>();

    public Huesped() {
    }

    public Huesped(int id_huespede, String nombre, String apellido, String dni, String direccion, String profesion, Date fechaNHuesped) {
        this.id_huespede = id_huespede;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.profesion = profesion;
        this.fechaNHuesped = fechaNHuesped;
    }

    public int getId_huespede() {
        return id_huespede;
    }

    public void setId_huespede(int id_huespede) {
        this.id_huespede = id_huespede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Date getFechaNHuesped() {
        return fechaNHuesped;
    }

    public void setFechaNHuesped(Date fechaNHuesped) {
        this.fechaNHuesped = fechaNHuesped;
    }

    public List<Reserva> getReservaHuesped() {
        return reservaHuesped;
    }

    public void setReservaHuesped(List<Reserva> reservaHuesped) {
        this.reservaHuesped = reservaHuesped;
    }
    
    
}
