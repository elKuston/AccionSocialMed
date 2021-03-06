/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ClaveRegistro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jange
 */
@Stateless
public class ClaveRegistroFacade extends AbstractFacade<ClaveRegistro> {

    @PersistenceContext(unitName = "Aegislash-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaveRegistroFacade() {
        super(ClaveRegistro.class);
    }
    
}
