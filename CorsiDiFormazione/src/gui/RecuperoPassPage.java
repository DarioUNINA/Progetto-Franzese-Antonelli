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
	private JTextField nomeUtenteText;
	
	
	
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
		
		JPanel recuperoPanel = new JPanel();
		recuperoPanel.setBackground(SystemColor.control);
		recuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		recuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(recuperoPanel);
		recuperoPanel.setLayout(null);

		
		JLabel rECUPEROPASSWORDLabel = new JLabel("RECUPERO PASSWORD");
		rECUPEROPASSWORDLabel.setForeground(Color.BLACK);
		rECUPEROPASSWORDLabel.setFont(new Font("Arial", Font.BOLD, 22));
		rECUPEROPASSWORDLabel.setBackground(Color.WHITE);
		rECUPEROPASSWORDLabel.setBounds(139, 11, 268, 33);
		recuperoPanel.add(rECUPEROPASSWORDLabel);
		
		JLabel nomeUtenteLabel = new JLabel("Nome Utente:");
		nomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomeUtenteLabel.setBounds(100, 80, 101, 14);
		recuperoPanel.add(nomeUtenteLabel);
		
		nomeUtenteText = new JTextField();
		nomeUtenteText.setColumns(10);
		nomeUtenteText.setBounds(211, 78, 121, 20);
		recuperoPanel.add(nomeUtenteText);
		
		JButton confermaButton = new JButton("CONFERMA");
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
				String Nome = nomeUtenteText.getText();
				if(Nome.isEmpty()) 
					alertNomeUtenteNonInserito();
				else {
						String state = theController.CheckNomeClicked(Nome.toLowerCase());
						
						if(state.equals("0")) {
							RecuperoPassDomandaPage rpd = new RecuperoPassDomandaPage(theController, Nome);
							setVisible(false);
						}else
							alertUtenteNonTrovato();
				}
					
			}
		});
		
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(211, 148, 121, 27);
		recuperoPanel.add(confermaButton);
		
		JButton indietroButton = new JButton("INDIETRO");
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
		indietroButton.setBounds(10, 273, 121, 23);
		recuperoPanel.add(indietroButton);
		
		
		
		
		setVisible(true);
	}
	
	public void alertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(this, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertUtenteNonTrovato() {
		JOptionPane.showMessageDialog(this, "Utente non trovato, riprova","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
}
