package ejb.stateless;

import dao.impl.CompanyDAOImpl;
import entity.Company;
import java.util.List;
import javax.ejb.Stateless;

@Stateless(mappedName="ejb/company")
public class CompanyBean implements CompanyBeanLocal {

    private CompanyDAOImpl companyDAO;

    public CompanyBean() {
        companyDAO = new CompanyDAOImpl<Company, Long>();
    }

    @Override
    public List<Company> getAll() {
        return companyDAO.listAll();
    }

    @Override
    public Company getById(Long id) {
        return (Company) companyDAO.get(id);
    }
}
