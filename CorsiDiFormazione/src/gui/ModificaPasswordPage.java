package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaPasswordPage extends JFrame {

	private JPanel contentPane;
	
	private Controller theController;
	private String nomeUtente;
	private JTextField PasswordField;
	private JTextField ConfermaPasswordField;


	
	public ModificaPasswordPage(Controller controller, String nomeUtente) {
		
		theController = controller;
		this.nomeUtente = nomeUtente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PasswordField = new JTextField();
		PasswordField.setBounds(162, 73, 86, 20);
		contentPane.add(PasswordField);
		PasswordField.setColumns(10);
		
		ConfermaPasswordField = new JTextField();
		ConfermaPasswordField.setBounds(162, 116, 86, 20);
		contentPane.add(ConfermaPasswordField);
		ConfermaPasswordField.setColumns(10);
		
		JButton ConfermaButton = new JButton("Conferma");
		ConfermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass = PasswordField.getText().toLowerCase();
				String cpass = ConfermaPasswordField.getText().toLowerCase();
				
				if(!pass.equals(cpass))
					alertPasswordNonCorrispondenti();
				else 
					if (pass.isEmpty())
						alertInserirePassword();
					else
						if(theController.confermaCambioPassword(nomeUtente, pass)) {
							
							alertPasswordCambiata();
							LogInPage pg = new LogInPage(theController);
							setVisible(false);
							
						}else
							alertErroreCambioPassword();
				
			}
		});
		ConfermaButton.setBounds(162, 158, 89, 23);
		contentPane.add(ConfermaButton);
		setVisible(true);
	}
	
	public void alertPasswordNonCorrispondenti() {
		JOptionPane.showMessageDialog(this, "Password non corrispondenti, riprova.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}
	
	public void alertPasswordCambiata() {
		JOptionPane.showMessageDialog(this, "Password cambiata con successo","CONFERMA", JOptionPane.INFORMATION_MESSAGE);
		}
	
	public void alertInserirePassword() {
		JOptionPane.showMessageDialog(this, "Inserire una password","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreCambioPassword() {
		JOptionPane.showMessageDialog(this, "Non e' stato possibile cambiare la password","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}
}

	