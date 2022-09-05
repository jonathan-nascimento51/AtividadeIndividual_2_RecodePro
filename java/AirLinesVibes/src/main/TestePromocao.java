package main;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import DAO.PromocaoDAO;
import model.Promocao;

public class TestePromocao {

	public static void createPromocao(Promocao promocao) throws Exception {
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da Promocao: ");
		promocao.setNome(entrada.nextLine());
		
		System.out.println("Digite o identificador da Promoção: ");
		promocao.setIdPromocao(entrada.nextInt());
		
		System.out.println("Digite o valor do desconto nesse formato (0,00):");
		promocao.setDesconto(entrada.nextDouble());
		
	}
	
	public static void selectPromocao (List<Promocao> promocao) throws Exception {
		for (var i : promocao) {
			out.println(
					"Id: " + i.getIdPromocao() +
					" | Nome: " + i.getNome() +
					" | Desconto: " + i.getDesconto());
			System.out.println("--------------------------------------------------------------------");
		}
	}
	
	public static void updatePromocao (Promocao promocao) throws Exception {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da promocao: ");
		promocao.setNome(entrada.nextLine());
		
		System.out.println("Digite o valor do desconto: ");
		promocao.setDesconto(entrada.nextDouble());
	}
	
	public static int deletePromocao(Scanner scanner) {
		System.out.println("Digite o identificador da promoção a ser alterada: ");
		return scanner.nextInt();
	}
	
	public static int mostraOpcoes (Scanner scanner) {
		System.out.println(" ");
		System.out.println("------------------------------PROMOÇÃO------------------------------");
		System.out.println("====================================================================");
		System.out.println("1 - Cadastrar | 2 - consultar | 3 - Alterar | 4 - Deletar | 0 - Sair");
		return scanner.nextInt(); 
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PromocaoDAO dao = new PromocaoDAO();
		
		int opcao = mostraOpcoes(scanner);
		
		while (opcao != 0) {
			 switch(opcao) {
			 case 1:
				 Promocao promocao = new Promocao();
				 createPromocao(promocao);
				 dao.create(promocao);
				 opcao = mostraOpcoes(scanner);
				 break;
				 
			 case 2:
				 selectPromocao(dao.readPromocao(scanner));
				 opcao = mostraOpcoes(scanner);
				 break;
				 
			 case 3:
				 Promocao promo = new Promocao();
				 promo.setIdPromocao((int) deletePromocao(scanner));
				 updatePromocao(promo);
				 dao.update(promo);
				 opcao = mostraOpcoes(scanner);
				 break;
				 
			 case 4:
				 dao.deleteById(deletePromocao(scanner));
				 opcao = mostraOpcoes(scanner);
				 break;
				 
			 }
		}
		
	}

}
