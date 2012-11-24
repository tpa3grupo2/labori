package mb;

import ejb.stateless.UserLaboriBeanLocal;
import entity.Field;
import entity.Uf;
import entity.UserLabori;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.naming.NamingException;

@ManagedBean
@ViewScoped
public class SignupBean implements Serializable {

    private UserLabori user;
    private UserLaboriBeanLocal userLaboriEJB;

    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    public SignupBean() throws NamingException {
        this.user = new UserLabori();
        userLaboriEJB = new util.GetEJB().getUserLabori();
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String createUser() {
        userLaboriEJB.create(user);
        userBean.login(user.getEmail(), user.getPassword());
        return "/user/fill-cv?faces-redirect=true";
    }

    public UserLabori getUser() {
        return user;
    }

    public void setUser(UserLabori usuario) {
        this.user = usuario;
    }

    public List<Uf> getUfs() throws NamingException {
        return new util.GetEJB().getUf().getAll();
    }

    public List<Field> getFields() throws NamingException {
        return new util.GetEJB().getField().getAll();
    }
}
