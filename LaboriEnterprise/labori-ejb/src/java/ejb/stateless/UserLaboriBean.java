package ejb.stateless;

import entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName="ejb/userLabori")
public class UserLaboriBean implements UserLaboriBeanLocal {

    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    @Override
    public UserLabori edit(UserLabori user) {
        em.merge(user);
        return user;
    }

    @Override
    public UserLabori getByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM UserLabori u WHERE u.email = :email");

        try {
            return (UserLabori) query
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void create (UserLabori user) {
        em.merge(user);
    }

    @Override
    public List<UserLabori> getAll() {
        return em.createQuery("select x from UserLabori x").getResultList();
    }

    @Override
    public UserLabori getById(Long id) {
        return em.find(UserLabori.class, id);
    }

    @Override
    public UserLabori checkPass(String email, String password) {
        UserLabori userMatched = getByEmail(email);

        if (userMatched != null && userMatched.getPassword().equals(password))
            return userMatched;
        return null;
    }

    @Override
    public List<JobVacancy> getAvailableVacancies (UserLabori user) {
        Query query = em.createQuery("SELECT DISTINCT j FROM JobVacancy j LEFT OUTER JOIN j.appliedUsers u WHERE j.field = :field AND (u IS NULL OR u IS NOT :user)");
        try {
            return (List<JobVacancy>) query
                    .setParameter("field", user.getField())
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void remove(UserLabori user) {
        em.remove(user);
    }

    @Override
    public UserLabori addEducation(UserLabori user, Education education) {
        user.addEducation(education);
        return em.merge(user);
    }

    @Override
    public UserLabori removeEducation(UserLabori user, Education education) {
        user.removeEducation(education);
        return em.merge(user);
    }

    @Override
    public UserLabori addWorkExperience(UserLabori user, WorkExperience workExperience) {
        user.addWorkExperience(workExperience);
        return em.merge(user);
    }

    @Override
    public UserLabori removeWorkExperience(UserLabori user, WorkExperience workExperience) {
        user.removeWorkExperience(workExperience);
        return em.merge(user);
    }

    @Override
    public UserLabori applyToJobVacancy(UserLabori user, JobVacancy jobVacancy) {
        user.applyToJobVacancy(jobVacancy);
        return em.merge(user);
    }

    @Override
    public UserLabori removeApplyToJobVacancy(UserLabori user, JobVacancy jobVacancy) {
        user.removeApplyToJobVacancy(jobVacancy);
        return em.merge(user);
    }

    @Override
    public List<JobVacancy> getAppliedVacancies(UserLabori user) {
        Query query = em.createQuery("SELECT DISTINCT j FROM JobVacancy j INNER JOIN j.appliedUsers u WHERE j.field = :field AND u IS :user");
        try {
            return (List<JobVacancy>) query
                    .setParameter("field", user.getField())
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
