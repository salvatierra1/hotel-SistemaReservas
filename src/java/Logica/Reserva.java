/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author Victor Salvatierra
 */
@Entity
public class Reserva implements Serializable {
    
     //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_reserva;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Temporal(TemporalType.DATE)
    private Date fechaEgreso;
    @Temporal(TemporalType.DATE)
    private Date fechaCarga;
    
    @OneToOne
    Huesped huespeR;
    @OneToOne
    Usuario usurioR;
    @OneToOne
    Habitacion habitacionR;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date fechaIngreso, Date fechaEgreso, Date fechaCarga, Huesped huespeR, Usuario usurioR, Habitacion habitacionR) {
        this.id_reserva = id_reserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.fechaCarga = fechaCarga;
        this.huespeR = huespeR;
        this.usurioR = usurioR;
        this.habitacionR = habitacionR;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Huesped getHuespeR() {
        return huespeR;
    }

    public void setHuespeR(Huesped huespeR) {
        this.huespeR = huespeR;
    }

    public Usuario getUsurioR() {
        return usurioR;
    }

    public void setUsurioR(Usuario usurioR) {
        this.usurioR = usurioR;
    }

    public Habitacion getHabitacionR() {
        return habitacionR;
    }

    public void setHabitacionR(Habitacion habitacionR) {
        this.habitacionR = habitacionR;
    }
    
    
}
