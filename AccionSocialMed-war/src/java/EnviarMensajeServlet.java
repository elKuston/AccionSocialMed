/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.MensajeFacade;
import dao.UsuarioFacade;
import entity.Mensaje;
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
@WebServlet(urlPatterns = {"/EnviarMensajeServlet"})
public class EnviarMensajeServlet extends HttpServlet {

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
    UsuarioFacade usuarioFacade;
    @EJB
    MensajeFacade mensajeFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String boton = request.getParameter("boton");
        HttpSession sesion = request.getSession();
        String ruta = "/IndexServlet";

        if (boton.equals("Enviar")) {
            String destinatario = request.getParameter("destinatario");
            if (usuarioFacade.find(destinatario) != null) {
                String titulo = request.getParameter("titulo");
                String contenido = request.getParameter("contenido");
                Mensaje mensaje = new Mensaje();
                mensaje.setContenido(contenido);
                mensaje.setEmisor((Usuario) sesion.getAttribute("usuario"));
                mensaje.setTitulo(titulo);
                mensaje.setReceptor(usuarioFacade.find(destinatario));
                if (mensajeFacade.findAll().isEmpty()) {
                    mensaje.setIdmensajenotificacion(0);
                } else {
                    mensaje.setIdmensajenotificacion(mensajeFacade.findAll().get(mensajeFacade.findAll().size() - 1).getIdmensajenotificacion() + 1);
                }
                mensaje.setLeido(Boolean.FALSE);
                mensajeFacade.create(mensaje);
                ruta = "MensajeriaServlet";
            }
            else{
                request.setAttribute("mensaje", "Destinatario no encontrado");
                ruta = "MensajeriaServlet";
            }

        } else if (boton.equals("Borrar")) {
            int mensaje = Integer.parseInt(request.getParameter("mensaje"));
            Mensaje ahi = mensajeFacade.find(mensaje);
            ahi.setLeido(Boolean.TRUE);
            mensajeFacade.edit(ahi);
            ruta = "MensajeriaServlet";
        }

        RequestDispatcher rd = request.getRequestDispatcher(ruta);
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
