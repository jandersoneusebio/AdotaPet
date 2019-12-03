package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc.modelo.Ficha;
import jdbc.modelo.Pets;
import jdbc.util.ConnectionFactory;

public class Adocao {
	private Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;
	
	public Adocao() {
		this.conexao = ConnectionFactory.createConnection();
	}
	
	public void apropriar(Pets pet){
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM Pets WHERE idPet = ?");
			stmt.setInt(1, pet.getIdPet());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				stmt = conexao.prepareStatement("UPDATE Ficha SET nome = ?, raca = ?, sexo = ?, idade = ?, tipoIdade = ?, deficiencia = ?, idPet = ? WHERE id = ?");
				stmt.setString(1, rs.getString(3));
				stmt.setString(2, rs.getString(4));
				stmt.setString(3, rs.getString(9));
				stmt.setString(4, rs.getString(5));
				stmt.setString(5, rs.getString(6));
				stmt.setString(6, rs.getString(8));
				stmt.setString(7, rs.getString(1));
				stmt.setInt(8, 1);
				stmt.execute();
			}
			stmt.close();
			rs.close();
			conexao.close();
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao enviar as informações para a ficha","ERRO",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	public List<Ficha> preencher() {
		List<Ficha> dados = new ArrayList<Ficha>();
		
		
		try {
		stmt = conexao.prepareStatement("SELECT * FROM Ficha");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Ficha ficha = new Ficha();
			ficha.setNome(rs.getString(2));
			ficha.setRaca(rs.getString(3));
			ficha.setSexo(rs.getString(4));
			ficha.setIdade(rs.getString(5));
			ficha.setTipoIdade(rs.getString(6));
			ficha.setDeficiencia(rs.getString(7));
			dados.add(ficha);
		}
		stmt.close();
		conexao.close();
		rs.close();
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a ficha","ERRO",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return dados;
		
	}
	

}
