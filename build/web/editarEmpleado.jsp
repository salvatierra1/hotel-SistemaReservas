<%-- 
    Document   : editarEmpleado
    Created on : 09/08/2021, 15:57:06
    Author     : Victor Salvatierra
--%>

<%@page import="Logica.Usuario"%>
<%@page import="Logica.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="cargaEmpleados" id="entre" action="svModificar" method="get">
            <%
               HttpSession misession = request.getSession();
               Empleado emple = (Empleado) misession.getAttribute("empleados");
   {%>
         <div class="carga"> 
             <h2>Cliente</h2>
                <div class="carga">
                    <p> Nombre:<input name="nombreH" type="text" id="nombre" placeholder="Nombre..." value="<%=emple.getNombre()%>"></p>
                </div>
                <div class="carga">
                    <p>Apellido: <input name="apellidoH" type="text" id="apellido" placeholder="Apellido..." value="<%=emple.getApellido() %>"></p>
                </div>
                <div class="carga">
                    <p>Dni: <input name="dniH" type="text" id="dni" placeholder="dni..." value="<%=emple.getDni() %>"></p>
                </div>
                <div class="carga">
                    <p>Direccion: <input name="direccionH" type="text" id="direccion" placeholder="direccion..." value="<%=emple.getDireccion() %>"></p>
                </div>
                <div class="carga">
                    <p>Cargo: <input name="cargoH" type="text" id="cargo" placeholder="cargo..." value="<%=emple.getCargo() %>"></p>
                </div>
                <div class="carga">
                    <p>Fecha nacimiento: <input name="fechaH" type="date" id="fecha" placeholder="fecha..." value="<%=emple.getFechaNEmpleado() %>"></p>
                </div>
                
                <input type="hidden" name="id" value="<%=emple.getId_empleado()%>">
                <button class="btn btn-primary" type="submit">Modificar</button>
                    <%}%>
               </form>
    </body>
</html>