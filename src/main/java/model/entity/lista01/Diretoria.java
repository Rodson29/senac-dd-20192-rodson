package model.entity.lista01;

import java.util.ArrayList;

public class Diretoria extends Lotacao {

	private Diretor diretor;
	private ArrayList<Gerencia> gerencias;
	public Diretoria(int id, String nome, String sigla, Diretor diretor, ArrayList<Gerencia> gerencias) {
		super(id, nome, sigla);
		this.diretor = diretor;
		this.gerencias = gerencias;
	}
	public Diretoria() {
		super();
		
	}
	public Diretoria(int id, String nome, String sigla) {
		super(id, nome, sigla);
		
	}
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	public ArrayList<Gerencia> getGerencias() {
		return gerencias;
	}
	public void setGerencias(ArrayList<Gerencia> gerencias) {
		this.gerencias = gerencias;
	}
	@Override
	public String toString() {
		return "Diretoria [diretor=" + diretor + ", gerencias=" + gerencias + "]";
	}
	
}
