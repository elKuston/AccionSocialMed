/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Informe;
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
public class InformeFacade extends AbstractFacade<Informe> {

    @PersistenceContext(unitName = "AccionSocialMed-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformeFacade() {
        super(Informe.class);
    }
    
    public Informe findByUser(String usuario, int actividad){
        Query q;
        q = this.em.createQuery("select p from Informe p where P.participante.correo = :usuario and P.actividad.nactividad=:actividad" );
        q.setParameter("usuario",usuario);
        q.setParameter("actividad",actividad);
        return q.getResultList().size()>0? (Informe) q.getSingleResult() : null;
    }
    
    public List<Informe> findByNactividad( int actividad){
        Query q;
        q = this.em.createQuery("select p from Informe p where P.actividad.nactividad=:actividad" );
        q.setParameter("actividad",actividad);
        return (List<Informe>) q.getResultList();
    }
    
}
