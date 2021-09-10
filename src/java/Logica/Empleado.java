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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Victor Salvatierra
 */
@Entity
public class Empleado implements Serializable {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_empleado;
    @Basic
    private String nombre;
    private String apellido;
    private String direccion;
    private String cargo;
    private String dni;
    @Temporal(TemporalType.DATE)
    private Date fechaNEmpleado;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String apellido, String direccion, String cargo, String dni, Date fechaNEmpleado) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cargo = cargo;
        this.dni = dni;
        this.fechaNEmpleado = fechaNEmpleado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNEmpleado() {
        return fechaNEmpleado;
    }

    public void setFechaNEmpleado(Date fechaNEmpleado) {
        this.fechaNEmpleado = fechaNEmpleado;
    }
    
    
    
}
