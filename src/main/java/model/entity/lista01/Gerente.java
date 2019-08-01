package model.entity.lista01;

public class Gerente extends Funcionario {
	private double comissao;

	public Gerente(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, double salarioBase,
			double descontoImpostoRenda, double contribuicaoPrevidenciaria, double comissao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, salarioBase, descontoImpostoRenda, contribuicaoPrevidenciaria);
		this.comissao = comissao;
	}

	public Gerente() {
		super();
		
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public Gerente(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, double salarioBase,
			double descontoImpostoRenda, double contribuicaoPrevidenciaria) {
		super(id, nome, cpf, sexo, idade, salarioBruto, salarioBase, descontoImpostoRenda, contribuicaoPrevidenciaria);
		
	}

	@Override
	public String toString() {
		return "Gerente [comissao=" + comissao + "]";
	}

	@Override
	public double calcularSalario() {
		
			
			return  this.getSalarioBruto() * 0.9 + this.comissao;
	
	}

}
