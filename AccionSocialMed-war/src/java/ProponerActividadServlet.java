/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.EtiquetaFacade;
import dao.NotificacionFacade;
import dao.OngFacade;
import dao.ProfesorFacade;
import entity.Actividad;
import entity.Etiqueta;
import entity.Notificacion;
import entity.Ong;
import entity.Profesor;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
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
@WebServlet(urlPatterns = {"/ProponerActividadServlet"})
public class ProponerActividadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB EtiquetaFacade etiquetaFacade;
    @EJB ActividadFacade actividadFacade;
    @EJB OngFacade ongFacade;
    @EJB NotificacionFacade notificacionFacade;
    @EJB ProfesorFacade profesorFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getSession().getAttribute("tipo")==null || (request.getSession().getAttribute("tipo")!=null && !request.getSession().getAttribute("tipo").equals("ong"))){
            request.getSession().setAttribute("mensaje", "No te cueles fiera");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        
        if(request.getParameter("validar")==null){//primera llamada al servlet, tenemos que cargar las etiquetas
            List<Etiqueta> etiquetas = etiquetaFacade.findAll();
            List<Etiqueta> ambitos = new ArrayList<>(), tipos = new ArrayList<>();
            for(Etiqueta e : etiquetas){
                if(e.getTipo()==1){
                    ambitos.add(e);
                }else{
                    tipos.add(e);
                }
            }
            
            request.setAttribute("ambitos", ambitos);
            request.setAttribute("tipos", tipos);
            
            RequestDispatcher rd = request.getRequestDispatcher("/proponerActividad.jsp");
            rd.forward(request, response);
        }else{//segunda llamada al servlet, tenemos que validar e insertar la activdad
            
            //cogemos los datos de la actividad
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String lugar = request.getParameter("lugar");
            int plazasDisponibles = Integer.parseInt(request.getParameter("plazas"));
            Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
            String ff = request.getParameter("fechaFin");
            boolean turnoTarde = request.getParameter("turno").equals("tarde");
            List<Actividad> actividades = actividadFacade.findAll();
            int nActividad = actividades.get(actividades.size()-1).getNactividad()+1;//se asume que las actividades nunca se borran de la base de datos, solo se desactivan
            
            Actividad a = new Actividad(nActividad, titulo, descripcion, fechaInicio);
            a.setOng(ongFacade.find(((Usuario) request.getSession().getAttribute("usuario")).getCorreo()));
            a.setNpersonas(plazasDisponibles);
            a.setLugar(lugar);
            a.setTurnotarde(turnoTarde);
            if(ff!=null){
                Date fechaFin;
                try{
                    fechaFin = Date.valueOf(ff);
                    a.setFechaFin(fechaFin);
                }catch(IllegalArgumentException e){
                    
                }
            }
            List<Etiqueta> etiquetasActividad = new ArrayList<>();
            
                Enumeration<String> ets = request.getParameterNames();
                while(ets.hasMoreElements()){
                    String s = ets.nextElement();
                    Etiqueta et = etiquetaFacade.find(s);
                    if(et!=null){
                        etiquetasActividad.add(et);
                    }
                }
            
            if(etiquetasActividad.size()>0){
                a.setEtiquetaList(etiquetasActividad);
            }
            
            actividadFacade.create(a);
            
            List<Profesor> gestores = profesorFacade.getGestores();
            
            Usuario user = (Usuario) request.getSession().getAttribute("usuario");
            for(Profesor g : gestores){
                Notificacion n = new Notificacion();
                n.setContenido("La ONG "+user.getNombre()+" ha propuesto una nueva actividad. Pulsa <a href='ClasificarActividadServlet?act="+a.getNactividad()+"'> aquí para clasificarla</a>");
                n.setLeido(false);
                n.setEmisor(user);
                n.setReceptor(g.getUsuario());
                List<Notificacion> nots = notificacionFacade.findAll();
                int id = nots.get(nots.size()-1).getIdnotificacion()+1;
                n.setIdnotificacion(id);
                notificacionFacade.create(n);
                /*String contenido = "La ONG "+user.getNombre()+" ha propuesto una nueva actividad. Pulsa <a href='ClasificarActividadServlet?act="+a.getNactividad()+"'> aquí para clasificarla</a>.";
                Notificacion.enviarNotificacion(user, g.getUsuario(), contenido);*/
            }
            
            request.getSession().setAttribute("mensaje", "La actividad será enviada al gestor para revisión");
            //request.getSession().setAttribute("mensaje", gestores.size()+"");
            RequestDispatcher rd = request.getRequestDispatcher("/IndexServlet");
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
