package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class RegistrazionePage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private JTextField NomeTextField;
	private JTextField PasswordTextField;
	private JTextField RispostaSicurezzaField;
	private ImageIcon imageicon;


	public RegistrazionePage(Controller c) {
		
		
		theController = c;
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel RegistrazionePanel = new JPanel();
		RegistrazionePanel.setBackground(UIManager.getColor("Button.light"));
		RegistrazionePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		RegistrazionePanel.setBounds(29, 29, 745, 395);
		contentPane.add(RegistrazionePanel);
		RegistrazionePanel.setLayout(null);
		
		JButton IndietroButton = new JButton("INDIETRO");
		IndietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		IndietroButton.setBounds(23, 361, 105, 23);
		RegistrazionePanel.add(IndietroButton);
		
		NomeTextField = new JTextField();
		NomeTextField.setBounds(46, 110, 297, 32);
		RegistrazionePanel.add(NomeTextField);
		NomeTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setBounds(403, 110, 297, 32);
		RegistrazionePanel.add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JComboBox DomandeComboBox = new JComboBox();
		DomandeComboBox.setBounds(46, 217, 297, 32);
		RegistrazionePanel.add(DomandeComboBox);
		
		RispostaSicurezzaField = new JTextField();
		RispostaSicurezzaField.setBounds(403, 217, 297, 32);
		RegistrazionePanel.add(RispostaSicurezzaField);
		RispostaSicurezzaField.setColumns(10);
		
		JLabel InserireRispostaLabel = new JLabel("Inserire Risposta");
		InserireRispostaLabel.setBounds(489, 177, 128, 39);
		RegistrazionePanel.add(InserireRispostaLabel);
		InserireRispostaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel NuovaPasswordLabel = new JLabel("Inserire Password");
		NuovaPasswordLabel.setBounds(489, 72, 128, 39);
		RegistrazionePanel.add(NuovaPasswordLabel);
		NuovaPasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel NuovoNomeUtenteLabel = new JLabel("Inserire Nome Utente");
		NuovoNomeUtenteLabel.setBounds(120, 72, 161, 39);
		RegistrazionePanel.add(NuovoNomeUtenteLabel);
		NuovoNomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel ScegliereDomandaLabel = new JLabel("Scegliere Domanda di Sicurezza");
		ScegliereDomandaLabel.setBounds(76, 177, 242, 39);
		RegistrazionePanel.add(ScegliereDomandaLabel);
		ScegliereDomandaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton ConfermaButton = new JButton("CONFERMA");
		ConfermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		ConfermaButton.setBounds(310, 288, 128, 32);
		RegistrazionePanel.add(ConfermaButton);
		
		JLabel PromeoriaLabel = new JLabel("La Password deve contenere almeno 6 caratteri!");
		PromeoriaLabel.setForeground(new Color(0, 0, 255));
		PromeoriaLabel.setBounds(439, 141, 242, 14);
		RegistrazionePanel.add(PromeoriaLabel);
		
		JLabel NonCaratteriSpecialiLabel = new JLabel("I Dati non devono contenere caratteri Speciali (!,\",@)");
		NonCaratteriSpecialiLabel.setForeground(Color.BLUE);
		NonCaratteriSpecialiLabel.setBounds(67, 141, 276, 14);
		RegistrazionePanel.add(NonCaratteriSpecialiLabel);
		
		JLabel ISCRIVITILabel = new JLabel("ISCRIVITI");
		ISCRIVITILabel.setForeground(Color.BLACK);
		ISCRIVITILabel.setFont(new Font("Arial", Font.BOLD, 22));
		ISCRIVITILabel.setBackground(Color.WHITE);
		ISCRIVITILabel.setBounds(325, 11, 97, 33);
		RegistrazionePanel.add(ISCRIVITILabel);
		ConfermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(theController.registrazionePageConfermaClicked("a", "b", "c", "d"))
					System.out.println("ciao");
				
			}
		});
		
		setVisible(true);
	}
}
