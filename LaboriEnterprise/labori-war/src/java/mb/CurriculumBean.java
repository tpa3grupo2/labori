package mb;

import ejb.stateless.CompanyBeanLocal;
import ejb.stateless.UniversityBeanLocal;
import ejb.stateless.UserLaboriBeanLocal;
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
import javax.naming.NamingException;
import util.GetEJB;

@ManagedBean
@ViewScoped
public class CurriculumBean implements Serializable {

    private Education education, educationToRemove;
    private WorkExperience workExperience, workExperienceToRemove;
    private UserLaboriBeanLocal userLaboriEJB;
    private UniversityBeanLocal universityEJB;
    private CompanyBeanLocal companyEJB;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    public String saveCurriculum() {
        return "/dashboard";
    }

    public CurriculumBean() throws NamingException {
        education = new Education();
        workExperience = new WorkExperience();

        GetEJB ejbGetter = new GetEJB();
        userLaboriEJB = ejbGetter.getUserLabori();
        universityEJB = ejbGetter.getUniversity();
        companyEJB = ejbGetter.getCompany();
    }

    public String saveUser() {
        userLaboriEJB.edit(userBean.getUser());
        userBean.getMessageBean().addMessage("Currículo atualizado com sucesso!", "success");
        return "/user/vacancies?faces-redirect=true";
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<University> getAvailableUniversities() {
        return universityEJB.getAll();
    }

    public List<Company> getAvailableCompanies() {
        return companyEJB.getAll();
    }

    public List<String> getAvailableYears() {
        ArrayList<String> list = new ArrayList<String>();
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer START_YEAR = 1980;

        for (Integer i=START_YEAR; i<=currentYear+5; i++)
            list.add(i.toString());

        return list;
    }

    public void addEducation() {
        userBean.getUser().addEducation(education);
        userLaboriEJB.edit(userBean.getUser());
        education = new Education();
    }

    public void removeEducation() {
        userBean.getUser().removeEducation(educationToRemove);
        userBean.setUser(userLaboriEJB.edit(userBean.getUser()));
    }

    public List<WorkExperience> getUserWorkExperience() {
        return userLaboriEJB.getWorkExperience(userBean.getUser());
    }

    public void addWorkExperience() {
        userBean.getUser().addWorkExperience(workExperience);
        userLaboriEJB.edit(userBean.getUser());
        workExperience = new WorkExperience();
    }

    public void removeWorkExperience() {
        userBean.getUser().removeWorkExperience(workExperienceToRemove);
        userBean.setUser(userLaboriEJB.edit(userBean.getUser()));
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public Education getEducationToRemove() {
        return educationToRemove;
    }

    public void setEducationToRemove(Education educationToRemove) {
        this.educationToRemove = educationToRemove;
    }

    public WorkExperience getWorkExperienceToRemove() {
        return workExperienceToRemove;
    }

    public void setWorkExperienceToRemove(WorkExperience workExperienceToRemove) {
        this.workExperienceToRemove = workExperienceToRemove;
    }
}
