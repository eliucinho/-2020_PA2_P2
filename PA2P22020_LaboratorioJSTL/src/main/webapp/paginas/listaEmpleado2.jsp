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
        <h1>Consulta Empleado 2!</h1>
        <p class="msgError"><c:out value="${msgError}"></c:out></p>
        <p class="msgExito"><c:out value="${msgExito}"></c:out></p>

        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Fecha Nacimiento</th>
                    <th>Fecha Contratación</th>
                    <th>Consultar</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="empleadoTmp" items="${listaEmpleado}">
                <tr>
                    <td><c:out value="${empleadoTmp.nombre}"></c:out>  </td>
                    <td><c:out value="${empleadoTmp.apellido}"></c:out></td>
                    <td><c:out value="${empleadoTmp.fechaNacimiento}"></c:out></td>
                    <td><c:out value="${empleadoTmp.fechaContratacion}"></c:out></td>
                    <td><a href=\"controladorEmpleado2Servlet?accion=consultar&codigoEmpleado=<c:out value="${empleadoTmp.codigoEmpleado}"></c:out>"> consultar</a></td>
                </tr>
            </c:forEach>
                
            </tbody>
        </table>

        <a href="../index.jsp">Ir a inicio</a><br>
        <!--a href="paginas/actualizarVehiculo.jsp">Actualizar</a><br-->
        <!--a href="controladorPrincipal?accion=eliminar&placa=">Eliminar</a><br-->
    </body>
</html>
