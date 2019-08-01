package model.entity;

import java.util.ArrayList;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private ArrayList<Telefone> telefones;
	private String sobrenome;
	private Endereco endereco;
	
	public Cliente( int id ,String nome, String cpf, ArrayList<Telefone> telefones, String sobrenome, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
	}
	
	public Cliente(String nome, String cpf, ArrayList<Telefone> telefones, String sobrenome, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
	}
	
	public Cliente() {
		super();
		
	}
	public int getId(){
		return id;
	}
	public void setId(int  id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Cliente [id = +id, nome=" + nome + ", cpf=" + cpf + ", telefones=" + telefones + ", sobrenome=" + sobrenome
				+ ", endereco=" + endereco + "]";
	}

	}
