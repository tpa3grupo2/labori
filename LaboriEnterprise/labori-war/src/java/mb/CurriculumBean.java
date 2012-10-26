package mb;

import entity.Company;
import entity.Education;
import entity.University;
import entity.WorkExperience;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import util.GeneralFactory;

@ManagedBean
@ViewScoped
public class CurriculumBean implements Serializable {

    private Education education;
    private WorkExperience workExperience;
    private Integer educationIdToRemove;
    private Integer workExperienceIdToRemove;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    public String saveCurriculum() {
        return "/dashboard";
    }

    public CurriculumBean() {
        education = new Education();
        workExperience = new WorkExperience();
    }

    public String saveUser() {

        GeneralFactory<entity.UserLabori> userFactory
                = new GeneralFactory<entity.UserLabori>("UserLabori");

        userBean.getMessageBean().addMessage("Currículo atualizado com sucesso!", "success");

        userFactory.update(userBean.getUser());
        return "/user/fill-cv?faces-redirect=true";
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<University> getAvailableUniversities() {
        GeneralFactory<entity.University> universityFactory
                = new GeneralFactory<entity.University>("University");

        return universityFactory.getAll();
    }

    public List<Company> getAvailableCompanies() {
        GeneralFactory<entity.Company> companyFactory
                = new GeneralFactory<entity.Company>("Company");

        return companyFactory.getAll();
    }

    public List<String> getAvailableYears() {
        ArrayList<String> list = new ArrayList<String>();
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer START_YEAR = 1980;

        for (Integer i=START_YEAR; i<=currentYear+5; i++)
            list.add(i.toString());

        return list;
    }

    public List<Education> getUserEducation() {
        GeneralFactory<entity.Education> educationFactory
                = new GeneralFactory<entity.Education>("Education");

        return educationFactory.getAllfromUser(userBean.getUser());
    }

    public void addEducation() {
        GeneralFactory<entity.University> universityFactory
                = new GeneralFactory<entity.University>("University");

        education.setUser(userBean.getUser());
        universityFactory.create(education);
        education = new Education();
    }

    public void removeEducation() {
        GeneralFactory<entity.Education> educationFactory
                = new GeneralFactory<entity.Education>("Education");

        educationFactory.removeFromId(educationIdToRemove);
    }

    public List<WorkExperience> getUserWorkExperience() {
        GeneralFactory<entity.WorkExperience> workExperienceFactory
                = new GeneralFactory<entity.WorkExperience>("WorkExperience");

        return workExperienceFactory.getAllfromUser(userBean.getUser());
    }

    public void addWorkExperience() {
        GeneralFactory<entity.WorkExperience> workExperienceFactory
                = new GeneralFactory<entity.WorkExperience>("WorkExperience");

        workExperience.setUser(userBean.getUser());
        workExperienceFactory.create(workExperience);
        workExperience = new WorkExperience();
    }

    public void removeWorkExperience() {
        GeneralFactory<entity.WorkExperience> workExperienceFactory
                = new GeneralFactory<entity.WorkExperience>("WorkExperience");

        workExperienceFactory.removeFromId(workExperienceIdToRemove);
    }


    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public Integer getEducationIdToRemove() {
        return educationIdToRemove;
    }

    public void setEducationIdToRemove(Integer educationIdToRemove) {
        this.educationIdToRemove = educationIdToRemove;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public Integer getWorkExperienceIdToRemove() {
        return workExperienceIdToRemove;
    }

    public void setWorkExperienceIdToRemove(Integer workExperienceIdToRemove) {
        this.workExperienceIdToRemove = workExperienceIdToRemove;
    }
}
