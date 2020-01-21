/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.InformeFacade;
import dao.UsuarioFacade;
import entity.Actividad;
import entity.Informe;
import entity.Usuario;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Angela
 */
@WebServlet(urlPatterns = {"/VerEvaluacionServlet"})
public class VerEvaluacionServlet extends HttpServlet {

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
    @EJB InformeFacade informeFacade;
    @EJB UsuarioFacade usuarioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        String correo = user.getCorreo();
        List<Informe> informes = informeFacade.findAll();
        Actividad act = actividadFacade.find(Integer.parseInt(request.getParameter("actividad")));

        
        Informe inf = informeFacade.findByUser(correo, act.getNactividad());
        boolean existe = inf!=null;
        
        
        if(!existe){
            inf = new Informe();
            inf.setIdinforme(informes.size()+1);
            inf.setActividad(act);
            inf.setParticipante(usuarioFacade.find(correo));
            
            if(act.getTipoActividad().equals("Aprendizaje-Servicio")){
                Usuario p = usuarioFacade.find(act.getCorreoProfesor().getCorreo());
                inf.setProfesor(p);
            }
            
            informeFacade.create(inf);
            inf = informeFacade.find(informes.size()+1);
        }
        
        request.setAttribute("informe", inf);
        request.setAttribute("actividad",act );
        
        RequestDispatcher rd = request.getRequestDispatcher("/verEvaluacion.jsp");
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
