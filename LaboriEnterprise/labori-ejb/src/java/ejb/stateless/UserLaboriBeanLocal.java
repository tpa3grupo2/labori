package ejb.stateless;

import entity.Education;
import entity.UserLabori;
import entity.WorkExperience;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author cauethenorio
 */
@Remote
public interface UserLaboriBeanLocal {

    public UserLabori create(UserLabori user);
    public List<UserLabori> getAll();
    public UserLabori getById(Long id);
    public UserLabori getByEmail(String email);
    public void update(UserLabori user);
    public void remove(UserLabori user);

    public UserLabori checkPass(String email, String password);

    public List<Education> getUserEducation(UserLabori user);
    public Education addEducation(UserLabori user, Education education);
    public void removeEducation(Education education);

    public List<WorkExperience> getWorkExperience(UserLabori user);
    public WorkExperience addWorkExperience(UserLabori user, WorkExperience workExperience);
    public void removeWorkExperience(WorkExperience workExperience);
}
