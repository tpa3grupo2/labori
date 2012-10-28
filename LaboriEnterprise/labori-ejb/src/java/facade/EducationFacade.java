/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Education;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauelt
 */
@Stateless
public class EducationFacade extends AbstractFacade<Education> {
    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EducationFacade() {
        super(Education.class);
    }

}
