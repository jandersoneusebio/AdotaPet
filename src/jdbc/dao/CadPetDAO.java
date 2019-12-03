package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.modelo.Pets;
import jdbc.util.ConnectionFactory;

public class CadPetDAO {
	private Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;
	
	
	public CadPetDAO() {
		this.conexao = ConnectionFactory.createConnection();
	}
	
	public void cadastrar(Pets pet) {
		try {
			String sql = "INSERT INTO Pets(pet,nome,raca,idade,tipoIdade,deficiente,deficiencia,sexo,adocao)" + " VALUES(?,?,?,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pet.getPet());
			stmt.setString(2, pet.getNome());
			stmt.setString(3, pet.getRaca());
			stmt.setString(4, pet.getIdade());
			stmt.setString(5, pet.getTipoIdade());
			stmt.setBoolean(6, pet.isDeficiente());
			stmt.setString(7, pet.getDeficiencia());
			stmt.setString(8, pet.getSexo());
			stmt.setBoolean(9, pet.isAdocao());
			stmt.execute();
			stmt.close();
			conexao.close();
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
