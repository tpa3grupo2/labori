package mb;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;
    
    @ManagedProperty("#{userBean}")
    private UserBean userBean;

    public String login() {
        
        String from = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("from");
        
        String returnViewId = "/user/login";
        if (userBean.login(email, password)) {
            
            if (from != null)
                returnViewId = from;
            else
                returnViewId = "/index";
        }
        
        return returnViewId + "?faces-redirect=true";
    }
    
    public void logout() {        
        userBean.logout();
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();        
        try {
            ec.redirect(ec.getRequestContextPath() + "/");
        } catch (IOException e) {}
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
