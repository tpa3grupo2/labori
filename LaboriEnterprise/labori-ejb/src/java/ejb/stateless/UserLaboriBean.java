package ejb.stateless;

import entity.UserLabori;
import entity.WorkExperience;
import facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName="ejb/userLabori")
public class UserLaboriBean extends AbstractFacade<UserLabori> implements UserLaboriBeanLocal {

    @PersistenceContext(unitName = "labori-warPU")
    private EntityManager em;

    public UserLaboriBean() {
        super(UserLabori.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public UserLabori edit(UserLabori user) {
        user = super.edit(user);
        em.flush();
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
        user.setUf(em.merge(user.getUf()));
        em.persist(user);
    }

    @Override
    public List<UserLabori> getAll() {
        return findAll();
    }

    @Override
    public UserLabori getById(Long id) {
        return (UserLabori) find(id);
    }

    @Override
    public UserLabori checkPass(String email, String password) {
        UserLabori userMatched = getByEmail(email);

        if (userMatched != null && userMatched.getPassword().equals(password))
            return userMatched;
        return null;
    }

//    @Override
//    public Education addEducation(UserLabori user, Education education) {
//        user.addEducation(education);
//        em.merge(user);
//        return education;
//    }
//
//    @Override
//    public void removeEducation(Education education) {
//        education = em.merge(education);
//        em.remove(education);
//    }
//
    @Override
    public WorkExperience addWorkExperience(UserLabori user, WorkExperience workExperience) {
        return null;
    }

    @Override
    public List<WorkExperience> getWorkExperience(UserLabori user) {
        return null;
    }
}
