/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.NotificacionFacade;
import entity.Actividad;
import entity.Notificacion;
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
 * @author romol
 */
@WebServlet(urlPatterns = {"/ValidarActividadServlet"})
public class ValidarActividadServlet extends HttpServlet {

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
    @EJB NotificacionFacade notificacionFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameterMap().get("accion")==null){//primera llamada, cargar datos
            Actividad a = actividadFacade.find(Integer.parseInt(request.getParameter("a")));
            request.setAttribute("actividad", a);

            RequestDispatcher rd = request.getRequestDispatcher("validarActividad.jsp");
            rd.forward(request, response);
        }else{//Segunda llamada, actualizar bdd
            String accion = request.getParameter("accion");
            Actividad a = actividadFacade.find(Integer.parseInt(request.getParameter("nActividad")));
            
            Notificacion n = new Notificacion();
            n.setLeido(false);
            n.setEmisor((Usuario) request.getSession().getAttribute("usuario"));
            List<Notificacion> nots = notificacionFacade.findAll();
            int id = nots.get(nots.size()-1).getIdnotificacion()+1;
            n.setIdnotificacion(id);
            n.setReceptor(a.getOng().getUsuario());
                    
            switch(accion){
                case "Aceptar actividad":
                    a.setValidada(Boolean.TRUE);
                    actividadFacade.edit(a); 
                    n.setContenido("La actividad "+a.getTitulo()+" ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.");
                    break;
                case "Rechazar actividad":
                    a.setValidada(Boolean.FALSE);
                    actividadFacade.edit(a);
                    //Enviar notificación a la ong
                    n.setContenido("La actividad "+a.getTitulo()+" ha sido rechazada por el profesor correspondiente.");
                    break;
                default:
                    throw new RuntimeException("A saber qué habrás hecho makina");
            }
            
            notificacionFacade.create(n);
            
            RequestDispatcher rd = request.getRequestDispatcher("IndexServlet");
            rd.forward(request, response);
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
