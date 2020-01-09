/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.EstudianteFacade;
import dao.InformeFacade;
import dao.OngFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Actividad;
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
@WebServlet(urlPatterns = {"/VerCertificado"})
public class VerCertificado extends HttpServlet {

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
    UsuarioFacade usuarioFacade;
    @EJB
    ProfesorFacade profesorFacade;
    @EJB
    PasFacade pasFacade;
    @EJB
    EstudianteFacade estudianteFacade;
    @EJB
    InformeFacade informeFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param = request.getParameter("actividad");
        Actividad act = actividadFacade.find(Integer.valueOf(param));
        HttpSession sesion = request.getSession();
        Usuario us = (Usuario) sesion.getAttribute("usuario");
        String correo= us.getCorreo();
        request.setAttribute("usuario", us);
        request.setAttribute("actividad", act);

        if (profesorFacade.find(correo) != null) {
            request.setAttribute("apellido", us.getProfesor().getApellidos());
        } else if (pasFacade.find(correo) != null) {
            request.setAttribute("apellido", us.getPas().getApellidos());
        } else if (estudianteFacade.find(correo) != null) {
            request.setAttribute("apellido", us.getEstudiante().getApellidos());
        }
        int nota=informeFacade.findByUser(us.getCorreo(), act.getNactividad()).getNotaprofesor();
        request.setAttribute("nota",nota );

            RequestDispatcher rd = request.getRequestDispatcher("/verCertificado.jsp");
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
