package Main;

import java.util.ArrayList;
import java.util.Random;

import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class Executavel {

	private static final String CODIGO_PAIS_BRASIL = "55";

	public static void main(String[] args) {
		// exerc�cio 1
		// criarClientesMostrarNoConsole();

		// M�todos de testes da aula 2
		criarEndereco();
		//excluirEndereco(1);
		//atualizarEndereco();
		//consultarEndereco(25);
		//consultarEnderecos();

		// salvarTelefonesAleatorios();
		// excluirTelefone();
		// atualizarTelefone();
		// consultarTelefones();
		
		salvarNovoCliente();
		
	}

	private static void salvarNovoCliente() {
		Cliente c = new Cliente("Jos�", "55577788811", criarTelefones(),  "da Silva Sauro", criarEndereco());
		ClienteDAO cliDAO = new ClienteDAO();
		c = cliDAO.salvar(c);
		
		if (c.getId() > 0) {
			System.out.println("Cliente salvo com sucesso. ID: " + c.getId());
			System.out.println("************* Telefones do cliente *************");
			System.out.println("");
			for(Telefone t: c.getTelefones()) {
				System.out.println(t);
			}
			System.out.println("");
			System.out.println("**********************************************");
		} else {
			System.out.println("N�o salvou cliente");
		}
	}

	private static void consultarEnderecos() {
		EnderecoDAO endDAO = new EnderecoDAO();
		System.out.println("************* Todos os endere�os *************");
		System.out.println("");
		ArrayList<Endereco> todosOsEnderecos = endDAO.consultarTodos();

		for (Endereco e : todosOsEnderecos) {
			System.out.println(e);
		}
		System.out.println("");
		System.out.println("**********************************************");
	}
	
	private static void consultarEndereco(int id) {
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco enderecoConsultado = endDAO.consultarPorId(id);
		
		System.out.println(enderecoConsultado);
	}

	private static void atualizarEndereco() {
		Endereco enderecoQueSeraAtualizado = new Endereco("Rua Nova", "88032000", "PR", "Curitiba", "Centro", "10");
		enderecoQueSeraAtualizado.setId(2);
		
		EnderecoDAO endDAO = new EnderecoDAO();

		if (endDAO.alterar(enderecoQueSeraAtualizado)) {
			System.out.println("Alterou endere�o");
		} else {
			System.out.println("N�o alterou endere�o");
		}
		
	}

	private static void excluirEndereco(int id) {
		EnderecoDAO endDAO = new EnderecoDAO();

		if (endDAO.excluir(id)) {
			System.out.println("Excluiu endere�o " + id);
		} else {
			System.out.println("N�o excluiu endere�o " + id);
		}
	}

	private static void consultarTelefones() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		System.out.println(telefoneDAO.consultarPorId(2));
		System.out.println("");
		System.out.println("************* Todos os telefones *************");
		ArrayList<Telefone> todosOsTelefones = telefoneDAO.consultarTodos();

		for (Telefone t : todosOsTelefones) {
			System.out.println(t);
		}
		System.out.println("");
		System.out.println("**********************************************");
	}

	private static void atualizarTelefone() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		Telefone telefoneQueSeraAtualizado = new Telefone(2, null, "88", "66", "1232-3211", "M�vel", false);
		if (telefoneDAO.alterar(telefoneQueSeraAtualizado)) {
			System.out.println("Alterou");
		} else {
			System.out.println("N�o alterou");
		}
	}

	private static void excluirTelefone() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		if (telefoneDAO.excluir(3)) {
			System.out.println("Excluiu");
		} else {
			System.out.println("N�o excluiu");
		}
	}

	private static void salvarTelefonesAleatorios() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		ArrayList<Telefone> telefones = criarTelefones();

		for (Telefone t : telefones) {
			telefoneDAO.salvar(t);
		}
	}

	private static void criarClientesMostrarNoConsole() {
		Endereco endereco1 = new Endereco("Mauro Ramos", "88000-123", "SC", "Florian�polis", "Centro", "10A");

		// Constru��o da lista de telefones
		ArrayList<Telefone> telefonesCliente1 = new ArrayList<Telefone>();
		Telefone tel1 = new Telefone(0, null, "55", "048", "2020-5555", "Fixa", true);
		telefonesCliente1.add(tel1);

		// Listas de telefones s�o criadas por um m�todo auxiliar criarTelefones()
		// criado na classe Executavel
//		Cliente cliente1 = new Cliente("Edson", "Arantes do Nascimento", "010.010.100-10", telefonesCliente1,
//				endereco1);
//		Cliente cliente2 = new Cliente("Artur", "Antunes Coimbra", "000.000.100-10", criarTelefones(), endereco1);
//		Cliente cliente3 = new Cliente("Manoel", "dos Santos", "777.010.100-10", criarTelefones(), endereco1);
//		Cliente cliente4 = new Cliente("Roberto", "Rivellino", "011.010.100-10", criarTelefones(), endereco1);
//		Cliente cliente5 = new Cliente("Eduardo", "Gon�alves de Andrade", "009.010.100-10", criarTelefones(),
//				endereco1);

//		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//		clientes.add(cliente1);
//		clientes.add(cliente2);
//		clientes.add(cliente3);
//		clientes.add(cliente4);
//		clientes.add(cliente5);

//		for (Cliente c : clientes) {
//			System.out.println("************************************************************************************");
//			System.out.println(c);
//		}
//		System.out.println("************************************************************************************");

		// TODO exerc�cio 2 -> salvar os clientes no banco
	}

	private static Endereco criarEndereco() {
		Random ran = new Random();
		String cep = "" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10)
				+ ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10);

		String numero = "" + ran.nextInt(1000);
		Endereco novoEndereco = new Endereco("Novo endere�o " + ran.nextInt(100), cep, "SC", "Florian�polis", "Centro",
				numero);

		EnderecoDAO dao = new EnderecoDAO();
		novoEndereco = dao.salvar(novoEndereco);

//		if (novoEndereco.getId() > 0) {
//			System.out.println("Endere�o salvo com sucesso.");
//		} else {
//			System.out.println("Endere�o n�o foi salvo.");
//		}
		
		return novoEndereco;
	}

	/**
	 * Cria uma lista de telefones rand�micos.
	 * 
	 * @return uma lista de telefones.
	 */
	private static ArrayList<Telefone> criarTelefones() {
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(new Telefone(0, null, CODIGO_PAIS_BRASIL, criarDdd(), criarNumeroTelefone(), "Fixa", true));
		telefones.add(new Telefone(0, null, CODIGO_PAIS_BRASIL, criarDdd(), criarNumeroTelefone(), "Fixa", true));
		telefones.add(new Telefone(0, null, CODIGO_PAIS_BRASIL, criarDdd(), criarNumeroTelefone(), "M�vel", true));

		return telefones;
	}

	/**
	 * Cria um DDD rand�mico
	 * 
	 * @return uma String com o DDD, com 2 caracteres.
	 */
	private static String criarDdd() {
		Random ran = new Random();
		return "" + ran.nextInt(10) + ran.nextInt(10);
	}

	/**
	 * Cria um n�mero de telefone rand�mico, no formato ####-####, onde # � um
	 * n�mero de 0 a 9
	 * 
	 * @return o n�mero gerado.
	 */
	private static String criarNumeroTelefone() {
		Random ran = new Random();
		String prefixo = "" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10);
		String ramal = "" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10);

		return prefixo + "-" + ramal;
	}
}


