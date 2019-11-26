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
    
        @EJB UsuarioFacade usuarioFacade;
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    @EJB EstudianteFacade estudianteFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        String resultado = "";
        String link="http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com/getuser/";
        link=link.concat(correo);
        link=link.concat("/");
        link=link.concat(contrasena);
     //METODO PARA OBTENER EL TIPO DE USUARIO DE IDUMA
        try {
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                resultado = resultado.concat(str);
            }
        } catch (IOException ex) {
        }
        //Aqui obtengo el valor del usuario y se de que tipo es en iduma
        JsonObject jobj = new Gson().fromJson(resultado, JsonObject.class);
        
        String json = jobj.get("situation").getAsString();
        
        if(json.equals("ABSENT"))
        {
            request.setAttribute("mensaje", "Datos incorrectos");
            
            RequestDispatcher rd = request.getRequestDispatcher("/Registro.jsp");
        rd.forward(request, response);
        }
        
        json = jobj.get("categoryName").getAsString();
        Usuario nuevoU = new Usuario(request.getParameter("correo"),request.getParameter("contrasena"),jobj.get("nombre").getAsString());
        List<Usuario> u = usuarioFacade.findAll();
        
        for(int i=0;i<u.size();i++)
        {
            if(u.get(i).getCorreo().equals(nuevoU.getCorreo()))
                {
                                   request.setAttribute("mensaje", "El usuario ya se enuentra registrado");
            
                RequestDispatcher rd = request.getRequestDispatcher("/Registro.jsp"); 
                                rd.forward(request, response);
                }
            
        }
        usuarioFacade.create(nuevoU);
        if(json.equals("Estudiante"))
        {
            Estudiante nuevoE = new Estudiante(nuevoU.getCorreo());
            estudianteFacade.create(nuevoE);
            
        } 
        else if (json.equals("PAS"))
        {
                  Pas nuevoPAS = new Pas(nuevoU.getCorreo());
                  pasFacade.create(nuevoPAS);
                    
        } 
        else if (json.equals("PDI"))
        {
                 Profesor nuevoPDI = new Profesor(nuevoU.getCorreo());
                 profesorFacade.create(nuevoPDI);
                    
                    
        }
        
        
        
        
        
        
        
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
