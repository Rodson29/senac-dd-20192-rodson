package model.entity.lista01;

public abstract class Funcionario {

	private int id;
	private String nome;
	private String cpf; 
	private String sexo;
	private int idade;
	private double salarioBruto;
	private double salarioBase;
	private double descontoImpostoRenda;
	private double contribuicaoPrevidenciaria;
	public Funcionario(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, double salarioBase,
			double descontoImpostoRenda, double contribuicaoPrevidenciaria) {
		super();
		this.id= id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
		this.salarioBruto = salarioBruto;
		this.salarioBase = salarioBase;
		this.descontoImpostoRenda = descontoImpostoRenda;
		this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
	}
	public Funcionario() {
		super();
		
	}
	public int getId(){
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double getDescontoImpostoRenda() {
		return descontoImpostoRenda;
	}
	public void setDescontoImpostoRenda(double descontoImpostoRenda) {
		this.descontoImpostoRenda = descontoImpostoRenda;
	}
	public double getContribuicaoPrevidenciaria() {
		return contribuicaoPrevidenciaria;
	}
	public void setContribuicaoPrevidenciaria(double contribuicaoPrevidenciaria) {
		this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
	}
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ",nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", idade=" + idade + ", salarioBruto="
				+ salarioBruto + ", salarioBase=" + salarioBase + ", descontoImpostoRenda=" + descontoImpostoRenda
				+ ", contribuicaoPrevidenciaria=" + contribuicaoPrevidenciaria + "]";
	}
	public void descontarImpostoRenda(){
		double descontoImpostoRenda = this.getSalarioBruto();
		if (this.getSalarioBruto() < 1800){
			descontoImpostoRenda = 0;

		}else if (this.getSalarioBruto() >= 1800 && this.getSalarioBruto() <=3000){
			descontoImpostoRenda = salarioBruto*0.10;

		}else {
			descontoImpostoRenda = salarioBruto * 0.15;
		}
	}

	public void descontarContribuicaoPrevidenciaria(){
		if (this.getIdade() < 45){
			contribuicaoPrevidenciaria = salarioBruto * 0.12;
		}else{
			contribuicaoPrevidenciaria = salarioBruto * 0.08;
		}
	}

	public void calcularSalarioBase(){
		salarioBase = salarioBruto-descontoImpostoRenda- contribuicaoPrevidenciaria;
	}
	
	public abstract double calcularSalario();


	
}

