package model;

public class Promocao {

	private String nome;
	private double desconto;
	private int idPromocao;
	
	public Promocao() {}
	
	public Promocao (String nome, double desconto, int idPromocao) {
		this.nome = nome;
		this.desconto = desconto;
		this.idPromocao = idPromocao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
	}
	
	public int getIdPromocao() {
		return idPromocao;
	}

}
