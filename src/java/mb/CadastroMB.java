package mb;

import dao.IDAO;
import dao.impl.UserDAOImpl;
import entity.UserLabori;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserLabori usuario;

	public CadastroMB() {
		this.usuario = new UserLabori();
	}

	public void criarConta() {
		try {
			
			IDAO dao = new UserDAOImpl();
			
			dao.create(usuario);

			FacesMessage message = new FacesMessage("Usuário criado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Houve um erro ao salvar: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public UserLabori getUser() {
		return usuario;
	}

	public void setUser(UserLabori usuario) {
		this.usuario = usuario;
	}
}
