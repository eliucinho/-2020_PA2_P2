<%-- 
    Document   : index
    Created on : 3 jul 2020, 17:51:05
    Author     : pccinho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scope Variables</title>
    </head>
    <%
        //Scope Session
        //almacenar
        //request.getSession().setAttribute("saludo", "");
    %>
    <body>
        <h1>Prueba de Variables</h1>
        <h2>Nombre: <%=request.getParameter("nombre")%></h2>
        <h2>Apellido: <%=request.getParameter("apellido")%></h2>
        <h2>Saludo: <%=request.getSession().getAttribute("saludo")%></h2>
        <form action="test.jsp" method="POST">
            <input type="text" name="nombre" value="" />
            <input type="text" name="apellido" value="" />
            <input type="text" name="saludo" value="" />
            <input type="text" name="saludoGeneral" value="" />
            <input type="submit" value="enviar" name="enviar" />
        </form>
        
        <a href="verVariables.jsp" >ir a ver variables</a>
    </body>
</html>
