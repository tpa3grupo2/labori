/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.WorkExperience;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauelt
 */
@Stateless
public class WorkExperienceFacade extends AbstractFacade<WorkExperience> {
    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkExperienceFacade() {
        super(WorkExperience.class);
    }

}
