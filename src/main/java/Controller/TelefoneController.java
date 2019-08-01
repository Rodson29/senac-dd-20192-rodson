package Controller;

import java.util.ArrayList;

import model.BO.TelefoneBO;
import model.entity.Telefone;

public class TelefoneController {
	
	public static final String TIPO_TELEFONE_MOVEL = "Móvel";
	public static final String TIPO_TELEFONE_FIXO = "Fixo";

	private TelefoneBO bo = new TelefoneBO();

	public ArrayList<Telefone> consultarTelefonesDoCliente(int idCliente) {
		return bo.consultarClientePorId(idCliente);
	}

	public String validarNovoTelefone(String codigoPaisInformado, String dddInformado, String numeroInformado,
			String tipoLinhaInformado) {
		// TODO fazer a validação
		return null;
	}

	public String salvar(Telefone novoTelefone) {
		// TODO Auto-generated method stub
		return null;
	}

}
