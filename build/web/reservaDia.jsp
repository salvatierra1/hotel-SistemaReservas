<%-- 
    Document   : reservaDia
    Created on : 08/08/2021, 10:32:47
    Author     : Victor Salvatierra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas dia</title>
    </head>
    <body>
        <br>
            <form class="rxd" action="reservaPorDia" method="POST">
                <div class="carga">
                    <h3>Buscar Reservas por dia</h3>
                   <p> Ingrese día: <input name="reservaDia" type="date" id="fechaR" placeholder="dd/mm/yyyy"></p>
                </div>
                 <div class="res">
                     <input class="btn btn-primary" type="submit" value="Buscar">  
                </div>
            </form>
         <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    </body>
</html>