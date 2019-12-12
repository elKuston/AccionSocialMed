/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import services.MessageService;
import dao.NotificacionFacade;
import dao.UsuarioFacade;
import entity.Notificacion;
import entity.Usuario;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author romol
 */
@WebServlet(urlPatterns = {"/VerNotificacionesServlet"})
public class VerNotificacionesServlet extends HttpServlet {

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
    UsuarioFacade usuarioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("mar")!=null){
            Notificacion n = notificacionFacade.find(Integer.parseInt(request.getParameter("mar")));
            n.setLeido(true);
            notificacionFacade.edit(n);
            /*RequestDispatcher rd = request.getRequestDispatcher("/VerNotificacionesServlet");
            rd.forward(request, response);
        */}
        
        List<Notificacion> notificaciones = notificacionFacade.porReceptor((Usuario) request.getSession().getAttribute("usuario"));
        
        request.setAttribute("notificaciones", notificaciones);
        
        MessageService.recibirMensaje(request);
        
        
      
        RequestDispatcher rd = request.getRequestDispatcher("/verNotificaciones.jsp");
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
