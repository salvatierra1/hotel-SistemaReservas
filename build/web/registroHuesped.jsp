<%-- 
    Document   : registroHuesped
    Created on : 08/08/2021, 10:23:58
    Author     : Victor Salvatierra
--%>

<%@page import="Logica.Huesped"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Huesped</title>
    </head>
    <body>
            <table class="table table-dark table-striped">
            <thead>
                    <tr>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">APELLIDO</th>
                        <th scope="col">DNI</th>
                        <th scope="col">DIRECCION</th>
                        <th scope="col">PROFESION</th>
                        <th scope="col">FECHA.NAC</th>
                    </tr>
            </thead>
                     <tbody>
    
                    <%
                        Controladora control = new Controladora();
                        List<Huesped>listHuesped = control.resgisHuesped();
                        for (Huesped hue :listHuesped) {
                    %>
                <tr>
                    <td><%= hue.getNombre() %></td>
                    <td><%= hue.getApellido() %></td>
                    <td><%= hue.getDni() %></td>
                    <td><%= hue.getDireccion() %></td> 
                    <td><%= hue.getProfesion() %></td> 
                    <td><%= hue.getFechaNHuesped() %></td> 
                </tr>
                    <%
                       
                          
                         }
                     %>
                </tbody>
              </table>
                
                
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    </body>
</html>
