<%-- 
    Document   : reservasPeriodo
    Created on : 09/08/2021, 18:12:05
    Author     : Victor Salvatierra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas periodo</title>
    </head>
    <body>
        <br>
            <form class="rxd" action="svPeriodo" method="POST">
                 <h3>Reservas durante un periodo</h3>
                <div class="carga">
                   <p>Desde: <input name="desdeR" type="date" id="desdeR" placeholder="dd/mm/yyyy"></p>
                </div>
                 <div class="carga">
                   <p>Hasta: <input name="hastaR" type="date" id="hastaR" placeholder="dd/mm/yyyy"></p>
                </div>
                 <div class="res">
                     <input class="btn btn-primary" type="submit" value="Buscar">  
                </div>
            </form>
         <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    </body>
</html>
