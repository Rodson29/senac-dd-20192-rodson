package model.entity.lista01;

public abstract class Lotacao {
	
	private int id;
	private String nome;
	private String sigla;
	public Lotacao(int id, String nome, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}
	public Lotacao() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	@Override
	public String toString() {
		return "Lotacao [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}

}
