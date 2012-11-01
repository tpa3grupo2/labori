package ejb.stateless;

import entity.Field;
import entity.JobVacancy;
import entity.UserLabori;
import entity.WorkExperience;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UserLaboriBeanLocal {

    public void create(UserLabori user);
    public List<UserLabori> getAll();
    public UserLabori getById(Long id);
    public UserLabori getByEmail(String email);
    public UserLabori edit(UserLabori user);
    public void remove(UserLabori user);
    public UserLabori checkPass(String email, String password);

    public List<WorkExperience> getWorkExperience(UserLabori user);
    public WorkExperience addWorkExperience(UserLabori user, WorkExperience workExperience);
    
    public List<JobVacancy> getAvailableVacancies (Field field);
}
