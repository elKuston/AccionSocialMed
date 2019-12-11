package services;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romol
 */
public class MessageService {
    /**
     * 
     * @param request La request a través de la que se ha llegado a la página
     * 
     * Permite que el servlet pueda recibir el mensaje enviado por la página anterior
     */
    public static void recibirMensaje(HttpServletRequest request){
        String mensaje = (String) request.getSession().getAttribute("mensaje");
        request.setAttribute("mensaje",mensaje);
        request.getSession().removeAttribute("mensaje");
    }
    /**
     * 
     * @param request request con la que se redirige a la siguiente página
     * @param mensaje el mensaje que se quiere mostrar
     * 
     * Envía un mensaje para que el próximo servlet al que se vaya pueda recogerlo y mostrarlo.
     */
    public static void enviarMensaje(HttpServletRequest request, String mensaje){
        request.getSession().setAttribute("mensaje", mensaje);
    }
}
