/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.AsignaturaFacade;
import dao.ProfesorFacade;
import entity.Actividad;
import entity.Asignatura;
import entity.Profesor;
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

/**
 *
 * @author romol
 */
@WebServlet(urlPatterns = {"/ClasificarActividadServlet"})
public class ClasificarActividadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB ActividadFacade actividadFacade;
    @EJB AsignaturaFacade asignaturaFacade;
    @EJB ProfesorFacade profesorFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setAttribute("actividad", request.getParameter("act"));
        int nActividad = Integer.parseInt(request.getParameter("act"));
        Actividad a = actividadFacade.find(nActividad);
        List<Asignatura> asignaturas = asignaturaFacade.findAll();
        List<Profesor> profesores = profesorFacade.findAll();
        
        request.setAttribute("actividad", a);
        request.setAttribute("asignaturas", asignaturas);
        request.setAttribute("profesores", profesores);
        

        RequestDispatcher rd = request.getRequestDispatcher("clasificarActividad.jsp");
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
