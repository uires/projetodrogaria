package br.com.drogariareescrita.controleestoque.domains;

import java.util.Date;

public class Medicamento extends ModeloEntidades {
	private int quantidade;
	private String nome;
	private double preco;
	private String substrancias;
	private String composicao;
	private String descricaoDeUsuabilidade;
	private double pesoLiquido;
	private Date dataEntradaUltimoEstoque;
	private int quantidadeMinimaDeUnidades;
	private Fabricante fabricante;
	
	public Medicamento() {
		Fabricante f = new Fabricante();
		f.setId(1L);
		this.setFabricante(f);
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeMinimaDeUnidades() {
		return quantidadeMinimaDeUnidades;
	}

	public void setQuantidadeMinimaDeUnidades(int quantidadeMinimaDeUnidades) {
		this.quantidadeMinimaDeUnidades = quantidadeMinimaDeUnidades;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Date getDataEntradaUltimoEstoque() {
		return dataEntradaUltimoEstoque;
	}

	public void setDataEntradaUltimoEstoque(Date dataEntradaUltimoEstoque) {
		this.dataEntradaUltimoEstoque = dataEntradaUltimoEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSubstrancias() {
		return substrancias;
	}

	public void setSubstrancias(String substrancias) {
		this.substrancias = substrancias;
	}

	public String getComposicao() {
		return composicao;
	}

	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}

	public String getDescricaoDeUsuabilidade() {
		return descricaoDeUsuabilidade;
	}

	public void setDescricaoDeUsuabilidade(String descricaoDeUsuabilidade) {
		this.descricaoDeUsuabilidade = descricaoDeUsuabilidade;
	}

	public double getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
}
