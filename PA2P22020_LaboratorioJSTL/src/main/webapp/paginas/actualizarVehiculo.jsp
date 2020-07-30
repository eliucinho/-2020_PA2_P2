<%-- 
    Document   : nuevoVehiculo
    Created on : 3 jul 2020, 19:35:35
    Author     : pccinho
--%>

<%@page import="hn.uth.pa2.app.entidades.Vehiculos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualizar!</h1>
        <form action="../controladorPrincipal" method="GET">
            <input type="text"  name="accion" value="actualizar" hidden="true"/>
            <%Vehiculos vehiculo=(Vehiculos)request.getSession().getAttribute("vehiculo"); %>
            placa: <input type="text"  name="placa" value="<%=vehiculo.getPlaca()%>" /><br>
            marca: <input type="text"  name="marca" value="<%=vehiculo.getMarca()%>" /><br>
            modelo: <input type="text" name="modelo" value="<%=vehiculo.getModelo()%>" /><br>
            duenio: <input type="text" name="duenio" value="<%=vehiculo.getIdDuenio()%>" /><br>
            
            <input type="submit" value="guardar cambios" />
            <a href="../index.jsp">Ir a inicio</a><br>
         </form>
    </body>
</html>
