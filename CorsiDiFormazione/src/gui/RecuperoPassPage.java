package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RecuperoPassPage extends JFrame {

	private JPanel contentPane;
	private Component url;
	private JTextField NomeUtenteField;

	private Controller theController;
	private ImageIcon imageicon;
	private JTextField NomeUtenteText;
	
	
	
	public RecuperoPassPage(Controller co) {
		setResizable(false);
		
		
		imageicon = new ImageIcon("napule.png");
		theController = co;
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

		
		JLabel RECUPEROPASSWORDLabel = new JLabel("RECUPERO PASSWORD");
		RECUPEROPASSWORDLabel.setForeground(Color.BLACK);
		RECUPEROPASSWORDLabel.setFont(new Font("Arial", Font.BOLD, 22));
		RECUPEROPASSWORDLabel.setBackground(Color.WHITE);
		RECUPEROPASSWORDLabel.setBounds(139, 11, 268, 33);
		RecuperoPanel.add(RECUPEROPASSWORDLabel);
		
		JLabel NomeUtenteLabel = new JLabel("Nome Utente:");
		NomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		NomeUtenteLabel.setBounds(100, 80, 101, 14);
		RecuperoPanel.add(NomeUtenteLabel);
		
		NomeUtenteText = new JTextField();
		NomeUtenteText.setColumns(10);
		NomeUtenteText.setBounds(211, 78, 121, 20);
		RecuperoPanel.add(NomeUtenteText);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				String Nome = NomeUtenteText.getText();
				if(Nome.isEmpty()) 
					alertNomeUtenteNonInserito();
				else	
					if(theController.CheckNomeClicked(Nome)) {
						//theController funzione per ricavarti domande operatori
						RecuperoPassDomandaPage rpd = new RecuperoPassDomandaPage(theController);
						setVisible(false);
					}
			}
		});
		
		ConfermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		ConfermaButton.setBounds(211, 148, 121, 27);
		RecuperoPanel.add(ConfermaButton);
		
		JButton IndietroButton = new JButton("INDIETRO");
		IndietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IndietroButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IndietroButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				LogIn LI = new LogIn(theController);
				setVisible(false);
			}
		});
		
		IndietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		IndietroButton.setBounds(10, 273, 121, 23);
		RecuperoPanel.add(IndietroButton);
		
		
		
		
		setVisible(true);
	}
	
	public void alertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(this, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
}
