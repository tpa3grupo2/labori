package mb;

import ejb.stateless.CompanyBeanLocal;
import ejb.stateless.UniversityBeanLocal;
import ejb.stateless.UserLaboriBeanLocal;
import entity.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.naming.NamingException;
import util.GetEJB;

@ManagedBean
@ViewScoped
public class CurriculumBean implements Serializable {

    private Education education;
    private WorkExperience workExperience;

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
        userBean.setUser(userLaboriEJB.addEducation(userBean.getUser(), education));
        education = new Education();
    }

    public void removeEducation(Education educationToRemove) {
        userBean.setUser(userLaboriEJB.removeEducation(userBean.getUser(), educationToRemove));
    }

    public void addWorkExperience() {
        workExperience.setConfirmed("Pendente");
        userBean.setUser(userLaboriEJB.addWorkExperience(userBean.getUser(), workExperience));
        workExperience = new WorkExperience();
    }

    public void removeWorkExperience(WorkExperience workExperienceToRemove) {
        userBean.setUser(userLaboriEJB.removeWorkExperience(userBean.getUser(), workExperienceToRemove));
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

    public void applyToJobVacancy(JobVacancy jobVacancy) {
        userBean.setUser(userLaboriEJB.applyToJobVacancy(userBean.getUser(), jobVacancy));
    }

    public void removeApplyToJobVacancy(JobVacancy jobVacancy) {
        userBean.setUser(userLaboriEJB.removeApplyToJobVacancy(userBean.getUser(), jobVacancy));
    }
    
    public String getWorkExperienceRowClasses() {
        Set<WorkExperience> workExperiences = userBean.getUser().getWorkExperienceRecords();
        String classes = "";
        
        for (Iterator<WorkExperience> it = workExperiences.iterator(); it.hasNext();) {
            WorkExperience we = it.next();
            if (we.getConfirmed().equals("Pendente"))
                classes += "warning,";
            else
                classes += "success,";
        }
        return classes;
    }
}
