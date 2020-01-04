/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Notificacion;
import entity.Profesor;
import entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jange
 */
@Stateless
public class ProfesorFacade extends AbstractFacade<Profesor> {

    @PersistenceContext(unitName = "AccionSocialMed-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesorFacade() {
        super(Profesor.class);
    }
    
    public List<Profesor> getGestores(){
        Query q;
        q = this.em.createQuery("select p from Profesor p where P.gestor=true");
        return q.getResultList();
    }
     
     public List<Notificacion> porReceptor(Usuario receptor){
        Query q;
        q = this.em.createQuery("select n from Notificacion n where n.receptor.correo = :rec ");
        q.setParameter("rec", receptor.getCorreo());
        return q.getResultList();
    }
    
}
