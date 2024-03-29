package view.aula05;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Controller.ClienteController;
import Controller.EnderecoController;
import Controller.TelefoneController;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class TelaCadastroCliente extends JFrame {
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtNumero;
	private JTable tblTelefones;
	private JLabel lblTelefonesCadastrados;
	private String[] colunasTabelaTelefones = {"País", "DDD", "Número", "Tipo"};
	private JComboBox cbEndereco;
	private JButton btnSalvar;
	private JComboBox cbTipo;
	private ArrayList<Telefone> telefonesDoNovoCliente;
	private ArrayList<Endereco> todosOsEnderecos;
	private String[] tipos = {TelefoneController.TIPO_TELEFONE_FIXO, TelefoneController.TIPO_TELEFONE_MOVEL};
	private Cliente novoCliente = null;
	private JButton btnAdicionarTelefone;
	private JFormattedTextField txtCPF;
	private JTextField txtCodigoPais;
	private JTextField txtDdd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					TelaCadastroCliente frame = new TelaCadastroCliente();
					frame.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroCliente(){
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,527,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 10, 50, 20);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(70, 10, 95, 20);
		txtNome.setBounds(94, 10, 71, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(180, 10, 70, 20);
		lblSobrenome.setBounds(180, 10, 89, 20);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(250, 10, 100, 20);
		txtSobrenome.setBounds(272, 10, 78, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(370, 10, 50, 20);
		contentPane.add(lblCpf);

		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCPF = new JFormattedTextField(mascaraCpf);
			txtCPF.setBounds(400, 10, 100, 20);
			contentPane.add(txtCPF);
			txtCPF.setColumns(10);
		}catch (ParseException e){

		}

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(10, 43, 78, 14);
		contentPane.add(lblEndereco);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 100, 490, 2);
		contentPane.add(separator);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeDigitado = txtNome.getText();
				String sobrenomeDigitado = txtSobrenome.getText();
				String cpfDigitado = txtCPF.getText().replace("-", "").replace(".", "");
				Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();
				ClienteController cliController = new ClienteController();
				
				String mensagem = cliController.validarCamposSalvar(nomeDigitado, sobrenomeDigitado, cpfDigitado, enderecoSelecionado);

				mensagem = cliController.validarCamposSalvar(nomeDigitado, sobrenomeDigitado, cpfDigitado, enderecoSelecionado);

				if (mensagem.isEmpty()) {
					novoCliente = new Cliente(nomeDigitado, cpfDigitado, new ArrayList<Telefone>(), sobrenomeDigitado, enderecoSelecionado);
					novoCliente = cliController.salvar(novoCliente);

					if (novoCliente.getId() > 0) {
						btnAdicionarTelefone.setEnabled(true);
						btnSalvar.setEnabled(false);
					}
				}else {
					JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		btnSalvar.setBounds(220, 70, 100, 23);
		contentPane.add(btnSalvar);

		JLabel lblNovoTelefone = new JLabel("Novo telefone");
		lblNovoTelefone.setForeground(Color.WHITE);
		lblNovoTelefone.setBackground(Color.DARK_GRAY);
		lblNovoTelefone.setOpaque(true);
		lblNovoTelefone.setFont(new Font("Tahoma",Font.BOLD,11));
		lblNovoTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoTelefone.setBounds(10, 110, 490, 20);
		contentPane.add(lblNovoTelefone);

		JLabel lblCodigoPais = new JLabel("Cód. país:");
		lblCodigoPais.setBounds(10, 140, 70, 20);
		contentPane.add(lblCodigoPais);

		txtCodigoPais = new JTextField();
		txtCodigoPais.setBounds(85, 140, 30, 20);
		contentPane.add(txtCodigoPais);
		txtCodigoPais.setColumns(10);

		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(120, 140, 40, 20);
		contentPane.add(lblDdd);

		txtDdd = new JTextField();
		txtDdd.setBounds(160, 140, 30, 20);
		contentPane.add(txtDdd);
		txtDdd.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(200, 140, 50, 20);
		lblNumero.setBounds(200, 140, 69, 20);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(255, 140, 78, 20);
		txtNumero.setBounds(272, 140, 78, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(343, 140, 30, 20);
		lblTipo.setBounds(370, 140, 40, 20);
		contentPane.add(lblTipo);

		cbTipo = new JComboBox(tipos);
		cbTipo.setBounds(383, 140, 117, 20);
		cbTipo.setBounds(400, 140, 100, 20);
		cbTipo.setSelectedIndex(-1);
		contentPane.add(cbTipo);

		btnAdicionarTelefone = new JButton("Adicionar telefone");
		btnAdicionarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controller = new TelefoneController();

				String codigoPaisInformado = txtCodigoPais.getText();
				String dddInformado = txtDdd.getText();
				String numeroInformado = txtNumero.getText();
				String tipoLinhaInformado = (String) cbTipo.getSelectedItem();

				String mensagemValidacao = controller.validarNovoTelefone(codigoPaisInformado, dddInformado,
						numeroInformado, tipoLinhaInformado);

				if (mensagemValidacao.isEmpty()) {
					Telefone novoTelefone = new Telefone(novoCliente, codigoPaisInformado, dddInformado, numeroInformado, tipoLinhaInformado, true);
					mensagemValidacao = controller.salvar(novoTelefone);

					if (mensagemValidacao.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Telefone " + "adicionado", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAdicionarTelefone.setEnabled(false);
		btnAdicionarTelefone.setBounds(170, 170, 200, 20);
		contentPane.add(btnAdicionarTelefone);


		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 200, 490, 2);
		contentPane.add(separator_1);

		tblTelefones = new JTable();
		tblTelefones.setBounds(10, 240, 490, 200);
		contentPane.add(tblTelefones);

		limparTabela();

		lblTelefonesCadastrados = new JLabel("Telefones do cliente");
		lblTelefonesCadastrados.setForeground(Color.WHITE);
		lblTelefonesCadastrados.setBackground(Color.DARK_GRAY);

		//Para que a cor de fundo do label apareça
		// Para que a cor de fundo do label apare�a
		lblTelefonesCadastrados.setOpaque(true);
		lblTelefonesCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonesCadastrados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefonesCadastrados.setBounds(10, 208, 490, 20);
		contentPane.add(lblTelefonesCadastrados);


		// C�digo do construtor da tela
		consultarEnderecos();
		cbEndereco = new JComboBox(todosOsEnderecos.toArray());
		cbEndereco.setBounds(70, 40, 430, 20);
		cbEndereco.setBounds(94, 40, 406, 20);
		cbEndereco.setSelectedIndex(-1);
		contentPane.add(cbEndereco);
	}
	
	private void consultarEnderecos() {
		EnderecoController controller = new EnderecoController();
		todosOsEnderecos = controller.consultarTodos();
	}

	protected void atualizarTabelaTelefones() {
		TelefoneController controller = new TelefoneController();
		
		if(novoCliente != null && novoCliente.getId() > 0) {
			if (novoCliente != null && novoCliente.getId() > 0) {
				telefonesDoNovoCliente = controller.consultarTelefonesDoCliente(novoCliente.getId());
			}
			
			limparTabela();
			
			DefaultTableModel model = (DefaultTableModel) tblTelefones.getModel();
			for (Telefone telefone : telefonesDoNovoCliente) {
				String[] novaLinha = new String[5];
				novaLinha[0] = telefone.getCodigoPais();
				novaLinha[1] = telefone.getDdd();
				novaLinha[2] = telefone.getNumero();
				novaLinha[3] = telefone.getTipo();
				model.addRow(novaLinha);
			}
		}
	}
	
	private void limparTabela() {
		tblTelefones.setModel(new DefaultTableModel(
				new Object[][] {
					colunasTabelaTelefones,
				},
				colunasTabelaTelefones
				));
	}
}