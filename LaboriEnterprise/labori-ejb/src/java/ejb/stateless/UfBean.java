package ejb.stateless;

import entity.Uf;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(mappedName="ejb/uf")
public class UfBean implements UfBeanLocal {

    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    public List<Uf> getAll() {
        return em.createQuery("select x from Uf x").getResultList();
    }

    @Override
    public Uf getById(Long id) {
        return em.find(Uf.class, id);
    }
}
