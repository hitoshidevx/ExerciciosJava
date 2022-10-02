package br.com.hitoshi.models;

public class Produto {
	
	private int id;
	private String nomeProduto;
	private double precoProduto;
	private int quantidade;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto() {
		
	}
	
	public Produto(int id, String nomeProduto, double precoProduto, int quantidade) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.quantidade = quantidade;
	}
	
}
