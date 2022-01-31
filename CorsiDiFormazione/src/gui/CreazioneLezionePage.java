package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CreazioneLezionePage extends JFrame {

	private JPanel creazioneLezioniPanel;
	private Controller theController;
	private Operatori operatore;
	private Component url;
	private ImageIcon imageicon;
	private JTextField titoloTextField;
	private JTextField durataTextField;
	private JTextField orarioTextField;
	private JTextField dataTextField;
	private JTextField descrizioneTextField;
	
	public CreazioneLezionePage(Controller controller, Operatori operatore) {
		
		
		this.operatore = operatore;
		theController = controller;
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		creazioneLezioniPanel = new JPanel();
		creazioneLezioniPanel.setBorder(new LineBorder(Color.BLACK));
		setContentPane(creazioneLezioniPanel);
		getContentPane().setBackground(new Color(65, 105, 225));
		creazioneLezioniPanel.setLayout(null);
			

		JPanel creaLezionePanel = new JPanel();
		creaLezionePanel.setBounds(10, 11, 548, 307);
		creaLezionePanel.setBackground(SystemColor.control);
		creaLezionePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		creazioneLezioniPanel.add(creaLezionePanel);
		creaLezionePanel.setLayout(null);
		
		JLabel creazioneLezioneLabel = new JLabel("CREAZIONE LEZIONE");
		creazioneLezioneLabel.setForeground(Color.BLACK);
		creazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		creazioneLezioneLabel.setBackground(Color.WHITE);
		creazioneLezioneLabel.setBounds(159, 11, 227, 33);
		creaLezionePanel.add(creazioneLezioneLabel);
		
		JLabel titoloLabel = new JLabel("Titolo:");
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(58, 75, 45, 18);
		creaLezionePanel.add(titoloLabel);
		
		JLabel durataLabel = new JLabel("Durata:");
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(52, 119, 51, 18);
		creaLezionePanel.add(durataLabel);
		
		JLabel orarioLabel = new JLabel("Orario:");
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(265, 75, 51, 18);
		creaLezionePanel.add(orarioLabel);
		
		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dataLabel.setBounds(280, 119, 36, 18);
		creaLezionePanel.add(dataLabel);
		
		JLabel descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(58, 175, 124, 18);
		creaLezionePanel.add(descrizioneLabel);
		
		JButton indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreLezioniPage glp = new GestoreLezioniPage(theController, operatore);
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
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		creaLezionePanel.add(indietroButton);
		
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
				String titolo = titoloTextField.getText().toLowerCase();
				String descrizione = descrizioneTextField.getText().toLowerCase();
				String data;
				String orario;
				String durata;
				
			}
		});	
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		creaLezionePanel.add(confermaButton);
		
		titoloTextField = new JTextField();
		titoloTextField.setFont(new Font("Arial", Font.BOLD, 11));
		titoloTextField.setColumns(10);
		titoloTextField.setBounds(113, 76, 103, 20);
		creaLezionePanel.add(titoloTextField);
		
		durataTextField = new JTextField();
		durataTextField.setFont(new Font("Arial", Font.BOLD, 11));
		durataTextField.setColumns(10);
		durataTextField.setBounds(113, 120, 103, 20);
		creaLezionePanel.add(durataTextField);
		
		orarioTextField = new JTextField();
		orarioTextField.setFont(new Font("Arial", Font.BOLD, 11));
		orarioTextField.setColumns(10);
		orarioTextField.setBounds(326, 76, 103, 20);
		creaLezionePanel.add(orarioTextField);
		
		dataTextField = new JTextField();
		dataTextField.setFont(new Font("Arial", Font.BOLD, 11));
		dataTextField.setColumns(10);
		dataTextField.setBounds(326, 120, 103, 20);
		creaLezionePanel.add(dataTextField);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setFont(new Font("Arial", Font.BOLD, 11));
		descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(159, 175, 270, 20);
		creaLezionePanel.add(descrizioneTextField);
		
	}
}
