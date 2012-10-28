package ejb.stateless;

import dao.impl.FieldDAOImpl;
import entity.Field;
import entity.Uf;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Hibernate;

@Stateless(mappedName="ejb/field")
public class FieldBean implements FieldBeanLocal {

    private FieldDAOImpl FieldDAO;

    public FieldBean() {
        FieldDAO = new FieldDAOImpl<Field, Long>();
    }

    @Override
    public List<Field> getAll() {
        FieldDAO.resetSession();
        FieldDAO.startTransaction();
        List<Field> listField = FieldDAO.listAll();
        FieldDAO.commitTransaction();
        return listField;

    }

    @Override
    public Field getById(Long id) {
        FieldDAO.startTransaction();
        Field field = (Field) FieldDAO.get(id);
        Hibernate.initialize(field);
        FieldDAO.commitTransaction();
        return field;
    }
}
