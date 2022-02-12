package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.Vector;
import javax.swing.JScrollPane;
import dto.Corsi;
import dto.Lezioni;
import java.awt.FlowLayout;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class GestoreLezioniPage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private Vector<Corsi> corsi;
	private Vector<Lezioni> lezioni;
	private Vector<String> mesi;
	private Vector<String> giorni;
	private Vector<Time> orario;
	private Vector<Time> durata;
	
	private ImageIcon imageicon;
	private ImageIcon imageImpostazioni;
	private ImageIcon imageTrattini;
	private ImageIcon imageEsci;
	private Component url;
	private JPanel contentPane;
	private JPanel gestoreLezioniPanel;
	private JLabel gestoreLezioniLabel;
	private JPanel corsiPanel;
	private JPanel filtriPanel;
	private JPanel lezioniPanel;
	private JLabel selezionaCorsoLabel;
	private JLabel elencoLezioneDelCorsoLabel;
	private JLabel filtriLabel;
	private JLabel giorniLabel;
	private JLabel mesiLabel;
	private JLabel orarioLabel;
	private JLabel durataLabel;
	private JButton filtraButton;
	private JButton resetButton;
	private JButton panormaicaLezioneButton;
	private JButton eliminaLezioneButton;
	private JButton aggiungiLezioneButton;
	private JScrollPane corsiScrollPane;
	private JList<Corsi> corsiList;
	
	private JScrollPane lezioniScrollPane;
	private JList<Lezioni> lezioniList;
	
	private JScrollPane orarioScrollPane;
	private JCheckBoxList orarioList;
	
	private JScrollPane durataScrollPane;
	private JCheckBoxList durataList;
	
	private JScrollPane giorniScrollPane;
	private JCheckBoxList giorniList;
	
	private JScrollPane mesiScrollPane;
	private JCheckBoxList mesiList;
	private JTextField titoloTextField;
	private JLabel titoloLabel;
	
	private JRadioButton setAllGiorniRadioButton;
	private JRadioButton setAllMesiRadioButton;
	
	private JPanel menuPanelEsteso;
	private JLabel impostazioniLabelMenuEsteso;
	private JLabel impostazioniScrittaLabel;
	private JLabel gestoreCorsiMenuLabel;
	private JLabel gestoreLezioniMenuLabel;
	private JLabel gestoreStudentiMenuLabel;
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
	
	public GestoreLezioniPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		
		theController = controller;
		this.operatore = operatore;

		corsi = theController.getCorsiOperatore(operatore);
		corsiList = new JList<Corsi>(corsi);
		
		mesi = theController.getMesi();
		giorni = theController.getGiorni();
		durata = theController.getDurate();
		orario = theController.getOrario();
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		grigio = new Color(205,205,205);
		grigioChiaro = new Color(233,233,233);
	

		imageImpostazioni = new ImageIcon("impostazioni.png");
		imageicon = new ImageIcon("napule.png");
		imageTrattini = new ImageIcon("trattini.png");
		imageEsci = new ImageIcon("esci.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(azzurro);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		contentPane.add(menuPanelEsteso);
		
		impostazioniLabelMenuEsteso = new JLabel(imageImpostazioni);
		impostazioniLabelMenuEsteso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		impostazioniLabelMenuEsteso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore, 2, null);
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
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore, 2, null);
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
		impostazioniScrittaLabel.setForeground(Color.WHITE);
		impostazioniScrittaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		impostazioniScrittaLabel.setBounds(44, 465, 142, 32);
		menuPanelEsteso.add(impostazioniScrittaLabel);
		
		gestoreCorsiMenuLabel = new JLabel("           GESTORE CORSI");
		gestoreCorsiMenuLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestoreCorsiMenuLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreCorsiOpacoPanel.setBackground(azzurro);
				gestoreCorsiMenuLabel.setForeground(Color.BLACK);
				gestoreCorsiMenuLabel.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreCorsiMenuLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				gestoreCorsiMenuLabel.setVisible(true);
			}
		});
		gestoreCorsiMenuLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreCorsiMenuLabel.setForeground(Color.WHITE);
		gestoreCorsiMenuLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreCorsiMenuLabel.setBounds(0, 66, 225, 22);
		menuPanelEsteso.add(gestoreCorsiMenuLabel);
		
		gestoreLezioniMenuLabel = new JLabel("           GESTORE LEZIONI");
		gestoreLezioniMenuLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestoreLezioniMenuLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuPanelEsteso.setVisible(false);
				menuPanel.setVisible(true);	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				gestoreLezioniOpacoPanel.setBackground(azzurro);
				gestoreLezioniMenuLabel.setForeground(Color.BLACK);
				gestoreLezioniMenuLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreLezioniMenuLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				gestoreLezioniMenuLabel.setVisible(true);
			}
			
		});
		gestoreLezioniMenuLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreLezioniMenuLabel.setForeground(Color.WHITE);
		gestoreLezioniMenuLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreLezioniMenuLabel.setBounds(0, 99, 225, 22);
		menuPanelEsteso.add(gestoreLezioniMenuLabel);
		
		gestoreStudentiMenuLabel = new JLabel("        GESTORE STUDENTI");
		gestoreStudentiMenuLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gestoreStudentiMenuLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreStudentiPage gs = new GestoreStudentiPage(theController, operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreStudentiOpacoPanel.setBackground(azzurro);
				gestoreStudentiMenuLabel.setForeground(Color.BLACK);
				gestoreStudentiMenuLabel.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreStudentiMenuLabel.setForeground(Color.WHITE);
				menuPanelEsteso.setVisible(true);
				gestoreStudentiMenuLabel.setVisible(true);
			}
		});
		gestoreStudentiMenuLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestoreStudentiMenuLabel.setForeground(Color.WHITE);
		gestoreStudentiMenuLabel.setFont(new Font("Arial", Font.BOLD, 16));
		gestoreStudentiMenuLabel.setBounds(0, 132, 225, 22);
		menuPanelEsteso.add(gestoreStudentiMenuLabel);
		
		gestoreCorsiOpacoPanel = new JPanel();
		gestoreCorsiOpacoPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreCorsiOpacoPanel.setBackground(azzurro);
				gestoreCorsiMenuLabel.setForeground(Color.BLACK);
				gestoreCorsiMenuLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreCorsiMenuLabel.setForeground(Color.WHITE);
				gestoreCorsiMenuLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
			}
		});
		gestoreCorsiOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreCorsiOpacoPanel.setBounds(0, 66, 225, 22);
		menuPanelEsteso.add(gestoreCorsiOpacoPanel);
		
		gestoreLezioniOpacoPanel = new JPanel();
		gestoreLezioniOpacoPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreLezioniOpacoPanel.setBackground(azzurro);
				gestoreLezioniMenuLabel.setForeground(Color.BLACK);
				gestoreLezioniMenuLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreLezioniMenuLabel.setForeground(Color.WHITE);
				gestoreLezioniMenuLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
			}
		});
		gestoreLezioniOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreLezioniOpacoPanel.setBounds(0, 99, 225, 22);
		menuPanelEsteso.add(gestoreLezioniOpacoPanel);
		
		gestoreStudentiOpacoPanel = new JPanel();
		gestoreStudentiOpacoPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuPanelEsteso.setVisible(true);
				gestoreStudentiOpacoPanel.setBackground(azzurro);
				gestoreStudentiMenuLabel.setForeground(Color.BLACK);
				gestoreStudentiMenuLabel.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
				gestoreStudentiMenuLabel.setForeground(Color.WHITE);
				gestoreStudentiMenuLabel.setVisible(true);
				menuPanelEsteso.setVisible(true);
			}
		});
		gestoreStudentiOpacoPanel.setBackground(new Color(25, 25, 112));
		gestoreStudentiOpacoPanel.setBounds(0, 132, 225, 22);
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
		contentPane.add(menuPanel);
		
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
		
		gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(grigioChiaro);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(64, 11, 810, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		gestoreLezioniLabel = new JLabel("GESTIONE LEZIONI");
		gestoreLezioniLabel.setForeground(Color.BLACK);
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBackground(grigioChiaro);
		corsiPanel.setBounds(64, 71, 241, 479);
		contentPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		lezioniPanel =  new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBackground(grigioChiaro);
		lezioniPanel.setBounds(315, 71, 559, 479);
		contentPane.add(lezioniPanel);
		lezioniPanel.setLayout(null);
		
		selezionaCorsoLabel = new JLabel("Seleziona Corso:");
		selezionaCorsoLabel.setBounds(52, 11, 121, 18);
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsiPanel.add(selezionaCorsoLabel);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(10, 40, 221, 428);
		corsiPanel.add(corsiScrollPane);
		
		
		corsiScrollPane.setViewportView(corsiList);
		corsiList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if(e.getValueIsAdjusting()) {
					
					if(corsiList.isSelectionEmpty()) {
						alertNessunCorsoSelezionato();
					}else {
						String id_corso = corsiList.getSelectedValue().getIdCorso();
						if(theController.setAllLezioniDelCorso(id_corso).isEmpty())
							alertNessunaLezioneDisponibile();
					
						lezioni = theController.setAllLezioniDelCorso(id_corso);
						lezioniList.setListData(lezioni);
						}
				}
					
			}
				
				
		});
		corsiList.setVisibleRowCount(10);
		corsiList.setBackground(azzurroChiaro);
		corsiList.setFont(new Font("Arial", Font.BOLD, 17));
		corsiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		elencoLezioneDelCorsoLabel = new JLabel("Elenco Lezione del Corso:");
		elencoLezioneDelCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoLezioneDelCorsoLabel.setBounds(44, 11, 203, 18);
		lezioniPanel.add(elencoLezioneDelCorsoLabel);
		
		panormaicaLezioneButton = new JButton("PANORAMICA");
		panormaicaLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panormaicaLezioneButton.setBackground(Color.WHITE);
		panormaicaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lezioniList.isSelectionEmpty()) {
					alertNessunaLezioneSelezionata();
				}else {
					String lezioneSelezionata = lezioniList.getSelectedValue().getTitolo();
					setVisible(false);
					PanoramicaLezionePage pl = new PanoramicaLezionePage(theController, operatore, theController.getLezione(lezioneSelezionata));
					
				}
			}
		});
		panormaicaLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		panormaicaLezioneButton.setBounds(146, 405, 116, 29);
		lezioniPanel.add(panormaicaLezioneButton);
		
		eliminaLezioneButton = new JButton("ELIMINA");
		eliminaLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminaLezioneButton.setForeground(Color.BLACK);
		eliminaLezioneButton.setBackground(Color.WHITE);
		eliminaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				eliminaLezioneButton.setBackground(Color.RED);
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				eliminaLezioneButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lezioniList.isSelectionEmpty()) {
					alertNessunaLezioneSelezionataElimina();
				}else {
					alertConfermaEliminazionelezione();
				}
			}
		});
		eliminaLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		eliminaLezioneButton.setBounds(11, 405, 116, 29);
		lezioniPanel.add(eliminaLezioneButton);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(11, 40, 251, 354);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniList = new JList<Lezioni>();
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setBackground(azzurroChiaro);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 17));
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		filtriPanel = new JPanel();
		filtriPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		filtriPanel.setBackground(grigioChiaro);
		filtriPanel.setBounds(272, 0, 287, 479);
		lezioniPanel.add(filtriPanel);
		filtriPanel.setLayout(null);
		
		filtriLabel = new JLabel("FILTRI PER LEZIONI");
		filtriLabel.setBounds(68, 11, 144, 18);
		filtriLabel.setFont(new Font("Arial", Font.BOLD, 15));
		filtriPanel.add(filtriLabel);
		
		giorniLabel = new JLabel("Giorni:");
		giorniLabel.setBounds(10, 100, 48, 18);
		filtriPanel.add(giorniLabel);
		giorniLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		mesiLabel = new JLabel("Mesi:");
		mesiLabel.setBounds(159, 100, 38, 18);
		filtriPanel.add(mesiLabel);
		mesiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		filtraButton = new JButton("FILTRA");
		filtraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Vector<String> vettoreGiorni = theController.getGiorniSelezionati(giorniList);
				Vector<String> vettoreMesi = theController.getMesiSelezionati(mesiList);
				Vector<Time> vettoreOrario = theController.getOrariSelezionati(orarioList, orario);
				Vector<Time> vettoreDurate = theController.getDurateSelezionate(durataList, durata);
				
				if(corsiList.getSelectedValue()==null)
					alertNessunCorsoSelezionato();
				else {
						lezioni = theController.setLezioniFiltrate(vettoreGiorni, vettoreMesi, vettoreOrario, vettoreDurate, corsiList.getSelectedValue().getIdCorso(), titoloTextField.getText().toLowerCase(), corsiList.getSelectedValue().getAnno());
						lezioniList.setListData(lezioni);
					}
			}
		});
		filtraButton.setBackground(Color.WHITE);
		filtraButton.setBounds(173, 445, 104, 23);
		filtriPanel.add(filtraButton);
		filtraButton.setForeground(Color.RED);
		filtraButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		resetButton = new JButton("RESET");
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				giorniList.setModel(theController.setModelCheckBoxString(giorni));
				mesiList.setModel(theController.setModelCheckBoxString(mesi));
				orarioList.setModel(theController.setModelCheckBoxTime(orario));
				durataList.setModel(theController.setModelCheckBoxTime(durata));
				setAllGiorniRadioButton.setSelected(false);
				setAllGiorniRadioButton.setText("set all");
				setAllMesiRadioButton.setSelected(false);
				setAllMesiRadioButton.setText("set all");
				lezioni = theController.setAllLezioniDelCorso(corsiList.getSelectedValue().getIdCorso());
				lezioniList.setListData(lezioni);
			}
		});
		resetButton.setBackground(Color.WHITE);
		resetButton.setBounds(10, 445, 104, 23);
		filtriPanel.add(resetButton);
		resetButton.setFont(new Font("Arial", Font.BOLD, 12));
		resetButton.setForeground(new Color(65, 105, 225));
		
		giorniScrollPane = new JScrollPane();
		giorniScrollPane.setBounds(10, 117, 120, 128);
		filtriPanel.add(giorniScrollPane);
		
		giorniList = new JCheckBoxList();
		giorniList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setAllGiorniRadioButton.setSelected(false);
				setAllGiorniRadioButton.setText("set all");
			}
		});
		giorniScrollPane.setViewportView(giorniList);
		giorniList.setBackground(azzurroChiaro);
		giorniList.setModel(theController.setModelCheckBoxString(giorni));
		giorniList.setFont(new Font("Arial", Font.BOLD, 15));
		giorniList.setVisibleRowCount(10);
		
		orarioScrollPane = new JScrollPane();
		orarioScrollPane.setBounds(10, 310, 118, 92);
		filtriPanel.add(orarioScrollPane);
		
		orarioList = new JCheckBoxList();
		orarioScrollPane.setColumnHeaderView(orarioList);
		orarioList.setBackground(azzurroChiaro);
		orarioList.setModel(theController.setModelCheckBoxTime(orario));
		orarioList.setFont(new Font("Arial", Font.BOLD, 15));
		orarioList.setVisibleRowCount(10);
		
		durataScrollPane = new JScrollPane();
		durataScrollPane.setBounds(159, 310, 118, 92);
		filtriPanel.add(durataScrollPane);
		
		durataList = new JCheckBoxList();
		durataScrollPane.setViewportView(durataList);
		durataList.setBackground(azzurroChiaro);
		durataList.setModel(theController.setModelCheckBoxTime(durata));
		durataList.setFont(new Font("Arial", Font.BOLD, 15));
		durataList.setVisibleRowCount(10);
		
		orarioLabel = new JLabel("Orario:");
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(10, 291, 60, 18);
		filtriPanel.add(orarioLabel);
		
		durataLabel = new JLabel("Durata:");
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(159, 291, 60, 18);
		filtriPanel.add(durataLabel);
		
		mesiScrollPane = new JScrollPane();
		mesiScrollPane.setBounds(159, 117, 118, 126);
		filtriPanel.add(mesiScrollPane);
		
		mesiList = new JCheckBoxList();
		mesiList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setAllMesiRadioButton.setSelected(false);
				setAllMesiRadioButton.setText("set all");
				
			}
		});
		mesiScrollPane.setViewportView(mesiList);
		mesiList.setBackground(azzurroChiaro);
		mesiList.setModel(theController.setModelCheckBoxString(mesi));
		mesiList.setFont(new Font("Arial", Font.BOLD, 15));
		mesiList.setVisibleRowCount(10);
		
		titoloTextField = new JTextField();
		titoloTextField.setBounds(102, 53, 86, 20);
		filtriPanel.add(titoloTextField);
		titoloTextField.setColumns(10);
		
		titoloLabel = new JLabel("Titolo:");
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(44, 53, 48, 18);
		filtriPanel.add(titoloLabel);
		
		setAllGiorniRadioButton = new JRadioButton("set all");
		setAllGiorniRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!setAllGiorniRadioButton.isSelected()) {
					
					giorniList.setModel(theController.setNone(giorniList.getModel()));
					setAllGiorniRadioButton.setText("set All");
					giorniList.updateUI();
					
				}else {
					
					setAllGiorniRadioButton.setText("set None");
					giorniList.setModel(theController.setAll(giorniList.getModel()));
					giorniList.updateUI();

				}
				
			}
		});
		setAllGiorniRadioButton.setBounds(10, 243, 109, 23);
		filtriPanel.add(setAllGiorniRadioButton);
		
		setAllMesiRadioButton = new JRadioButton("set all");
		setAllMesiRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!setAllMesiRadioButton.isSelected()) {
					
					mesiList.setModel(theController.setNone(mesiList.getModel()));
					setAllMesiRadioButton.setText("set All");
					mesiList.updateUI();
					
				}else {
					
					setAllMesiRadioButton.setText("set None");
					mesiList.setModel(theController.setAll(mesiList.getModel()));
					mesiList.updateUI();
				}
			}
		});
		setAllMesiRadioButton.setBounds(159, 243, 109, 23);
		filtriPanel.add(setAllMesiRadioButton);
		
				
		aggiungiLezioneButton = new JButton("AGGIUNGI LEZIONE");
		aggiungiLezioneButton.setBounds(11, 445, 251, 23);
		lezioniPanel.add(aggiungiLezioneButton);
		aggiungiLezioneButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		aggiungiLezioneButton.setBackground(Color.WHITE);
		aggiungiLezioneButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			aggiungiLezioneButton.setBackground(Color.GREEN);
		}
		public void mouseExited(java.awt.event.MouseEvent e) {
			aggiungiLezioneButton.setBackground(Color.WHITE);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(corsiList.isSelectionEmpty()) {
				alertNessunCorsoSelezionatoAggiungiLezione();
			}else {
				String id_corso = corsiList.getSelectedValue().getIdCorso().toString();		
				CreazioneLezionePage clp = new CreazioneLezionePage(theController, operatore, theController.getCorso(id_corso));
				setVisible(false);
			}
		}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void alertNessunaLezioneDisponibile() {
		JOptionPane.showMessageDialog(this, "Non ci sono lezioni per il Corso selezionato.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunaLezioneSelezionata() {
		JOptionPane.showMessageDialog(this, "Selezionare una lezione","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunCorsoSelezionato() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunaLezioneSelezionataElimina() {
		JOptionPane.showMessageDialog(this, "Selezionare una lezione per poter eliminarla.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunCorsoSelezionatoAggiungiLezione() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso per poter aggiungerne una Lezione.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertConfermaEliminazionelezione() {
		Object[] opzioni = {"Sì", "No"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler eliminare la lezione selezionata ?",
				"CONFERMA DI ELIMINAZIONE",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			
			String state = theController.eliminaLezione(lezioniList.getSelectedValue().getIdLezione());
			
			if(state == "0") {
				alertEliminazioneEffettuata();
			}else
				alertEliminazioneFallita(state);
		}
	}
	
	public void alertEliminazioneEffettuata() {
		
		JOptionPane.showMessageDialog(this, "Lezione eliminata correttamente","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		lezioni = theController.setAllLezioniDelCorso(corsiList.getSelectedValue().getIdCorso());
		lezioniList.setListData(lezioni);
	}
	
	public void alertEliminazioneFallita(String state) {
		
		if(state == "-1")
			JOptionPane.showMessageDialog(this, "Lezione non eliminata a causa di un errore sconosciuto ", "<ERRORE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Lezione non eliminata.\nCodice d'errore: " + state,"<ERRORE>", JOptionPane.WARNING_MESSAGE);
		
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
}
