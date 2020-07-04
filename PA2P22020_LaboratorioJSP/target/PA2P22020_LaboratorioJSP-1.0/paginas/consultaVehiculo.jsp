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
        <h1>Consulta!</h1>
            <input type="text"  name="accion" value="nuevo" hidden="true"/>
            <%Vehiculos vehiculo=(Vehiculos)request.getSession().getAttribute("vehiculo"); %>
            placa: <input type="text"  name="placa" value="<%=vehiculo.getPlaca()%>" /><br>
            marca: <input type="text"  name="marca" value="<%=vehiculo.getMarca()%>" /><br>
            modelo: <input type="text" name="modelo" value="<%=vehiculo.getModelo()%>" /><br>
            duenio: <input type="text" name="modelo" value="<%=vehiculo.getIdDuenio()%>" /><br>
            
            <a href="../index.jsp">Ir a inicio</a><br>
            <a href="paginas/actualizarVehiculo.jsp">Actualizar</a><br>
            <a href="controladorPrincipal?accion=eliminar&placa=<%=vehiculo.getPlaca()%>">Eliminar</a><br>
    </body>
</html>
