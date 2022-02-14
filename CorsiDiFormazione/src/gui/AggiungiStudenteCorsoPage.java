package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Corsi;
import dto.Operatori;
import dto.Studenti;
import java.awt.Cursor;

public class AggiungiStudenteCorsoPage extends JFrame {

	private Operatori operatore;
	private Studenti studente;
	private Controller theController;
	private Vector<Corsi> corsi;
	private JComboBox<Corsi> corsiComboBox;
	
	private JPanel contentPane;
	private Component url;
	private ImageIcon imageicon;
	private JPanel prenotaLezioneStudentiPanel;
	private JLabel aggiungiStudenteAlCorsoLabel;
	private JButton indietroButton;
	private JButton aggiungiButton;
	private JLabel selezionareCorsoLabel;
	private JLabel datiStudenteLabel;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	

	
	public AggiungiStudenteCorsoPage(Controller controller, Operatori operatore, Studenti studente) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		this.studente = studente;
		
		corsi = theController.setIscrizioneCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiComboBox = new JComboBox<Corsi>(corsi);
		
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
		
		prenotaLezioneStudentiPanel = new JPanel();
		prenotaLezioneStudentiPanel.setBackground(grigioChiaro);
		prenotaLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		prenotaLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(prenotaLezioneStudentiPanel);
		prenotaLezioneStudentiPanel.setLayout(null);
		
		aggiungiStudenteAlCorsoLabel = new JLabel("AGGIUNGI STUDENTE AL CORSO");
		aggiungiStudenteAlCorsoLabel.setForeground(new Color(65, 105, 225));
		aggiungiStudenteAlCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		aggiungiStudenteAlCorsoLabel.setBackground(Color.WHITE);
		aggiungiStudenteAlCorsoLabel.setBounds(98, 11, 367, 33);
		prenotaLezioneStudentiPanel.add(aggiungiStudenteAlCorsoLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		prenotaLezioneStudentiPanel.add(indietroButton);
		
		aggiungiButton = new JButton("AGGIUGI");
		aggiungiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aggiungiButton.setBackground(Color.WHITE);
		aggiungiButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiButton.setBounds(417, 274, 121, 23);
		prenotaLezioneStudentiPanel.add(aggiungiButton);
		
		selezionareCorsoLabel = new JLabel("Selezionare corso:");
		selezionareCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareCorsoLabel.setBounds(51, 131, 136, 23);
		prenotaLezioneStudentiPanel.add(selezionareCorsoLabel);
		
		
		corsiComboBox.setBounds(193, 132, 163, 22);
		prenotaLezioneStudentiPanel.add(corsiComboBox);
		
		datiStudenteLabel = new JLabel("STUDENTE:  " + studente.getMatricola() + ",  " + studente.getCognome().toUpperCase() + ",  " + studente.getNome().toUpperCase());
		datiStudenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		datiStudenteLabel.setBounds(51, 106, 414, 14);
		prenotaLezioneStudentiPanel.add(datiStudenteLabel);
		
		if(corsiComboBox.getSelectedItem() == null) {
			alertNonCiSonoCorsiDisponibili();
			PanoramicaSingoloStudentePage pssp = new  PanoramicaSingoloStudentePage(theController, operatore, studente);
			setVisible(false);
		}
		
		// LISTNER
		
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
		
		aggiungiButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				aggiungiButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				aggiungiButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				aggiungiStudente();
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	// ALERT
	public void alertNonCiSonoCorsiDisponibili() {
	
		JOptionPane.showMessageDialog(this, "Non ci sono corsi disponibili dove poter iscrivere lo studente!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		PanoramicaSingoloStudentePage pssp = new  PanoramicaSingoloStudentePage(theController, operatore, studente);
		setVisible(false);
	}
	
	public void alertStudenteIscrittoCorrettamente() {
		JOptionPane.showMessageDialog(this, "Studente iscritto correttamente!","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		PanoramicaSingoloStudentePage pssp = new  PanoramicaSingoloStudentePage(theController, operatore, studente);
		setVisible(false);
	}
	
	public void alertErroreIscrizioneStudente(String state) {
		
		if(state.equals("10009")) 
			JOptionPane.showMessageDialog(this, "Non puoi iscirvere uno studente ad un corso terminato!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("10006"))
				JOptionPane.showMessageDialog(this, "Non e stato possibile effettuare l'iscrizione perche'e' stato raggiunto il numero massimo di partecipanti ammessi al corso","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Errore sconsciuto durante l'iscrizione al corso","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void aggiungiStudente() {
		String state = theController.aggiungiStudenteCorso(studente.getMatricola(), corsi.get(corsiComboBox.getSelectedIndex()).getIdCorso());
		
		if(state.equals("0")) {
			alertStudenteIscrittoCorrettamente();
			
		}else
			alertErroreIscrizioneStudente(state);
	}
}
