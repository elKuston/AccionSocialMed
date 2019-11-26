/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.OngFacade;
import dao.UsuarioFacade;
import entity.Ong;
import entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/IngresarONGServlet2"})
public class IngresarONG2Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        @EJB OngFacade ongFacade;
         @EJB UsuarioFacade usuarioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        
                            List<Ong> ongs = ongFacade.findAll();
                request.setAttribute("ongs", ongs);
                
                if(request.getParameter("CorreoONG").equals(""))
                                    {
                                        request.setAttribute("mensaje","No dejes el campo del correo vacío");
                        RequestDispatcher rd = request.getRequestDispatcher("/IngresarONG.jsp");
                        rd.forward(request, response);
                    }
                for(int i = 0;i<ongs.size();i++)
                {
                    if(ongs.get(i).getCorreo().equals(request.getParameter("CorreoONG")))
                    {
                        request.setAttribute("mensaje","Esta ONG ya existe");
                        RequestDispatcher rd = request.getRequestDispatcher("/IngresarONG.jsp");
                        rd.forward(request, response);
                    }
                }
                
                Usuario nuevoU = new Usuario(request.getParameter("CorreoONG"),"Rellenar","Rellenar");
                Ong nuevaO = new Ong(request.getParameter("CorreoONG"));
                nuevaO.setActiva(false);
                nuevaO.setClaveRegistro(request.getParameter("CorreoONG").substring(0, 3)+ongFacade.count());
                        
                usuarioFacade.create(nuevoU);
                ongFacade.create(nuevaO);
                RequestDispatcher rd = request.getRequestDispatcher("/IngresarONGServlet");
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
            try {
                processRequest(request, response);
            } catch (InterruptedException ex) {
                Logger.getLogger(IngresarONG2Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                processRequest(request, response);
            } catch (InterruptedException ex) {
                Logger.getLogger(IngresarONG2Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
