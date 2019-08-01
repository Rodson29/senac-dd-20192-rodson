package model.dao.Lista01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.Banco;
import model.dao.BaseDAO;
import model.entity.Telefone;
import model.entity.lista01.Diretor;
import model.entity.lista01.Funcionario;
import model.entity.lista01.Gerente;



public class FuncionarioDAO implements BaseDAO<Funcionario> {
	
	public static final String DESCRICAO_TIPO_FUNCIONARIO_OPERACIONAL = "Operacional";
	public static final String DESCRICAO_TIPO_FUNCIONARIO_DIRETOR = "Diretor";
	public static final String DESCRICAO_TIPO_FUNCIONARIO_GERENTE = "Gerente";
	public static final String TIPO_FUNCIONARIO_OPERACIONAL = "O";
	public static final String TIPO_FUNCIONARIO_DIRETOR = "D";
	public static final String TIPO_FUNCIONARIO_GERENTE = "G";

	public Funcionario salvar(Funcionario novoFuncionario) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO FUNCIONARIO(NOME, CPF, SEXO, IDADE, SALARIOBRUTO, SALARIOBASE,DESCONTOIMPOSTORENDA,"
				+ "CONTRIBUICAOPREVIDECIARIA,SALARIO,COMISSAO,TIPO) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoFuncionario.getNome());
			stmt.setString(2, novoFuncionario.getCpf());
			stmt.setString(3, novoFuncionario.getSexo());
			stmt.setInt(4, novoFuncionario.getIdade());
			stmt.setDouble(5, novoFuncionario.getSalarioBruto());
			stmt.setDouble(6, novoFuncionario.getSalarioBase());
			stmt.setDouble(7, novoFuncionario.getDescontoImpostoRenda());
			stmt.setDouble(8, novoFuncionario.getContribuicaoPrevidenciaria());
			stmt.setDouble(9, novoFuncionario.calcularSalario());
			
			 if(novoFuncionario instanceof Gerente){
				 Gerente ger = (Gerente) novoFuncionario;
				 stmt.setDouble(10,ger.getComissao());
			 }else  if(novoFuncionario instanceof Diretor){
				 Diretor dir = (Diretor) novoFuncionario;
				 stmt.setDouble(10,dir.getComissao());
			 }else {
				 stmt.setDouble(10,0);
			 }
			 stmt.setString(11, DESCRICAO_TIPO_FUNCIONARIO_OPERACIONAL);
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novoFuncionario.setId(idGerado);
			}
			
			 } catch (SQLException e) {
			System.out.println("Erro ao inserir novo Funcionario...");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoFuncionario;
	}
	public boolean excluir(int id) {
		
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM FUNCIONARIO WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quadroFuncionariosAtingindos = 0;
		try {
			quadroFuncionariosAtingindos= stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir funcionario.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return quadroFuncionariosAtingindos> 0;
	}

	public boolean alterar(Funcionario funcionario) {
		
		Connection conn = Banco.getConnection();
		String sql = " UPDATE FUNCIONARIO "
				+ " SET NOME=?, CPF=?, SEXO=?, IDADE=?, SALARIOBRUTO=?, SALARIOBASE=?,DESCONTOIMPOSTORENDA=?,"
				+ "CONTRIBUICAOPREVIDECIARIA=?,SALARIO=?,COMISSAO=?,TIPO=?"
				+ " WHERE ID=? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quadroFuncionariosAtingindos = 0;
		
		try {
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setString(3, funcionario.getSexo());
			stmt.setInt(4, funcionario.getIdade());
			stmt.setDouble(5, funcionario.getSalarioBase());
			stmt.setDouble(6, funcionario.getSalarioBruto());
			stmt.setDouble(7, funcionario.getDescontoImpostoRenda());
			stmt.setDouble(8, funcionario.getContribuicaoPrevidenciaria());
			stmt.setDouble(9, funcionario.calcularSalario());
			 if(funcionario instanceof Gerente){
				 Gerente ger = (Gerente) funcionario;
				 stmt.setDouble(10,ger.getComissao());
			 }else  if(funcionario instanceof Diretor){
				 Diretor dir = (Diretor) funcionario;
				 stmt.setDouble(10,dir.getComissao());
			 }else {
				 stmt.setDouble(10,0);
			 }
			 stmt.setString(11, DESCRICAO_TIPO_FUNCIONARIO_OPERACIONAL);
			
			quadroFuncionariosAtingindos = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar telefone.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quadroFuncionariosAtingindos > 0 ;
	}

	public Funcionario consultarPorId(int id) {
	
		Connection conn = Banco.getConnection();
		String sql = " SELECT *  FROM FUNCIONARIO "
				+ " WHERE ID=" + id;
		
		Statement stmt = Banco.getStatement(conn); 
		
		Funcionario funcionario = null;
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);
			
			if(resultadoDaConsulta.next()) {
				funcionario = construirFuncionarioDoResultSet(resultadoDaConsulta);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar funcionario por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}
		
		return funcionario;
	}

	public ArrayList<Funcionario> consultarTodos() {
	
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM FUNCIONARIO";

		Statement stmt = Banco.getStatement(conn); 
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);
			
			while(resultadoDaConsulta.next()) {
				Funcionario funcionario = construirFuncionarioDoResultSet(resultadoDaConsulta);
				funcionarios.add(funcionario);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar funcionarios");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return funcionarios;
	}
	
	private Funcionario construirFuncionarioDoResultSet(ResultSet resultadoDaConsulta) {
		Funcionario funcionario = null;
		
		
		try {
			funcionario.setId(resultadoDaConsulta.getInt("id"));
			funcionario.setNome(resultadoDaConsulta.getString("nome"));
			funcionario.setCpf(resultadoDaConsulta.getString("cpf"));
			funcionario.setSexo(resultadoDaConsulta.getString("sexo"));
			funcionario.setIdade(resultadoDaConsulta.getInt("idade"));
			funcionario.setSalarioBruto(resultadoDaConsulta.getDouble("salarioBruto"));
			funcionario.setSalarioBase(resultadoDaConsulta.getDouble("salarioBase"));
			funcionario.setDescontoImpostoRenda(resultadoDaConsulta.getDouble("descontoImpostoRenda"));
			funcionario.setContribuicaoPrevidenciaria(resultadoDaConsulta.getDouble("contribuicaoPrevidenciaria"));
			funcionario.calcularSalario();
			
		
	
	
	} catch (SQLException e) {
			System.out.println("Erro ao construir funcionario a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		
	}
         return funcionario;
		
		 }	

}





