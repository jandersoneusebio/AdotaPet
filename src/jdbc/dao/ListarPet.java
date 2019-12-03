package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Pets;
import jdbc.util.ConnectionFactory;

public class ListarPet {
	private Connection conexao;
	PreparedStatement stmt;
	ResultSet rs;
	
	public ListarPet() {
		this.conexao = ConnectionFactory.createConnection();
	}
	
	public List<Pets> listar(){
		List<Pets> lista = new ArrayList<Pets>();
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM Pets");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pets pet = new Pets();
				pet.setIdPet(rs.getInt(1));
				pet.setPet(rs.getString(2));
				pet.setNome(rs.getString(3));
				pet.setRaca(rs.getString(4));
				pet.setIdade(rs.getString(5) + " " + rs.getString(6));
				pet.setDeficiente(rs.getBoolean(7));
				pet.setDeficiencia(rs.getString(8));
				pet.setSexo(rs.getString(9));
				lista.add(pet);
				
			}
			stmt.close();
			rs.close();
			conexao.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public List<Pets> listarAptos(){
		List<Pets> lista = new ArrayList<Pets>();
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM Pets WHERE adocao = 1");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pets pet = new Pets();
				pet.setIdPet(rs.getInt(1));
				pet.setPet(rs.getString(2));
				pet.setNome(rs.getString(3));
				pet.setRaca(rs.getString(4));
				pet.setIdade(rs.getString(5));
				pet.setTipoIdade(rs.getString(6));
				pet.setDeficiente(rs.getBoolean(7));
				pet.setDeficiencia(rs.getString(8));
				pet.setSexo(rs.getString(9));
				lista.add(pet);
				
			}
			stmt.close();
			rs.close();
			conexao.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	
	
	public List<Pets> buscaApropiar(Pets pet){
		List<Pets> lista = new ArrayList<Pets>();
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM Pets WHERE id" + "VALUES (?)");
			stmt.setLong(1, pet.getIdPet());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(2));
//				nome = pet.setNome(rs.getString(3));
//				pet.setRaca(rs.getString(4));
//				pet.setIdade(rs.getInt(5));
//				pet.setTipoIdade(rs.getString(6));
//				pet.setDeficiente(rs.getBoolean(7));
//				pet.setDeficiencia(rs.getString(8));
//				pet.setSexo(rs.getString(9));
//				lista.add(pet);
			}
			stmt.close();
			conexao.close();
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
}
