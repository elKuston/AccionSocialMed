/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Asignatura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jange
 */
@Stateless
public class AsignaturaFacade extends AbstractFacade<Asignatura> {

    @PersistenceContext(unitName = "AccionSocialMed-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignaturaFacade() {
        super(Asignatura.class);
    }
    
    public Asignatura buscar(String nombre){
        Query q;
        q = this.em.createQuery("select a from Asignatura a where a.nombreAsignatura = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList().size()>0 ? (Asignatura) q.getResultList().get(0) : null;
    }
    
}
