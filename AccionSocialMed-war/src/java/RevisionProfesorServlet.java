/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.NotificacionFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Actividad;
import entity.Notificacion;
import entity.Profesor;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author jange
 */
@WebServlet(urlPatterns = {"/RevisionProfesorServlet"})
public class RevisionProfesorServlet extends HttpServlet {

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
        String boton = request.getParameter("boton");
        HttpSession sesion = request.getSession();
        Actividad act = actividadFacade.find(Integer.parseInt(request.getParameter("act")));
        Usuario solicitante= usuarioFacade.find(request.getParameter("solicitante"));
        Integer notificacion= Integer.parseInt(request.getParameter("notificacion"));

        if (boton.equals("Aceptar solicitante")) {
            Notificacion not = new Notificacion();
            not.setEmisor((Usuario) sesion.getAttribute("usuario"));
            not.setReceptor(act.getOng().getUsuario());
            not.setLeido(Boolean.FALSE);
            not.setIdnotificacion(notificacionFacade.findAll().get(notificacionFacade.findAll().size() - 1).getIdnotificacion() + 1);
            not.setContenido("El usuario " + solicitante.getNombre() + " quiere participar en una actividad, consulte el resto de la informacion aqui"
                    + "<form action=\"RevisionServlet\" method=\"post\">\n"
                    + "<input type=\"hidden\" value=\"" + act.getNactividad() + "\" name=\"actividad\"/>\n"
                    + "<input type=\"hidden\" value=\"" + solicitante.getCorreo() + "\" name=\"solicitante\"/>\n"
                    + "<input type=\"hidden\" value=\"" + not.getIdnotificacion() + "\" name=\"notificacion\"/>\n"
                    + "<input type=\"submit\" name=\"boton\" value=\"Revisar\">\n"
                    + "</form>");
            notificacionFacade.create(not);
            sesion.setAttribute("mensaje", "Se enviará notificacion a la ONG correspondiente");
        } 
        if (boton.equals("Rechazar solicitante")) {
            sesion.setAttribute("mensaje", "Solicitante rechazado");
            Notificacion not = new Notificacion();
            not.setEmisor((Usuario) sesion.getAttribute("usuario"));
            not.setReceptor(solicitante);
            not.setLeido(Boolean.FALSE);
            not.setIdnotificacion(notificacionFacade.findAll().get(notificacionFacade.findAll().size() - 1).getIdnotificacion() + 1);
            not.setContenido("Has sido rechazado de la actividad "+act.getTitulo() +" de la ONG "+ act.getOng().getUsuario().getNombre());
            notificacionFacade.create(not);
        }
        if(!boton.equals("Volver")){
        Notificacion elim=notificacionFacade.find(notificacion);
        notificacionFacade.remove(elim);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/VerNotificacionesServlet");
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
