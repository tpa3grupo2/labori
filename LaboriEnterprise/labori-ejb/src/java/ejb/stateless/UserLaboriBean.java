package ejb.stateless;

import dao.impl.EducationDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.WorkExperienceDAOImpl;
import entity.Education;
import entity.Field;
import entity.UserLabori;
import entity.WorkExperience;
import java.util.List;
import javax.ejb.Stateless;

@Stateless(mappedName="ejb/userLabori")
public class UserLaboriBean implements UserLaboriBeanLocal {

    private UserDAOImpl userDAO;
    private EducationDAOImpl educationDAO;
    private WorkExperienceDAOImpl workExperienceDAO;

    public UserLaboriBean() {
        userDAO = new UserDAOImpl<UserLabori, Long>();
        educationDAO = new EducationDAOImpl<Education, Long>();
        workExperienceDAO = new WorkExperienceDAOImpl<WorkExperience, Long>();
    }

    @Override
    public List<UserLabori> getAll() {
        return userDAO.listAll();
    }

    @Override
    public UserLabori getById(Long id) {
        return (UserLabori) userDAO.get(id);
    }

    @Override
    public void update(UserLabori user) {
        userDAO.startTransaction();
        user.setField((Field)userDAO.getSession().merge(user.getField()));
        userDAO.update(user);
    }

    @Override
    public void remove(UserLabori user) {
        userDAO.delete(user);
    }

    @Override
    public UserLabori checkPass(String email, String password) {
        UserLabori userMatched = getByEmail(email);

        if (userMatched != null && userMatched.getPassword().equals(password))
            return userMatched;
        return null;
    }

    @Override
    public UserLabori getByEmail(String email) {

        List<UserLabori> listUsers;
        UserLabori userExample = new UserLabori();
        userExample.setEmail(email);

        userDAO.startTransaction();
        listUsers = userDAO.findByExample(userExample);
        userDAO.commitTransaction();

        if (listUsers.size() > 0)
            return listUsers.get(0);
        return null;
    }

    @Override
    public UserLabori create(UserLabori user) {
        userDAO.resetSession();
        userDAO.startTransaction();
        user = (UserLabori) userDAO.save(user);
        userDAO.commitTransaction();
        return user;
    }

    @Override
    public List<Education> getUserEducation(UserLabori user) {
        userDAO.startTransaction();

        Education education = new Education();
        education.setUser(user);
        List<Education> listEducation = educationDAO.findByExample(education);

        userDAO.commitTransaction();
        return listEducation;
    }

    @Override
    public Education addEducation(UserLabori user, Education education) {
        userDAO.startTransaction();

        user = (UserLabori) userDAO.findOneByExample(user);
        education.setUser(user);
        education = (Education) educationDAO.save(education);

        userDAO.commitTransaction();
        return education;
    }

    @Override
    public void removeEducation(Education education) {
        userDAO.startTransaction();
        educationDAO.delete(education);
        userDAO.commitTransaction();
    }

    @Override
    public List<WorkExperience> getWorkExperience(UserLabori user) {
        userDAO.startTransaction();

        WorkExperience workExperience = new WorkExperience();
        workExperience.setUser(user);
        List<WorkExperience> listWorkExperience = workExperienceDAO.findByExample(workExperience);

        userDAO.commitTransaction();
        return listWorkExperience;
    }

    @Override
    public WorkExperience addWorkExperience(UserLabori user, WorkExperience workExperience) {
        userDAO.startTransaction();

        user = (UserLabori) userDAO.findOneByExample(user);
        workExperience.setUser(user);
        workExperience = (WorkExperience) workExperienceDAO.save(workExperience);

        userDAO.commitTransaction();
        return workExperience;
    }

    @Override
    public void removeWorkExperience(WorkExperience workExperience) {
        userDAO.startTransaction();
        educationDAO.delete(workExperience);
        userDAO.commitTransaction();
    }
}
