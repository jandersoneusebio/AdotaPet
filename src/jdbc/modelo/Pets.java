package jdbc.modelo;

import java.io.Serializable;

public class Pets implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idPet;
	private String pet;
	private String nome;
	private String raca;
	private String idade;
	private String tipoIdade;
	private boolean deficiente;
	private String deficiencia;
	private String sexo;
	private boolean adocao;
	
	
	public boolean isAdocao() {
		return adocao;
	}
	public void setAdocao(boolean adocao) {
		this.adocao = adocao;
	}
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}
	
	public int getIdPet() {
		return idPet;
	}
	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}
	
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
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
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
