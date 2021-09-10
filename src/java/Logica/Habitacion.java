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

/**
 *
 * @author Victor Salvatierra
 */
@Entity
public class Habitacion implements Serializable {
    
     //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_habitacion;
    @Basic
    private String nombreTematica;
    private String tipo;
    private String piso;
    private String precio;
    private String cantidadPersonas;
    
    @OneToMany
    List<Reserva>reservaHabitacion = new ArrayList<>();

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, String nombreTematica, String tipo, String piso, String precio, String cantidadPersonas) {
        this.id_habitacion = id_habitacion;
        this.nombreTematica = nombreTematica;
        this.tipo = tipo;
        this.piso = piso;
        this.precio = precio;
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getNombreTematica() {
        return nombreTematica;
    }

    public void setNombreTematica(String nombreTematica) {
        this.nombreTematica = nombreTematica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(String cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public List<Reserva> getReservaHabitacion() {
        return reservaHabitacion;
    }

    public void setReservaHabitacion(List<Reserva> reservaHabitacion) {
        this.reservaHabitacion = reservaHabitacion;
    }
    
    
}
