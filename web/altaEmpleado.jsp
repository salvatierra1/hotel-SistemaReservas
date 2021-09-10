<%-- 
    Document   : altaEmpleado
    Created on : 08/08/2021, 09:13:23
    Author     : Victor Salvatierra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link  href="altaEmple/styleEm.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Empleado</title>
    </head>
        <body>
       
        <form name="cargaEmpleados" id="entre" action="svEmpleado" method="POST">
            
            <div class="caja" style="background: ghostwhite">       
                <h3>Alta Empleados</h3>
                <div class="carga">
                    <p>Nombre: <input name="nombre" type="text" id="nombre" placeholder="Nombre..."></p>
                </div>
                <div class="carga">
                    <p>Apellido: <input name="apellido" type="text" id="apellido" placeholder="Apellido..."></p>
                </div>
                <div class="carga">
                   <p> DNI: <input name="dni" type="text" id="dni" placeholder="DNI..."></p>
                </div>
                 <div class="carga">
                   <p> Direccion:  <input name="direccion" type="text" id="direccion" placeholder="Direccion..."></p>
                </div>
                 <div class="carga">
                   <p> Cargo: <input name="cargo" type="text" id="cargo" placeholder="Cargo..."></p>
                </div>
                <div class="carga">
                   <p> Fecha Nacimiento: <input name="fechaNE" type="date" id="fechaNacimiento" placeholder="Fecha Nac..."></p>
                </div>
                <div class="carga">
                   <p>User:  <input name="usuario" type="text" id="fechaNacimiento" placeholder="Usuario..."></p>
                </div>
                 <div class="carga">
                   <p>Contraseña:  <input name="contra" type="password" id="fechaNacimiento" placeholder="Contraseña..."></p>
                </div>
                <div class="carga">
                    <input type="submit" value="Guardar"  class="btn btn-primary" > 
                </div>
            </div>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    </body>
</html>
