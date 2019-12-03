package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.modelo.Responsavel;
import jdbc.util.ConnectionFactory;

public class ResponsavelDAO {
	private Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;
	
	public ResponsavelDAO() {
		this.conexao = ConnectionFactory.createConnection();
	}
//	private long id;
//	private String nome;
//	private String sobrenome;
//	private String endereco;
//	private String email;
//	private String sexo;
//	private long telefone;
//	private int idade;
//	private long cpf;
	public void cadResp(Responsavel resp) {
		try {
			String sql = "INSERT INTO Responsavel(nome,sobrenome,endereco,email,sexo,telefone,idade,cpf,alergico,filhos)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, resp.getNome());
			stmt.setString(2, resp.getSobrenome());
			stmt.setString(3, resp.getEndereco());
			stmt.setString(4, resp.getEmail());
			stmt.setString(5, resp.getSexo());
			stmt.setInt(6, resp.getTelefone());
			stmt.setInt(7, resp.getIdade());
			stmt.setString(8, resp.getCpf());
			stmt.setBoolean(9, resp.isAlergico());
			stmt.setBoolean(10, resp.isFilhos());
			stmt.execute();
			
			stmt.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
