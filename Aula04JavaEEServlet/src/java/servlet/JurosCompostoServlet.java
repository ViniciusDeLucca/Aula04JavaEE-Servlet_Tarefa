/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinic
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juros-composto.html"})
public class JurosCompostoServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JurosSimplesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>JavaEE</h1>");
            out.println("<h2>Servlets</h2>");
            out.println("<h3>Juros Composto</h3>");
            DecimalFormat df = new DecimalFormat("###,##0.00");
            DecimalFormat dff = new DecimalFormat("###,##0");
            try {
                
                double jcp = Double.parseDouble(request.getParameter("jcp"));
                out.println("<h4><b>Valor presente</b>: R$"+(df.format(jcp))+"</h4>");
                double jc = Double.parseDouble(request.getParameter("jc"));
                out.println("<h4><b>Juros</b>: "+jc+"%</h4>");
                double jcm = Double.parseDouble(request.getParameter("jcm"));
                out.println("<h4><b>Meses</b>: "+(dff.format(jcm))+"</h4>");
                out.println("<hr>");
                double jcfinal = (jc/100);
                double periodo = Math.pow((1+jcfinal), jcm);
                double vlf = (jcp*periodo);
                out.println("<h4><b>Valor futuro</b>: R$"+(df.format(vlf))+"</h4>");
            } catch (Exception ex) {
                out.println("<p style='color:red'>"+ex.getMessage()+"</p>");
            }
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
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
