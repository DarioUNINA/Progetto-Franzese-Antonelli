package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.module.Configuration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;
import dto.Studenti;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.Icon;

public class PanoramicaStudentePage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private JList<Corsi> corsiList;
	private Studenti studente;
	private JList<Lezioni> lezioniList;
	private Vector<Corsi> corsi;
	private Vector<Corsi> corsiAmmessi;
	private Vector<Lezioni> lezioni;
	
	private ImageIcon imageicon;
	private ImageIcon imageImpostazioni;
	private ImageIcon imageTrattini;
	private ImageIcon imageEsci;
	
	private JPanel sfondoPane;
	private JPanel infoPanel;
	private JLabel studenteLabel;
	private Component url;
	private JPanel studentePanel;
	private JLabel elencoCorsiLabel;
	private JPanel corsiPanel;
	private JScrollPane corsiScrollPane;
	private JPanel lezioniPanel;
	private JLabel elencoLezioniLabel;
	private JScrollPane lezioniScrollPane;
	private JPanel corsiAmmessoPanel;
	private JLabel corsiAmmessoLabel;
	private JButton iscriviAdUnCorsoButton;
	private JButton annullaPrenotazioneButton;
	private JButton disiscriviDaUnCorsoButton;
	private JButton prenotaLezioneButton;
	private JLabel corsoLabel;
	private JLabel presenzeLabel;
	private JLabel ammessoLabel;
	private JLabel numeroLezioniLabel;
	private JPanel menuPanelEsteso;
	private JLabel impostazioniLabelMenuEsteso;
	private JLabel impostazioniScrittaLabel;
	private JLabel gestoreCorsiLabel;
	private JLabel gestoreLezioniLabel;
	private JLabel gestoreStudentiLabel;
	private JLabel esciImageMenuEstesoLabel;
	private JLabel esciLabel;
	private JLabel labelTrattiniMenuEsteso;
	private JLabel menuEstesoLabel;
	private JPanel gestoreCorsiOpacoPanel;
	private JPanel gestoreLezioniOpacoPanel;
	private JPanel gestoreStudentiOpacoPanel;
	private JLabel ammessoValueLabel;
	
	private JPanel menuPanel;
	private JLabel esciImageLabel;
	private JLabel labelTrattini;
	private JLabel impostazioniLabel;
	private JButton modificaStudenteButton;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public PanoramicaStudentePage(Controller cont, Operatori operatore, Studenti studente) {
		
		theController = cont;
		this.operatore = operatore;
		this.studente = studente;
		corsi = theController.setCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiList = new JList<Corsi> (corsi);
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		imageImpostazioni = new ImageIcon("impostazioni.png");
		imageicon = new ImageIcon("napule.png");
		imageTrattini = new ImageIcon("trattini.png");
		imageEsci = new ImageIcon("esci.png");
		setIconImage(imageicon.getImage());

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		sfondoPane = new JPanel();
		sfondoPane.setBackground(blu);
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		menuPanelEsteso = new JPanel();
		menuPanelEsteso.setVisible(false);
		menuPanelEsteso.setBounds(10, 11, 225, 539);
		menuPanelEsteso.setLayout(null);
		menuPanelEsteso.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		menuPanelEsteso.setBackground(new Color(25, 25, 112));
		sfondoPane.add(menuPanelEsteso);
		
		impostazioniLabelMenuEsteso = new JLabel(imageImpostazioni);
		impostazioniLabelMenuEsteso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		impostazioniLabelMenuEsteso.setBounds(10, 465, 24, 32);
		menuPanelEsteso.add(impostazioniLabelMenuEsteso);
		impostazioniScrittaLabel = new JLabel("IMPOSTAZIONI");
		impostazioniScrittaLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		impostazioniScrittaLabel.setForeground(Color.WHITE);
		impostazioniScrittaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		impostazioniScrittaLabel.setBounds(44, 465, 142, 32);
		menuPanelEsteso.add(impostazioniScrittaLabel);
		
		gestoreCorsiLabel = new JLabel("           GESTORE CORSI");
		gestoreCorsiLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestoreCorsiLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreCorsiLabel.setForeground(Color.WHITE);
		gestoreCorsiLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreCorsiLabel.setBounds(0, 66, 225, 22);
		menuPanelEsteso.add(gestoreCorsiLabel);
		
		gestoreLezioniLabel = new JLabel("           GESTORE LEZIONI");
		gestoreLezioniLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestoreLezioniLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreLezioniLabel.setForeground(Color.WHITE);
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreLezioniLabel.setBounds(0, 99, 225, 22);
		menuPanelEsteso.add(gestoreLezioniLabel);
		
		gestoreStudentiLabel = new JLabel("        GESTORE STUDENTI");
		gestoreStudentiLabel.setBorder(new LineBorder(new Color(0, 0, 0)));	
		gestoreStudentiLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreStudentiLabel.setForeground(Color.WHITE);
		gestoreStudentiLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreStudentiLabel.setBounds(0, 132, 225, 22);
		menuPanelEsteso.add(gestoreStudentiLabel);
		
		gestoreCorsiOpacoPanel = new JPanel();
		gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreCorsiOpacoPanel.setBounds(0, 66, 225, 22);
		menuPanelEsteso.add(gestoreCorsiOpacoPanel);
		
		gestoreLezioniOpacoPanel = new JPanel();
		gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreLezioniOpacoPanel.setBounds(0, 99, 225, 22);
		menuPanelEsteso.add(gestoreLezioniOpacoPanel);
		
		gestoreStudentiOpacoPanel = new JPanel();
		gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreStudentiOpacoPanel.setBounds(0, 132, 225, 22);
		menuPanelEsteso.add(gestoreStudentiOpacoPanel);
		
		esciImageMenuEstesoLabel = new JLabel(imageEsci);
		esciImageMenuEstesoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esciImageMenuEstesoLabel.setBounds(10, 496, 24, 22);
		esciImageMenuEstesoLabel.setVisible(true);
		menuPanelEsteso.add(esciImageMenuEstesoLabel);
		
		esciLabel = new JLabel("ESCI");
		esciLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esciLabel.setForeground(Color.WHITE);
		esciLabel.setFont(new Font("Arial", Font.BOLD, 18));
		esciLabel.setBounds(44, 496, 142, 32);
		menuPanelEsteso.add(esciLabel);
		
		labelTrattiniMenuEsteso = new JLabel(imageTrattini);
		labelTrattiniMenuEsteso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelTrattiniMenuEsteso.setFont(new Font("Arial", Font.BOLD, 15));
		labelTrattiniMenuEsteso.setBounds(10, 11, 24, 25);
		menuPanelEsteso.add(labelTrattiniMenuEsteso);
		
		menuEstesoLabel = new JLabel("Menu");
		menuEstesoLabel.setForeground(Color.WHITE);
		menuEstesoLabel.setFont(new Font("Arial", Font.BOLD, 18));
		menuEstesoLabel.setBounds(85, 11, 58, 22);
		menuPanelEsteso.add(menuEstesoLabel);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		menuPanel.setBackground(new Color(25, 25, 112));
		menuPanel.setBounds(10, 11, 44, 539);
		sfondoPane.add(menuPanel);
		
		labelTrattini = new JLabel(imageTrattini);
		labelTrattini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelTrattini.setFont(new Font("Arial", Font.BOLD, 15));
		labelTrattini.setBounds(10, 11, 24, 25);
		menuPanel.add(labelTrattini);
		
		impostazioniLabel = new JLabel(imageImpostazioni);
		impostazioniLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		impostazioniLabel.setBounds(10, 465, 24, 32);
		menuPanel.add(impostazioniLabel);
		
		esciImageLabel = new JLabel(imageEsci);
		esciImageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esciImageLabel.setBounds(10, 496, 24, 25);
		menuPanel.add(esciImageLabel);
		
		studentePanel = new JPanel();
		studentePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentePanel.setBackground(grigioChiaro);
		studentePanel.setBounds(64, 11, 810, 77);
		sfondoPane.add(studentePanel);
		studentePanel.setLayout(null);
		
		studenteLabel = new JLabel("STUDENTE: " + studente.getMatricola() +" " + studente.getCognome().toUpperCase());
		studenteLabel.setFont(new Font("Arial", Font.BOLD, 30));
		studenteLabel.setBounds(10, 0, 528, 44);
		studentePanel.add(studenteLabel);
		
		modificaStudenteButton = new JButton("MODIFICA STUDENTE");
		modificaStudenteButton.setBackground(Color.WHITE);
		modificaStudenteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificaStudenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		modificaStudenteButton.setBounds(592, 43, 208, 23);
		studentePanel.add(modificaStudenteButton);

		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBackground(grigioChiaro);
		corsiPanel.setBounds(64, 99, 196, 451);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		elencoCorsiLabel = new JLabel("ELENCO CORSI:");
		elencoCorsiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoCorsiLabel.setBounds(44, 11, 131, 14);
		corsiPanel.add(elencoCorsiLabel);
	
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(10, 36, 176, 404);
		corsiPanel.add(corsiScrollPane);
		
		corsiScrollPane.setViewportView(corsiList);
		
		corsiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		corsiList.setBackground(azzurroChiaro);
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		
		lezioniPanel = new JPanel();
		lezioniPanel.setLayout(null);
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBackground(grigioChiaro);
		lezioniPanel.setBounds(270, 99, 205, 451);
		sfondoPane.add(lezioniPanel);
		
		elencoLezioniLabel = new JLabel(" PRENOTAZIONI EFFETTUATE");
		elencoLezioniLabel.setFont(new Font("Arial", Font.BOLD, 14));
		elencoLezioniLabel.setBounds(0, 11, 205, 14);
		lezioniPanel.add(elencoLezioniLabel);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(10, 36, 185, 404);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniList = new JList<Lezioni>();
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setBackground(azzurroChiaro);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		
		corsiAmmessoPanel = new JPanel();
		corsiAmmessoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiAmmessoPanel.setBounds(485, 99, 389, 451);
		corsiAmmessoPanel.setBackground(grigioChiaro);
		sfondoPane.add(corsiAmmessoPanel);
		corsiAmmessoPanel.setLayout(null);
		
		corsiAmmessoLabel = new JLabel("STATUS CORSO");
		corsiAmmessoLabel.setBounds(140, 11, 128, 14);
		corsiAmmessoPanel.add(corsiAmmessoLabel);
		corsiAmmessoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		iscriviAdUnCorsoButton = new JButton("ISCRIVI AD UN CORSO");
		iscriviAdUnCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iscriviAdUnCorsoButton.setBackground(Color.WHITE);
		iscriviAdUnCorsoButton.setFont(new Font("Arial", Font.BOLD, 11));
		iscriviAdUnCorsoButton.setBounds(10, 331, 174, 43);
		corsiAmmessoPanel.add(iscriviAdUnCorsoButton);
		
		disiscriviDaUnCorsoButton = new JButton("DISISCRIVI DA UN CORSO");
		disiscriviDaUnCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disiscriviDaUnCorsoButton.setBackground(Color.WHITE);
		disiscriviDaUnCorsoButton.setFont(new Font("Arial", Font.BOLD, 11));
		disiscriviDaUnCorsoButton.setBounds(205, 331, 174, 43);
		corsiAmmessoPanel.add(disiscriviDaUnCorsoButton);
		
		prenotaLezioneButton = new JButton("PRENOTA LEZIONE");
		prenotaLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prenotaLezioneButton.setBackground(Color.WHITE);
		prenotaLezioneButton.setFont(new Font("Arial", Font.BOLD, 11));
		prenotaLezioneButton.setBounds(10, 397, 174, 43);
		corsiAmmessoPanel.add(prenotaLezioneButton);
		
		annullaPrenotazioneButton = new JButton("ANNULLA PRENOTAZIONE");
		annullaPrenotazioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		annullaPrenotazioneButton.setBackground(Color.WHITE);
		annullaPrenotazioneButton.setFont(new Font("Arial", Font.BOLD, 11));
		annullaPrenotazioneButton.setBounds(205, 397, 174, 43);
		corsiAmmessoPanel.add(annullaPrenotazioneButton);
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPanel.setBackground(azzurroChiaro);
		infoPanel.setBounds(10, 37, 369, 275);
		corsiAmmessoPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		corsoLabel = new JLabel("Corso: " );
		corsoLabel.setFont(new Font("Arial", Font.BOLD, 17));
		corsoLabel.setBounds(38, 39, 338, 21);
		infoPanel.add(corsoLabel);
		
		presenzeLabel = new JLabel("Presenze: ");
		presenzeLabel.setFont(new Font("Arial", Font.BOLD, 17));
		presenzeLabel.setBounds(38, 148, 338, 21);
		infoPanel.add(presenzeLabel);
		
		ammessoLabel = new JLabel("Ammesso :");
		ammessoLabel.setFont(new Font("Arial", Font.BOLD, 17));
		ammessoLabel.setBounds(38, 201, 95, 21);
		infoPanel.add(ammessoLabel);
		
		numeroLezioniLabel = new JLabel("Numero Lezioni: ");
		numeroLezioniLabel.setFont(new Font("Arial", Font.BOLD, 17));
		numeroLezioniLabel.setBounds(38, 95, 338, 21);
		infoPanel.add(numeroLezioniLabel);
		
		ammessoValueLabel = new JLabel("");
		ammessoValueLabel.setFont(new Font("Arial", Font.BOLD, 17));
		ammessoValueLabel.setBounds(134, 201, 31, 21);
		infoPanel.add(ammessoValueLabel);
		
		
		//LISTENERS
		
		menuPanelEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				menuPanelEsteso.setVisible(false);
				menuPanel.setVisible(true);
			}
		});

		impostazioniLabelMenuEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.impostazioniPage(operatore, 1, studente);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		
		impostazioniScrittaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.impostazioniPage(operatore, 1, studente);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				impostazioniScrittaLabel.setForeground(Color.ORANGE);
				menuPanel.setVisible(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				impostazioniScrittaLabel.setForeground(Color.WHITE);
				menuPanel.setVisible(false);

			}
		});
		
		gestoreCorsiLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.gestoreCorsiPage(operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreCorsiOpacoPanel.setBackground(azzurro);
				gestoreCorsiLabel.setForeground(Color.BLACK);
				gestoreCorsiLabel.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreCorsiLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				gestoreCorsiLabel.setVisible(true);
			}
		});
		
		gestoreLezioniLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.gestoreLezioniPage(operatore);
				setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				gestoreLezioniOpacoPanel.setBackground(azzurro);
				gestoreLezioniLabel.setForeground(Color.BLACK);
				gestoreLezioniLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreLezioniLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				gestoreLezioniLabel.setVisible(true);
			}
			
		});
		
		gestoreStudentiLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.gestoreStudentiPage(operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreStudentiOpacoPanel.setBackground(azzurro);
				gestoreStudentiLabel.setForeground(Color.BLACK);
				gestoreStudentiLabel.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreStudentiLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				gestoreStudentiLabel.setVisible(true);
			}
		});
		
		gestoreStudentiOpacoPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreStudentiOpacoPanel.setBackground(azzurro);
				gestoreStudentiLabel.setForeground(Color.BLACK);
				gestoreStudentiLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreStudentiLabel.setForeground(Color.WHITE);
				gestoreStudentiLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
			}
		});
		
		gestoreLezioniOpacoPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreLezioniOpacoPanel.setBackground(azzurro);
				gestoreLezioniLabel.setForeground(Color.BLACK);
				gestoreLezioniLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreLezioniLabel.setForeground(Color.WHITE);
				gestoreLezioniLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
			}
		});
	
		
		gestoreCorsiOpacoPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreCorsiOpacoPanel.setBackground(azzurro);
				gestoreCorsiLabel.setForeground(Color.BLACK);
				gestoreCorsiLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreCorsiLabel.setForeground(Color.WHITE);
				gestoreCorsiLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
			}
		});
		
		esciLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				alertReturnToLogIn();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				esciLabel.setForeground(Color.RED);
				menuPanelEsteso.setVisible(true);
				menuPanel.setVisible(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				esciLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		
		labelTrattiniMenuEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
		});
		
		labelTrattini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
		});

		impostazioniLabel.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
			
		});
		
		esciImageLabel.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
			
		});
		
		modificaStudenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.modificaStudentePage(operatore, studente);
				setVisible(false);
			}
		});
		
		corsiList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestorePanoramica();
			}
		});

		iscriviAdUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestoreIscrizioneCorso();
			}
		});
		
		disiscriviDaUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					gestoreDisiscrizione();
					
			}
		});
		
		annullaPrenotazioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lezioniList.getSelectedValue() == null)
					alertNessunaLezioneSelezionata();
				else {
					alertConfermaAnnullaPrenotazione();
				}
			}
		});
		
		prenotaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gestorePrenotaLezione();
			}
		});

		esciImageMenuEstesoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				alertReturnToLogIn();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
	//ALERT
	
	public void alertNonCiSonolezioniDisponibili() {
		
		JOptionPane.showMessageDialog(this, "Non ci sono lezioni disponibili per "+ corsiList.getSelectedValue().getNome().toUpperCase() + "!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNonCiSonoCorsiDisponibili() {
		
		JOptionPane.showMessageDialog(this, "Non ci sono corsi disponibili dove poter iscrivere lo studente!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNessunCorsoSelezionato() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	
	public void alertStudenteDisiscrittoCorrettamente() {
		
		JOptionPane.showMessageDialog(this, "Studente disiscritto correttamente!","<CONFERMA>", JOptionPane.WARNING_MESSAGE);
		corsi = theController.setCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiList.setListData(corsi);
		lezioniList.setListData(lezioni);
		
		corsoLabel.setText("Corso: ");
		presenzeLabel.setText("Presenze: " );
		numeroLezioniLabel.setText("Numero Lezioni: ");
		ammessoLabel.setText("Ammesso:" );
	}
		
	public void alertErroreDisiscrizioneStudente(String state) {
		if(state=="-1")
			JOptionPane.showMessageDialog(this, "Errore sconosciuto durante l'iscrizione al corso " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Errore durante l'iscrizione al corso, codice errore: " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNessunaLezioneSelezionata() {
		JOptionPane.showMessageDialog(this, "Selezionare una lezione.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertConfermaAnnullaPrenotazione() {
		
		Object[] opzioni = {"Sì"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler annullare la prenotazione selezionata?",
				"CONFERMA DI ANNULLAMENTO",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			
			String state = theController.eliminaPrenotazione(lezioniList.getSelectedValue().getIdLezione(), studente.getMatricola());
			
			if(state == "0")
				alertPrenotazioneAnnullata();
			else
				alertErroreEliminazionePrenotazione(state);
		}
	}
	
	public void alertPrenotazioneAnnullata() {
		
		JOptionPane.showMessageDialog(this, "Prenotazione annullata correttamente ","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		corsi = theController.setCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		lezioni = theController.getPresenzeStudente(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
		lezioniList.setListData(lezioni);
	}
	
	public void alertErroreEliminazionePrenotazione(String state) {
		
		if(state == "-1")
			JOptionPane.showMessageDialog(this, "Impossibile annullare la prenotazione a causa di un errore sconosciuto ","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("10011"))
				JOptionPane.showMessageDialog(this, "ATTENZIONE: la lezione giá e stata effettuata, impossibile eliminare la prenotazione ","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Impossibile annullare la prenotazione.\nCodice d'errore: " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
	
	public void alertConfermaEliminazioneIscrizione() {
		
		Object[] opzioni = {"Sì", "No"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler eliminare l'iscrizione al corso di  " + corsiList.getSelectedValue().getNome().toUpperCase() + " ?",
				"CONFERMA DI ANNULLAMENTO",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			
			String state = theController.disiscriviStudenteCorso(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
			
			if(state.equals("0")) 
				alertStudenteDisiscrittoCorrettamente();
			else
				alertErroreDisiscrizioneStudente(state);
		}
	}
	
	public void alertReturnToLogIn() {
		Object[] opzioni = {"Sì", "No"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler uscire?",
				"CONFERMA DI USCITA",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			theController.logIn();
			setVisible(false);
		}
			
	}
	
	public void gestorePanoramica() {
		
		if(corsiList.isSelectionEmpty()) {
			alertNessunCorsoSelezionato();
		}else{
			corsoLabel.setText("Corso: " + corsi.get(corsiList.getSelectedIndex()).getNome());
			presenzeLabel.setText("Presenze: " + theController.getNumeroPresenzeDelCorso(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso()));
			numeroLezioniLabel.setText("Numero Lezioni: " + theController.getNumeroLezioni(corsiList.getSelectedValue().getIdCorso()));
			if(theController.getAmmessoAdEsame(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso())) {
				ammessoValueLabel.setText("SI" );
				ammessoValueLabel.setForeground(Color.green);
			}else {
				ammessoValueLabel.setText("NO");
				ammessoValueLabel.setForeground(Color.red);
			}
			
			lezioni = theController.getPresenzeStudente(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
			lezioniList.setListData(lezioni);
				
		}
	}
	
	public void gestorePrenotaLezione() {
		
		if(corsiList.getSelectedValue() == null)
			alertNessunCorsoSelezionato();
		else {
			lezioni = theController.iscirizioneStudenteLezioniDelCorso(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
			if(lezioni.isEmpty())
				alertNonCiSonolezioniDisponibili();
			else {
				theController.confermaPrenotaLezionePage(operatore, studente, corsiList.getSelectedValue());
				setVisible(false);
			}
		}
			

	}
	
	
	//GESTORI
	
	public void gestoreIscrizioneCorso() {
			
		corsi = theController.setIscrizioneCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		if(corsi.isEmpty())
			alertNonCiSonoCorsiDisponibili();
		else {
			theController.aggiungiStudenteCorsoPage(operatore, studente);
			setVisible(false);
		}
	}
		
		
	public void gestoreDisiscrizione() {
			
		if(corsiList.isSelectionEmpty())
			alertNessunCorsoSelezionato();
		else 
			alertConfermaEliminazioneIscrizione();
	}

	
}
