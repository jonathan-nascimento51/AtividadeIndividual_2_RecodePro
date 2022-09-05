package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.ConnectionFactory;
import model.Promocao;

import java.sql.Statement;


public class PromocaoDAO {

		private Connection connection;
		
		public PromocaoDAO() {
			this.connection = new ConnectionFactory().getConnection();
					
		}
		
		public void create (Promocao promocao) {
			String sql = "INSERT INTO promocao VALUES (?,?,?)";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, promocao.getIdPromocao());
				stmt.setDouble(2, promocao.getDesconto());
				stmt.setString(3, promocao.getNome());
				stmt.execute();
				System.out.println(" ");
				System.out.println("Promoção persistida!");
				System.out.println(" ");
			} catch (SQLException e) {
				System.out.println(" ");
				System.out.printf("Erro ao persistir os dados de Promoção! \n", e.getMessage());
				System.out.println(" ");
			}
		}
		
		public List<Promocao> readPromocao(Scanner scanner) {
			String sql = "SELECT * FROM promocao";
			try {
				Statement stmt = this.connection.createStatement();
				ResultSet result = stmt.executeQuery(sql);
				List<Promocao> promocao = new ArrayList<>();
				
				while (result.next()) {
					Promocao promocao1 = new Promocao();
					promocao1.setIdPromocao(result.getInt(1));
					promocao1.setDesconto(result.getDouble(2));
					promocao1.setNome(result.getString(3));
					promocao.add(promocao1);
				}
				System.out.println(" ");
				System.out.println("--------------------------LISTA DE PROMOÇÕES------------------------");
				System.out.println(" ");
				return promocao;
				
				
			} catch (SQLException e) {
				System.out.println(" ");
				System.out.printf("Erro ao Consultar a Lista de Promoções! \n", e.getMessage());
				System.out.println(" ");
				return null;
			}
			
		}
		
		public void update (Promocao promocao) {
			String sql = "UPDATE promocao SET desconto = ? , nome = ? WHERE idPromocao = ?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setDouble(1, promocao.getDesconto());
				stmt.setString(2, promocao.getNome());
				stmt.setInt(3, promocao.getIdPromocao());
				stmt.execute();
				System.out.println(" ");
				System.out.println("Promocao Atualizada!");
				System.out.println(" ");
			} catch (SQLException e) {
				System.out.println(" ");
				System.out.printf("Erro ao Atualizar os Dados de Promocao! \n", e.getMessage());
				System.out.println(" ");
			}
		}
		
		public void deleteById (int idPromocao) {
			String sql = "DELETE FROM promocao WHERE idPromocao = ?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, idPromocao);
				stmt.execute();
				System.out.println(" ");
				System.out.println("Promocao Deletada!");
				System.out.println(" ");
			} catch (SQLException e) {
				System.out.println(" ");
				System.out.printf("Erro ao deletar a Promoção! \n", e.getMessage());
				System.out.println(" ");
			}
		}
}
