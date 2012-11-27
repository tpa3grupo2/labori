package ejb.stateless;

import entity.Company;
import entity.JobVacancy;
import entity.UserLabori;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/company")
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

    @Override
    public Company edit(Company company) {
        return em.merge(company);
    }

    @Override
    public Company create(Company company) {
        em.persist(company);
        return company;
    }

    @Override
    public Company getByCNPJ(String cnpj) {
        Query query = em.createQuery("SELECT x FROM Company x WHERE x.cnpj = :cnpj");

        try {
            Company c = (Company) query.setParameter("cnpj", cnpj).getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Company checkPass(String cnpj, String password) {
        Company companyMatched = getByCNPJ(cnpj);

        if (companyMatched != null && companyMatched.getPassword().equals(password)) {
            return companyMatched;
        }
        return null;

    }
    
    @Override
    public JobVacancy createVacancy(JobVacancy vacancy) {
        em.persist(vacancy);
        return vacancy;
    }

    @Override
    public List<JobVacancy> getAllVacancies(Company company) {
        Query query = em.createQuery("SELECT x FROM JobVacancy x WHERE x.company = :company");

        try {
            return (List<JobVacancy>) query.setParameter("company", company).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserLabori> getVacancyCandidates(JobVacancy vacancy) {
        Query query = em.createQuery("SELECT x FROM UserLabori x INNER JOIN x.applications j WHERE j = :jobvacancy");

        try {
            return (List<UserLabori>) query.setParameter("jobvacancy", vacancy).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Long getVacancyCandidatesCount(JobVacancy vacancy) {
        Query query = em.createQuery("SELECT COUNT(x) FROM UserLabori x INNER JOIN x.applications j WHERE j = :jobvacancy");

        try {
            return ((Long) query.setParameter("jobvacancy", vacancy).getSingleResult()).longValue();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public JobVacancy getJobVacancyById(Long id) {
        return em.find(JobVacancy.class, id);
    }

    @Override
    public void removeVacancy(JobVacancy vacancy) {
        vacancy = em.merge(vacancy);
        em.remove(vacancy);
    }
}
