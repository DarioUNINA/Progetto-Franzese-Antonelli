package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Operatori;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ModificaPasswordPage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	
	private ImageIcon imageicon;
	private Component url;
	private JPanel contentPane;
	private JPanel recuperoPanel;
	private JTextField confermaPasswordField;;
	private JButton confermaButton;
	private JTextField passwordField;
	private JLabel modificaPasswordLabel;
	private JLabel inserirePasswordLabel;
	private JLabel confermaPasswordLabel;
	private JButton indietroButton;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public ModificaPasswordPage(Controller controller, Operatori operatore) {
		
		theController = controller;
		this.operatore = operatore;
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		setResizable(false);
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		
		contentPane = new JPanel();
		contentPane.setBackground(blu);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recuperoPanel = new JPanel();
		recuperoPanel.setBackground(grigioChiaro);
		recuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		recuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(recuperoPanel);
		recuperoPanel.setLayout(null);
		
		confermaPasswordField = new JPasswordField();
		confermaPasswordField.setFont(new Font("Arial", Font.BOLD, 13));
		confermaPasswordField.setBounds(195, 129, 167, 20);
		recuperoPanel.add(confermaPasswordField);
		confermaPasswordField.setColumns(10);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(195, 175, 162, 31);
		recuperoPanel.add(confermaButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.BOLD, 13));
		passwordField.setBounds(195, 88, 167, 20);
		recuperoPanel.add(passwordField);
		passwordField.setColumns(10);
		
		modificaPasswordLabel = new JLabel("MODIFICA PASSWORD");
		modificaPasswordLabel.setForeground(Color.BLACK);
		modificaPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));
		modificaPasswordLabel.setBackground(Color.WHITE);
		modificaPasswordLabel.setBounds(154, 11, 268, 33);
		recuperoPanel.add(modificaPasswordLabel);
		
		inserirePasswordLabel = new JLabel("   Inserire Nuova Password:");
		inserirePasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		inserirePasswordLabel.setBounds(0, 91, 195, 14);
		recuperoPanel.add(inserirePasswordLabel);
		
		confermaPasswordLabel = new JLabel("Conferma Password:");
		confermaPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
		confermaPasswordLabel.setBounds(51, 131, 154, 14);
		recuperoPanel.add(confermaPasswordLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 265, 123, 31);
		recuperoPanel.add(indietroButton);
		
		gestoreIndietro();
			
		//LISTNER
		
		confermaButton.addMouseListener(new MouseAdapter() {
			public void actionPerformed(ActionEvent e) {
				gestoreModificaPassword();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
		});
		
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImpostazioniPage hp = new ImpostazioniPage(theController, operatore, 3, null);
				setVisible(false);
			}
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//ALERT
	
	public void alertPasswordNonCorrispondenti() {
		JOptionPane.showMessageDialog(this, "Password non corrispondenti, riprova.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}
	
	
	public void alertPasswordCambiata() {
		JOptionPane.showMessageDialog(this, "Password modificata con successo","CONFERMA", JOptionPane.INFORMATION_MESSAGE);
		
		if(operatore.getPassword() == null) { 
			LogInPage pg = new LogInPage(theController);
		}else {
			GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
		}
		setVisible(false);
	}
	
	
	public void alertInserirePassword() {
		JOptionPane.showMessageDialog(this, "Inserire una password","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreCambioPassword(String state) {
		
			if(state.equals("10004")) 
				JOptionPane.showMessageDialog(this, "La password non deve contenere caratteri speciali!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
				else 
					if(state.equals("10001"))
						JOptionPane.showMessageDialog(this, "La password deve essere lunga almeno 6 caratteri","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(this, "Errore durante la modifica della password","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}		
	
	//GESTORI
	
	public void gestoreModificaPassword() {

		String pass = passwordField.getText().toLowerCase();
		String cpass = confermaPasswordField.getText().toLowerCase();
		
		if(!pass.equals(cpass))
			alertPasswordNonCorrispondenti();
		else 
			if (pass.isEmpty())
				alertInserirePassword();
			else {
					
					String state = theController.confermaCambioPassword(operatore, pass);
												
						if(state.equals("0"))
							alertPasswordCambiata();
						else
							alertErroreCambioPassword(state);
				}
	}
	
	
	public void gestoreIndietro() {
		if(operatore.getPassword() == null)
			indietroButton.setVisible(false);
	}
}

	