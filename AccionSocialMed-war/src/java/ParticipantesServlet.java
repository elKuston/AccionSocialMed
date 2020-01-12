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
import entity.Actividad;
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

/**
 *
 * @author Angela
 */
@WebServlet(urlPatterns = {"/ParticipantesServlet"})
public class ParticipantesServlet extends HttpServlet {

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
    @EJB EstudianteFacade estudianteFacade;
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    @EJB InformeFacade informeFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actividad act = actividadFacade.find(Integer.parseInt(request.getParameter("actividad")));
       ArrayList<String> participantesN = new ArrayList<>();
       ArrayList<String> participantesTipo = new ArrayList<>();
       List<Usuario> participantes = act.getUsuarioList();
      
       
       for(Usuario u: act.getUsuarioList()){
           String correo = u.getCorreo();
           String nombre = u.getNombre();
           String tipo ="Otro";
           
           if(estudianteFacade.find(correo) != null) {
                tipo = "Estudiante";
                
               if (u.getEstudiante().getApellidos()!= null) {
                    nombre += " "+u.getEstudiante().getApellidos();
                }
            } else if (profesorFacade.find(correo) != null) {
                tipo = "Profesor";
                
                if(u.getProfesor().getApellidos()!= null){
                nombre += " "+u.getProfesor().getApellidos();
                }
                
           } else {
               if (pasFacade.find(correo) != null) {
                   tipo += "PAS";
                   if(u.getPas().getApellidos()!= null) {
                       nombre += " "+u.getPas().getApellidos(); 
                   }
                }
            }
           

           participantesN.add(nombre);
           participantesTipo.add(tipo);
           
       }
        
        request.setAttribute("actividad",act);
        request.setAttribute("nAct",act.getNactividad());
        request.setAttribute("participantesN", participantesN);
        request.setAttribute("participantesTipo", participantesTipo);
        request.setAttribute("participantes", participantes);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/participantes.jsp");
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
