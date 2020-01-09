/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Mensaje;
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
public class MensajeFacade extends AbstractFacade<Mensaje> {

    @PersistenceContext(unitName = "AccionSocialMed-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }
    
    public List<Mensaje> findByActualUser(String usuario){
        Query q;
        q = this.em.createQuery("select p from Mensaje p where P.receptor.correo = :usuario and P.leido=false" );
        q.setParameter("usuario",usuario);
        return q.getResultList();
    }
    
    public List<Mensaje> findBySalientes(String usuario){
        Query q;
        q = this.em.createQuery("select p from Mensaje p where P.emisor.correo = :usuario and P.leido=false" );
        q.setParameter("usuario",usuario);
        return q.getResultList();
    }
}
