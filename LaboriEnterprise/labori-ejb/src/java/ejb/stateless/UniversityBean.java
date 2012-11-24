package ejb.stateless;

import entity.University;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="ejb/university")
public class UniversityBean implements UniversityBeanLocal {

    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    public List<University> getAll() {
        return em.createQuery("select x from University x").getResultList();
    }

    @Override
    public University getById(Long id) {
        return em.find(University.class, id);
    }
}
