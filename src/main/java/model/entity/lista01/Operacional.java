package model.entity.lista01;

public class Operacional extends Funcionario {
	
	

	public Operacional() {
		super();
		
	}

	public Operacional(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, double salarioBase,
			double descontoImpostoRenda, double contribuicaoPrevidenciaria) {
		super(id, nome, cpf, sexo, idade, salarioBruto, salarioBase, descontoImpostoRenda, contribuicaoPrevidenciaria);
		
	}

	@Override
	public double calcularSalario() {
		
		return this.getSalarioBruto() * 0.85;
	}

}
