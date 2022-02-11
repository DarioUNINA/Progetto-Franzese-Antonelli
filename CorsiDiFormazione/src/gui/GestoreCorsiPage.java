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
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color grigio;
	final Color grigioChiaro;
	
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
	private JLabel nomeCorsoLabel;
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
	private JTextPane nomeCorsoTextPane;
	
	public GestoreCorsiPage(Controller cont, Operatori operatore) {

		theController = cont;
		this.operatore = operatore;
		corsi = theController.getCorsiOperatore(operatore);
		anni = theController.getAllAnni();
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		grigio = new Color(205,205,205);
		grigioChiaro = new Color(233,233,233);
		
		areeTematiche = theController.getAllAreeTematiche();
		paroleChiave = theController.getAllParoleChiave();
	
		
		imageImpostazioni = new ImageIcon("impostazioni.png");
		imageicon = new ImageIcon("napule.png");
		imageTrattini = new ImageIcon("trattini.png");
		imageEsci = new ImageIcon("esci.png");
		setIconImage(imageicon.getImage());

		setResizable(false);
		
		getContentPane().setBackground(grigio);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		sfondoPane = new JPanel();
		sfondoPane.setBackground(azzurro);
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		menuPanelEsteso = new JPanel();
		menuPanelEsteso.setVisible(false);
		menuPanelEsteso.setBounds(10, 11, 225, 539);
		menuPanelEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				menuPanelEsteso.setVisible(false);
				menuPanel.setVisible(true);
			}
		});
		menuPanelEsteso.setLayout(null);
		menuPanelEsteso.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		menuPanelEsteso.setBackground(new Color(25, 25, 112));
		sfondoPane.add(menuPanelEsteso);
		
		impostazioniLabelMenuEsteso = new JLabel(imageImpostazioni);
		impostazioniLabelMenuEsteso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		impostazioniLabelMenuEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		impostazioniLabelMenuEsteso.setBounds(10, 465, 24, 32);
		menuPanelEsteso.add(impostazioniLabelMenuEsteso);
		
		impostazioniScrittaLabel = new JLabel("IMPOSTAZIONI");
		impostazioniScrittaLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		impostazioniScrittaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		impostazioniScrittaLabel.setForeground(Color.WHITE);
		impostazioniScrittaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		impostazioniScrittaLabel.setBounds(44, 465, 142, 32);
		menuPanelEsteso.add(impostazioniScrittaLabel);
		
		gestoreCorsiLabel = new JLabel("GESTORE CORSI");
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
		gestoreCorsiLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreCorsiLabel.setForeground(Color.WHITE);
		gestoreCorsiLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreCorsiLabel.setBounds(44, 66, 171, 22);
		menuPanelEsteso.add(gestoreCorsiLabel);
		
		gestoreLezioniLabel = new JLabel("GESTORE LEZIONI");
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
		gestoreLezioniLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreLezioniLabel.setForeground(Color.WHITE);
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreLezioniLabel.setBounds(44, 99, 171, 22);
		menuPanelEsteso.add(gestoreLezioniLabel);
		
		gestoreStudentiLabel = new JLabel("GESTORE STUDENTI");
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
		gestoreStudentiLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreStudentiLabel.setForeground(Color.WHITE);
		gestoreStudentiLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreStudentiLabel.setBounds(44, 132, 171, 22);
		menuPanelEsteso.add(gestoreStudentiLabel);
		
		gestoreCorsiOpacoPanel = new JPanel();
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
		gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreCorsiOpacoPanel.setBounds(10, 66, 205, 22);
		menuPanelEsteso.add(gestoreCorsiOpacoPanel);
		
		gestoreLezioniOpacoPanel = new JPanel();
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
		gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreLezioniOpacoPanel.setBounds(10, 99, 205, 22);
		menuPanelEsteso.add(gestoreLezioniOpacoPanel);
		
		gestoreStudentiOpacoPanel = new JPanel();
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
		gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreStudentiOpacoPanel.setBounds(10, 132, 205, 22);
		menuPanelEsteso.add(gestoreStudentiOpacoPanel);
		
		esciImageMenuEstesoLabel = new JLabel(imageEsci);
		esciImageMenuEstesoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		esciImageMenuEstesoLabel.setBounds(10, 496, 24, 22);
		esciImageMenuEstesoLabel.setVisible(true);
		menuPanelEsteso.add(esciImageMenuEstesoLabel);
		
		esciLabel = new JLabel("ESCI");
		esciLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esciLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				alertReturnToLogIn();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
		});
		esciLabel.setForeground(Color.WHITE);
		esciLabel.setFont(new Font("Arial", Font.BOLD, 18));
		esciLabel.setBounds(44, 496, 142, 32);
		menuPanelEsteso.add(esciLabel);
		
		labelTrattiniMenuEsteso = new JLabel(imageTrattini);
		labelTrattiniMenuEsteso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelTrattiniMenuEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
		});
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
		labelTrattini.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
		});
		labelTrattini.setFont(new Font("Arial", Font.BOLD, 15));
		labelTrattini.setBounds(10, 11, 24, 25);
		menuPanel.add(labelTrattini);
		
		impostazioniLabel = new JLabel(imageImpostazioni);
		impostazioniLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		impostazioniLabel.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
			
		});
		impostazioniLabel.setBounds(10, 465, 24, 32);
		menuPanel.add(impostazioniLabel);
		
		esciImageLabel = new JLabel(imageEsci);
		esciImageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		esciImageLabel.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
			}
			
		});
		esciImageLabel.setBounds(10, 496, 24, 25);
		menuPanel.add(esciImageLabel);
		
		benvenuto = new JPanel();
		benvenuto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		benvenuto.setBackground(grigioChiaro);
		benvenuto.setBounds(64, 11, 810, 77);
		sfondoPane.add(benvenuto);
		benvenuto.setLayout(null);
		
		benvenutoLabel = new JLabel("Benvenuto, " + operatore.getNomeUtente().toUpperCase());
		benvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		benvenutoLabel.setBounds(10, 14, 352, 44);
		benvenuto.add(benvenutoLabel);
		
		filtri = new JPanel();
		filtri.setBorder(new LineBorder(Color.BLACK, 2));
		filtri.setBackground(grigioChiaro);
		filtri.setBounds(64, 99, 312, 451);
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
		terminatoCheckBoxNo = new JCheckBox("NO");
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
		terminatoCheckBoxSi.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBoxSi.setBounds(119, 149, 46, 23);
		filtri.add(terminatoCheckBoxSi);
		
		
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
		corsiPanel.setBounds(386, 99, 488, 256);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBorder(new LineBorder(Color.BLACK));
		corsiScrollPane.setBounds(10, 31, 222, 214);
		corsiPanel.add(corsiScrollPane);

		corsiList = new JList<Corsi>(corsi);
		corsiList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.isSelectionEmpty()) {
					alertNessunCorsoSelezionato();
				}else{
					nomeCorsoTextPane.setText(corsi.get(corsiList.getSelectedIndex()).getNome().toUpperCase());
					presenzeMinLabel.setText("Presenze Min: " + corsi.get(corsiList.getSelectedIndex()).getPresenzeMin());
					maxPartecipantiLabel.setText("Max Partecipanti: " + corsi.get(corsiList.getSelectedIndex()).getMaxPartecipanti());
					descrizioneTextPane.setText(corsi.get(corsiList.getSelectedIndex()).getDescrizione());
				}
				
				if(theController.getFutureLezioni(corsi.get(corsiList.getSelectedIndex()).getIdCorso()).isEmpty()) 
					alertNessunaLezioneProgrammataDisponibile();
					
				lezioni = theController.getFutureLezioni(corsi.get(corsiList.getSelectedIndex()).getIdCorso());
				lezioniProgrammateList.setListData(lezioni);
					
				
				
			}
		});
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBackground(azzurroChiaro);
		corsiList.setVisibleRowCount(10);
		
		corsiLabel = new JLabel("CORSI");
		corsiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsiLabel.setBounds(93, 11, 62, 14);
		corsiPanel.add(corsiLabel);
		
		nomeCorsoLabel = new JLabel("Corso:");
		nomeCorsoLabel.setFont(new Font("Arial", Font.BOLD, 14));
		nomeCorsoLabel.setBounds(242, 49, 236, 14);
		corsiPanel.add(nomeCorsoLabel);
		
		descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 14));
		descrizioneLabel.setBounds(242, 190, 237, 14);
		corsiPanel.add(descrizioneLabel);
		
		presenzeMinLabel = new JLabel("Presenze Min:");
		presenzeMinLabel.setFont(new Font("Arial", Font.BOLD, 14));
		presenzeMinLabel.setBounds(242, 114, 236, 14);
		corsiPanel.add(presenzeMinLabel);
		
		maxPartecipantiLabel = new JLabel("Max Martecipanti:");
		maxPartecipantiLabel.setFont(new Font("Arial", Font.BOLD, 14));
		maxPartecipantiLabel.setBounds(242, 151, 236, 14);
		corsiPanel.add(maxPartecipantiLabel);
		
		descrizioneTextPane = new JTextPane();
		descrizioneTextPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		descrizioneTextPane.setFont(new Font("Arial", Font.BOLD, 14));
		descrizioneTextPane.setBackground(grigioChiaro);
		descrizioneTextPane.setBounds(242, 205, 236, 40);
		corsiPanel.add(descrizioneTextPane);
		
		panoramicaLabel = new JLabel("PANORAMICA");
		panoramicaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panoramicaLabel.setBounds(314, 11, 104, 14);
		corsiPanel.add(panoramicaLabel);
		
		nomeCorsoTextPane = new JTextPane();
		nomeCorsoTextPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		nomeCorsoTextPane.setFont(new Font("Arial", Font.BOLD, 14));
		nomeCorsoTextPane.setBackground(new Color(233, 233, 233));
		nomeCorsoTextPane.setBounds(242, 63, 185, 40);
		corsiPanel.add(nomeCorsoTextPane);
		
		gestione = new JPanel();
		gestione.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		gestione.setBackground(grigioChiaro);
		gestione.setBounds(386, 366, 488, 184);
		sfondoPane.add(gestione);
		gestione.setLayout(null);
		
		eliminaCorsoButton = new JButton("ELIMINA CORSO");
		eliminaCorsoButton.setBounds(266, 104, 212, 25);
		gestione.add(eliminaCorsoButton);
		eliminaCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminaCorsoButton.setBackground(Color.WHITE);
		eliminaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EliminaCorsoPage ep = new EliminaCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		eliminaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		iscriviStudenteButton = new JButton("ISCRIVI STUDENTE");
		iscriviStudenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	AggiungiStudenteCorsoPage ascp = new AggiungiStudenteCorsoPage(theController, operatore)
			}
		});
		iscriviStudenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		iscriviStudenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		iscriviStudenteButton.setBackground(Color.WHITE);
		iscriviStudenteButton.setBounds(266, 57, 212, 25);
		gestione.add(iscriviStudenteButton);
		
		statisticheButton = new JButton("STATISTICHE");
		statisticheButton.setFont(new Font("Arial", Font.BOLD, 15));
		statisticheButton.setBackground(Color.WHITE);
		statisticheButton.setBounds(266, 11, 212, 25);
		gestione.add(statisticheButton);
		
		lezioniProgrammateScrollPane = new JScrollPane();
		lezioniProgrammateScrollPane.setBorder(new LineBorder(Color.BLACK));
		lezioniProgrammateScrollPane.setBounds(10, 31, 220, 142);
		gestione.add(lezioniProgrammateScrollPane);
		
		lezioniProgrammateList = new JList<Lezioni>();
		lezioniProgrammateScrollPane.setViewportView(lezioniProgrammateList);
		lezioniProgrammateList.setVisibleRowCount(10);
		lezioniProgrammateList.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniProgrammateList.setBackground(new Color(136, 187, 214));
		
		lezioniProgrammateLabel = new JLabel("LEZIONI PROGRAMMATE");
		lezioniProgrammateLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniProgrammateLabel.setBounds(26, 11, 182, 14);
		gestione.add(lezioniProgrammateLabel);
		
		aggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
		aggiungiCorsoButton.setBounds(266, 148, 212, 25);
		gestione.add(aggiungiCorsoButton);
		aggiungiCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aggiungiCorsoButton.setBackground(Color.WHITE);
		aggiungiCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CreazioneCorsoPage ccp = new CreazioneCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		aggiungiCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		resetFiltriButton = new JButton("RESET");
		resetFiltriButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		resetFiltriButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetFiltriButton.setBackground(Color.WHITE);
		resetFiltriButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
		});
		resetFiltriButton.setForeground(Color.RED);
		resetFiltriButton.setBounds(10, 415, 89, 23);
		resetFiltriButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(resetFiltriButton);
		
		filtraButton = new JButton("FILTRA");
		filtraButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		filtraButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		filtraButton.setBackground(Color.WHITE);
		filtraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
		});
		filtraButton.setForeground(new Color(65, 105, 225));
		filtraButton.setBounds(212, 415, 89, 23);
		filtraButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(filtraButton);
		
		FullMatchRadioButton = new JRadioButton("Full Match");
		PartialMatchRadioButton = new JRadioButton("Partial Match");
		FullMatchRadioButton.setSelected(true);
		FullMatchRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			PartialMatchRadioButton.setSelected(false);
				
			}
		});
		FullMatchRadioButton.setBounds(106, 8, 89, 23);
		filtri.add(FullMatchRadioButton);
		
		
		PartialMatchRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FullMatchRadioButton.setSelected(false);
				
			}
		});
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

		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void alertReturnToLogIn() {
		Object[] opzioni = {"Sì"};
		
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
	public void alertNessunaLezioneProgrammataDisponibile() {
		JOptionPane.showMessageDialog(this, "Non ci sono lezioni Programmate per il Corso selezionato.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);		
	}
}
