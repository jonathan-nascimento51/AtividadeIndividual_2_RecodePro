package model;

public class Passagem {
	
	private int idPassagem;
	private String destino;
	private double valor;
	private int fkIdPromocao;

	public Passagem() {}
	
	public Passagem(String destino, double valor) {
		this.destino = destino;
		this.valor = valor;
	}
	
	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getfkIdPromocao() {
		return fkIdPromocao;
	}

	public void setFkIdPromocao(int fkIdPromocao) {
		this.fkIdPromocao = fkIdPromocao;
	}
}
