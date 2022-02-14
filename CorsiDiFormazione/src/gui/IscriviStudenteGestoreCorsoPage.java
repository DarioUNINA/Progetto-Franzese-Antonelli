package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Corsi;
import dto.Operatori;
import dto.Studenti;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import java.util.Vector;

public class IscriviStudenteGestoreCorsoPage extends JFrame {

	private Controller theController;
	private Operatori operatore;
	private Corsi corso;
	private Vector<Studenti> studenti;
	
	private Component url;
	private ImageIcon imageicon;
	
	private JPanel contentPane;
	private JPanel aggiungiStudentiPanel;
	private JLabel aggiungiStudenteAlCorsoLabel;
	private JLabel corsoLabel;
	private JLabel selezionareStudenteLabel;
	private JButton indietroButton;
	private JButton aggiungiButton;

	private JComboBox<Studenti> studentiComboBox;
	
	final Color grigioChiaro;
	
	public IscriviStudenteGestoreCorsoPage(Controller cont, Operatori operatore, Corsi corso) {
		setResizable(false);
		
		theController = cont;
		this.operatore = operatore;
		this.corso = corso;
		studenti = theController.getStudentiDisponibili(corso.getIdCorso());
		studentiComboBox = new JComboBox<Studenti>(studenti);
		
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
		
		aggiungiStudentiPanel = new JPanel();
		aggiungiStudentiPanel.setBackground(grigioChiaro);
		aggiungiStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		aggiungiStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(aggiungiStudentiPanel);
		aggiungiStudentiPanel.setLayout(null);
		
		aggiungiStudenteAlCorsoLabel = new JLabel("AGGIUNGI STUDENTE AL CORSO");
		aggiungiStudenteAlCorsoLabel.setForeground(new Color(65, 105, 225));
		aggiungiStudenteAlCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		aggiungiStudenteAlCorsoLabel.setBackground(Color.WHITE);
		aggiungiStudenteAlCorsoLabel.setBounds(94, 11, 367, 33);
		aggiungiStudentiPanel.add(aggiungiStudenteAlCorsoLabel);
		
		corsoLabel = new JLabel("CORSO: " + corso.getNome());
		corsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsoLabel.setBounds(30, 111, 414, 14);
		aggiungiStudentiPanel.add(corsoLabel);
		
		selezionareStudenteLabel = new JLabel("Selezionare Studente:");
		selezionareStudenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareStudenteLabel.setBounds(30, 136, 163, 23);
		aggiungiStudentiPanel.add(selezionareStudenteLabel);
		
		studentiComboBox.setBounds(203, 137, 163, 22);
		aggiungiStudentiPanel.add(studentiComboBox);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		aggiungiStudentiPanel.add(indietroButton);
		
		aggiungiButton = new JButton("AGGIUGI");
		aggiungiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aggiungiButton.setBackground(Color.WHITE);
		aggiungiButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiButton.setBounds(417, 274, 121, 23);
		aggiungiStudentiPanel.add(aggiungiButton);
		
		
		//LISTNER
			
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreCorsiPage gcp = new GestoreCorsiPage(theController, operatore);
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
				
				aggiungiStudenteCorso();
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	//ALERT
	public void alertStudenteIscrittoCorrettamente() {
		JOptionPane.showMessageDialog(this, "Studente iscritto correttamente!","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		GestoreCorsiPage gcp = new GestoreCorsiPage(theController, operatore);
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
	
	public void aggiungiStudenteCorso() {
		String state = theController.aggiungiStudenteCorso(studenti.get(studentiComboBox.getSelectedIndex()).getMatricola(), corso.getIdCorso());
		
		if(state.equals("0")) {
			alertStudenteIscrittoCorrettamente();
			
		}else
			alertErroreIscrizioneStudente(state);
	}
}
