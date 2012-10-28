package ejb.stateless;

import dao.impl.UfDAOImpl;
import entity.Uf;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Hibernate;
import org.hibernate.Session;

@Stateless(mappedName="ejb/uf")
public class UfBean implements UfBeanLocal {
    private UfDAOImpl ufDAO;

    public UfBean() {
        ufDAO = new UfDAOImpl<Uf, Long>();
    }

    @Override
    public List<Uf> getAll() {
        ufDAO.resetSession();
        ufDAO.startTransaction();
        List<Uf> listUf = ufDAO.listAll();
        ufDAO.commitTransaction();
        return listUf;
    }

    @Override
    public Uf getById(Long id) {
        ufDAO.startTransaction();
        Uf uf = (Uf) ufDAO.get(id);
        Hibernate.initialize(uf);
        ufDAO.commitTransaction();
        return uf;
    }
}
