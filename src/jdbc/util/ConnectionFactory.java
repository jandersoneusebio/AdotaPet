package jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	public static Connection createConnection() {
		String stringDeConexao = "jdbc:mysql://localhost:3306/adotaPet?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "";// coloque a senha do seu BD
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não Foi Possivel Realizar Conexão com o BD ");
		}
		return conexao;
	}

}