/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.EstudianteFacade;
import dao.InformeFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Informe;
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
import services.Utils;

/**
 *
 * @author romol
 */
@WebServlet(urlPatterns = {"/EvaluarAlumnoServlet"})
public class EvaluarAlumnoServlet extends HttpServlet {

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
    @EJB UsuarioFacade usuarioFacade;
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    @EJB EstudianteFacade estudianteFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correoParticipante = request.getParameter("part");
        Informe informe = informeFacade.findByUser(correoParticipante, Integer.parseInt(request.getParameter("act")));
        Usuario u = usuarioFacade.find(correoParticipante);
         String apellido = "";
            if (profesorFacade.find(u.getCorreo()) != null) {
                apellido = u.getProfesor().getApellidos();
            } else if (pasFacade.find(u.getCorreo()) != null) {
                apellido =  u.getPas().getApellidos();
            } else if (estudianteFacade.find(u.getCorreo()) != null) {
                apellido =  u.getEstudiante().getApellidos();
            }
        request.setAttribute("informe", informe);
        request.setAttribute("participante", u);
        request.setAttribute("apellido", apellido);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/evaluarAlumno.jsp");
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
