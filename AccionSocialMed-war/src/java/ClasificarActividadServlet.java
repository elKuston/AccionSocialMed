/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.ActividadFacade;
import dao.AsignaturaFacade;
import dao.ProfesorFacade;
import entity.Actividad;
import entity.Asignatura;
import entity.Profesor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(urlPatterns = {"/ClasificarActividadServlet"})
public class ClasificarActividadServlet extends HttpServlet {

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
    @EJB AsignaturaFacade asignaturaFacade;
    @EJB ProfesorFacade profesorFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setAttribute("actividad", request.getParameter("act"));
        int nActividad = Integer.parseInt(request.getParameter("act"));
        Actividad a = actividadFacade.find(nActividad);
        List<Asignatura> asignaturas = cargarAsignaturas();
        List<Profesor> profesores = profesorFacade.findAll();
        
        request.setAttribute("actividad", a);
        request.setAttribute("asignaturas", asignaturas);
        request.setAttribute("profesores", profesores);
        

        RequestDispatcher rd = request.getRequestDispatcher("clasificarActividad.jsp");
        rd.forward(request, response);
    }
    
    private List<Asignatura> cargarAsignaturas(){
        List<Asignatura> asignaturas = new ArrayList<>();
        
        //Coger las asignaturas de iduma
        String resultado = "";
        String link = "http://idumamockup-env.3mca2qexfx.eu-central-1.elasticbeanstalk.com/fullcontent";
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
        JsonObject jRaw = new Gson().fromJson(resultado, JsonObject.class);
        JsonArray asignaturasJson = jRaw.get("courses").getAsJsonArray();
        Iterator<JsonElement> it = asignaturasJson.iterator();
        while(it.hasNext()){
            JsonObject asig = it.next().getAsJsonObject();
            String nombre = asig.get("name").getAsString();
            if(nombre!=null){
                Asignatura a = asignaturaFacade.buscar(nombre);
                System.out.println("Asignatura "+nombre+ (a==null? " no" : "") +" encontrada "+nombre.length());
                if(a==null){
                    a = new Asignatura();
                    a.setNombreAsignatura(nombre);
                    a.setNCreditos(6);
                    a.setCodAsignatura(asignaturaFacade.count()+1);
                    //try{
                        asignaturaFacade.create(a);
                        //Thread.sleep(15);
                    //}catch(Exception e){
                      //  System.out.println("c mamo "+nombre.length());
                    //}
                }
                asignaturas.add(a);
            }
        }
        
        
        
        
            
        return asignaturas;
    }
    
    public static String stripAccents(String s) 
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
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
