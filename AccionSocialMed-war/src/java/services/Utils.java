/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.EstudianteFacade;
import dao.PasFacade;
import dao.ProfesorFacade;
import entity.Usuario;
import javax.ejb.EJB;

/**
 *
 * @author romol
 */

public class Utils {
    /**
     * 
     * @param usuario el usuario del que se quiere conocer el apellido
     * @return el apellido del usuario o una cadena vacía si es una ONG
     */
    @EJB ProfesorFacade profesorFacade;
    @EJB PasFacade pasFacade;
    @EJB EstudianteFacade estudianteFacade;
    public String obtenerApellidos(Usuario usuario){
        String apellido = "";
        if(usuario!=null){
            if (profesorFacade.find(usuario.getCorreo()) != null) {
                apellido = usuario.getProfesor().getApellidos();
            } else if (pasFacade.find(usuario.getCorreo()) != null) {
                apellido =  usuario.getPas().getApellidos();
            } else if (estudianteFacade.find(usuario.getCorreo()) != null) {
                apellido =  usuario.getEstudiante().getApellidos();
            }
        }
        return apellido;
    }
}
