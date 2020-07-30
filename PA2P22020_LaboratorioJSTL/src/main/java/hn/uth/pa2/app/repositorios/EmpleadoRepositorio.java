/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.repositorios;

import hn.uth.pa2.app.entidades.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author pccinho
 */
public class EmpleadoRepositorio implements Repositorio<Empleado> {

    public Connection getConnection() throws Exception {
        try {
            String lib = "jdbc";
            String base = "derby";
            String servidor = "localhost";
            String puerto = "1527";
            String nombreBase = "uth";

            //String cadenaConexion="jdbc:derby://localhost:1527/uth";
            String cadenaConexion = String.format("%s:%s://%s:%s/%s", lib, base, servidor, puerto, nombreBase
            );
            String usuario = "uth";
            String contrasenia = "uth";

            return DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión: " + e.toString());
        }
    }

    public int getSecuencia() throws Exception {
        int valorRetorno = -1;
        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "select MAX(CODIGO_EMPLEADO)+1 SECUENCIA from EMPLEADOS ";

            Statement st = cnx.createStatement();

            //ejecuta la sentencia
            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int secuencia = resultado.getInt("SECUENCIA");
                valorRetorno = secuencia;
            }

            //IMPORTANTE:  cerrar sesiones
            st.close();
            cnx.close();

        } catch (Exception e) {
            throw new Exception("Error al calcular secuencia: " + e.toString());
        }
        return valorRetorno;
    }


    @Override
    public void crear(Empleado t) throws Exception {
        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "INSERT INTO EMPLEADOS(CODIGO_EMPLEADO, NOMBRE,APELLIDO) "
                    + " VALUES "
                    + "(?,?,?) ";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getCodigoEmpleado());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());

            //ejecuta la sentencia
            ps.execute();

            //IMPORTANTE:  cerrar sesiones
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void eliminar(Empleado t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Empleado t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado buscar(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> buscarTodo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
