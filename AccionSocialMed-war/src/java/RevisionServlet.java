/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
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
@WebServlet(urlPatterns = {"/RevisionServlet"})
public class RevisionServlet extends HttpServlet {

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
    @EJB UsuarioFacade usuarioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        Actividad act = actividadFacade.find(Integer.parseInt(request.getParameter("actividad")));
        Usuario solicitante = usuarioFacade.find(request.getParameter("solicitante"));
        String notificacion= request.getParameter("notificacion");
        String rolSolicitante=null;
        String tipo= (String)sesion.getAttribute("tipo");
           
        
        if(solicitante.getEstudiante()!=null){rolSolicitante="Estudiante";}
        if(solicitante.getPas()!=null){rolSolicitante="PAS";}
        if(solicitante.getProfesor()!=null){rolSolicitante="Profesor";}
        
        request.setAttribute("solicitante", solicitante);
        request.setAttribute("acti", act);
        request.setAttribute("rolSolicitante", rolSolicitante);
        request.setAttribute("actual",tipo);
        request.setAttribute("notificacion", notificacion);
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/revision.jsp");
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
