/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.NotificacionFacade;
import dao.UsuarioFacade;
import entity.Actividad;
import entity.Notificacion;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Angela
 */
@WebServlet(urlPatterns = {"/CancelarParticipacionServlet"})
public class CancelarParticipacionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @EJB
    ActividadFacade actividadFacade;
    @EJB
    NotificacionFacade notificacionFacade;
    @EJB
    UsuarioFacade usuarioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        
         Actividad act = actividadFacade.find(Integer.parseInt(request.getParameter("id")));
         
         List<Actividad> inscritas = user.getActividadList();
         inscritas.remove(act);
         user.setActividadList(inscritas);
         usuarioFacade.edit(user);
         
         List<Usuario> participantes = act.getUsuarioList();
         participantes.remove(user);
         act.setUsuarioList(participantes);
         actividadFacade.edit(act);
         
        
         
         //notificacion profa
        Notificacion n1 = new Notificacion();
        n1.setEmisor(user);
        n1.setLeido(false);
        n1.setIdnotificacion(notificacionFacade.findAll().get(notificacionFacade.findAll().size() - 1).getIdnotificacion() + 1);
        
        n1.setReceptor(act.getCorreoProfesor().getUsuario());
                n1.setContenido("El usuario " + user.getNombre() +  " ha cancelado su participación en la actividad " + act.getTitulo());
                 notificacionFacade.create(n1);
        
        //notificacion ong
        Notificacion n2 = new Notificacion();
        n2.setEmisor(user);
        n2.setLeido(false);
        n2.setIdnotificacion(notificacionFacade.findAll().get(notificacionFacade.findAll().size() - 1).getIdnotificacion() + 1);
        
        n2.setReceptor(act.getOng().getUsuario());
                n2.setContenido("El usuario " + user.getNombre() +  " ha cancelado su participación en la actividad " + act.getTitulo());
                 notificacionFacade.create(n2);
                 
                 
         sesion.setAttribute("mensaje", "Cancelación realizada correctamente.");
         RequestDispatcher rd = request.getRequestDispatcher("/IndexServlet");
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
