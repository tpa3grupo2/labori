package ejb.stateless;

import entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<WorkExperience> getPendingWorkExperiences(Company company) {
        Query query = em.createQuery("SELECT x FROM WorkExperience x WHERE x.company = :company AND confirmed = 'Pendente'");

        try {
            return query.setParameter("company", company).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Map<String, Double> getStatsByField(Field field) {
        
        Map<String, Double> returnHash = new HashMap<String, Double>();
        Query query;
        
        query = em.createQuery("SELECT COUNT(x) FROM JobVacancy x WHERE x.field = :field");
        Double vagas = ((Long) query.setParameter("field", field).getSingleResult()).doubleValue();
        
        query = em.createQuery("SELECT COUNT(x) FROM JobVacancy x");
        Double vagas_tot = ((Long) query.getSingleResult()).doubleValue();
        
        returnHash.put("vagas", vagas);
        returnHash.put("tot_vagas", vagas_tot);
        returnHash.put("perc_vagas", vagas/vagas_tot*100);
        
        query = em.createQuery("SELECT COUNT(x) FROM UserLabori x WHERE x.field = :field");
        Double usuarios = ((Long) query.setParameter("field", field).getSingleResult()).doubleValue();
        
        query = em.createQuery("SELECT COUNT(x) FROM UserLabori x");
        Double usuarios_tot = ((Long) query.getSingleResult()).doubleValue();

        returnHash.put("usuarios", usuarios);
        returnHash.put("tot_usuarios", usuarios_tot);
        returnHash.put("perc_usuarios", usuarios/usuarios_tot*100);

        query = em.createQuery("SELECT COUNT(c) FROM JobVacancy x JOIN x.appliedUsers c WHERE x.field = :field");
        Double candidaturas = ((Long) query.setParameter("field", field).getSingleResult()).doubleValue();
        
        query = em.createQuery("SELECT COUNT(c) FROM JobVacancy x JOIN x.appliedUsers c");
        Double candidaturas_tot = ((Long) query.getSingleResult()).doubleValue();
        
        returnHash.put("candidaturas", candidaturas);
        returnHash.put("tot_candidaturas", candidaturas_tot);
        returnHash.put("perc_candidaturas", candidaturas/candidaturas_tot*100);

        query = em.createQuery("SELECT DISTINCT c FROM JobVacancy x JOIN x.company c WHERE x.field = :field");
        Double empresas = ((Integer) query.setParameter("field", field).getResultList().size()).doubleValue();
        
        query = em.createQuery("SELECT COUNT(x) FROM Company x");
        Double empresas_tot = ((Long) query.getSingleResult()).doubleValue();
        
        returnHash.put("empresas", empresas);
        returnHash.put("tot_empresas", empresas_tot);
        
        if (vagas != 0)
            returnHash.put("rel_cand_vagas", usuarios/vagas);
        else
            returnHash.put("rel_cand_vagas", 0.0);
        returnHash.put("perc_empresas", empresas/empresas_tot*100);

        return returnHash;
    }

}
