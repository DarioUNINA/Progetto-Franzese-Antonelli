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

import dto.Corsi;
import dto.Lezioni;
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

	
	private Controller theController;
	private Operatori operatore;
	private JList<Corsi> corsiList;
	private Studenti studente;
	private JList<Lezioni> lezioniList;
	private String[] nomeColonne = {"Corso", "Numero Presenze"};
	private Vector<Corsi> corsi;
	private Vector<Lezioni> lezioni;
	
	private ImageIcon imageicon;
	private JPanel sfondoPane;
	private Component url;
	private JPanel studentePanel;
	private JLabel studenteLabel;
	private JButton indietroButton;
	private JLabel elencoCorsiLabel;
	private JPanel corsiPanel;
	private JScrollPane corsiScrollPane;
	private JPanel lezioniPanel;
	private JLabel elencoLezioniLabel;
	private JScrollPane lezioniScrollPane;
	private JPanel corsiAmmessoPanel;
	private JButton confermaButton;
	private JLabel corsiAmmessoLabel;
	private JButton iscriviAdUnCorsoButton;
	private JButton annullaPrenotazioneButton;
	private JButton disiscriviDaUnCorsoButton;
	private JButton prenotaLezioneButton;
	private JTable corsiAmmessiLable;
	
	
	public PanoramicaSingoloStudentePage(Controller cont, Operatori operatore, Studenti studente) {
		
		theController = cont;
		this.operatore = operatore;
		this.studente = studente;
		
		corsi = theController.setCorsiStudente(studente);
		corsiList = new JList<Corsi> (corsi);
		
		imageicon = new ImageIcon("napule.png");
		
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
		
		studentePanel = new JPanel();
		studentePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentePanel.setBackground(SystemColor.control);
		studentePanel.setBounds(10, 11, 777, 77);
		sfondoPane.add(studentePanel);
		studentePanel.setLayout(null);
		
		studenteLabel = new JLabel("");
		studenteLabel.setFont(new Font("Arial", Font.BOLD, 30));
		studenteLabel.setBounds(10, 0, 528, 44);
		studentePanel.add(studenteLabel);
		studenteLabel.setText("STUDENTE: " + studente.getMatricola() + ", " + studente.getCognome().toUpperCase());
		
		indietroButton = new JButton("INDIETRO");
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
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBounds(10, 99, 185, 341);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		elencoCorsiLabel = new JLabel("ELENCO CORSI:");
		elencoCorsiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoCorsiLabel.setBounds(31, 11, 131, 14);
		corsiPanel.add(elencoCorsiLabel);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		corsiScrollPane.setBounds(10, 36, 165, 240);
		corsiPanel.add(corsiScrollPane);
		

		corsiScrollPane.setViewportView(corsiList);
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		
		lezioniPanel = new JPanel();
		lezioniPanel.setLayout(null);
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(227, 99, 185, 341);
		sfondoPane.add(lezioniPanel);
		
		elencoLezioniLabel = new JLabel("ELENCO LEZIONI:");
		elencoLezioniLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoLezioniLabel.setBounds(31, 11, 131, 14);
		lezioniPanel.add(elencoLezioniLabel);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		lezioniScrollPane.setBounds(10, 36, 165, 294);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList = new JList();
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id_corso = corsiList.getSelectedValue().getIdCorso();
				lezioniList.setListData(theController.setAllLezioniDelCorso(id_corso));
			}
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 12));
		confermaButton.setBounds(31, 287, 119, 30);
		corsiPanel.add(confermaButton);
		
		corsiAmmessoPanel = new JPanel();
		corsiAmmessoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiAmmessoPanel.setBounds(440, 99, 347, 341);
		sfondoPane.add(corsiAmmessoPanel);
		corsiAmmessoPanel.setLayout(null);
		
		corsiAmmessoLabel = new JLabel("CORSI ALLA QUALE SI E' AMMESSI ");
		corsiAmmessoLabel.setBounds(49, 11, 263, 14);
		corsiAmmessoPanel.add(corsiAmmessoLabel);
		corsiAmmessoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		corsiAmmessiLable = new JTable();
		corsiAmmessiLable.setBorder(new LineBorder(Color.ORANGE));
		corsiAmmessiLable.setBounds(10, 180, 327, -127);
		corsiAmmessoPanel.add(corsiAmmessiLable);
		
		iscriviAdUnCorsoButton = new JButton("ISCRIVI AD UN CORSO");
		iscriviAdUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiStudenteCorsoPage asc = new AggiungiStudenteCorsoPage(theController, operatore, studente);
				setVisible(false);
			}
		});
		iscriviAdUnCorsoButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		iscriviAdUnCorsoButton.setBounds(10, 222, 162, 35);
		corsiAmmessoPanel.add(iscriviAdUnCorsoButton);
		
		disiscriviDaUnCorsoButton = new JButton("DISISCRIVI DA UN CORSO");
		disiscriviDaUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisiscriviStudenteCorsoPage dsc = new DisiscriviStudenteCorsoPage(theController, operatore, studente);
				setVisible(false);
			}
		});
		disiscriviDaUnCorsoButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		disiscriviDaUnCorsoButton.setBounds(175, 222, 162, 35);
		corsiAmmessoPanel.add(disiscriviDaUnCorsoButton);
		
		prenotaLezioneButton = new JButton("PRENOTA LEZIONE");
		prenotaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotaLezioneStudentePage pls = new PrenotaLezioneStudentePage(theController, operatore, studente);
				setVisible(false);
			}
		});
		prenotaLezioneButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prenotaLezioneButton.setBounds(10, 279, 162, 35);
		corsiAmmessoPanel.add(prenotaLezioneButton);
		
		annullaPrenotazioneButton = new JButton("ANNULLA PRENOTAZIONE");
		annullaPrenotazioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnnullaPrenotazionePage ap = new AnnullaPrenotazionePage(theController, operatore, studente);
				setVisible(false);
			}
		});
		annullaPrenotazioneButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		annullaPrenotazioneButton.setBounds(175, 279, 162, 35);
		corsiAmmessoPanel.add(annullaPrenotazioneButton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
