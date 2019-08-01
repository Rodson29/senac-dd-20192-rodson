package Controller;

import java.util.ArrayList;

import model.dao.EnderecoDAO;
import model.entity.Endereco;

public class EnderecoController {
	
	public ArrayList<Endereco> consultarTodos() {
		
		EnderecoDAO dao = new EnderecoDAO();
		return dao.consultarTodos();
	}

}
