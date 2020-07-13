<%-- 
    Document   : consultaEmpleado
    Created on : 10 jul 2020, 19:37:04
    Author     : pccinho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta Empleado!</h1>
        
        <input type="text"  name="accion" value="nuevo" hidden="true"/>
        Codigo Empleado: <input type="text"  name="placa" value="<c:out value="${empleado.codigoEmpleado}"></c:out>" /><br>
        nombre: <input type="text"  name="marca" value="<c:out value="${empleado.nombre}"></c:out>" /><br>
        apellido: <input type="text" name="modelo" value="<c:out value="${empleado.apellido}"></c:out>" /><br>

        <a href="../index.jsp">Ir a inicio</a><br>
        <!--a href="paginas/actualizarVehiculo.jsp">Actualizar</a><br-->
        <!--a href="controladorPrincipal?accion=eliminar&placa=">Eliminar</a><br-->
    </body>
</html>
