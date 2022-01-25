package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrazionePage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private JTextField NomeTextField;
	private JTextField PasswordTextField;
	private JTextField RispostaTextField;


	public RegistrazionePage(Controller c) {
		
		theController = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		NomeTextField = new JTextField();
		NomeTextField.setBounds(166, 54, 86, 20);
		contentPane.add(NomeTextField);
		NomeTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setBounds(166, 85, 86, 20);
		contentPane.add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JComboBox DomandeComboBox = new JComboBox();
		DomandeComboBox.setBounds(166, 126, 96, 20);
		contentPane.add(DomandeComboBox);
		
		RispostaTextField = new JTextField();
		RispostaTextField.setBounds(166, 168, 86, 20);
		contentPane.add(RispostaTextField);
		RispostaTextField.setColumns(10);
		
		JButton ConfermaButton = new JButton("New button");
		ConfermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				theController.registrazionePageConfermaClicked();
				
			}
		});
		ConfermaButton.setBounds(319, 197, 89, 23);
		contentPane.add(ConfermaButton);
		
		setVisible(true);
	}
}
