/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPerisistencia;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Salvatierra
 */
public class Controladora {
    
    ControladoraPerisistencia controlPersis = new ControladoraPerisistencia();

    public void crearUsuario(String nombreE, String apellidoE, String dniE, String cargoE, String direccionE, String fechaE, String user, String pass) {
        
        Empleado empleado = new Empleado();
        Date fecha = Date.valueOf(fechaE);
        empleado.setFechaNEmpleado(fecha);
        empleado.setApellido(apellidoE);
        empleado.setDireccion(direccionE);
        empleado.setNombre(nombreE);
        empleado.setCargo(cargoE);
        empleado.setDni(dniE);
        controlPersis.empleAlta(empleado);
        Usuario usuE = new Usuario();
        usuE.setEmpleadoU(empleado);
        usuE.setNombreUsuario(user);
        usuE.setContraseña(pass);
        controlPersis.usuAlta(usuE);
    }

    public boolean verificarUser(String usuarioE, String contraE) {
         List<Usuario>listaUser = controlPersis.RecogerUsuarios();
        if (listaUser != null) {
            for(Usuario usus : listaUser){
                if(usus.getNombreUsuario().equals(usuarioE)&& usus.getContraseña().equals(contraE)){
                    return true;
                }
            }
               
        } 
        return false;
    }

    public void altaReserva(String nombre, String apellido, String direccion, String profesion, String fechaN, String dni, String fechaE, String fechaI, String tipoH, String pisoH, String tematicaH, String precio, String cantidadP, String fechaVenta, String openSession) throws ParseException {
        
            Huesped huesped = new Huesped();
            huesped.setApellido(apellido);
            huesped.setDireccion(direccion);
            huesped.setDni(dni);
            huesped.setNombre(nombre);
            huesped.setProfesion(profesion);
            java.util.Date fechaNH = new SimpleDateFormat("yyyy-MM-dd").parse(fechaN);
            huesped.setFechaNHuesped(fechaNH);
            controlPersis.altaHuesped(huesped);
            
            Habitacion cuarto = new Habitacion();
            cuarto.setNombreTematica(tematicaH);
            cuarto.setCantidadPersonas(cantidadP);
            cuarto.setPrecio(precio);
            cuarto.setPiso(pisoH);
            cuarto.setTipo(tipoH);
            controlPersis.altaHabi(cuarto);

            Usuario myUsu = controlPersis.traerUsarios(openSession);
            Reserva res = new Reserva();
            res.setUsurioR(myUsu);
            res.setHuespeR(huesped);
            res.setHabitacionR(cuarto);
            java.util.Date fechaC = new SimpleDateFormat("yyyy-MM-dd").parse(fechaVenta);
            res.setFechaCarga(fechaC);
            java.util.Date fechaIn = new SimpleDateFormat("yyyy-MM-dd").parse(fechaI);
            res.setFechaIngreso(fechaIn);
            java.util.Date fechaEg = new SimpleDateFormat("yyyy-MM-dd").parse(fechaE);
            res.setFechaEgreso(fechaEg);
            controlPersis.resAlta(res);
    }
    
     public List<Huesped>resgisHuesped(){
        return controlPersis.listaHuesped();
    }
    public List<Reserva> traerReservas() {
        return controlPersis.traerR();
    }

    public List<Reserva> reservasEncontradas(String fechaC) {
        List<Reserva>listaReservas = traerReservas();
        List<Reserva>resEncontrada = new ArrayList<>();
        for (Reserva reserva : listaReservas) {
           String fechaCarga = String.format("%1$tY-%1$tm-%1$td", reserva.getFechaCarga());
            if (fechaCarga.equals(fechaC)) {
                resEncontrada.add(reserva);
            }
        }    
        return resEncontrada;
    }

    public int buscarEmpleado(String dni) {
        int id = 0;
       List<Empleado>listaEmpleados = controlPersis.traerEmpleados(); 
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDni().equals(dni)) {
                
                id = empleado.getId_empleado();
            }
        }
        return id;
    }

    public List<Reserva> reservasEmpleados(int id) {
        List<Reserva>reservasEmpleado = new ArrayList<>();
        List<Reserva>listaRes = traerReservas();
        for (Reserva reserva : listaRes) {
            if (reserva.getUsurioR().getEmpleadoU().getId_empleado() == id) {
                
                reservasEmpleado.add(reserva);
                
            }
        }
        return reservasEmpleado;
    }

    public Empleado explorarEmpleado(int id) {
         return controlPersis.explorarEmpleado(id);
    }

    public void modificarEmpleado(Empleado emple) {
         controlPersis.modificarEmpleado(emple);
    }

     public List<Empleado> traerEmpleados(){
        return controlPersis.traerEmpleados();
    }

    public List<Reserva> reservasPeriodo(String fechaDesde, String fechaHasta) {
        List<Reserva>reservasPeriodo = traerReservas();
        List<Reserva>reservaPeriodo = new ArrayList<>();
        Date fechaD = Date.valueOf(fechaDesde);
        Date fechaH = Date.valueOf(fechaHasta);
        for(Reserva reserva : reservaPeriodo) {
            if ((reserva.getFechaCarga().after(fechaD)|| reserva.getFechaCarga().equals(fechaD))&& (reserva.getFechaCarga().before(fechaH)||reserva.getFechaCarga().equals(fechaH))) {
                reservaPeriodo.add(reserva);
            }
        }
        return reservasPeriodo;
    }

    public void borrarEmpleado(int id) {
        controlPersis.borrarEmpleado(id);
    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public List<Usuario> traerUsuario() {
        return controlPersis.traerUsuario();
    }

    public Usuario explorarUsuario(int id) {
        return controlPersis.explorarUsuario(id);
    }

    public void modificarUsuario(Usuario usu) {
        controlPersis.modificarUsuario(usu);
    }

 }
    
