<%-- 
    Document   : verEmpleado
    Created on : 09/08/2021, 15:48:33
    Author     : Victor Salvatierra
--%>


<%@page import="java.sql.Date"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table class="table table-dark table-striped">
            <thead>
                    <tr>
                        <th class="cell100 column2">Persona</th>
                        <th class="cell100 column3">Direccion</th>
                        <th class="cell100 column4">Dni</th>
                         <th class="cell100 column5">Eliminar</th>
                        <th class="cell100 column6">Eliminar</th>
                        <th class="cell100 column7">Editar</th>
                    </tr>
            </thead>
            <tbody>
                <%  HttpSession misession = request.getSession();
                    List<Empleado>listaEmpleado = (List) request.getSession().getAttribute("listaEmpleado");
                    for (Empleado emple : listaEmpleado) {  
                %>    
                <tr class="row100 body">
                        <%String nombreComp = emple.getNombre() + " " + emple.getApellido();%>
                        <td class="cell100 column2"><%= nombreComp%></td>
                        <%String direccion = emple.getDireccion(); %>
                        <td class="cell100 column3"><%= direccion%></td>
                        <%String dni = emple.getDni(); %>
                        <td class="cell100 column4"><%= dni%></td>
                        <%String cargo = emple.getCargo(); %>
                        <td class="cell100 column5"><%= cargo%></td>
                        
                       
                        <%int id = emple.getId_empleado();%>
                        
                        <td class="cell100 column5">
                            <form class="cell100 column5" name="borrarEmpleado" action="svEliminar" method="post" style="display: inline">
                                <input type="hidden" name="id" value="<%=id%>">
                                <button type="submit" class="btn btn-danger btn-xs" date-title="Delete" style="display:inline">Eliminar</button>
                            </form>
                        </td>
                        
                        <td class="cell100 column6">
                            <form class="cell100 column6" name="borrarModificar" action="svModificar" method="post" style="display: inline">
                                <input type="hidden" name="id" value="<%=id%>">
                                <button type="submit" class="btn btn-primary" date-title="Edit" style="display:inline">Modificar</button>
                            </form>
                        </td>
                    </tr>
                <%
                   }%>
                
            </tbody>
        </table>
       <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    </body>
</html>
