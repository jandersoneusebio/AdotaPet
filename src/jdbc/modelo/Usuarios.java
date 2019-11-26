package jdbc.modelo;

import java.io.Serializable;

public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idUsuario;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getIdEditora() {
		return idUsuario;
	}
	public void setIdEditora(Long idEditora) {
		this.idUsuario = idEditora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
