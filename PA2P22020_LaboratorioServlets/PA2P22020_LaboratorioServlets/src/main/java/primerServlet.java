/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pccinho
 */
@WebServlet(urlPatterns = {"/primerServlet"})
public class primerServlet extends HttpServlet {

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
        
        String saludo=request.getParameter("saludo");
        System.out.println("Valor de la variable: "+saludo);
        
        Enumeration<String> listaEncabezados = request.getHeaderNames();
        Enumeration<String> listaParametros = request.getParameterNames();
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PA2-20200626</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+saludo+"</h1>");
            
            out.println("<h2>Lista de encabezados</h2>");
            while(listaEncabezados.hasMoreElements()){
                out.println("<p>"+listaEncabezados.nextElement()+"</p>");
            }
            
            out.println("<h2>Lista de parametros</h2>");
            while(listaParametros.hasMoreElements()){
                out.println("<p>"+listaParametros.nextElement()+"</p>");
            }
            
            out.println("<h2>Información General</h2>");
            out.println("<p>"+request.getContextPath()+"</p>");
            out.println("<p>"+request.getLocalAddr()+"</p>");
            out.println("<p>"+request.getLocalName()+"</p>");
            out.println("<p>"+request.getLocalPort()+"</p>");
            out.println("<p>"+request.getMethod()+"</p>");
            out.println("<p>"+request.getRemoteAddr()+"</p>");
            out.println("<p>"+request.getRemoteHost()+"</p>");
            out.println("<p>"+request.getRemoteUser()+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
