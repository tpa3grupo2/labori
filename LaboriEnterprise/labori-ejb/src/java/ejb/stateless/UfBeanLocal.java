package ejb.stateless;

import entity.Uf;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UfBeanLocal {

    public List<Uf> getAll();
    public Uf getById(Long id);

}
