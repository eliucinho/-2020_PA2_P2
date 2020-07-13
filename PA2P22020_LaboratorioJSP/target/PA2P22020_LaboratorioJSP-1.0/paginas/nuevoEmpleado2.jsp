<%-- 
    Document   : nuevoVehiculo
    Created on : 3 jul 2020, 19:35:35
    Author     : pccinho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .msgError{
                background-color: red;
                color: yellow;
            }
            .msgExito{
                background-color: green;
                color: black;
            }
        </style>
    </head>
    <body>
        <h1>Nuevo Empleado 2!</h1>
        <p class="msgError"><c:out value="${msgError}"></c:out></p>
        <p class="msgExito"><c:out value="${msgExito}"></c:out></p>
        <form action="../controladorEmpleado2Servlet" method="GET">
            <input type="text"  name="accion" value="nuevo" hidden="true"/>
            Nombre: <input type="text"  name="nombre" value="" /><br>
            Apellido: <input type="text"  name="apellido" value="" /><br>
            Fecha Nacimiento: <input type="date" name="fechaNacimiento" value="" /><br>
            Fecha Contratacion: <input type="date" name="fechaContratacion" value="" /><br>
            <input type="submit" value="enviar" name="enviar" />
        </form>
    </body>
</html>
