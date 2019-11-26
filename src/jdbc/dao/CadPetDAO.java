package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.modelo.Pets;
import jdbc.util.ConnectionFactory;

public class CadPetDAO {
	private Connection conexao;
	ResultSet rs;
	PreparedStatement stmt;
	
	public CadPetDAO() {
		this.conexao = ConnectionFactory.createConnection();
	}
	
	public void cadastrar(Pets pet) {
		try {
			String sql = "INSERT INTO Pets(nome,raca,idade,tipoIdade,deficiente,deficiencia,sexo)" + " VALUES(?,?,?,?,?,?,?)";
			stmt.setString(1, pet.getNome());
			stmt.setString(2, pet.getRaca());
			stmt.setInt(3, pet.getIdade());
			stmt.setString(4, pet.getTipoIdade());
			stmt.setBoolean(5, pet.isDeficiente());
			stmt.setString(6, pet.getDeficiencia());
			stmt.setString(7, pet.getSexo());
			stmt.execute();
			stmt.close();
			conexao.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
