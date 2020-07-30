/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controladores;

import hn.uth.pa2.app.entidades.Empleado2;
import hn.uth.pa2.app.entidades.Vehiculos;
import hn.uth.pa2.app.repositorios.Empleado2Repositorio;
import hn.uth.pa2.app.repositorios.Repositorio;
import hn.uth.pa2.app.repositorios.VehiculoRepositorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "controladorEmpleadoPrincipal", urlPatterns = {"/controladorEmpleadoPrincipal"})
public class controladorEmpleadoPrincipal extends HttpServlet {

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
        try {
            String accion=request.getParameter("accion");
            String codigoEmpleado=request.getParameter("codigoEmpleado");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String fechaNacimiento=request.getParameter("fechaNacimiento");
            String fechaContratacion=request.getParameter("fechaContratacion");


            if (accion.equals(servletConfiguracion.ACCION_LISTAR)) {
                Empleado2Repositorio vr = new Empleado2Repositorio();
                List<Empleado2> listaEmpleados = vr.buscarTodo();

                request.setAttribute("listaEmpleado", listaEmpleados);
                
                ir(request, response, "paginas/listaEmpleado2.jsp");
            }
        } catch (Exception ex) {
            //Logger.getLogger(controladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
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
