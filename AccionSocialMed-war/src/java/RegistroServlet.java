/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.EstudianteFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import entity.Estudiante;
import entity.Pas;
import entity.Profesor;
import entity.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
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
 * @author gdiar
 */
@WebServlet(urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

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
    ProfesorFacade profesorFacade;
    @EJB
    PasFacade pasFacade;
    @EJB
    EstudianteFacade estudianteFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        List<Usuario> u = usuarioFacade.findAll();
        Usuario nuevoU = new Usuario(request.getParameter("correo"), request.getParameter("contrasena"), (String) sesion.getAttribute("name"));
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getCorreo().equals(nuevoU.getCorreo())) {
                request.setAttribute("mensaje", "El usuario ya se enuentra registrado. Puede iniciar sesión");

                RequestDispatcher rd = request.getRequestDispatcher("/prettyLogin.jsp");
                rd.forward(request, response);
            }

        }
        
        String ocupacion = (String)sesion.getAttribute("ocupation");

        if (!request.getParameter("telefono").equals("")) {
            nuevoU.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        }

        if (!request.getParameter("localidad").equals("")) {
            nuevoU.setLocalidad(request.getParameter("localidad"));
        }

        if (!request.getParameter("direccion").equals("")) {
            nuevoU.setDireccion(request.getParameter("direccion"));
        }

        nuevoU.setNombre((String) sesion.getAttribute("name"));

        String apellidos = (String) sesion.getAttribute("apellidos");

        usuarioFacade.create(nuevoU);
        if (ocupacion.equals("Estudiante")) {
            Estudiante nuevoE = new Estudiante(nuevoU.getCorreo());
            nuevoE.setApellidos(apellidos);
            estudianteFacade.create(nuevoE);

        } else if (ocupacion.equals("PAS")) {
            Pas nuevoPAS = new Pas(nuevoU.getCorreo());
            nuevoPAS.setApellidos(apellidos);
            pasFacade.create(nuevoPAS);

        } else if (ocupacion.equals("PDI")) {
            Profesor nuevoPDI = new Profesor(nuevoU.getCorreo());
            nuevoPDI.setApellidos(apellidos);

            profesorFacade.create(nuevoPDI);

        }

        sesion.removeAttribute("name");
        sesion.removeAttribute("ocupation");
        sesion.removeAttribute("correo2");
        sesion.removeAttribute("apellidos");
        RequestDispatcher rd = request.getRequestDispatcher("/prettyLogin.jsp");
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
