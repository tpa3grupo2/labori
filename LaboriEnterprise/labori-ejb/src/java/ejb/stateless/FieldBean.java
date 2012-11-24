package ejb.stateless;

import entity.Field;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="ejb/field")
public class FieldBean implements FieldBeanLocal {

    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    public List<Field> getAll() {
        return em.createQuery("select x from Field x").getResultList();
    }

    @Override
    public Field getById(Long id) {
        return em.find(Field.class, id);
    }
}
