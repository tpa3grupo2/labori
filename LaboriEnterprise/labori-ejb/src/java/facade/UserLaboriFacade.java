/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.UserLabori;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauelt
 */
@Stateless
public class UserLaboriFacade extends AbstractFacade<UserLabori> {
    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserLaboriFacade() {
        super(UserLabori.class);
    }

}
