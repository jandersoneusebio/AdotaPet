package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import jdbc.modelo.Usuarios;
import jdbc.util.ConnectionFactory;

public class LoginDAO {
	private Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;
	
	
	public LoginDAO() {
		this.conexao = ConnectionFactory.createConnection();
	}
	
	public boolean checkLogin(Usuarios usuario) throws SQLException{
		boolean resultado = false;
		if (usuario.getEmail().equals(null) || usuario.getEmail().equals("")) {
			JOptionPane.showMessageDialog(null, "Email obrigatório","Alerta",JOptionPane.WARNING_MESSAGE);
		} else if (usuario.getSenha().equals(null) || usuario.getSenha().equals("")){
			JOptionPane.showMessageDialog(null, "Senha obrigatória","Alerta",JOptionPane.WARNING_MESSAGE);
		} else {
			resultado = logar(usuario);
		}
		return resultado;
	}
	
	public boolean logar(Usuarios usuario) throws SQLException {
		boolean resultado = false;
		
		stmt = conexao.prepareStatement("SELECT * FROM Usuarios WHERE email = ? AND senha = ?");
		stmt.setString(1, usuario.getEmail());
		stmt.setString(2, usuario.getSenha());
		rs = stmt.executeQuery();
		resultado = rs.next();
		stmt.close();
		conexao.close();
		
		return resultado;
	}
}
