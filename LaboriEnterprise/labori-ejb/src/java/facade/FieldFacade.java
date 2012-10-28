/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Field;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauelt
 */
@Stateless
public class FieldFacade extends AbstractFacade<Field> {
    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FieldFacade() {
        super(Field.class);
    }

}
