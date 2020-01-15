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
@WebServlet(urlPatterns = {"/ConfirmacionUnionProfesorServlet"})
public class ConfirmacionUnionProfesorServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        Actividad act = actividadFacade.find(Integer.parseInt(request.getParameter("id")));
        String accion = request.getParameter("boton");
        Usuario user = (Usuario) sesion.getAttribute("usuario");

        if (accion.equals("Quiero unirme")) {
            if (user.getActividadList().contains(act)) {
                sesion.setAttribute("mensaje", "Ya estas inscrito en esta actividad");
            } else {

                Notificacion not = new Notificacion();
                not.setEmisor((Usuario) sesion.getAttribute("usuario"));;
                not.setLeido(Boolean.FALSE);
                not.setIdnotificacion(notificacionFacade.findAll().get(notificacionFacade.findAll().size() - 1).getIdnotificacion() + 1);

                if (act.getTipoActividad().equals("Voluntariado")) {
                    not.setReceptor(act.getOng().getUsuario());
                    not.setContenido("Una persona quiere participar en una actividad, consulte el resto de la informacion aqui"
                            + "<form action=\"RevisionServlet\" method=\"post\">\n"
                            + "<input type=\"hidden\" value=\"" + act.getNactividad() + "\" name=\"actividad\"/>\n"
                            + "<input type=\"hidden\" value=\"" + user.getCorreo() + "\" name=\"solicitante\"/>\n"
                            + "<input type=\"hidden\" value=\"" + not.getIdnotificacion() + "\" name=\"notificacion\"/>\n"
                            + "<input type=\"submit\" name=\"boton\" value=\"Revisar\">\n"
                            + "</form>");

                } else {
                    not.setReceptor(act.getCorreoProfesor().getUsuario());
                    not.setContenido("El usuario " + user.getNombre() + " quiere participar en una actividad, consulte el resto de la informacion aqui"
                            + "<form action=\"RevisionServlet\" method=\"post\">\n"
                            + "<input type=\"hidden\" value=\"" + act.getNactividad() + "\" name=\"actividad\"/>\n"
                            + "<input type=\"hidden\" value=\"" + user.getCorreo() + "\" name=\"solicitante\"/>\n"
                            + "<input type=\"hidden\" value=\"" + not.getIdnotificacion() + "\" name=\"notificacion\"/>\n"
                            + "<input type=\"submit\" name=\"boton\" value=\"Revisar\">\n"
                            + "</form>");

                }

                notificacionFacade.create(not);
            }
        }

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
