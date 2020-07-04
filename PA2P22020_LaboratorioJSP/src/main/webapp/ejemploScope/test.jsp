<%-- 
    Document   : test
    Created on : 3 jul 2020, 17:56:37
    Author     : pccinho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scope Test</title>
    </head>
    <%
        //Scope Request
        String saludo = request.getParameter("saludo");
        String saludoGeneral = request.getParameter("saludoGeneral");

        //Scope Session
        //almacenar
        request.getSession().setAttribute("saludo", saludo);

        //Scope Applicacion
        getServletContext().setAttribute("saludoGeneral", saludoGeneral);
        
    %>
    <body>
        <h1>Prueba de Variables Test</h1>
        <h2>Nombre: <%=request.getParameter("nombre")%></h2>
        <h2>Apellido: <%=request.getParameter("apellido")%></h2>

        <h2>Saludo: <%=request.getSession().getAttribute("saludo")%></h2> 
        <h2>Saludo General: <%=getServletContext().getAttribute("saludoGeneral")%></h2>
    
        <a href="verVariables.jsp" >ir a ver variables</a>
        <a href="index.jsp" >ir formulario</a>
    </body>
</html>
