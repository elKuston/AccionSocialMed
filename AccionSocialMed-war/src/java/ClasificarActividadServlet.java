/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import services.MessageService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.ActividadFacade;
import dao.AsignaturaFacade;
import dao.NotificacionFacade;
import dao.ProfesorFacade;
import entity.Actividad;
import entity.Asignatura;
import entity.Notificacion;
import entity.Profesor;
import entity.Usuario;
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
    @EJB NotificacionFacade notificacionFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameterMap().get("accion")==null){//Primera llamada al servlet, cargar los datos para la vista
            
            //request.setAttribute("actividad", request.getParameter("act"));
            int nActividad = Integer.parseInt(request.getParameter("act"));
            Actividad a = actividadFacade.find(nActividad);
            if(a.getValidada()!=null){
                //request.getSession().setAttribute("mensaje", "La actividad ya ha sido clasificada o descartada anteriormente.");
                MessageService.enviarMensaje(request, "La actividad ya ha sido clasificada o descartada anteriormente.");
                RequestDispatcher rd = request.getRequestDispatcher("VerNotificacionesServlet");
                rd.forward(request, response);
            }
            List<Asignatura> asignaturas = cargarAsignaturas();
            List<Profesor> profesores = profesorFacade.findAll();

            request.setAttribute("actividad", a);
            request.setAttribute("asignaturas", asignaturas);
            request.setAttribute("profesores", profesores);


            RequestDispatcher rd = request.getRequestDispatcher("clasificarActividad.jsp");
            rd.forward(request, response);
            
        }else{//Segunda llamada, procesar los datos
            Notificacion n = new Notificacion();
            //n.setContenido("La ONG "+user.getNombre()+" ha propuesto una nueva actividad. Pulsa <a href='ClasificarActividadServlet?act="+a.getNactividad()+"'> aquí para clasificarla</a>");
            n.setLeido(false);
            n.setEmisor((Usuario) request.getSession().getAttribute("usuario"));
            //n.setReceptor();
            List<Notificacion> nots = notificacionFacade.findAll();
            int id = nots.get(nots.size()-1).getIdnotificacion()+1;
            n.setIdnotificacion(id);
            
            
            Actividad a = actividadFacade.find(Integer.parseInt(request.getParameter("nActividad")));
                
            if(request.getParameter("accion").equals("Descartar actividad")){//Marcar la actividad como rechazada
                a.setValidada(Boolean.FALSE);
                actividadFacade.edit(a);
                //Enviar notificación a la ong
                n.setContenido("La actividad "+a.getTitulo()+" ha sido descartada por el gestor.");
                n.setReceptor(a.getOng().getUsuario());
            }else if(request.getParameter("accion").equals("Clasificar actividad")){//Clasificar la actividad
                System.out.println(request.getParameter("tipo"));
                switch(request.getParameter("tipo")){
                    case "ApS":
                        
                        break;
                    case "inv":
                        a.setTipoActividad("Investigación");
                        Profesor p = profesorFacade.find(request.getParameter("profesor"));
                        a.setCorreoProfesor(p);
                        actividadFacade.edit(a);
                        n.setReceptor(p.getUsuario());
                        n.setContenido("Le ha sido asignada una nueva actividad de investigación. ");
                        break;
                    case "vol":
                        a.setValidada(Boolean.TRUE);
                        a.setTipoActividad("Voluntariado");
                        actividadFacade.edit(a);
                        //Enviar notificación a la ONG
                        n.setContenido("La actividad "+a.getTitulo()+" ha sido aceptada y clasificada como voluntariado");
                        n.setReceptor(a.getOng().getUsuario());
                        break;
                    default:
                        throw new RuntimeException("C mamo, el gestor ha puesto un tipo de actividad mu raro ("+request.getParameter("tipo")+")");
                }
            }
            
            notificacionFacade.create(n);
            
        }
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
                    asignaturaFacade.create(a);
                }
                asignaturas.add(a);
            }
        }
            
        return asignaturas;
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
