/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author agustkd96
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("user");
        String contra = request.getParameter("pass");
        MessageDigest md;
        byte []digest = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(contra.getBytes());
            digest = md.digest();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext= bigInt.toString(16);
        while (hashtext.length()<32) {
            hashtext="0"+hashtext;
        }
        
        Consultas co = new Consultas();
        
        if(co.autenticacion(usuario, hashtext)){
            HttpSession objsesion= request.getSession(true);
            objsesion.setAttribute("usuario", usuario);
            //Para agregar un nuevo atributo se tiene que iniciar otra conexion a la db por que si no devuelve NULL, no c pork
            Consultas co2= new Consultas();
            String tipo = co2.getIDyTipo(usuario);
            objsesion.setAttribute("tipo",tipo);
            
            Consultas co3= new Consultas();
            String idtipo= co3.getIDTipo_Empleado(usuario);
            objsesion.setAttribute("idtipo", idtipo);
            response.getWriter().write(usuario);
            response.sendRedirect("index.jsp");
        }else
            response.sendRedirect("login.jsp");
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
