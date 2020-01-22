/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.EtiquetaFacade;
import dao.UsuarioFacade;
import entity.Actividad;
import entity.Etiqueta;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/GestionEtiquetas2Servlet"})
public class GestionEtiquetas2Servlet extends HttpServlet {

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
    @EJB EtiquetaFacade etiquetaFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
                String r = (String) request.getParameter("option");
                
                if(r.equals("Nueva Etiqueta"))
                {
                    int t = Integer.parseInt((String)request.getParameter("tipo"));
                    System.out.println("I ENTERED");
                    Etiqueta nE = new Etiqueta((String)request.getParameter("nEt"));
                    nE.setTipo(t);
                    List<Actividad> lA = new ArrayList<>();
                    nE.setActividadList(lA);
                    List<Usuario> lU = new ArrayList<>();
                    nE.setUsuarioList(lU);
                    etiquetaFacade.create(nE);
                }
                else if(r.equals("Borrar Etiqueta"))
                {
                    System.out.println("I ENTEREDELETE");
                    Etiqueta bE = etiquetaFacade.find((String) request.getParameter("bEt"));
                    etiquetaFacade.remove(bE);
                }
    
        
                 RequestDispatcher rd = request.getRequestDispatcher("/GestionEtiquetasServlet");
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
