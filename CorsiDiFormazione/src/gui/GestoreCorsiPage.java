package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.AreeTematiche;
import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;
import dto.ParoleChiave;
import utilities.JCheckBoxList;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JList;

import java.awt.ScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import com.toedter.components.JLocaleChooser;

import controller.Controller;

import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.Icon;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;

public class GestoreCorsiPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	
	private Component url;
	private ImageIcon imageicon;
	private ImageIcon imageImpostazioni;
	private ImageIcon imageTrattini;
	private ImageIcon imageEsci;
	private JPanel sfondoPane;
	private JPanel benvenuto;
	private JLabel benvenutoLabel;
	private JPanel filtri;
	private JLabel filtriLabel;
	private JLabel areaTematicaLabel;
	private JLabel annoLabel;
	private JLabel terminatoLabel;
	private JLabel parolaChiaveLabel;
	private JScrollPane temiScrollPane;
	private JScrollPane paroleChiaveScrollPane;
	private JCheckBoxList listaParoleChiave;
	private JCheckBoxList listaTemi;
	private JCheckBoxList annoList;
	private JCheckBox terminatoCheckBoxSi;
	private JCheckBox terminatoCheckBoxNo;
	private JButton aggiungiCorsoButton;
	private JButton eliminaCorsoButton;
	private JPanel corsiPanel;
	private JScrollPane corsiScrollPane;	
	private JScrollPane annoScrollPane;
	private JList<Corsi> corsiList;
	private JPanel gestione;
	private JButton resetFiltriButton;
	private JButton filtraButton;
	private Vector<AreeTematiche> areeTematiche;
	private Vector<Corsi> corsi;
	private Vector<ParoleChiave> paroleChiave;
	private Vector<String> anni;
	private Vector<Lezioni> lezioni;
	private JRadioButton FullMatchRadioButton;
	private JRadioButton PartialMatchRadioButton;
	private JPanel menuPanelEsteso;
	private JLabel impostazioniLabelMenuEsteso;
	private JLabel impostazioniScrittaLabel;
	private JLabel gestoreCorsiLabel;
	private JLabel gestoreLezioniLabel;
	private JLabel gestoreStudentiLabel;
	private JLabel esciImageMenuEstesoLabel;
	private JLabel esciLabel;
	private JButton modificaCorsoButton;
	private JLabel annoPanoramicaLabel;
	private JLabel paroleChiaveLabel;
	private JTextPane paroleChiaveTextPane;
	private JLabel areetematicheLabel;
	private JTextPane areeTematicheTextPane ;
		
	private JLabel labelTrattiniMenuEsteso;
	private JLabel menuEstesoLabel;
	private JPanel gestoreCorsiOpacoPanel;
	private JPanel gestoreLezioniOpacoPanel;
	private JPanel gestoreStudentiOpacoPanel;
	private JPanel menuPanel;
	private JLabel labelTrattini;
	private JLabel impostazioniLabel;
	private JLabel esciImageLabel;
	private JLabel corsiLabel;
	private JLabel descrizioneLabel;
	private JLabel presenzeMinLabel;
	private JLabel maxPartecipantiLabel;
	private JTextPane descrizioneTextPane;
	private JLabel panoramicaLabel;
	private JButton iscriviStudenteButton;
	private JButton statisticheButton ;
	private JScrollPane lezioniProgrammateScrollPane;
	private JList<Lezioni> lezioniProgrammateList;
	private JLabel lezioniProgrammateLabel;

	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public GestoreCorsiPage(Controller controller, Operatori operatore) {

		theController = controller;
		this.operatore = operatore;
		corsi = theController.getCorsiOperatore(operatore);
		anni = theController.getAllAnni();
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		
		areeTematiche = theController.getAllAreeTematiche();
		paroleChiave = theController.getAllParoleChiave();
	
		
		imageImpostazioni = new ImageIcon("impostazioni.png");
		imageicon = new ImageIcon("napule.png");
		imageTrattini = new ImageIcon("trattini.png");
		imageEsci = new ImageIcon("esci.png");
		setIconImage(imageicon.getImage());

		setResizable(false);
		
		getContentPane().setBackground(azzurroChiaro);
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
		
		benvenuto = new JPanel();
		benvenuto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		benvenuto.setBackground(grigioChiaro);
		benvenuto.setBounds(64, 11, 810, 64);
		sfondoPane.add(benvenuto);
		benvenuto.setLayout(null);
		
		benvenutoLabel = new JLabel("Benvenuto, " + operatore.getNomeUtente().toUpperCase());
		benvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		benvenutoLabel.setBounds(10, 0, 665, 44);
		benvenuto.add(benvenutoLabel);
		
		filtri = new JPanel();
		filtri.setBorder(new LineBorder(Color.BLACK, 2));
		filtri.setBackground(grigioChiaro);
		filtri.setBounds(64, 86, 312, 464);
		sfondoPane.add(filtri);
		filtri.setLayout(null);
		
		filtriLabel = new JLabel("FILTRI:");
		filtriLabel.setBounds(10, 6, 63, 22);
		filtri.add(filtriLabel);
		filtriLabel.setFont(new Font("Arial", Font.BOLD, 18));
		
		areaTematicaLabel = new JLabel("Area Tematica:");
		areaTematicaLabel.setBounds(10, 179, 89, 14);
		areaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(areaTematicaLabel);
		
		annoLabel = new JLabel("Anno:");
		annoLabel.setBounds(10, 39, 89, 14);
		annoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		annoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		filtri.add(annoLabel);
		
		terminatoLabel = new JLabel("Terminato:");
		terminatoLabel.setBounds(10, 154, 89, 14);
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(terminatoLabel);
		
		parolaChiaveLabel = new JLabel("Parola Chiave:");
		parolaChiaveLabel.setBounds(10, 293, 89, 14);
		parolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(parolaChiaveLabel);
				
		terminatoCheckBoxSi = new JCheckBox("SI");
		terminatoCheckBoxSi.setBackground(grigioChiaro);
		terminatoCheckBoxSi.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBoxSi.setBounds(119, 149, 46, 23);
		filtri.add(terminatoCheckBoxSi);
		
		terminatoCheckBoxNo = new JCheckBox("NO");
		terminatoCheckBoxNo.setBackground(grigioChiaro);
		terminatoCheckBoxNo.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBoxNo.setBounds(206, 149, 49, 23);
		filtri.add(terminatoCheckBoxNo);
		
		paroleChiaveScrollPane = new JScrollPane();
		paroleChiaveScrollPane.setBorder(new LineBorder(Color.BLACK));
		paroleChiaveScrollPane.setBounds(109, 288, 177, 100);
		filtri.add(paroleChiaveScrollPane);
		
		listaParoleChiave = new JCheckBoxList();
		paroleChiaveScrollPane.setViewportView(listaParoleChiave);
		listaParoleChiave.setModel(theController.setModelCheckBoxParole(paroleChiave));
		listaParoleChiave.setFont(new Font("Arial", Font.BOLD, 15));
		listaParoleChiave.setBackground(azzurroChiaro);
		listaParoleChiave.setVisibleRowCount(10);
		listaParoleChiave.setVisible(true);
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(Color.BLACK, 2));
		corsiPanel.setBackground(grigioChiaro);
		corsiPanel.setBounds(386, 86, 488, 250);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBorder(new LineBorder(Color.BLACK));
		corsiScrollPane.setBounds(10, 31, 232, 135);
		corsiPanel.add(corsiScrollPane);

		corsiList = new JList<Corsi>(corsi);
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBackground(azzurroChiaro);
		corsiList.setVisibleRowCount(10);
		
		corsiLabel = new JLabel("CORSI");
		corsiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsiLabel.setBounds(93, 11, 62, 14);
		corsiPanel.add(corsiLabel);
		
		descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 14));
		descrizioneLabel.setBounds(10, 174, 146, 14);
		corsiPanel.add(descrizioneLabel);
		
		presenzeMinLabel = new JLabel("Presenze Mininime:");
		presenzeMinLabel.setFont(new Font("Arial", Font.BOLD, 14));
		presenzeMinLabel.setBounds(252, 60, 226, 14);
		corsiPanel.add(presenzeMinLabel);
		
		maxPartecipantiLabel = new JLabel("Massimo Martecipanti:");
		maxPartecipantiLabel.setFont(new Font("Arial", Font.BOLD, 14));
		maxPartecipantiLabel.setBounds(252, 85, 222, 14);
		corsiPanel.add(maxPartecipantiLabel);
		
		descrizioneTextPane = new JTextPane();
		descrizioneTextPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		descrizioneTextPane.setEditable(false);
		descrizioneTextPane.setFont(new Font("Arial", Font.BOLD, 12));
		descrizioneTextPane.setBackground(grigioChiaro);
		descrizioneTextPane.setBounds(10, 186, 232, 53);
		descrizioneTextPane.setVisible(false);
		corsiPanel.add(descrizioneTextPane);
		
		panoramicaLabel = new JLabel("PANORAMICA");
		panoramicaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panoramicaLabel.setBounds(314, 11, 104, 14);
		corsiPanel.add(panoramicaLabel);
		
		annoPanoramicaLabel = new JLabel("Anno: ");
		annoPanoramicaLabel.setFont(new Font("Arial", Font.BOLD, 14));
		annoPanoramicaLabel.setBounds(252, 35, 222, 14);
		corsiPanel.add(annoPanoramicaLabel);
		
		paroleChiaveLabel = new JLabel("ParoleChiave:");
		paroleChiaveLabel.setFont(new Font("Arial", Font.BOLD, 14));
		paroleChiaveLabel.setBounds(252, 110, 104, 14);
		corsiPanel.add(paroleChiaveLabel);
		
		paroleChiaveTextPane = new JTextPane();
		paroleChiaveTextPane.setEditable(false);
		paroleChiaveTextPane.setFont(new Font("Arial", Font.BOLD, 12));
		paroleChiaveTextPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		paroleChiaveTextPane.setBackground(grigioChiaro);
		paroleChiaveTextPane.setBounds(252, 123, 226, 43);
		paroleChiaveTextPane.setVisible(false);
		corsiPanel.add(paroleChiaveTextPane);
		
		areetematicheLabel = new JLabel("AreeTematiche:");
		areetematicheLabel.setFont(new Font("Arial", Font.BOLD, 14));
		areetematicheLabel.setBounds(252, 174, 127, 14);
		corsiPanel.add(areetematicheLabel);
		
		areeTematicheTextPane = new JTextPane();
		areeTematicheTextPane.setFont(new Font("Arial", Font.BOLD, 12));
		areeTematicheTextPane.setEditable(false);
		areeTematicheTextPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		areeTematicheTextPane.setBackground(grigioChiaro);
		areeTematicheTextPane.setBounds(252, 186, 226, 53);
		areeTematicheTextPane.setVisible(false);
		corsiPanel.add(areeTematicheTextPane);
		
		gestione = new JPanel();
		gestione.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		gestione.setBackground(grigioChiaro);
		gestione.setBounds(386, 347, 488, 203);
		gestione.setLayout(null);
		sfondoPane.add(gestione);
		
		eliminaCorsoButton = new JButton("ELIMINA CORSO");
		eliminaCorsoButton.setBounds(266, 131, 212, 25);
		eliminaCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminaCorsoButton.setBackground(Color.WHITE);
		eliminaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		gestione.add(eliminaCorsoButton);
		
		iscriviStudenteButton = new JButton("ISCRIVI STUDENTE");
		iscriviStudenteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iscriviStudenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		iscriviStudenteButton.setBackground(Color.WHITE);
		iscriviStudenteButton.setBounds(266, 95, 212, 25);
		gestione.add(iscriviStudenteButton);
		
		statisticheButton = new JButton("STATISTICHE CORSO");
		statisticheButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		statisticheButton.setFont(new Font("Arial", Font.BOLD, 15));
		statisticheButton.setBackground(Color.WHITE);
		statisticheButton.setBounds(266, 23, 212, 25);
		gestione.add(statisticheButton);
		
		lezioniProgrammateScrollPane = new JScrollPane();
		lezioniProgrammateScrollPane.setBorder(new LineBorder(Color.BLACK));
		lezioniProgrammateScrollPane.setBounds(10, 31, 220, 161);
		gestione.add(lezioniProgrammateScrollPane);
		
		lezioniProgrammateList = new JList<Lezioni>();
		lezioniProgrammateScrollPane.setViewportView(lezioniProgrammateList);
		lezioniProgrammateList.setVisibleRowCount(10);
		lezioniProgrammateList.setBackground(azzurroChiaro);
		lezioniProgrammateList.setFont(new Font("Arial", Font.BOLD, 15));
		
		lezioniProgrammateLabel = new JLabel("LEZIONI PROGRAMMATE");
		lezioniProgrammateLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniProgrammateLabel.setBounds(26, 11, 182, 14);
		gestione.add(lezioniProgrammateLabel);
		
		aggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
		aggiungiCorsoButton.setBounds(266, 167, 212, 25);
		aggiungiCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aggiungiCorsoButton.setBackground(Color.WHITE);
		aggiungiCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		gestione.add(aggiungiCorsoButton);
		
		modificaCorsoButton = new JButton("MODIFICA CORSO");
		modificaCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		modificaCorsoButton.setBackground(Color.WHITE);
		modificaCorsoButton.setBounds(266, 59, 212, 25);
		gestione.add(modificaCorsoButton);
		
		resetFiltriButton = new JButton("RESET");
		resetFiltriButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		resetFiltriButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetFiltriButton.setBackground(Color.WHITE);
		resetFiltriButton.setForeground(Color.RED);
		resetFiltriButton.setBounds(10, 415, 89, 23);
		resetFiltriButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(resetFiltriButton);
		
		filtraButton = new JButton("FILTRA");
		filtraButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		filtraButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		filtraButton.setBackground(Color.WHITE);
		filtraButton.setForeground(new Color(65, 105, 225));
		filtraButton.setBounds(212, 415, 89, 23);
		filtraButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(filtraButton);
		
		FullMatchRadioButton = new JRadioButton("Full Match");
		FullMatchRadioButton.setBackground(grigioChiaro);
		FullMatchRadioButton.setSelected(true);
		FullMatchRadioButton.setBounds(106, 8, 89, 23);
		filtri.add(FullMatchRadioButton);
		
		PartialMatchRadioButton = new JRadioButton("Partial Match");
		PartialMatchRadioButton.setBackground(grigioChiaro);
		PartialMatchRadioButton.setBounds(197, 8, 104, 23);
		filtri.add(PartialMatchRadioButton);
		
		annoScrollPane = new JScrollPane();
		annoScrollPane.setBounds(109, 34, 175, 106);
		annoScrollPane.setBorder(new LineBorder(Color.BLACK));
		filtri.add(annoScrollPane);
		
		annoList = new JCheckBoxList();
		annoScrollPane.setViewportView(annoList);
		annoList.setModel(theController.setModelCheckBoxString(anni));
		annoList.setFont(new Font("Arial", Font.BOLD, 15));
		annoList.setBackground(azzurroChiaro);
		annoList.setVisibleRowCount(10);
		
		temiScrollPane = new JScrollPane();
		temiScrollPane.setBounds(109, 174, 177, 108);
		filtri.add(temiScrollPane);
		temiScrollPane.setBorder(new LineBorder(Color.BLACK));
		
		listaTemi = new JCheckBoxList();
		temiScrollPane.setViewportView(listaTemi);
		listaTemi.setModel(theController.setModelCheckBox(areeTematiche));
		listaTemi.setFont(new Font("Arial", Font.BOLD, 15));
		listaTemi.setBackground(azzurroChiaro);
		listaTemi.setVisibleRowCount(10);
		
		listaTemi.setVisible(true);
		annoList.setVisible(true);

		
		
		//LISTNER 
		
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
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore, 0, null);
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
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore, 0, null);
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
				menuPanelEsteso.setVisible(false);
				menuPanel.setVisible(true);
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
				GestoreLezioniPage gs = new GestoreLezioniPage(theController, operatore);
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
				GestoreStudentiPage gs = new GestoreStudentiPage(theController, operatore);
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
				menuPanelEsteso.setVisible(true);
				gestoreLezioniLabel.setForeground(Color.WHITE);
				gestoreLezioniLabel.setVisible(true);
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
		
		
		terminatoCheckBoxSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				terminatoCheckBoxNo.setSelected(false);
				terminatoCheckBoxNo.setForeground(Color.BLACK);
				
				if(terminatoCheckBoxSi.getSelectedObjects() != null)
					terminatoCheckBoxSi.setForeground(Color.GREEN);
				else
					terminatoCheckBoxSi.setForeground(Color.BLACK);
			}
		});
		
		
		terminatoCheckBoxNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				terminatoCheckBoxSi.setSelected(false);
				terminatoCheckBoxSi.setForeground(Color.BLACK);
				
				if(terminatoCheckBoxNo.getSelectedObjects() != null)
					terminatoCheckBoxNo.setForeground(Color.RED);
				else
					terminatoCheckBoxNo.setForeground(Color.BLACK);
				
			}
		});
		
		
		corsiList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestorePanoramica();
				
			}
		});
		
		
		eliminaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EliminaCorsoPage ep = new EliminaCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		
		
		iscriviStudenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.isSelectionEmpty()) 
					alertNessunCorsoSelezionato();
				else {
					
					IscriviStudenteGestoreCorsoPage page = new IscriviStudenteGestoreCorsoPage(theController, operatore, corsiList.getSelectedValue());
					setVisible(false);
				}			
			}
		});
		
		
		statisticheButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.getSelectedValue() == null) {
					alertNessunCorsoSelezionato();
				}else {
					StatisticheCorsoPage scp = new StatisticheCorsoPage(theController, operatore, corsiList.getSelectedValue());
					setVisible(false);
				}
			}
		});
		
		
		aggiungiCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CreazioneCorsoPage ccp = new CreazioneCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		
		
		modificaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.getSelectedValue() == null) {
					alertNessunCorsoSelezionato();
				}else {
					ModificaCorsoPage mmcp = new ModificaCorsoPage(theController, operatore, corsiList.getSelectedValue());
					setVisible(false);
				}
			}
		});
		
		
		resetFiltriButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gestoreResetFiltri();
				
			}
		});
		
		
		filtraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gestoreFiltri();
				
			}
		});
		
		
		FullMatchRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			PartialMatchRadioButton.setSelected(false);
				
			}
		});
		
		
		PartialMatchRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FullMatchRadioButton.setSelected(false);
				
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	//GESTORI
	
	public void gestoreFiltri() {
		
		Vector<AreeTematiche> aree = theController.getAreeSelezionate(listaTemi, areeTematiche);
		Vector<ParoleChiave> parole = theController.getParoleSelezionate(listaParoleChiave, paroleChiave);
		
		Vector<String> vettoreAnni = theController.getStringheSelezionate(annoList, anni);

		boolean terminatoSi , terminatoNo; 
		
		if(terminatoCheckBoxSi.isSelected())
			terminatoSi = true;
		else
			terminatoSi = false;
		
		if(terminatoCheckBoxNo.isSelected())
			terminatoNo = true;
		else
			terminatoNo = false;
		
		if(FullMatchRadioButton.isSelected()) {
			
			if(vettoreAnni.size()>1)
				alertCorsiFM();
			else
				corsi = theController.setCorsiFiltratiFM(aree, vettoreAnni, terminatoSi, terminatoNo, parole, operatore.getIdOperatore());
		}
			
		else
			corsi = theController.setCorsiFiltratiPM(aree, vettoreAnni, terminatoSi, terminatoNo, parole, operatore.getIdOperatore());

		corsiList.setListData(corsi);
	}
	
	
	public void gestoreResetFiltri() {
	
		listaTemi.setModel(theController.setModelCheckBox(areeTematiche));
		annoList.setModel(theController.setModelCheckBoxString(anni));
		terminatoCheckBoxSi.setSelected(false);
		terminatoCheckBoxSi.setForeground(Color.BLACK);
		terminatoCheckBoxNo.setSelected(false);
		terminatoCheckBoxNo.setForeground(Color.BLACK);		
		listaParoleChiave.setModel(theController.setModelCheckBoxParole(paroleChiave));
		
		corsi = theController.getCorsiOperatore(operatore);
		corsiList.setListData(corsi);
		
	}
	
	
	public void gestorePanoramica() {
		if(corsiList.isSelectionEmpty()) {
			alertNessunCorsoSelezionato();
		}else{
			
			if(corsiList.getSelectedValue().isTerminato())
				iscriviStudenteButton.setEnabled(false);
			else
				iscriviStudenteButton.setEnabled(true);
			
			presenzeMinLabel.setText("Presenze Min: " + corsiList.getSelectedValue().getPresenzeMin());
			maxPartecipantiLabel.setText("Max Partecipanti: " + corsiList.getSelectedValue().getMaxPartecipanti());
			descrizioneTextPane.setText(corsiList.getSelectedValue().getDescrizione());
			descrizioneTextPane.setVisible(true);
			annoPanoramicaLabel.setText("Anno: " + corsiList.getSelectedValue().getAnno());
			
			String paroleChiave = theController.getParoleChiaveString(corsiList.getSelectedValue().getIdCorso());
			if(!paroleChiave.equals(""))
				paroleChiave = paroleChiave.substring(0, paroleChiave.length()-2);
			paroleChiaveTextPane.setText(paroleChiave);
			paroleChiaveTextPane.setVisible(true);
			
			String areeTematiche = theController.getAreeTematicheString(corsiList.getSelectedValue().getIdCorso());
			if(!areeTematiche.equals(""))
				areeTematiche = areeTematiche.substring(0, areeTematiche.length()-2);
			areeTematicheTextPane.setText(areeTematiche);
			areeTematicheTextPane.setVisible(true);
		}
			
		lezioni = theController.getFutureLezioni(corsi.get(corsiList.getSelectedIndex()).getIdCorso());
		lezioniProgrammateList.setListData(lezioni);
			
		
	}
	
	
	//ALERT
	
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
			LogInPage LI = new LogInPage(theController);
			setVisible(false);
		}
			
	}


	public void alertCorsiFM() {
		
		JOptionPane.showMessageDialog(this, "Non puoi eserguire un filtraggio Full Match con piu di un anno","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNessunCorsoSelezionato() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
}
