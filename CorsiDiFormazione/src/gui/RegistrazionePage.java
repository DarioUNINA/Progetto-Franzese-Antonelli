package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import dto.DomandeSicurezza;
import dto.Operatori;
import java.awt.Cursor;

public class RegistrazionePage extends JFrame {

	
	private Controller theController;
	private Vector<DomandeSicurezza> domande;
	
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel registrazionePanel;
	private JButton indietroButton;
	private JTextField nomeTextField;
	private JTextField passwordTextField;
	private JComboBox domandeComboBox;
	private JTextField rispostaSicurezzaField;
	private JLabel inserireRispostaLabel;
	private JLabel nuovaPasswordLabel;
	private JLabel nuovoNomeUtenteLabel;
	private JLabel scegliereDomandaLabel;
	private JButton confermaButton;
	private JLabel promemoriaLabel;
	private JLabel nonCaratteriSpecialiLabel;
	private JLabel iSCRIVITILabel;

	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public RegistrazionePage(Controller controller) {
		
		theController = controller;
		domande = theController.getDomandeSicurezza();
		
		domandeComboBox = new JComboBox(domande);
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(blu);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		registrazionePanel = new JPanel();
		registrazionePanel.setBackground(grigioChiaro);
		registrazionePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		registrazionePanel.setBounds(35, 29, 815, 501);
		contentPane.add(registrazionePanel);
		registrazionePanel.setLayout(null);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 458, 161, 32);
		registrazionePanel.add(indietroButton);
		
		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Arial", Font.BOLD, 15));
		nomeTextField.setBounds(80, 132, 297, 32);
		registrazionePanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Arial", Font.BOLD, 15));
		passwordTextField.setBounds(437, 132, 297, 32);
		registrazionePanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		domandeComboBox.setFont(new Font("Arial", Font.BOLD, 15));
		domandeComboBox.setMaximumRowCount(3);
		domandeComboBox.setBounds(80, 271, 297, 32);
		registrazionePanel.add(domandeComboBox);
		
		rispostaSicurezzaField = new JTextField();
		rispostaSicurezzaField.setFont(new Font("Arial", Font.BOLD, 15));
		rispostaSicurezzaField.setBounds(437, 271, 297, 32);
		registrazionePanel.add(rispostaSicurezzaField);
		rispostaSicurezzaField.setColumns(10);
		
		inserireRispostaLabel = new JLabel("Inserire Risposta");
		inserireRispostaLabel.setBounds(534, 244, 128, 39);
		registrazionePanel.add(inserireRispostaLabel);
		inserireRispostaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		nuovaPasswordLabel = new JLabel("Inserire Password");
		nuovaPasswordLabel.setBounds(524, 106, 128, 39);
		registrazionePanel.add(nuovaPasswordLabel);
		nuovaPasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		nuovoNomeUtenteLabel = new JLabel("Inserire Nome Utente");
		nuovoNomeUtenteLabel.setBounds(150, 106, 161, 39);
		registrazionePanel.add(nuovoNomeUtenteLabel);
		nuovoNomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		scegliereDomandaLabel = new JLabel("Scegliere Domanda di Sicurezza");
		scegliereDomandaLabel.setBounds(101, 244, 242, 39);
		registrazionePanel.add(scegliereDomandaLabel);
		scegliereDomandaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(338, 360, 161, 39);
		registrazionePanel.add(confermaButton);
		
		promemoriaLabel = new JLabel("La Password deve contenere almeno 6 caratteri!");
		promemoriaLabel.setForeground(Color.RED);
		promemoriaLabel.setBounds(447, 166, 287, 14);
		registrazionePanel.add(promemoriaLabel);
		
		nonCaratteriSpecialiLabel = new JLabel("I Dati non devono contenere caratteri Speciali (!,\",@)");
		nonCaratteriSpecialiLabel.setForeground(Color.RED);
		nonCaratteriSpecialiLabel.setBounds(90, 166, 297, 14);
		registrazionePanel.add(nonCaratteriSpecialiLabel);
		
		iSCRIVITILabel = new JLabel("ISCRIVITI");
		iSCRIVITILabel.setForeground(Color.BLACK);
		iSCRIVITILabel.setFont(new Font("Arial", Font.BOLD, 32));
		iSCRIVITILabel.setBackground(Color.WHITE);
		iSCRIVITILabel.setBounds(338, 11, 161, 33);
		registrazionePanel.add(iSCRIVITILabel);
		
		
		//LISTNER
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				indietroButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				indietroButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.logIn();
				setVisible(false);
			}
		});
		
		
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestoreNuovoUtente();
									
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
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void alertConfermaRegistrazione() {
		Object[] opzioni = {"Log In","Home Page"};
		int n = JOptionPane.showOptionDialog(this,
					"Come si vuole procedere?",
					"REGISTRAZIONE EFFETTUATA ",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, //non usa un'icona personalizzata
					opzioni, //i titoli dei pulsanti
					opzioni[0]); //titolo del pulsante 
		
		if(n==0) {
			theController.logIn();
			setVisible(false);	
		}else {
			Operatori op = new Operatori (nomeTextField.getText(), passwordTextField.getText());
			op.setIdOperatore(theController.getIdOperatore(op));
			
			theController.gestoreCorsiPage(op);
			setVisible(false);
		}
			
	}

	
	public void alertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(this, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertPasswordNonInserita() {
		JOptionPane.showMessageDialog(this, "Password non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertRispostaNonInserita() {
		JOptionPane.showMessageDialog(this, "Risposta non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreRegsistrazione(String state) {
		
		if(state.equals("10004")) 
			JOptionPane.showMessageDialog(this, "La password non deve contenere caratteri speciali!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("10003"))
				JOptionPane.showMessageDialog(this, "Il Nome utente non deve contenere caratteri speciali!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else 
				if(state.equals("10001"))
					JOptionPane.showMessageDialog(this, "La password deve essere lunga almeno 6 caratteri","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
				else
					if(state.equals("10002"))
						JOptionPane.showMessageDialog(this, "Il nome utente deve essere lungo almeno 4 caratteri","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
					else
						if(state.equals("23505"))
							JOptionPane.showMessageDialog(this, "Il nome utente gia esiste, riprova","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
						else
							JOptionPane.showMessageDialog(this, "Errore durante la registrazione","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	//GESTORI
	
	public void gestoreNuovoUtente() {
		String NomeU = nomeTextField.getText().toLowerCase();
		String Pass = passwordTextField.getText().toLowerCase();
		String DomandaSicurezza = domandeComboBox.getSelectedItem().toString();
		String RispostaSicurezza = rispostaSicurezzaField.getText().toLowerCase();
		
		if(NomeU.isEmpty())
			alertNomeUtenteNonInserito();
		else 
			if(Pass.isEmpty())
				alertPasswordNonInserita();
				else
					if(RispostaSicurezza.isEmpty())
						alertRispostaNonInserita();
					else
					{
						String state = theController.registrazioneClicked(NomeU, Pass, DomandaSicurezza, RispostaSicurezza);
						
						if(state.equals("0"))
							alertConfermaRegistrazione();
						else
							alertErroreRegsistrazione(state);
					}
	}
}
