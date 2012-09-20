package mb;

import dao.IDAO;
import dao.impl.UserDAOImpl;
import entity.Field;
import entity.Uf;
import entity.UserLabori;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

@ManagedBean
@ViewScoped
public class SignupBean implements Serializable {

    private UserLabori user;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    public SignupBean() {
        this.user = new UserLabori();
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String createUser() {

            IDAO dao = new UserDAOImpl();
            dao.create(user);

            userBean.login(user.getEmail(), user.getPassword());
            return "/user/fill-cv?faces-redirect=true";
    }

    public UserLabori getUser() {
        return user;
    }

    public void setUser(UserLabori usuario) {
        this.user = usuario;
    }

    public List<Uf> getUfs() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Uf");
        return query.list();
    }

    public List<Field> getFields() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Field");
        return query.list();
    }
}
