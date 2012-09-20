package mb;

import entity.UserLabori;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private UserLabori user;
    private boolean logged;

    @ManagedProperty("#{messageBean}")
    private MessageBean messageBean;

    public UserBean() {
        super();
        reset();
    }

    private void reset() {
        user = null;
        logged = false;
    }

    public boolean login(String email, String password) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Query query = session.createQuery("from UserLabori u where email = :email and password = :password")
                .setParameter("email", email.toString())
                .setParameter("password", password.toString());

        user = (UserLabori) query.uniqueResult();

        if (user != null) {
            setLogged(true);
            return true;
        }

        return false;
    }

    public void logout() {
        reset();
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public UserLabori getUser() {
        return user;
    }

    public void setUser(UserLabori user) {
        this.user = user;
    }

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }
}
