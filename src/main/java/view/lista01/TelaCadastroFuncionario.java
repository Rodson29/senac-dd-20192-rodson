package view.lista01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TelaCadastroFuncionario {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario window = new TelaCadastroFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][22.00]"));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		frame.getContentPane().add(lblNewLabel, "cell 0 1");
		
		txtNome = new JTextField();
		frame.getContentPane().add(txtNome, "cell 2 1,growx,aligny top");
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		frame.getContentPane().add(lblNewLabel_1, "cell 0 2");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 2 2,growx");
		textField_1.setColumns(10);
	}

}
