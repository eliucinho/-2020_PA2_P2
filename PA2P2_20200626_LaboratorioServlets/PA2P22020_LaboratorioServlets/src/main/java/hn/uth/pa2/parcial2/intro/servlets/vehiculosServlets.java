/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.intro.servlets;

import hn.uth.pa2.parcial2.intro.objetos.Vehiculo;
import hn.uth.pa2.parcial2.intro.repositorios.VehiculoRepositorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pccinho
 */
@WebServlet(name = "vehiculosServlets", urlPatterns = {"/vehiculosServlets"})
public class vehiculosServlets extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String placa = request.getParameter("placa");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String idDuenio = request.getParameter("duenio");

        VehiculoRepositorio vr = new VehiculoRepositorio();

        try {
            vr.crear(new Vehiculo(placa, marca, modelo, Integer.parseInt(idDuenio)));
        } catch (Exception ex) {
            Logger.getLogger(vehiculosServlets.class.getName()).log(Level.SEVERE, null, ex);
        }

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vehiculosServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vehiculosServlets at " + request.getContextPath() + "</h1>");
            List<Vehiculo> listaVehiculo = vr.buscarTodo();

            out.println("<table>");
            out.println("<th>");
            out.println("<td>Placa</td>");
            out.println("<td>Marca</td>");
            out.println("<td>Modelo</td>");
            out.println("<td>Id Dueño</td>");
            out.println("</th>");
            for (Vehiculo tmp : listaVehiculo) {
                out.println("<tr>");
                out.println("<td>" + tmp.getPlaca() + "</td>");
                out.println("<td>" + tmp.getMarca() + "</td>");
                out.println("<td>" + tmp.getModelo() + "</td>");
                out.println("<td>" + tmp.getId_duenio() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
            response.sendError(201);
        } catch (Exception ex) {
            Logger.getLogger(vehiculosServlets.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        //response.sendRedirect("primerServlet");
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
