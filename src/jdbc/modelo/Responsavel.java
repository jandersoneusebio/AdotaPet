package jdbc.modelo;

import java.io.Serializable;

public class Responsavel implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String sobrenome;
	private String endereco;
	private String email;
	private String sexo;
	private int telefone;
	private int idade;
	private String cpf;
	private boolean filhos;
	private boolean alergico;

	
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public boolean isFilhos() {
		return filhos;
	}
	public void setFilhos(boolean filhos) {
		this.filhos = filhos;
	}
	public boolean isAlergico() {
		return alergico;
	}
	public void setAlergico(boolean alergico) {
		this.alergico = alergico;
	}
	
}
