package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Endereco;

public class EnderecoDAO implements BaseDAO<Endereco> {

	public Endereco salvar(Endereco novoEndereco) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ENDERECO(RUA, CEP, ESTADO, CIDADE, BAIRRO, NUMERO) "
				+ " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoEndereco.getRua());
			stmt.setString(2, novoEndereco.getCep());
			stmt.setString(3, novoEndereco.getEstado());
			stmt.setString(4, novoEndereco.getCidade());
			stmt.setString(5, novoEndereco.getBairro());
			stmt.setString(6, novoEndereco.getNumero());
			
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novoEndereco.setId(idGerado);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo endereço.");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoEndereco;
	}

	public boolean excluir(int id) {
		
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM ENDERECO WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeInformacoesExcluidas = 0;
		try {
			quantidadeInformacoesExcluidas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir endereco...");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return quantidadeInformacoesExcluidas > 0;
	}

	public boolean alterar(Endereco endereco) {
		
		Connection conn = Banco.getConnection();
		String sql = " UPDATE ENDERECO "
				+ " SET rua=?, cep=?, estado=?, cidade=?, bairro=?, numero=? "
				+ " WHERE ID=? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeInformacoesExcluida = 0;
		
		try {
			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getCep());
			stmt.setString(3, endereco.getEstado());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getBairro());
			stmt.setString(6, endereco.getNumero());
			stmt.setInt(7, endereco.getId());
			quantidadeInformacoesExcluida = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar telefone.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeInformacoesExcluida > 0 ;
		
		
	}

	public Endereco consultarPorId(int id) {
		
		Connection conn = Banco.getConnection();
		String sql = " SELECT id, rua, cep, estado, cidade, bairro, numero "
				+ " FROM ENDERECO "
				+ " WHERE ID=" + id;
		
		Statement stmt = Banco.getStatement(conn); 
		
		Endereco endereco = null;
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);
			
			if(resultadoDaConsulta.next()) {
				endereco = construirEnderecoDoResultSet(resultadoDaConsulta);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereco por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}
		
		return endereco;
	}

	public ArrayList<Endereco> consultarTodos() {
		
		Connection conn = Banco.getConnection();
		String sql = " SELECT id, rua, cep, estado, cidade, bairro, numero "
				+ " FROM ENDERECO ";

		Statement stmt = Banco.getStatement(conn); 
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);
			
			while(resultadoDaConsulta.next()) {
				Endereco endereco = construirEnderecoDoResultSet(resultadoDaConsulta);
				enderecos.add(endereco);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar telefones");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return enderecos;
		
		}
	
	private Endereco construirEnderecoDoResultSet(ResultSet resultadoDaConsulta){
		
		Endereco endereco;
		endereco = new Endereco();
		try {
			endereco.setId(resultadoDaConsulta.getInt("id"));
			endereco.setRua(resultadoDaConsulta.getString("rua"));
			endereco.setCep(resultadoDaConsulta.getString("cep"));
			endereco.setEstado(resultadoDaConsulta.getString("estado"));
			endereco.setCidade(resultadoDaConsulta.getString("cidade"));
			endereco.setBairro(resultadoDaConsulta.getString("bairro"));
			endereco.setNumero(resultadoDaConsulta.getString("numero"));
		} catch (SQLException e) {
			System.out.println("Erro ao construir endereco a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return endereco;
	
	
	}
}