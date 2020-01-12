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

/**
 *
 * @author Angela
 */
@WebServlet(urlPatterns = {"/InformeServlet"})
public class InformeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB UsuarioFacade usuarioFacade;
    @EJB ActividadFacade actividadFacade;
    @EJB InformeFacade informeFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nAct = Integer.parseInt(request.getParameter("nAct"));
        String correo = request.getParameter("correo");
        Actividad act = actividadFacade.find(nAct);
        List<Informe> informes = informeFacade.findAll();
        Informe inf;
        
        boolean existe = false;
        int pos = 0;
        int id = 0;
        
        while(!existe && (pos < informes.size())) {
            if (informes.get(pos).getActividad().getNactividad().equals(nAct)
                    && (informes.get(pos).getEstudiante().getCorreo().equals(correo))){
                id = pos+1;
                existe = true;
            } else {
                pos++;
            }
        }
        
        
        if(existe) {
            inf = informeFacade.find(id);
        } else {
            inf = new Informe();
            inf.setIdinforme(informes.size()+1);
            inf.setActividad(act);
            inf.setEstudiante(usuarioFacade.find(correo));
            
            if(act.getTipoActividad().equals("Aprendizaje-Servicio")){
                Usuario p = usuarioFacade.find(act.getCorreoProfesor().getCorreo());
                inf.setProfesor(p);
            }
            
            informeFacade.create(inf);
            inf = informeFacade.find(informes.size()+1);
        }
        
        request.setAttribute("informe", inf);
        request.setAttribute("nombre", request.getParameter("nombre"));
        request.setAttribute("actividad",act);         


       RequestDispatcher rd = request.getRequestDispatcher("/informe.jsp");
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
