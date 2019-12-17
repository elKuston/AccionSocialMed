/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ActividadFacade;
import dao.NotificacionFacade;
import entity.Actividad;
import entity.Asignatura;
import entity.Etiqueta;
import entity.Notificacion;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
 * @author jange
 */
@WebServlet(urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB NotificacionFacade notificacionFacade;
    @EJB ActividadFacade actividadFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession sesion = request.getSession();
        Usuario user= (Usuario) sesion.getAttribute("usuario");
        String mensaje = (String) sesion.getAttribute("mensaje");
        request.setAttribute("mensaje",mensaje);
        sesion.removeAttribute("mensaje");
        request.setAttribute("usuario",user);
        
        if(request.getParameter("all")!=null)
        {
            sesion.setAttribute("screen","all");
        }
        
        if(request.getParameter("match")!=null)
        {
            sesion.setAttribute("screen", "match");
        }
        
        List<Notificacion> notificaciones = notificacionFacade.findAll();
        List<Notificacion> pendientes = new ArrayList<>();
        for(Notificacion n : notificaciones){
            if(n.getReceptor().equals(user)&&!n.getLeido()){
                pendientes.add(n);
            }
        }
        request.setAttribute("pendientes", pendientes);
        
        List<Actividad> act = actividadFacade.findAll();
        act=filtrar(act);
        if(sesion.getAttribute("screen")==null || sesion.getAttribute("screen").equals("match"))
        {
            sesion.setAttribute("screen", "match");
            act = Match(user,act, (String) sesion.getAttribute("tipo"));
            request.setAttribute("actividades", act);
        }
        else
        {
            request.setAttribute("actividades", act);
        }
        
        
            Actividad actividad=actividadFacade.findAll().get(0);
            request.setAttribute("actividad", actividad);
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    private List<Actividad> Match (Usuario u, List<Actividad> a, String rol)
    {
        int turno = 0;
        int etiquetas = 0;
        int asignaturas = 0;
        List<Etiqueta> e1 = u.getEtiquetaList();
        List<Asignatura> as = null;
        if(rol.equals("estudiante")) as = u.getEstudiante().getAsignaturaList();

        
        int[] s = new int[a.size()];
        
        for(int i = 0; i < a.size(); i++)
        {
            turno=0;
            etiquetas=0;
            asignaturas=0;
            
            if(u.getTurnotarde() && a.get(i).getTurnotarde() || !u.getTurnotarde() && !a.get(i).getTurnotarde()) turno = 1;
            List<Etiqueta> e2 = a.get(i).getEtiquetaList();
            
            if(a.get(i).getAsignaturaAsociada()!=null && as!=null)
            {
                if(as.contains(a.get(i).getAsignaturaAsociada())) asignaturas = 10;
            }
            
            for(Etiqueta e : e1)
            {
                if(e2.contains(e)) 
                {
                    etiquetas+=7;
                }
                else
                {
                    etiquetas-=2;
                }
            }
            
            s[i]=(etiquetas+asignaturas)*turno;
        }
        
        a = orderBy(a,s);
        return a;
    }
    
    private List<Actividad> filtrar(List<Actividad> ac)
    {
        List<Actividad> b = new ArrayList();
        Date d = new Date();
        for(Actividad a : ac)
        {
            if(a.getValidada()!=null && a.getValidada() && a.getFechaInicio().after(d))
            {
                b.add(a);
            }
        }
        
        return b;
    }

    private List<Actividad> orderBy(List<Actividad> a, int[] s)
    {
        int max=4;
        int maxin = -1;
        boolean add = true;
        List<Actividad> b = new ArrayList<>();
        while(add)
        {
            max = 4;
            add = false;
            for(int i = 0; i < a.size();i++)
            {
                if(s[i]>max)
                {
                    max = s[i];
                    maxin = i;
                    add = true;
                }
            }
            
            if(add)
            {
                b.add(a.get(maxin));
                s[maxin]=0;
            }

        }
        return b;
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
