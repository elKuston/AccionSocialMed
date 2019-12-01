/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.EstudianteFacade;
import dao.OngFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import dao.UsuarioFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/LoginUmaServlet"})
public class LoginUmaServlet extends HttpServlet {

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
    @EJB OngFacade ongFacade;
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    @EJB EstudianteFacade estudianteFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String direccion = "/loginUma.jsp";

        String resultado = "";
        String link="http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com/getuser/";
        link=link.concat(correo);
        link=link.concat("/");
        link=link.concat(contrasena);
     //METODO PARA OBTENER EL TIPO DE USUARIO DE IDUMA
        if(!correo.equals("") && !contrasena.equals("")){
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
        
        
        
        if (usuarioFacade.find(correo) != null){
            if (json.equals("PRESENT")) {
                direccion = "/IndexServlet";
                sesion.setAttribute("usuario", usuarioFacade.find(correo));
                if (profesorFacade.find(correo)!= null) {
                    sesion.setAttribute("tipo", "profesor");
                } else if (pasFacade.find(correo)!= null) {
                    sesion.setAttribute("tipo", "pas");
                }else if (estudianteFacade.find(correo) != null) {
                    sesion.setAttribute("tipo", "estudiante");
                } else if (ongFacade.find(correo) != null) {
                    request.setAttribute("mensaje", "Este login es para usuarios");
                    direccion="/loginUma.jsp";}
            }
            else {
                    sesion.removeAttribute("usuario");
                    request.setAttribute("mensaje", "Contraseña erronea");
                }
        }
        else{request.setAttribute("mensaje", "Usuario o contraseña erroneos"); }
        
        }else{
            request.setAttribute("mensaje", "No dejes campos vacios");
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
