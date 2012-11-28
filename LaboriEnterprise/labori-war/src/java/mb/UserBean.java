package mb;

import ejb.stateless.UserLaboriBeanLocal;
import entity.JobVacancy;
import entity.UserLabori;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private UserLabori user;
    private boolean logged;
    private UserLaboriBeanLocal userLaboriEJB;

    @ManagedProperty("#{messageBean}")
    private MessageBean messageBean;

    public UserBean() throws NamingException {
        super();
        reset();

        userLaboriEJB = new util.GetEJB().getUserLabori();
    }

    private void reset() {
        user = null;
        logged = false;
    }
    
    public void refresh() {
        if (user != null)
            user = userLaboriEJB.getById(user.getId());
    }

    public boolean login(String email, String password) {

        user = userLaboriEJB.checkPass(email, password);

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

    public List<JobVacancy> getAvailableVacancies() {
        return userLaboriEJB.getAvailableVacancies(user);
    }

    public List<JobVacancy> getAppliedVacancies() {
        return userLaboriEJB.getAppliedVacancies(user);
    }
}
