package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Corsi;
import dto.Operatori;
import dto.Studenti;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PrenotaLezioneStudentePage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private Studenti studente;
	private JComboBox<Corsi> corsiComboBox;
	private Vector <Corsi> corsi;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel prenotaLezioneStudentiPanel;
	private JLabel prenotazioneLezioneLabel;
	private JButton indietroButton;
	private JLabel selezionareCorsoLabel;
	
	
	
	
	
	public PrenotaLezioneStudentePage(Controller controller, Operatori operatore, Studenti studente) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		this.studente = studente;
		
		corsi= theController.setDisiscrizioneCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiComboBox = new JComboBox<Corsi>(corsi);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton confermaButton;
		prenotaLezioneStudentiPanel = new JPanel();
		prenotaLezioneStudentiPanel.setBackground(SystemColor.control);
		prenotaLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		prenotaLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(prenotaLezioneStudentiPanel);
		prenotaLezioneStudentiPanel.setLayout(null);
		
		prenotazioneLezioneLabel = new JLabel("PRENOTAZIONE LEZIONE");
		prenotazioneLezioneLabel.setForeground(new Color(65, 105, 225));
		prenotazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		prenotazioneLezioneLabel.setBackground(Color.WHITE);
		prenotazioneLezioneLabel.setBounds(138, 11, 279, 33);
		prenotaLezioneStudentiPanel.add(prenotazioneLezioneLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanoramicaSingoloStudentePage gss = new PanoramicaSingoloStudentePage(theController, operatore, studente);
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
		prenotaLezioneStudentiPanel.add(indietroButton);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ConfermaPrenotaLezionePage cpls = new ConfermaPrenotaLezionePage(theController, operatore, studente);
				setVisible(false);
			}
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		prenotaLezioneStudentiPanel.add(confermaButton);
		
		selezionareCorsoLabel = new JLabel("Selezionare corso:");
		selezionareCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareCorsoLabel.setBounds(51, 131, 136, 23);
		prenotaLezioneStudentiPanel.add(selezionareCorsoLabel);
		
		corsiComboBox.setBounds(193, 132, 163, 22);
		prenotaLezioneStudentiPanel.add(corsiComboBox);
		
		setVisible(true);
	}

}
