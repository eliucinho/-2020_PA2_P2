/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controladores;

import hn.uth.pa2.app.entidades.Empleado2;
import hn.uth.pa2.app.repositorios.Empleado2Repositorio;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pccinho
 */
@WebServlet(name = "controladorEmpleado2Servlet", urlPatterns = {"/controladorEmpleado2Servlet"})
public class controladorEmpleado2Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String fechaNacimiento=request.getParameter("fechaNacimiento");
        String fechaContratacion=request.getParameter("fechaContratacion");
        
        Empleado2Repositorio er=new Empleado2Repositorio();
        int secuencia = -2;
       
        try {
            secuencia = er.getSecuencia();
            Date fechaNacimientoDate=new SimpleDateFormat("yyyy-mm-dd").parse(fechaNacimiento);
            int fechaContratacionInteger=Integer.parseInt(fechaContratacion.replaceAll("-", ""));
            
            Empleado2 empleadoNuevo=new Empleado2(secuencia, nombre, apellido,fechaNacimientoDate, fechaContratacionInteger);
            er.crear(empleadoNuevo);
            
            request.setAttribute("empleado", empleadoNuevo);
            request.setAttribute("msgExito", "Registro Agregado Exitosamente!!");
            ir(request, response, "paginas/consultaEmpleado2.jsp");
        } catch (Exception ex) {
            request.setAttribute("msgError", "Error al almacenarlo: "+ex.toString());
            ir(request, response, "paginas/nuevoEmpleado2.jsp");
        }
    }
    private void ir(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher despachador = request.getRequestDispatcher(url);
        despachador.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
