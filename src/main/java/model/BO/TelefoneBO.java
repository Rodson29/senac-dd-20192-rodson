package model.BO;

import java.util.ArrayList;

import model.dao.TelefoneDAO;
import model.entity.Telefone;

public class TelefoneBO {
	
	private TelefoneDAO teldao = new TelefoneDAO();

    public ArrayList<Telefone> consultarClientePorId(int idCliente) {
    	
		return teldao.consultarClientePorId(idCliente);
		}
    public ArrayList<Telefone> consultarTodos(){
    	return teldao.consultarTodos();
	}
    
     public String salvar(Telefone novoTelefone){
    	 
    	 String mensagem = "";
    	 if (teldao.telefoneJaCadastrado(novoTelefone)){
    		 mensagem = "Telefone já existe";
    	 }else{
    		 novoTelefone = teldao.salvar(novoTelefone);
    	 }
    	 
    	 if (novoTelefone.getId() == 0){
    		 mensagem = "Erro ao cadastrar telefone";
    	 }
    	 
    	 return mensagem;
     }
	
}

