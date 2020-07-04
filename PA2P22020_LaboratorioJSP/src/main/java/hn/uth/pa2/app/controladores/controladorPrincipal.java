/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controladores;

import hn.uth.pa2.app.entidades.Vehiculos;
import hn.uth.pa2.app.repositorios.VehiculoRepositorio;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "controladorPrincipal", urlPatterns = {"/controladorPrincipal"})
public class controladorPrincipal extends HttpServlet {

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
            String accion = request.getParameter("accion");
            String placa = request.getParameter("placa");
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String duenio = request.getParameter("duenio");

            Vehiculos vehiculoDTO = getVehiculosDTO(placa, marca, modelo, duenio);

            if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                VehiculoRepositorio vr = new VehiculoRepositorio();
                vr.crear(vehiculoDTO);

                ir(request, response, "index.jsp");
            }
            
            if (accion.equals(servletConfiguracion.ACCION_CONSULTAR)) {

                VehiculoRepositorio vr = new VehiculoRepositorio();
                Vehiculos vehiculoConsultado = vr.buscar(vehiculoDTO.getPlaca());
                request.getSession().setAttribute("vehiculo", vehiculoConsultado);
                //request.getSession().setAttribute("codigoError", 0);
                //request.getSession().setAttribute("mensajeError", "Error al generar registro");
                ir(request, response, "paginas/consultaVehiculo.jsp");
            }
            if (accion.equals(servletConfiguracion.ACCION_ELIMINAR)) {

                VehiculoRepositorio vr = new VehiculoRepositorio();
                vr.eliminar(vehiculoDTO);

                ir(request, response, "index.jsp");
            }
            if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR)) {

                VehiculoRepositorio vr = new VehiculoRepositorio();
                vr.actualizar(vehiculoDTO);
                request.getSession().setAttribute("vehiculo", vehiculoDTO);
                ir(request, response, "paginas/consultaVehiculo.jsp");
            }
        } catch (Exception ex) {
            //Logger.getLogger(controladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private Vehiculos getVehiculosDTO(String placa, String marca, String modelo, String duenio) {
        Vehiculos vehiculoDTO = new Vehiculos(placa);
        vehiculoDTO.setMarca(marca);
        vehiculoDTO.setModelo(modelo);
        if (duenio!=null) {
            vehiculoDTO.setIdDuenio(Integer.parseInt(duenio));
        }
        
        return vehiculoDTO;
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
