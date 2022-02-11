package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;
import dto.Studenti;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class GestoreStudentiPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private JComboBox<Studenti> studentiComboBox;
	private Vector<Studenti> studenti;
	
	private ImageIcon imageicon;
	private Component url;
	private JPanel contentPane;
	private JPanel selzionaStudentiPanel;
	private JLabel selezionaStudenteLabel;
	private JButton indietroButton;
	private JLabel studenteLabel;
	private JButton eliminaStudenteButton;
	private JButton panoramicaButton;
	private JButton creaStudenteButton;

	final Color grigioChiaro;
	
	public GestoreStudentiPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		studenti = theController.setStudenti();
		studentiComboBox = new JComboBox<Studenti>(studenti);
		
		grigioChiaro = new Color(233,233,233);
		
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
		
		selzionaStudentiPanel = new JPanel();
		selzionaStudentiPanel.setBackground(grigioChiaro);
		selzionaStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		selzionaStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(selzionaStudentiPanel);
		selzionaStudentiPanel.setLayout(null);
		
		selezionaStudenteLabel = new JLabel("SELEZIONA STUDENTE");
		selezionaStudenteLabel.setForeground(new Color(65, 105, 225));
		selezionaStudenteLabel.setFont(new Font("Arial", Font.BOLD, 22));
		selezionaStudenteLabel.setBackground(Color.WHITE);
		selezionaStudenteLabel.setBounds(147, 11, 260, 33);
		selzionaStudentiPanel.add(selezionaStudenteLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
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
		indietroButton.setBounds(10, 273, 168, 23);
		selzionaStudentiPanel.add(indietroButton);
		
		studenteLabel = new JLabel("Studente:");
		studenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		studenteLabel.setBounds(111, 123, 77, 14);
		selzionaStudentiPanel.add(studenteLabel);
		
		
		studentiComboBox.setBounds(198, 120, 157, 22);
		selzionaStudentiPanel.add(studentiComboBox);
		
		eliminaStudenteButton = new JButton("ELIMINA STUDENTE");
		eliminaStudenteButton.setBackground(Color.WHITE);
		eliminaStudenteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminaStudenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					alertSeiSicuroDiVolerEliminareStudente();
			}
		});
		eliminaStudenteButton.setForeground(Color.RED);
		eliminaStudenteButton.setFont(new Font("Arial", Font.BOLD, 11));
		eliminaStudenteButton.setBounds(290, 169, 140, 33);
		selzionaStudentiPanel.add(eliminaStudenteButton);
		
		panoramicaButton = new JButton("PANORAMICA");
		panoramicaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panoramicaButton.setBackground(Color.WHITE);
		panoramicaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				panoramicaButton.setBackground(Color.GREEN);
			}

		public void mouseExited(java.awt.event.MouseEvent e) {
			panoramicaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PanoramicaSingoloStudentePage gss = new PanoramicaSingoloStudentePage(theController, operatore, studenti.get(studentiComboBox.getSelectedIndex()));
				setVisible(false);
			}
		});
		panoramicaButton.setFont(new Font("Arial", Font.BOLD, 11));
		panoramicaButton.setBounds(120, 169, 140, 33);
		selzionaStudentiPanel.add(panoramicaButton);
		
		creaStudenteButton = new JButton("CREA STUDENTE");
		creaStudenteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		creaStudenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CreazioneStudentePage page = new CreazioneStudentePage(theController, operatore);
				setVisible(false);
			}
		});
		creaStudenteButton.setBackground(Color.WHITE);
		creaStudenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		creaStudenteButton.setBounds(370, 273, 168, 23);
		selzionaStudentiPanel.add(creaStudenteButton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void alertStudenteNonSelezionato() {
		JOptionPane.showMessageDialog(this, "Studente Non Selezionato.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertSeiSicuroDiVolerEliminareStudente() {
		Object[] opzioni = {"Sì"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler eliminare lo studente ?",
				"CONFERMA ELIMINAZIONE",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			
			theController.eliminaStudente(studenti.get(studentiComboBox.getSelectedIndex()).getMatricola());
			alertEliminazioneStudenteEffettuata();
			
		}
			
	}
	
	public void alertEliminazioneStudenteEffettuata() {
		
		JOptionPane.showMessageDialog(this, "Studente eliminato con successo","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		studenti = theController.setStudenti();

		studentiComboBox.removeAllItems();
		
		for(Studenti s:studenti) 
			studentiComboBox.addItem(s);
		
		
	}
}
