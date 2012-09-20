package mb;

import dao.IDAO;
import dao.impl.UserDAOImpl;
import entity.Uf;
import entity.UserLabori;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    
    public void createUser() {
        try {

            IDAO dao = new UserDAOImpl();
            dao.create(user);

            userBean.login(user.getEmail(), user.getPassword());

            FacesMessage message = new FacesMessage("Usuário criado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Houve um erro ao salvar: " + e);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
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
}
