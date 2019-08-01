package model.entity.lista01;

import java.util.ArrayList;

public class Gerencia extends Lotacao {
   
	private Gerente gerente;
	private ArrayList<Operacional> operacionais;
	public Gerencia(int id, String nome, String sigla, Gerente gerente, ArrayList<Operacional> operacionais) {
		super(id, nome, sigla);
		this.gerente = gerente;
		this.operacionais = operacionais;
	}
	public Gerencia() {
		super();
		
	}
	public Gerencia(int id, String nome, String sigla) {
		super(id, nome, sigla);
		
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public ArrayList<Operacional> getOperacionais() {
		return operacionais;
	}
	public void setOperacionais(ArrayList<Operacional> operacionais) {
		this.operacionais = operacionais;
	}
	@Override
	public String toString() {
		return "Gerencia [gerente=" + gerente + ", operacionais=" + operacionais + "]";
	}
}
