/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Base_Datos;
import Modelo.Datos_Basicos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class Estudiantes extends HttpServlet {
            
    
            Base_Datos bd=new Base_Datos();
            Datos_Basicos db;
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
       
        RequestDispatcher dispatcher;
        
        try (PrintWriter out = response.getWriter()) {
            
            
            
            String userName= request.getParameter("Nombre");
            String userLastName= request.getParameter("Apellido");
            String userPromedio= request.getParameter("Promedio");
            String userGenero= request.getParameter("Sexo");
            
            if (userName !=null && !userName.equalsIgnoreCase("") && userLastName !=null && !userLastName.equalsIgnoreCase("") 
                    && userGenero !=null && userPromedio !=null && !userPromedio.equalsIgnoreCase("")) {
                db=new Datos_Basicos(userName,userLastName,userPromedio,userGenero);
                bd.agregar(db);
//                out.println(bd.toString());
                response.sendRedirect("Portada.html");
//                dispatcher = getServletContext().getRequestDispatcher("Portada.html");
//                dispatcher.forward(request, response);/*redireccionamineto*/
            }else{
                response.sendRedirect("Estudiantes.html");
//                dispatcher = getServletContext().getRequestDispatcher("Estudiantes.html");
//                dispatcher.forward(request, response);/*redireccionamineto*/
                
            }
                
                
            
         
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
