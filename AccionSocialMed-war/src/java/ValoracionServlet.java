/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.InformeFacade;
import dao.NotificacionFacade;
import entity.Informe;
import entity.Notificacion;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/ValoracionServlet"})
public class ValoracionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB InformeFacade informeFacade;
    @EJB NotificacionFacade notificacionFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        int nota = Integer.parseInt(request.getParameter("nota"));
        String informe = request.getParameter("informe");
        int id = Integer.parseInt(request.getParameter("id"));
        Informe inf = informeFacade.find(id);
        
        inf.setNotaparticipante(nota);
        inf.setComentarioparticipante(informe);
        inf.setFechaopinion(new Date());
        
        informeFacade.edit(inf);
        sesion.setAttribute("mensaje", "Informe guardado correctamente.");
        
        //notificacion
        Notificacion n = new Notificacion();
        n.setEmisor(user);
        n.setLeido(false);
        n.setIdnotificacion(notificacionFacade.findAll().get(notificacionFacade.findAll().size() - 1).getIdnotificacion() + 1);
        
        n.setReceptor(inf.getActividad().getOng().getUsuario());
                n.setContenido("El usuario " + user.getNombre() + " ha valorado su actividad " + inf.getActividad().getTitulo() + ". Puede leerla aquí: "
                        + "<form action=\"VerActividadServlet\">"
                                + "<input type=\"submit\" name=\"boton\" value=\"Consultar\">\n"
                        + "<input type=\"hidden\" value=\"" + inf.getActividad().getNactividad() + "\" name=\"actividad\"/>\n"
                        + "</form>");
                
                 notificacionFacade.create(n);
                 
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
