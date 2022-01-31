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
import dto.Studenti;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class PanoramicaSingoloStudentePage extends JFrame {

	private JPanel sfondoPane;
	private Component url;
	private Controller theController;
	private ImageIcon imageicon;
	private Operatori operatore;
	private JTable corsiAmmessiLable;
	private Studenti studente;
	
	public PanoramicaSingoloStudentePage(Controller cont, Operatori operatore, Studenti studente) {
		
		imageicon = new ImageIcon("napule.png");
		theController = cont;
		this.operatore = operatore;
		setIconImage(imageicon.getImage());

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		sfondoPane = new JPanel();
		sfondoPane.setBackground(new Color(65, 105, 225));
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		
		
		JPanel studentePanel = new JPanel();
		studentePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentePanel.setBackground(SystemColor.control);
		studentePanel.setBounds(10, 11, 777, 77);
		sfondoPane.add(studentePanel);
		studentePanel.setLayout(null);
		
		JLabel studenteLabel = new JLabel("");
		studenteLabel.setFont(new Font("Arial", Font.BOLD, 30));
		studenteLabel.setBounds(10, 0, 528, 44);
		studentePanel.add(studenteLabel);
		studenteLabel.setText("STUDENTE: " + studente.getMatricola() + ", " + studente.getCognome().toUpperCase());
		
		JButton indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				indietroButton.setBackground(Color.RED);
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				indietroButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreStudentiPage gs = new GestoreStudentiPage(theController, operatore);
				setVisible(false);
				
			}
		});
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(615, 43, 152, 23);
		studentePanel.add(indietroButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(10, 99, 185, 341);
		sfondoPane.add(panel);
		panel.setLayout(null);
		
		JLabel elencoCorsiLabel = new JLabel("ELENCO CORSI:");
		elencoCorsiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoCorsiLabel.setBounds(31, 11, 131, 14);
		panel.add(elencoCorsiLabel);
		
		JButton btnNewButton = new JButton("CONFERMA");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(31, 287, 119, 30);
		panel.add(btnNewButton);
		
		JScrollPane corsiScrollPane = new JScrollPane();
		corsiScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		corsiScrollPane.setBounds(10, 36, 165, 240);
		panel.add(corsiScrollPane);
		
		JList corsiList = new JList(theController.setCorsiStudente(studente));
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(227, 99, 185, 341);
		sfondoPane.add(panel_1);
		
		JLabel elencoLezioniLabel = new JLabel("ELENCO LEZIONI:");
		elencoLezioniLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoLezioniLabel.setBounds(31, 11, 131, 14);
		panel_1.add(elencoLezioniLabel);
		
		JList lezioniList = new JList();
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniList.setBounds(10, 36, 165, 294);
		panel_1.add(lezioniList);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(440, 99, 347, 341);
		sfondoPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCorsiAllaQuale = new JLabel("CORSI ALLA QUALE E' AMMESSO ");
		lblCorsiAllaQuale.setBounds(53, 11, 246, 14);
		panel_2.add(lblCorsiAllaQuale);
		lblCorsiAllaQuale.setFont(new Font("Arial", Font.BOLD, 15));
		
		corsiAmmessiLable = new JTable();
		corsiAmmessiLable.setBorder(new LineBorder(Color.ORANGE));
		corsiAmmessiLable.setBounds(10, 180, 327, -127);
		panel_2.add(corsiAmmessiLable);
		
		JButton iscriviAdUnCorsoButton = new JButton("ISCRIVI AD UN CORSO");
		iscriviAdUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiStudenteCorsoPage asc = new AggiungiStudenteCorsoPage(theController, operatore);
				setVisible(false);
			}
		});
		iscriviAdUnCorsoButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		iscriviAdUnCorsoButton.setBounds(10, 222, 162, 35);
		panel_2.add(iscriviAdUnCorsoButton);
		
		JButton disiscriviDaUnCorsoButton = new JButton("DISISCRIVI DA UN CORSO");
		disiscriviDaUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisiscriviStudenteCorsoPage dsc = new DisiscriviStudenteCorsoPage(cont, operatore);
				setVisible(false);
			}
		});
		disiscriviDaUnCorsoButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		disiscriviDaUnCorsoButton.setBounds(175, 222, 162, 35);
		panel_2.add(disiscriviDaUnCorsoButton);
		
		JButton prenotaLezioneButton = new JButton("PRENOTA LEZIONE");
		prenotaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotaLezioneStudentePage pls = new PrenotaLezioneStudentePage(theController, operatore);
				setVisible(false);
			}
		});
		prenotaLezioneButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prenotaLezioneButton.setBounds(10, 279, 162, 35);
		panel_2.add(prenotaLezioneButton);
		
		JButton annullaPrenotazioneButton = new JButton("ANNULLA PRENOTAZIONE");
		annullaPrenotazioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnnullaPrenotazionePage ap = new AnnullaPrenotazionePage(theController, operatore);
				setVisible(false);
			}
		});
		annullaPrenotazioneButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		annullaPrenotazioneButton.setBounds(175, 279, 162, 35);
		panel_2.add(annullaPrenotazioneButton);
		
		setVisible(true);
	}
}
