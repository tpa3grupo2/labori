package ejb.stateless;

import entity.Company;
import entity.JobVacancy;
import entity.UserLabori;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CompanyBeanLocal {
    public List<Company> getAll();
    public Company getById(Long id);

    public Company getByCNPJ(String cnpj);
    public Company checkPass(String cnpj, String password);
    public List<JobVacancy> getAllVacancies(Company company);
    public List<UserLabori> getVacancyCandidates(JobVacancy vacancy);
    public int getVacancyCandidatesCount(JobVacancy vacancy);
}
