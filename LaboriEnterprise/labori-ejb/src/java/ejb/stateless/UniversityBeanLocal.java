package ejb.stateless;

import entity.University;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UniversityBeanLocal {
    public List<University> getAll();
    public University getById(Long id);
}
