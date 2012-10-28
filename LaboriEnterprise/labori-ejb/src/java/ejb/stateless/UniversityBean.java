package ejb.stateless;

import dao.impl.UniversityDAOImpl;
import entity.Field;
import entity.University;
import java.util.List;
import javax.ejb.Stateless;

@Stateless(mappedName="ejb/university")
public class UniversityBean implements UniversityBeanLocal {

    private UniversityDAOImpl universityDAO;

    public UniversityBean() {
        universityDAO = new UniversityDAOImpl<University, Long>();
    }

    @Override
    public List<University> getAll() {
        universityDAO.resetSession();
        universityDAO.startTransaction();
        List<University> list = universityDAO.listAll();
        universityDAO.commitTransaction();
        return list;
    }

    @Override
    public University getById(Long id) {
        return (University) universityDAO.get(id);
    }
}
