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
        <% 
            out.println("Saludo desde codigo java: "+saludo);
            
            out.print(ic.getTablaVehiculos());
        %>
    </body>
</html>
