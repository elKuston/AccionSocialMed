/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.NotificacionFacade;
import entity.Actividad;
import entity.Notificacion;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
 * @author jange
 */
@WebServlet(urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB NotificacionFacade notificacionFacade;
    @EJB ActividadFacade actividadFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession sesion = request.getSession();
        Usuario user= (Usuario) sesion.getAttribute("usuario");
        String mensaje = (String) sesion.getAttribute("mensaje");
        request.setAttribute("mensaje",mensaje);
        sesion.removeAttribute("mensaje");
        request.setAttribute("usuario",user);
        
        List<Notificacion> notificaciones = notificacionFacade.findAll();
        List<Notificacion> pendientes = new ArrayList<>();
        for(Notificacion n : notificaciones){
            if(n.getReceptor().equals(user)&&!n.getLeido()){
                pendientes.add(n);
            }
        }
        Actividad actividad=actividadFacade.findAll().get(0);
        request.setAttribute("actividad", actividad);
        request.setAttribute("pendientes", pendientes);
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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
