package model.entity.lista01;

public class Diretor extends Funcionario {
	
	private double comissao;

	public Diretor(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, double salarioBase,
			double descontoImpostoRenda, double contribuicaoPrevidenciaria, double comissao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, salarioBase, descontoImpostoRenda, contribuicaoPrevidenciaria);
		this.comissao = comissao;
	}

	public Diretor() {
		super();
	
	}
	public Diretor(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, double salarioBase,
			double descontoImpostoRenda, double contribuicaoPrevidenciaria) {
		super(id, nome, cpf, sexo, idade, salarioBruto, salarioBase, descontoImpostoRenda, contribuicaoPrevidenciaria);
	
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return "Diretor [comissao=" + comissao + "]";
	}

	@Override
	public double calcularSalario() {
		 return this.getSalarioBase()* 3 + comissao;
		
	}
}