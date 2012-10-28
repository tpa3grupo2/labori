/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Uf;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauelt
 */
@Stateless
public class UfFacade extends AbstractFacade<Uf> {
    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UfFacade() {
        super(Uf.class);
    }

}
