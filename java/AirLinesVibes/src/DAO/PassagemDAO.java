package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.ConnectionFactory;
import model.Passagem;

public class PassagemDAO {
	
	private Connection connection;
	
	public PassagemDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void create (Passagem passagem) {
		String sql = "INSERT INTO passagem VALUES (null,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, passagem.getDestino());
			stmt.setDouble(2, passagem.getValor());
			stmt.setInt(3, passagem.getfkIdPromocao());
			stmt.execute();
			System.out.println(" ");
			System.out.println("Passagem persistida!");
			System.out.println(" ");
		} catch (SQLException e) {
			System.out.println(" ");
			System.out.printf("Erro ao persistir os dados de Passagem! \n", e.getMessage());
			System.out.println(" ");
		}
		
	}
	
	public List<Passagem> readPassagem (Scanner scanner) {
		String sql = "SELECT * FROM passagem";
		try {
			Statement stmt = this.connection.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			List<Passagem> passagem = new ArrayList<>();
			
			while (result.next()) {
				Passagem passagem1 = new Passagem();
				passagem1.setIdPassagem(result.getInt(1));
				passagem1.setDestino(result.getString(2));
				passagem1.setValor(result.getDouble(3));
				passagem1.setFkIdPromocao(result.getInt(4));
				passagem.add(passagem1);
			}
			System.out.println(" ");
			System.out.println("--------------------------LISTA DE PASSAGENS------------------------");
			System.out.println(" ");
			return passagem;
			
		} catch (SQLException e) {
			System.out.println(" ");
			System.out.printf("Erro ao Consultar a Lista de Passagem! \n", e.getMessage());
			System.out.println(" ");
			return null;
		}
	}
	
	public void update (Passagem passagem) {
		String sql = "UPDATE passagem SET destino = ? , valor = ? , idPromocao = ? WHERE idPassagem = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, passagem.getDestino());
			stmt.setDouble(2, passagem.getValor());
			stmt.setInt(3, passagem.getfkIdPromocao());
			stmt.setInt(4, passagem.getIdPassagem());
			stmt.execute();
			System.out.println(" ");
			System.out.println("Passagem Atualizada!");
			System.out.println(" ");
		} catch (SQLException e) {
			System.out.println(" ");
			System.out.printf("Erro ao Atualizar os Dados de Passagem! \n", e.getMessage());
			System.out.println(" ");
		}
	}
	
	public void deleteById (int idPassagem) {
		String sql = "DELETE FROM passagem WHERE idPassagem = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPassagem);
			stmt.execute();
			stmt.close();
			connection.close();
			System.out.println(" ");
			System.out.println("Passagem Deletada!");
			System.out.println(" ");
		} catch (SQLException e) {
			System.out.println(" ");
			System.out.printf("Erro ao deletar Passagem! \n", e.getMessage());
			System.out.println(" ");
		}
	}
	

}
