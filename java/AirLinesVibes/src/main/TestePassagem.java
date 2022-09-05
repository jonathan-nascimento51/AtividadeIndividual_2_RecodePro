package main;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import DAO.PassagemDAO;
import model.Passagem;

public class TestePassagem {
	
	public static void  createPassagem (Passagem passagem) throws Exception {
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite seu Destino: ");
		passagem.setDestino(entrada.nextLine());
		
		System.out.println("Digite o valor da sua Passagem: ");
		passagem.setValor(entrada.nextDouble());
		
		System.out.println("Digite o ID da Promocao para Receber o Desconto: ");
		passagem.setFkIdPromocao(entrada.nextInt());
	}
	
	public static void updatePassagem (Passagem passagem) throws Exception {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o Novo Destino: ");
		passagem.setDestino(entrada.nextLine());
		
		System.out.println("Digite o Valor da Passagem: ");
		passagem.setValor(entrada.nextDouble());
		
		System.out.println("Digite o ID da Promoção: ");
		passagem.setFkIdPromocao(entrada.nextInt());
	}
	
	public static int deletePassagem(Scanner scanner) {
		System.out.println("Digite o identificador da passagem a ser alterada: ");
		return scanner.nextInt();
	}
	
	public static void selectPassagem (List<Passagem> passagem) throws Exception {
		for (var i : passagem) {
			out.println(
					"Id: " + i.getIdPassagem() +
					" | Destino: " + i.getDestino() +
					" | Valor: " + i.getValor() +
					" | Id Promoção: " + i.getfkIdPromocao());
			System.out.println("--------------------------------------------------------------------");
		}
	}
	
	
	
	public static int mostraOpcoes (Scanner scanner) {
		System.out.println(" ");
		System.out.println("------------------------------PASSAGEM------------------------------");
		System.out.println("====================================================================");
		System.out.println("1 - Cadastrar | 2 - consultar | 3 - Alterar | 4 - Deletar | 0 - Sair");
		return scanner.nextInt(); 
	}

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		PassagemDAO dao = new PassagemDAO();
		
		int opcao = mostraOpcoes(scanner);
		
		while (opcao != 0) {
			switch(opcao) {
			case 1:
				Passagem passagem = new Passagem();
				createPassagem(passagem);
				dao.create(passagem);
				opcao = mostraOpcoes(scanner);
				break;
			case 2:
				selectPassagem(dao.readPassagem(scanner));
				opcao = mostraOpcoes(scanner);
				break;
			case 3:
				Passagem passa = new Passagem();
				passa.setIdPassagem((int) deletePassagem(scanner));
				updatePassagem(passa);
				dao.update(passa);
				opcao = mostraOpcoes(scanner);
				break;
			case 4:
				dao.deleteById(deletePassagem(scanner));
				opcao = mostraOpcoes(scanner);
				break;
			}
		}
	}

}
