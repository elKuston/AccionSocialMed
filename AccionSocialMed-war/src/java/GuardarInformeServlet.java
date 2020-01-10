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
import entity.Actividad;
import entity.Estudiante;
import entity.Informe;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/GuardarInformeServlet"})
public class GuardarInformeServlet extends HttpServlet {

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
    @EJB UsuarioFacade usuarioFacade;
    @EJB EstudianteFacade estudianteFacade;
    @EJB PasFacade pasFacade;
    @EJB ProfesorFacade profesorFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int nota = Integer.parseInt(request.getParameter("nota"));
        int horas = Integer.parseInt(request.getParameter("horas"));
        String informe = request.getParameter("informe");
        String correo = request.getParameter("correo");
        String tipo = request.getParameter("tipo");
        String nActividad = request.getParameter("actividad");
        Actividad act = actividadFacade.find(Integer.parseInt(nActividad));

        List<Informe> informes = act.getInformeList();
             
        
        //ver si existe informe
        boolean existe = false;
        for(Informe i: informes) {
            if(i.getEstudiante().getCorreo().equals(correo)) {
            existe = true;
            }
        }

        Informe i = new Informe();
        Date d = new Date();
        
        i.setComentarioong(informe);
        i.setNhoras(horas);
        i.setNotaong(nota);
        i.setFechainforme(d);
         

        //nuevo informe
        if(!existe){
             i.setIdinforme(informes.size()+1);
             i.setActividad(act);
             
            if(tipo.equals("Estudiante")){
            i.setEstudiante(estudianteFacade.find(correo).getUsuario());
            } else if (tipo.equals("Profesor")) {
                 i.setEstudiante(profesorFacade.find(correo).getUsuario());
            } else {
                 i.setEstudiante(pasFacade.find(correo).getUsuario());
            }
               
           informeFacade.create(i);
           
        } else {
            informeFacade.edit(i);
        }
       

        
        
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
