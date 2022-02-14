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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;
import dto.Studenti;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Cursor;

public class ConfermaPrenotaLezionePage extends JFrame {

	private Operatori operatore;
	private Studenti studente;
	private Corsi corso;
	private Controller theController;
	private JComboBox<Lezioni> lezioniComboBox;
	private Vector <Lezioni> lezioni;
	
	private ImageIcon imageicon;
	private JPanel contentPane;
	private Component url;
	private JPanel confermaPrenotaLezioneStudentiPanel;
	private JLabel prenotazioneLezioneLabel;
	private JButton indietroButton;
	private JButton confermaButton;
	private JLabel selezionareLezioneLabel;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public ConfermaPrenotaLezionePage(Controller controller, Operatori operatore, Studenti studente, Corsi corso) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		this.studente = studente;
		this.corso = corso;

		lezioni = theController.iscirizioneStudenteLezioniDelCorso(studente.getMatricola(), corso.getIdCorso());
		lezioniComboBox = new JComboBox<Lezioni>(lezioni);
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);

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
		
		confermaPrenotaLezioneStudentiPanel = new JPanel();
		confermaPrenotaLezioneStudentiPanel.setBackground(grigioChiaro);
		confermaPrenotaLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		confermaPrenotaLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(confermaPrenotaLezioneStudentiPanel);
		confermaPrenotaLezioneStudentiPanel.setLayout(null);
		
		prenotazioneLezioneLabel = new JLabel("PRENOTAZIONE LEZIONE");
		prenotazioneLezioneLabel.setForeground(new Color(65, 105, 225));
		prenotazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		prenotazioneLezioneLabel.setBackground(Color.WHITE);
		prenotazioneLezioneLabel.setBounds(136, 11, 279, 33);
		confermaPrenotaLezioneStudentiPanel.add(prenotazioneLezioneLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		confermaPrenotaLezioneStudentiPanel.add(indietroButton);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		confermaPrenotaLezioneStudentiPanel.add(confermaButton);
		
		selezionareLezioneLabel = new JLabel("Selezionare lezione:");
		selezionareLezioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareLezioneLabel.setBounds(42, 131, 145, 23);
		confermaPrenotaLezioneStudentiPanel.add(selezionareLezioneLabel);
		
		lezioniComboBox.setBounds(193, 132, 163, 22);
		confermaPrenotaLezioneStudentiPanel.add(lezioniComboBox);
		
		
		//LISTNER
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanoramicaSingoloStudentePage page = new PanoramicaSingoloStudentePage(theController, operatore, studente);
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
		
		confermaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gestoreAggiungiStudenteLezione();
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	//ALERT
	
	public void alertStudenteAggiuntoCorrettamente() {
		JOptionPane.showMessageDialog(this, "Studente aggiunto correttamente alla lezione.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreIscrizioneAllaLezione(String state) {
		if(state=="-1")	
			JOptionPane.showMessageDialog(this, "Errore durante l'iscrizione alla lezione","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("10007"))
				JOptionPane.showMessageDialog(this, "Non e' possibile iscriversi a lezioni gia' concluse","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				if(state.equals("10008"))
					JOptionPane.showMessageDialog(this, "ATTENZIONE: sei gia' iscritto a una lezione contemporanea a quella selezionata","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
				else
					JOptionPane.showMessageDialog(this, "Errore durante l'iscrizione alla lezione.\nCodice d'errore "+ state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
	
	
	//GESTORI
	
	public void gestoreAggiungiStudenteLezione() {
		String state = theController.aggiungiStudenteLezioneClicked(studente.getMatricola(), lezioni.get(lezioniComboBox.getSelectedIndex()).getIdLezione());
		
		if(state.equals("0")) {
			alertStudenteAggiuntoCorrettamente();
			PanoramicaSingoloStudentePage pssp = new  PanoramicaSingoloStudentePage(theController, operatore, studente);
			setVisible(false);
		}else
			alertErroreIscrizioneAllaLezione(state);
		
	}
}
