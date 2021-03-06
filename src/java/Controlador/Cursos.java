/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Base_Datos_Curso;
import Modelo.Datos_Basicos_Curso;

/**
 *
 * @author DavidM
 */
public class Cursos extends HttpServlet {

    Base_Datos_Curso bd = new Base_Datos_Curso();
    Datos_Basicos_Curso db;
    
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
        try (PrintWriter out = response.getWriter()) {
            
            String userCodigo=request.getParameter("Codigo");
            String userNombre=request.getParameter("Nombre");
            String userDuracion=request.getParameter("Duracion");
            String userIdProfesor=request.getParameter("IdProf");
            
            if (userCodigo != null && !userCodigo.equals("") && userNombre !=null && !userNombre.equals("") && 
                    userDuracion !=null && !userDuracion.equals("") && userIdProfesor !=null && !userIdProfesor.equals("")) {
                
                db=new Datos_Basicos_Curso(userCodigo, userNombre, userDuracion, userIdProfesor);
                bd.Agregar(db);
                response.sendRedirect("Portada.html");
            }else{
                response.sendRedirect("Cursos.html");
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
