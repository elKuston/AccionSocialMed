/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.EstudianteFacade;
import dao.OngFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Usuario;
import entity.Profesor;
import entity.Pas;
import entity.Ong;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
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
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
    OngFacade ongFacade;
    ProfesorFacade profesorFacade;
    PasFacade pasFacade;
    EstudianteFacade estudianteFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String direccion = "/login.jsp";
        
        URL url = new URL("http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        InputStream stream =con.getInputStream();
        int data =stream.read();
        int code = con.getResponseCode();
        sesion.setAttribute("json", data);

        if (usuarioFacade.find(correo) != null) {
            if (usuarioFacade.find(correo).getContrasena().equals(contrasena)) {
                direccion = "/IndexServlet";
                sesion.setAttribute("usuario", usuarioFacade.find(correo));
                if(usuarioFacade.find(correo).getProfesor() != null) sesion.setAttribute("tipo", "profesor");
                if(usuarioFacade.find(correo).getPas() != null) sesion.setAttribute("tipo", "pas");
                if(usuarioFacade.find(correo).getEstudiante() != null) sesion.setAttribute("tipo","estudiante");
                if(usuarioFacade.find(correo).getOng()!= null && usuarioFacade.find(correo).getOng().getActiva()){
                    sesion.setAttribute("tipo","ong");
                }  else{
                    direccion="/login.jsp";
                    sesion.removeAttribute("usuario");
                }
                
                
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(direccion);
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
