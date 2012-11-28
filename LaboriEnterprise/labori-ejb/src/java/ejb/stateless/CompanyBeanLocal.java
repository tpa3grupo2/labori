package ejb.stateless;

import entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

@Remote
public interface CompanyBeanLocal {
    public List<Company> getAll();
    public Company getById(Long id);
    public Company edit(Company company);
    public Company create(Company company);

    public Company getByCNPJ(String cnpj);
    public Company checkPass(String cnpj, String password);
    public JobVacancy createVacancy(JobVacancy vacancy);
    public List<JobVacancy> getAllVacancies(Company company);
    public List<UserLabori> getVacancyCandidates(JobVacancy vacancy);
    public void removeVacancy(JobVacancy vacancy);
    public Long getVacancyCandidatesCount(JobVacancy vacancy);

    public JobVacancy getJobVacancyById(Long id);
    public List<WorkExperience> getPendingWorkExperiences(Company company);
    public Map<String, Double> getStatsByField(Field field);
}
