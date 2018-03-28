package br.com.springjdbc.model;

public class Produto {

	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	public Produto() {}

	public Produto(String nome, String descricao) {
		setNome(nome);
		setDescricao(descricao);
	}
	
	public Produto(Integer id, String nome, String descricao) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	
}
