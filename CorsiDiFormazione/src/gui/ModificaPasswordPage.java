package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaPasswordPage extends JFrame {

	private JPanel contentPane;
	
	private Controller theController;
	private String nomeUtente;
	private JTextField PasswordField;
	private JTextField ConfermaPasswordField;
	private ImageIcon imageicon;
	private Component url;
	
	public ModificaPasswordPage(Controller controller, String nomeUtente) {
		
		theController = controller;
		this.nomeUtente = nomeUtente;
		
		
		setResizable(false);
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel RecuperoPanel = new JPanel();
		RecuperoPanel.setBackground(SystemColor.control);
		RecuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		RecuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(RecuperoPanel);
		RecuperoPanel.setLayout(null);
		
		ConfermaPasswordField = new JTextField();
		ConfermaPasswordField.setBounds(195, 129, 167, 20);
		RecuperoPanel.add(ConfermaPasswordField);
		ConfermaPasswordField.setColumns(10);
		
		JButton ConfermaButton = new JButton("CONFERMA");
		ConfermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ConfermaButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ConfermaButton.setBackground(Color.WHITE);
			}
		});
		ConfermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		ConfermaButton.setBounds(195, 175, 162, 31);
		RecuperoPanel.add(ConfermaButton);
		
		PasswordField = new JTextField();
		PasswordField.setBounds(195, 88, 167, 20);
		RecuperoPanel.add(PasswordField);
		PasswordField.setColumns(10);
		
		JLabel RECUPEROPASSWORDLabel = new JLabel("RECUPERO PASSWORD");
		RECUPEROPASSWORDLabel.setForeground(Color.BLACK);
		RECUPEROPASSWORDLabel.setFont(new Font("Arial", Font.BOLD, 22));
		RECUPEROPASSWORDLabel.setBackground(Color.WHITE);
		RECUPEROPASSWORDLabel.setBounds(139, 11, 268, 33);
		RecuperoPanel.add(RECUPEROPASSWORDLabel);
		
		JLabel InserirePasswordLabel = new JLabel("   Inserire Password:");
		InserirePasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		InserirePasswordLabel.setBounds(41, 91, 154, 14);
		RecuperoPanel.add(InserirePasswordLabel);
		
		JLabel ConfermaPasswordLabel = new JLabel("Conferma Password:");
		ConfermaPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
		ConfermaPasswordLabel.setBounds(41, 132, 154, 14);
		RecuperoPanel.add(ConfermaPasswordLabel);
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

	