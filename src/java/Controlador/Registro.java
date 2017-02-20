/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.*;
import static com.sun.xml.xsom.impl.UName.comparator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import javafx.scene.control.ComboBox;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class Registro extends HttpServlet {

    Base_Datos_Estudiantes bd = new Base_Datos_Estudiantes();
    Base_Datos_Curso bd2= new Base_Datos_Curso();
    Base_Datos_Inscripcion bd3 = new Base_Datos_Inscripcion();
    Base_Datos_Profesor bd4 = new Base_Datos_Profesor();
    
    ArrayList<Datos_Basicos_Estudiantes> at=new ArrayList<>();
    ArrayList<Datos_Basicos_Curso> at2=new ArrayList<>();
    ArrayList<Datos_Basicos_Profesor> at3=new ArrayList<>();
    ArrayList<Datos_Basicos_Inscripcion> at4=new ArrayList<>();

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

            String boton = request.getParameter("Botones");
            String combo = request.getParameter("selCombo");

            if (boton.equals("Cargar")) {

                switch (combo) {
                    case "1.Cursos sin Ingles":
                      
                         at2=bd2.cargar();
                        String b="";
                        for (int i = 0; i < at2.size(); i++) {
                            System.out.println(at2.get(i));   
                        }
                        for (int i = 0; i < at2.size(); i++) {
                            
                            
                            if (at2.get(i).getCodigo()==101 || at2.get(i).getCodigo()==105) {
                               
                            }else{
                              b=b+ "            <tr>\n"
                                + "              <td style=\"width: 130px;\">"+"Codigo: "+at2.get(i).getCodigo()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Nombre: "+at2.get(i).getNombreS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Duracion: "+at2.get(i).getDuracion()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"IdProfesor: "+at2.get(i).getIdProfesor()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                               ;   
                            }
                           
                        }
                        response.setContentType("text/html");
                        PrintWriter outs = response.getWriter();
                        String docType
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; color: red; width: 691px; height: 44px;\">"+"Cargado Satisfactorio"+"</td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + b + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "2.Estudiante 1518":
                        Datos_Basicos_Estudiantes d = new Datos_Basicos_Estudiantes();
                        bd.Arbol();
                        bd.LeerArbol();
                        d=bd.BuscarArbol(1518);
                        String c="";
                        
                       
                            c=c+ "            <tr>\n"
                                + "              <td style=\"width: 130px;\">"+"Id: "+d.getId()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Nombre: "+d.getNameS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Apellido: "+d.getLastnameS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Telefono: "+d.getTelefono()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                               ;
                        
                        response.setContentType("text/html");
                        PrintWriter outs2 = response.getWriter();
                        String docType2
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType2
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; color: red; width: 691px; height: 44px;\">"+"Cargado Satisfactorio"+"</td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + c + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "3.Cursos +10 Dias de duracion":
                       
                         at2=bd2.cargar();
                        String e="";
                        for (int i = 0; i < at2.size(); i++) {
                            System.out.println(at2.get(i));   
                        }
                        for (int i = 0; i < at2.size(); i++) {
                            
                            
                            if (at2.get(i).getDuracion()<11 || at2.get(i).getCodigo()== 104 ) {

                            }else{
                              e=e+ "            <tr>\n"
                                + "              <td style=\"width: 130px;\">"+"Codigo: "+at2.get(i).getCodigo()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Nombre: "+at2.get(i).getNombreS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Duracion: "+at2.get(i).getDuracion()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"IdProfesor: "+at2.get(i).getIdProfesor()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                               ;   
                            }
                           
                        }
                        response.setContentType("text/html");
                        PrintWriter outs3 = response.getWriter();
                        String docType3
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType3
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; color: red; width: 691px; height: 44px;\">"+"Cargado Satisfactorio"+"</td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + e + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "4.Profesores - Estudiantes":
                        
                        at=bd.cargar();
                        at3=bd4.cargar();
                        ArrayList<Datos_Basicos_Estudiantes> at5 = new ArrayList<Datos_Basicos_Estudiantes>();
                        System.out.println(at3.size()+"tamaño profes");
                        for (int i = 0; i < at3.size(); i++) {
                            System.out.println(i);
                            try {
                               at5.add( bd.BuscarArbol(at3.get(i).getId()));
                            } catch (Exception error) {
                            }
                            
                        }
                        System.out.println(at5.size());
                        String f="";
                        for (int i = 0; i < at5.size(); i++) {
                            if (at5.get(i)==null) {
                                
                            }else{
                            f=f+ "            <tr>\n"
                                + "              <td style=\"width: 130px;\">"+"Id: "+at5.get(i).getId()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Nombre: "+at5.get(i).getNameS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Apellido: "+at5.get(i).getLastnameS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Telefono: "+at5.get(i).getTelefono()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                               ;}
                        }
                        
                        
                        response.setContentType("text/html");
                        PrintWriter outs4 = response.getWriter();
                        String docType4
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType4
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; color: red; width: 691px; height: 44px;\">"+"Cargado Satisfactorio"+"</td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                +f
                                + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "5.Estudiantes + de 3.0":
                        
                        
                        
                        response.setContentType("text/html");
                        PrintWriter outs5 = response.getWriter();
                        String docType5
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType5
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px; height: 44px;\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + "            <tr>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"></td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                                + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "6.Cursos sin profesor":
                        
                        at2=bd2.cargar();
                        String h="";
                        for (int i = 0; i < at2.size(); i++) {
                            if (at2.get(i).getIdProfesor()==0) {
                               h=h+ "            <tr>\n"
                                + "              <td style=\"width: 130px;\">"+"Codigo: "+at2.get(i).getCodigo()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                               ; 
                            }else{
                            }
                        }
                        
                        response.setContentType("text/html");
                        PrintWriter outs6 = response.getWriter();
                        String docType6
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType6
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px; height: 44px;\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + h + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "7.Estudiantes Profesor 33":
                        response.setContentType("text/html");
                        PrintWriter outs7 = response.getWriter();
                        String docType7
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType7
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px; height: 44px;\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + "            <tr>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"></td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                                + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "8.# Estudiantes x curso":
                        response.setContentType("text/html");
                        PrintWriter outs8 = response.getWriter();
                        String docType8
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType8
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px; height: 44px;\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + "            <tr>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\"></td>\n"
                                + "              <td style=\"width: 130px;\"><br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                                + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        break;
                    case "9.Estudiantes":
                        at=bd.cargar();
                        String a="";
                        for (int i = 0; i < at.size(); i++) {
                            System.out.println(at.get(i));   
                        }
                        for (int i = 0; i < at.size(); i++) {
                            a=a+ "            <tr>\n"
                                + "              <td style=\"width: 130px;\">"+"Id: "+at.get(i).getId()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Nombre: "+at.get(i).getNameS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Apellido: "+at.get(i).getLastnameS()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 130px;\">"+"Telefono: "+at.get(i).getTelefono()+"<br>\n"
                                + "              </td>\n"
                                + "              <td style=\"width: 134px;\"></td>\n"
                                + "            </tr>\n"
                               ;
                        }
                        response.setContentType("text/html");
                        PrintWriter outs9 = response.getWriter();
                        String docType9
                                = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
                        out.println(docType9
                                + "<html>\n"
                                + "<head>\n"
                                + "  <meta content=\"text/html; charset=ISO-8859-1\"\n"
                                + " http-equiv=\"content-type\">\n"
                                + "  <title>Registro</title>\n"
                                + "</head>\n"
                                + "<body>\n"
                                + "<form style=\"width: 617px;\" action=\"Registro\"\n"
                                + " name=\"Registro\" method=\"post\">\n"
                                + "  <div style=\"text-align: center;\"> </div>\n"
                                + "  <table style=\"text-align: left; height: 372px; width: 701px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><img\n"
                                + " style=\"width: 404px; height: 287px;\"\n"
                                + " src=\"Imagenes/Img_Listar.jpg\" alt=\"\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"width: 691px;\"> Categoria de la Lista:\n"
                                + "        <select name=\"selCombo\" size=\"1\">\n"
                                + "        <option value=\"1.Cursos sin Ingles\">1.Cursos sin Ingles </option>\n"
                                + "        <option value=\"2.Estudiante 1518\">2.Estudiante 1518</option>\n"
                                + "        <option value=\"3.Cursos +10 Dias de duracion\">3.Cursos +10 Dias de\n"
                                + "duracion</option>\n"
                                + "        <option value=\"4.Profesores - Estudiantes\">4.Profesores - Estudiantes</option>\n"
                                + "        <option value=\"5.Estudiantes + de 3.0\">5.Estudiantes + de 3.0</option>\n"
                                + "        <option value=\"6.Cursos sin profesor\">6.Cursos sin profesor</option>\n"
                                + "        <option value=\"7.Estudiantes Profesor 33\">7.Estudiantes Profesor 33</option>\n"
                                + "        <option value=\"8.# Estudiantes x curso\">8.# Estudiantes x curso </option>\n"
                                + "        <option value=\"9.Estudiantes\">9.Estudiantes</option>\n"
                                + "        </select>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; width: 691px;\"><input\n"
                                + " name=\"Botones\" value=\"Cargar\" type=\"submit\"></td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td style=\"text-align: center; color: red; width: 691px; height: 44px;\">"+"Cargado Satisfactorio"+"</td>\n"
                                + "      </tr>\n"
                                + "      <tr>\n"
                                + "        <td\n"
                                + " style=\"vertical-align: top; text-align: right; width: 691px; height: 105px;\">\n"
                                + "        <table style=\"text-align: left; height: 45px; width: 685px;\"\n"
                                + " border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n"
                                + "          <tbody>\n"
                                + a + "          </tbody> <tbody>\n"
                                + "          </tbody>\n"
                                + "        </table>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody>\n"
                                + "  </table>\n"
                                + "  <br>\n"
                                + "</form>\n"
                                + "</body>\n"
                                + "</html>");
                        a="";
                        break;
                }

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
