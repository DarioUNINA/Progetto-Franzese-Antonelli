package CorsiDiFormazione;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(181, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 107, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel NomeUtenteLabel = new JLabel("      Nome Utente:");
		NomeUtenteLabel.setBounds(89, 69, 92, 14);
		contentPane.add(NomeUtenteLabel);
		
		JLabel PasswordLabel_ = new JLabel("            Password:");
		PasswordLabel_.setBounds(89, 110, 92, 14);
		contentPane.add(PasswordLabel_);
		
		JLabel TitoloLabel = new JLabel("      GESTIONE CORSI DI FORMAZIONE");
		TitoloLabel.setBounds(112, 0, 208, 44);
		contentPane.add(TitoloLabel);
		
		JButton AccediButton = new JButton("ACCEDI");
		AccediButton.setBounds(178, 138, 89, 23);
		contentPane.add(AccediButton);
		
		JButton RegistrazioneButton = new JButton("REGISTRATI");
		RegistrazioneButton.setBounds(10, 227, 106, 23);
		contentPane.add(RegistrazioneButton);
		
		JButton PasswordDimenticataButton = new JButton("Hai dimenticato la Password?");
		PasswordDimenticataButton.setBounds(112, 172, 208, 23);
		contentPane.add(PasswordDimenticataButton);
	}
}
