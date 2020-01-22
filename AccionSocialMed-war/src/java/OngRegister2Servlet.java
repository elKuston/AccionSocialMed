/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.OngFacade;
import dao.UsuarioFacade;
import entity.Ong;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angela
 */
@WebServlet(urlPatterns = {"/OngRegister2Servlet"})
public class OngRegister2Servlet extends HttpServlet {

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String correo = request.getParameter("correo");
        String passw1 = request.getParameter("passw1");
        String passw2 = request.getParameter("passw2");
        String nombre = request.getParameter("nombre");
                  
        String dir = "/ongRegister2.jsp";
        
       
       if (passw1.equals(passw2)){
           Usuario u = usuarioFacade.find(correo);
           Ong o = ongFacade.find(correo);
           o.setContrasena(passw1);
           o.setActiva(true);
           u.setNombre(nombre);
           
           dir = "/loginOng.jsp";
           
        if (!request.getParameter("tlf").equals("")) {
            u.setTelefono(Integer.parseInt(request.getParameter("tlf")));
        }
        
        if (!request.getParameter("web").equals("")) {
            o.setWeb(request.getParameter("web"));
        }
        
        if (!request.getParameter("direc").equals("")) {
            u.setDireccion(request.getParameter("direc"));
        }

        if (!request.getParameter("localidad").equals("")) {
            u.setLocalidad(request.getParameter("localidad"));
        }
        u.setTurnotarde(Boolean.FALSE);
        
           usuarioFacade.edit(u);
           ongFacade.edit(o);
           
       } else {
            request.setAttribute("mensaje", "Las contraseñas no coinciden");
            request.setAttribute("usuario",usuarioFacade.find(correo));
       }
       
       RequestDispatcher rd = request.getRequestDispatcher(dir);
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
