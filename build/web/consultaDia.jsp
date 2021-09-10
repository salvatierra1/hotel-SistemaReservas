<%-- 
    Document   : consultaDia
    Created on : 08/08/2021, 10:37:57
    Author     : Victor Salvatierra
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Reserva"%>
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
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Fecha de carga</th>
                        <th scope="col">Fecha de ingreso</th>
                        <th scope="col">Fecha de egreso</th>
                        
                    </tr>
            </thead>
                     <tbody>
          <%
              String fechaRe = (String) session.getAttribute("fechaCarga");
              List<Reserva>encontradaRes = (List) session.getAttribute("encontradas");
              for (Reserva reserva : encontradaRes) {     
          %>
                    <tr>
                    <td><%= reserva.getHuespeR().getNombre()%></td> 
                     <td><%= reserva.getHuespeR().getApellido() %></td>
                      <td><%= reserva.getFechaCarga() %></td> 
                      <td><%= reserva.getFechaIngreso() %></td> 
                      <td><%= reserva.getFechaEgreso() %></td> 
                    </tr>
          <%
             }  
          %>
            
          </tbody>
            </table>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    </body>
</html>

