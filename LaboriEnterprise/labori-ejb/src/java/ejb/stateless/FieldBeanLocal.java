package ejb.stateless;

import entity.Field;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FieldBeanLocal {

    public List<Field> getAll();
    public Field getById(Long id);

}
