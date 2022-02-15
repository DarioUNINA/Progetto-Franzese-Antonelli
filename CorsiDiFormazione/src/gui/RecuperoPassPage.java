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

import controller.Controller;

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
import java.awt.Cursor;

public class RecuperoPassPage extends JFrame {

	private Controller theController;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel recuperoPanel;
	private JLabel recuperoPasswordLabel;
	private JLabel nomeUtenteLabel;
	private JTextField nomeUtenteTextField;
	private JButton confermaButton;
	private JButton indietroButton;	
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public RecuperoPassPage(Controller controller) {
		
		theController = controller;
		
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
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		recuperoPanel = new JPanel();
		recuperoPanel.setBackground(grigioChiaro);
		recuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		recuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(recuperoPanel);
		recuperoPanel.setLayout(null);
		
		recuperoPasswordLabel = new JLabel("RECUPERO PASSWORD");
		recuperoPasswordLabel.setForeground(Color.BLACK);
		recuperoPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));
		recuperoPasswordLabel.setBackground(Color.WHITE);
		recuperoPasswordLabel.setBounds(143, 11, 268, 33);
		recuperoPanel.add(recuperoPasswordLabel);
		
		nomeUtenteLabel = new JLabel("Nome Utente:");
		nomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 20));
		nomeUtenteLabel.setBounds(31, 113, 153, 24);
		recuperoPanel.add(nomeUtenteLabel);
		
		nomeUtenteTextField = new JTextField();
		nomeUtenteTextField.setFont(new Font("Arial", Font.BOLD, 13));
		nomeUtenteTextField.setColumns(10);
		nomeUtenteTextField.setBounds(171, 113, 197, 27);
		recuperoPanel.add(nomeUtenteTextField);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(201, 154, 135, 24);
		recuperoPanel.add(confermaButton);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 272, 135, 24);
		recuperoPanel.add(indietroButton);
		
		
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
				
				gestoreCheckNome();
				}
					
		});
		
		
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
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	//ALERT
	public void alertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(this, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertUtenteNonTrovato() {
		JOptionPane.showMessageDialog(this, "Utente non trovato, riprova","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
	
	//GESTORI
	
	public void gestoreCheckNome() {
		String Nome = nomeUtenteTextField.getText().toLowerCase();
		
		if(Nome.isEmpty()) 
			alertNomeUtenteNonInserito();
		else {
				String state = theController.CheckNomeClicked(Nome.toLowerCase());
				
				if(state.equals("0")) {
					
					theController.recuperoPassDomandaPage(theController.getOperatoreRecuperoPass(Nome));
					setVisible(false);
				}else
					alertUtenteNonTrovato();
		}
	}
}
