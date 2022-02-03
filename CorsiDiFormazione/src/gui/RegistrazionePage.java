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
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import dto.DomandeSicurezza;
import dto.Operatori;

public class RegistrazionePage extends JFrame {

	
	private Controller theController;
	
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
	
	
	private Vector<DomandeSicurezza> domande;


	public RegistrazionePage(Controller controller) {
		
		
		theController = controller;
		domande = theController.getDomandeSicurezza();
		domandeComboBox = new JComboBox(domande);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		registrazionePanel = new JPanel();
		registrazionePanel.setBackground(SystemColor.control);
		registrazionePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		registrazionePanel.setBounds(29, 29, 745, 395);
		contentPane.add(registrazionePanel);
		registrazionePanel.setLayout(null);
		
		indietroButton = new JButton("INDIETRO");
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
				LogInPage LI = new LogInPage(theController);
				setVisible(false);
			}
		});
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(23, 361, 121, 23);
		registrazionePanel.add(indietroButton);
		
		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Arial", Font.BOLD, 13));
		nomeTextField.setBounds(46, 110, 297, 32);
		registrazionePanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Arial", Font.BOLD, 13));
		passwordTextField.setBounds(403, 110, 297, 32);
		registrazionePanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		domandeComboBox.setFont(new Font("Arial", Font.BOLD, 13));
		domandeComboBox.setMaximumRowCount(3);
		domandeComboBox.setBounds(46, 217, 297, 32);
		registrazionePanel.add(domandeComboBox);
		
		rispostaSicurezzaField = new JTextField();
		rispostaSicurezzaField.setFont(new Font("Arial", Font.BOLD, 13));
		rispostaSicurezzaField.setBounds(403, 217, 297, 32);
		registrazionePanel.add(rispostaSicurezzaField);
		rispostaSicurezzaField.setColumns(10);
		
		inserireRispostaLabel = new JLabel("Inserire Risposta");
		inserireRispostaLabel.setBounds(489, 177, 128, 39);
		registrazionePanel.add(inserireRispostaLabel);
		inserireRispostaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		nuovaPasswordLabel = new JLabel("Inserire Password");
		nuovaPasswordLabel.setBounds(489, 72, 128, 39);
		registrazionePanel.add(nuovaPasswordLabel);
		nuovaPasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		nuovoNomeUtenteLabel = new JLabel("Inserire Nome Utente");
		nuovoNomeUtenteLabel.setBounds(120, 72, 161, 39);
		registrazionePanel.add(nuovoNomeUtenteLabel);
		nuovoNomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		scegliereDomandaLabel = new JLabel("Scegliere Domanda di Sicurezza");
		scegliereDomandaLabel.setBounds(76, 177, 242, 39);
		registrazionePanel.add(scegliereDomandaLabel);
		scegliereDomandaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(310, 288, 128, 32);
		registrazionePanel.add(confermaButton);
		
		promemoriaLabel = new JLabel("La Password deve contenere almeno 6 caratteri!");
		promemoriaLabel.setForeground(Color.RED);
		promemoriaLabel.setBounds(413, 141, 287, 14);
		registrazionePanel.add(promemoriaLabel);
		
		nonCaratteriSpecialiLabel = new JLabel("I Dati non devono contenere caratteri Speciali (!,\",@)");
		nonCaratteriSpecialiLabel.setForeground(Color.RED);
		nonCaratteriSpecialiLabel.setBounds(46, 141, 297, 14);
		registrazionePanel.add(nonCaratteriSpecialiLabel);
		
		iSCRIVITILabel = new JLabel("ISCRIVITI");
		iSCRIVITILabel.setForeground(Color.BLACK);
		iSCRIVITILabel.setFont(new Font("Arial", Font.BOLD, 22));
		iSCRIVITILabel.setBackground(Color.WHITE);
		iSCRIVITILabel.setBounds(325, 11, 97, 33);
		registrazionePanel.add(iSCRIVITILabel);
		
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
			LogInPage HP = new LogInPage(theController);
			setVisible(false);	
		}else {
			Operatori op = new Operatori (nomeTextField.getText(), passwordTextField.getText());
			HomePage hp = new HomePage(theController, op);
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
}
