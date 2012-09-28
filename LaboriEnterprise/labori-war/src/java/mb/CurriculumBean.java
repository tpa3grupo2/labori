package mb;

import entity.Education;
import entity.University;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import util.GeneralFactory;

@ManagedBean
@ViewScoped
public class CurriculumBean implements Serializable {

    private Session session;
    private List<Education> educationList;
    private Education education;

    public CurriculumBean() {
        educationList = new ArrayList<Education>();
    }

    public void iniciarFormulario(){
        education = new Education();
    }

    public void salvar(){
        this.educationList.add(education);
        this.education = new Education();
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<University> getAvailableUniversities() {
        GeneralFactory<entity.University> universityFactory
                = new GeneralFactory<entity.University>("University");

        return universityFactory.getAll();
    }

    public List<String> getAvailableYears() {
        ArrayList<String> list = new ArrayList<String>();
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer START_YEAR = 1980;

        for (Integer i=START_YEAR; i<=currentYear; i++)
            list.add(i.toString());

        return list;
    }
}
