package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.modelo.Usuarios;
import jdbc.util.ConnectionFactory;

public class EnviarBD {
	private Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;

	public EnviarBD() {
		this.conexao = ConnectionFactory.createConnection();
	}

	public void salvar(Usuarios user) {
		try {
			String sql = "Insert into Usuarios(nome, sobrenome, email, senha)" + " values(?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getSobrenome());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getSenha());
			stmt.execute();
			stmt.close();  		 
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
