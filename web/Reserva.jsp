<%-- 
    Document   : Reserva
    Created on : 08/08/2021, 09:55:26
    Author     : Victor Salvatierra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
    </head>
    <body>
 
        <form name="cargaEmpleados" id="entre" action="svReserva" method="POST">
         <div class="container " style="background:ghostwhite"> 
             <div class="row">
                 <h3>Cliente</h3>
                <div class="col-4">
                    <p>Nombre:<input name="nombreH" type="text" id="nombre" placeholder="Nombre..."></p>
                </div>
                <div class="col-4">
                    <p>Apellido:<input name="apellidoH" type="text" id="apellido" placeholder="Apellido..."></p>
                </div>
                <div class="col-4">
                   <p>DNI:<input name="dniH" type="text" id="dni" placeholder="DNI..."></p>
                </div>
                <div class="col-4">
                   <p>Direccion:<input name="direccionH" type="text" id="direccion" placeholder="Direccion..."></p>
                </div>
                <div class="col-4">
                   <p>Profesion: <input name="profesionH" type="text" id="profesion" placeholder="Profesion..."></p>
                </div> 
                <div class="col-4">
                   <p>Fecha Nacimiento: <input name="fechaNH" type="date" id="fechaNacimiento" placeholder="dd/mm/yyyy"></p>
                </div>
               </div>
             <div class="row">
                 <h3>Fecha</h3>
                <div class="col-2">
                   <p> Fecha Ingreso:<input name="fechaIngresoH" type="date" id="fechaIngreso" placeholder="dd/mm/yyyy"></p>
                </div>
                <div class="col-2">
                   <p> Fecha Egreso:<input name="fechaEgresoH" type="date" id="fechaEgreso" placeholder="dd/mm/yyyy"></p>
                </div>
             </div>
                 
             <div class="text-justify">
                <h3>Habitacion</h3>
                <div class="col-3 text-left">
                <p>Tematica: <select name="tematica"></p>
                                    <option>-</option->
                                    <option>Marvis</option>
                                    <option>Monvis</option>
                              </select>
                </div> 
                <div class="col-3">
                <p>Tipo:<select name="tipo"></p>
                                    <option>-</option->
                                    <option>Single</option>
                                    <option>Doble</option>
                                    <option>Triple</option>
                                    <option>Cuatriple</option>
                      </select>
                </div> 
                <div class="col-6">
                <p>Piso:<select name="piso"></p>
                                    <option>-</option->
                                    <option>1°</option>
                        </select>
                </div> 
                <div class="col-6">
                <p>Cantidad Personas:<select name="cantidad"></p>
                                    <option>S-1</option->
                                    <option>D-2</option>
                                    <option>T-3</option>
                                    <option>C-5</option>
                        </select>
                </div>
                <div class="col-6">
                <p>Precio por noches:<select name="precio"></p>
                                    <option>$1200</option->
                                    <option>$2300</option>
                                    <option>$3600</option>
                                    <option>$5600</option>
                        </select>
                </div>
                <div class="col-5">
                   <p> Fecha carga: <input name="fechaCarga" type="date" id="fechaEgreso" placeholder="dd/mm/yyyy"></p>
                </div>

                <div class="">
                    <input type="submit" value="Guardar" class="btn btn-primary" > 
                </div>
           
             </div>
        </form>
        </div>
        
            <br>
            <div class="text-left" style="column-count: 2" style="background: ghostwhite">
                <div class="col-5 text-center">
                    <a class="btn btn-outline-success" href="registroHuesped.jsp">Ver huespedes</a>  
                </div>
                <br>
                <div class="col-5 text-center">
                    <a class="btn btn-outline-dark" href="reservaDia.jsp">Reservas del dia</a>  
                </div>
                <br>
                <div class="col-5 text-center">
                     <a class="btn btn-outline-danger" href="reservasPeriodo.jsp">Reservas periodo</a>  
                </div>
                <br>
                <div class="col-5">
                     <a class="btn btn-outline-danger" href="consultaReservaEmpleado.jsp">Reservas empleado</a>  
                </div>  
                <br>
               <div class="col-5">
                    <form action="svBuscarE" method="GET">
                         <a class="btn btn-outline-primary" href="svBuscarE">Empleados</a>  
                    </form>
                </div>
                
             </div>    
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </body>
</html>
