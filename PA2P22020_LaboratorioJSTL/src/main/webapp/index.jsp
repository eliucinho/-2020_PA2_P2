<%-- 
    Document   : index
    Created on : 26 jun 2020, 20:06:24
    Author     : pccinho
--%>

<%@page import="hn.uth.pa2.app.controladores.indexController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PA2</title>
    </head>
    <body>
        <h1>Introducción a JSP</h1>
        <% 
            indexController ic=new indexController();
            
            String saludo="hola PA2";
        %>
        
        <p><%=saludo%></p>
        <a href="http://localhost:8080/PA2P22020_LaboratorioJSTL/controladorEmpleadoPrincipal?accion=listar">Ir a listar empleados (absoluta)</a>
        <br>
        <a href="controladorEmpleadoPrincipal?accion=listar">Ir a listar empleados (relativa)</a>
        <br>
        <a href="paginas/nuevoVehiculo.jsp">nuevo vehiculo</a>
        <% 
            out.println("Saludo desde codigo java: "+saludo);
            
            out.print(ic.getTablaVehiculos());
        %>
    </body>
</html>
