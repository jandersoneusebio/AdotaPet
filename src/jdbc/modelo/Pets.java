package jdbc.modelo;

import java.io.Serializable;

public class Pets implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String raca;
	private int idade;
	private String tipoIdade;
	private boolean deficiente;
	private String deficiencia;
	private String sexo;
	
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTipoIdade() {
		return tipoIdade;
	}
	public void setTipoIdade(String tipoIdade) {
		this.tipoIdade = tipoIdade;
	}
	public boolean isDeficiente() {
		return deficiente;
	}
	public void setDeficiente(boolean deficiente) {
		this.deficiente = deficiente;
	}
	public String getDeficiencia() {
		return deficiencia;
	}
	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}
}
