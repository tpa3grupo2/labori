package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Usuario implements Serializable {

	@SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
	@Id
	@GeneratedValue(generator = "Emp_Gen")
	private Long id;
	@Column(unique = true)
	private String nome;
	private String login;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
