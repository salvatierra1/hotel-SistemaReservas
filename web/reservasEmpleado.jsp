<%-- 
    Document   : reservasEmpleado
    Created on : 09/08/2021, 09:49:22
    Author     : Victor Salvatierra
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <!DOCTYPE html>
<html>
    <head>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
    </head>
    <body>
            <table class="table table-dark table-striped">
            <thead>
                    <tr>
                        <th scope="col">Fecha Carga</th>
                        <th scope="col">Fecha Ingreso</th>
                        <th scope="col">Fecha Egreso</th>
                        <th scope="col">Nombre Huesped</th>
                        
                    </tr>
            </thead>
                     <tbody>
            <%
            List<Reserva>listaRes = (List)session.getAttribute("lisRes");
           
            for (Reserva reserva : listaRes) {
                    
                %>
                <tr>
                <td><%= reserva.getFechaCarga() %></td>
                <td><%= reserva.getFechaIngreso() %></td>
                <td><%= reserva.getFechaEgreso() %></td>
                <td><%= reserva.getHuespeR().getNombre()%></td>
                </tr>
                <%
                }
                %>
            </tbody>
            </table>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        </body>
</html>

    </body>
</html>
