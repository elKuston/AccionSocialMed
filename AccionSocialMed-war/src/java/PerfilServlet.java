/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.EstudianteFacade;
import services.MessageService;
import dao.NotificacionFacade;
import dao.OngFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Estudiante;
import entity.Ong;
import entity.Pas;
import entity.Profesor;
import entity.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Angela
 */
@WebServlet(urlPatterns = {"/PerfilServlet"})
public class PerfilServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB UsuarioFacade usuarioFacade;
    @EJB OngFacade ongFacade;
    @EJB EstudianteFacade estudianteFacade;
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        String button = request.getParameter("bt");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        if(button != null) {
            if (!request.getParameter("nombre").equals("")) {
            user.setNombre(request.getParameter("nombre"));              
            }
            
            if(!request.getParameter("tlf").equals("")){
            user.setTelefono(Integer.parseInt(request.getParameter("tlf")));  
            }
            
            if (!request.getParameter("direc").equals("")) {
            user.setDireccion(request.getParameter("direc"));   
            }
        
            if (!request.getParameter("localidad").equals("")) {
                user.setLocalidad(request.getParameter("localidad"));
            }
            
            //tipo ong
            if (sesion.getAttribute("tipo").equals("ong")) {
                Ong o = user.getOng();
                
                if (!request.getParameter("passw1").equals("") && !request.getParameter("passw2").equals("")) {
                    if (request.getParameter("passw1").equals(request.getParameter("passw2"))) {
                        o.setContrasena(request.getParameter("passw1"));
                    }
                }
             
                if (!request.getParameter("web").equals("")) {
                    o.setWeb(request.getParameter("web")); 
                }
             
                ongFacade.edit(o);
                
            //tipo estudiante
            } else if (sesion.getAttribute("tipo").equals("estudiante")) {
             Estudiante e = user.getEstudiante();
             
             if (!request.getParameter("app").equals("")) {
                 e.setApellidos(request.getParameter("app"));
             }
             
             if (!request.getParameter("fnac").equals("")) {
                 
                 String date = request.getParameter("fnac");
                 try {
                     e.setFechaNacimiento(formato.parse(date));
                 } catch (ParseException ex) {
                     Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             estudianteFacade.edit(e);
            
            //tipo profesor
         } else if (sesion.getAttribute("tipo").equals("profesor")) {
             Profesor p = user.getProfesor();
             
             if (!request.getParameter("app").equals("")) {
                 p.setApellidos(request.getParameter("app"));
             }
             
             if (!request.getParameter("fnac").equals("")) {
                 
                 String date = request.getParameter("fnac");
                 try {
                     p.setFechaNacimiento(formato.parse(date));
                 } catch (ParseException ex) {
                     Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             
             profesorFacade.edit(p);
             
             //tipo pas
         } else {
             Pas pas = user.getPas();
             
             if (!request.getParameter("app").equals("")) {
                 pas.setApellidos(request.getParameter("app"));
             }
             
             pasFacade.edit(pas);
             
         }
            
          
            
            usuarioFacade.edit(user);
        }
        
        request.setAttribute("usuario",user);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/perfil.jsp");
        rd.forward(request, response);
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
