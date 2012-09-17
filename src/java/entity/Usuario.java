package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id", "email"}))
public class Usuario implements Serializable {

	
        @Id
        @GeneratedValue(generator = "Emp_Gen")
        @SequenceGenerator(name = "Emp_Gen", allocationSize = 1)
	private Long id;
	@Column(length=64)
        private String nome;
	@Column(unique=true, length=64)
        private String email;
	@Column(length=32)
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
