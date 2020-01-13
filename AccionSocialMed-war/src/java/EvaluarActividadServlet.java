/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.EstudianteFacade;
import dao.InformeFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Informe;
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
import services.MessageService;

/**
 *
 * @author romol
 */
@WebServlet(urlPatterns = {"/EvaluarActividadServlet"})
public class EvaluarActividadServlet extends HttpServlet {

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
    @EJB ActividadFacade actividadFacade;
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    @EJB EstudianteFacade estudianteFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessageService.recibirMensaje(request);
        int nActividad = Integer.parseInt(request.getParameter("actividad"));
        List<Usuario> usuarios = actividadFacade.find(nActividad).getUsuarioList();
        List<String> apellidos = new ArrayList<>();
        request.setAttribute("participantes", usuarios);
        List<Informe> informes = new ArrayList<>();
        for(Usuario u : usuarios){
            
            Informe i = informeFacade.findByUser(u.getCorreo(), nActividad);
            informes.add(i);
            
            String apellido = "";
            if (profesorFacade.find(u.getCorreo()) != null) {
                apellido = u.getProfesor().getApellidos();
            } else if (pasFacade.find(u.getCorreo()) != null) {
                apellido =  u.getPas().getApellidos();
            } else if (estudianteFacade.find(u.getCorreo()) != null) {
                apellido =  u.getEstudiante().getApellidos();
            }
            
            apellidos.add(apellido);
        }
        request.setAttribute("apellidos", apellidos);
        request.setAttribute("informes", informes);
        
        RequestDispatcher rd = request.getRequestDispatcher("/evaluarActividad.jsp");
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
