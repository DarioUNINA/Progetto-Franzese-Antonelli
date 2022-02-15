package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Operatori;
import dto.Studenti;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;

public class ModificaNomeUtentePage extends JFrame {

	private Controller theController;
	private Operatori operatore;
	private int flag;
	private Studenti studente;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel modificaNomeUtentePanel;
	private JLabel modificaNomeUtenteLabel;
	private JLabel nuovoNomeUtenteLabel;
	private JLabel confermaNuovoNomeLabel;
	private JTextField nuovoNomeUtenteTextField;
	private JTextField confermaNuovoNomeUtenteTextField;
	private JButton confermaButton;
	private JButton indietroButton;
	
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public ModificaNomeUtentePage(Controller controller, Operatori operatore, int flag, Studenti studente) {
		
		theController = controller;
		this.operatore = operatore;
		this.flag = flag;
		this.studente = studente;
		
		setResizable(false);
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
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
		
		modificaNomeUtentePanel = new JPanel();
		modificaNomeUtentePanel.setBackground(grigioChiaro);
		modificaNomeUtentePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		modificaNomeUtentePanel.setBounds(10, 11, 548, 307);
		contentPane.add(modificaNomeUtentePanel);
		modificaNomeUtentePanel.setLayout(null);
		
		modificaNomeUtenteLabel = new JLabel("MODIFICA NOME UTENTE");
		modificaNomeUtenteLabel.setForeground(Color.BLACK);
		modificaNomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 22));
		modificaNomeUtenteLabel.setBackground(Color.WHITE);
		modificaNomeUtenteLabel.setBounds(134, 11, 279, 33);
		modificaNomeUtentePanel.add(modificaNomeUtenteLabel);
		
		nuovoNomeUtenteLabel = new JLabel("Inserire nuovo Nome Utente:");
		nuovoNomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nuovoNomeUtenteLabel.setBounds(173, 79, 214, 20);
		modificaNomeUtentePanel.add(nuovoNomeUtenteLabel);
		
		confermaNuovoNomeLabel = new JLabel("Conferma Nome Utente:");
		confermaNuovoNomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		confermaNuovoNomeLabel.setBounds(187, 164, 192, 20);
		modificaNomeUtentePanel.add(confermaNuovoNomeLabel);
		
		nuovoNomeUtenteTextField = new JTextField();
		nuovoNomeUtenteTextField.setFont(new Font("Arial", Font.BOLD, 13));
		nuovoNomeUtenteTextField.setBounds(179, 104, 192, 20);
		modificaNomeUtentePanel.add(nuovoNomeUtenteTextField);
		nuovoNomeUtenteTextField.setColumns(10);
		
		confermaNuovoNomeUtenteTextField = new JTextField();
		confermaNuovoNomeUtenteTextField.setFont(new Font("Arial", Font.BOLD, 13));
		confermaNuovoNomeUtenteTextField.setColumns(10);
		confermaNuovoNomeUtenteTextField.setBounds(179, 184, 192, 20);
		modificaNomeUtentePanel.add(confermaNuovoNomeUtenteTextField);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(194, 230, 162, 31);
		modificaNomeUtentePanel.add(confermaButton);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		modificaNomeUtentePanel.add(indietroButton);
		
		
		//LISTNER
		
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				gestoreModificaDati();
			}
		});
		
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.impostazioniPage(operatore, flag, null);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				indietroButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				indietroButton.setBackground(Color.WHITE);
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	//ALERT
	public void alertNomeUtenteNonCorrispondenti() {
		JOptionPane.showMessageDialog(this, "Nome Utente non corrispondente, riprova.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}
	
	public void alertInserireNomeUtente() {
		JOptionPane.showMessageDialog(this, "Inserire un Nome Utente","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNomeUtenteCambiato() {
		JOptionPane.showMessageDialog(this, "Nome Utente cambiato con successo","CONFERMA", JOptionPane.INFORMATION_MESSAGE);
		}
	
	public void alertErroreCambioNomeUtente(String state) {
		
		if(state.equals("10003")) 
			JOptionPane.showMessageDialog(this, "Il Nome Utente non deve contenere caratteri speciali!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else 
				if(state.equals("10002"))
					JOptionPane.showMessageDialog(this, "Il Nome Utente deve essere lungo almeno 4 caratteri","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
				else
					JOptionPane.showMessageDialog(this, "Errore durante la modifica del Nome Utente","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}	
	
	
	//GESTORI
	
	public void gestoreModificaDati() {
		String nomeU = nuovoNomeUtenteTextField.getText().toLowerCase();
		String confermaNomeU = confermaNuovoNomeUtenteTextField.getText().toLowerCase();
		
		if(!nomeU.equals(confermaNomeU))
			alertNomeUtenteNonCorrispondenti();
		else 
			if (nomeU.isEmpty())
				alertInserireNomeUtente();
			else {
				
					String state = theController.confermaCambioNomeUtente(nomeU, operatore);
					
					if(state.equals("0")) {
						
						alertNomeUtenteCambiato();
						theController.gestoreCorsiPage(operatore);
						setVisible(false);
					
					}else
						alertErroreCambioNomeUtente(state);
			}
	}
}
