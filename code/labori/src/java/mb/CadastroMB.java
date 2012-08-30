package mb;

import dao.IDAO;
import dao.impl.UsuarioDAOImpl;
import entity.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public CadastroMB() {
		this.usuario = new Usuario();
	}

	public void criarConta() {
		try {
			
			IDAO dao = new UsuarioDAOImpl();
			
			dao.create(usuario);

			FacesMessage message = new FacesMessage("Usuário criado com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Houve um erro ao salvar: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
