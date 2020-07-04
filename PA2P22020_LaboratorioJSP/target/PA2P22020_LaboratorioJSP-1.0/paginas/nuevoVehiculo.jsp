<%-- 
    Document   : nuevoVehiculo
    Created on : 3 jul 2020, 19:35:35
    Author     : pccinho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Vehiculo!</h1>
        <form action="../controladorPrincipal" method="GET">
            <input type="text"  name="accion" value="nuevo" hidden="true"/>
            placa: <input type="text"  name="placa" value="" /><br>
            marca: <input type="text"  name="marca" value="" /><br>
            modelo: <input type="text" name="modelo" value="" /><br>
            duenio: 
            <select name="duenio">
                <option value="1">Flores</option>
                <option value="2">DIMASA</option>
            </select><br>
            <input type="submit" value="enviar" name="enviar" />
        </form>
    </body>
</html>
