package ejb.stateless;

import entity.Company;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="ejb/company")
public class CompanyBean implements CompanyBeanLocal {

    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    public List<Company> getAll() {
        return em.createQuery("select x from Company x").getResultList();
    }

    @Override
    public Company getById(Long id) {
        return em.find(Company.class, id);
    }
}
