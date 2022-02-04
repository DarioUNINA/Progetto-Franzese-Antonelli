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
import dto.Operatori;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import com.toedter.components.JLocaleChooser;

public class HomePage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel sfondoPane;
	private JPanel benvenuto;
	private JLabel benvenutoLabel;
	private JButton impostazioniButton;
	private JButton esciButton;
	private JPanel filtri;
	private JLabel filtriLabel;
	private JLabel areaTematicaLabel;
	private JLabel annoLabel;
	private JLabel terminatoLabel;
	private JLabel parolaChiaveLabel;
	private JLabel areaTematica;
	private JComboBox<AreeTematiche> areaTematicaComboBox;
	private JComboBox<String> annoComboBox;
	private JCheckBox terminatoCheckBoxSi;
	private JCheckBox terminatoCheckBoxNo;
	private JTextField paroleChiaveTextField;
	private JPanel addDeleteCorsi;
	private JButton aggiungiCorsoButton;
	private JButton eliminaCorsoButton;
	private JPanel corsiPanel;
	private JScrollPane corsiScrollPane;	
	private JList<Corsi> corsiList;
	private JButton selezionaButton;
	private JPanel gestione;
	private JButton gestioneCorsiButton;
	private JButton gestioneLezioniButton;
	private JButton gestioneStudentiButton;
	private JButton resetFiltriButton;
	private JButton filtraButton;
	

	public HomePage(Controller cont, Operatori operatore) {
		setAlwaysOnTop(true);
		this.getContentPane().setBackground(Color.BLUE);
		imageicon = new ImageIcon("napule.png");
		theController = cont;
		this.operatore = operatore;
		setIconImage(imageicon.getImage());

		setResizable(false);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		sfondoPane = new JPanel();
		sfondoPane.setBackground(new Color(65, 105, 225));
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		benvenuto = new JPanel();
		benvenuto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		benvenuto.setBackground(SystemColor.control);
		benvenuto.setBounds(10, 11, 777, 77);
		sfondoPane.add(benvenuto);
		benvenuto.setLayout(null);
		
		benvenutoLabel = new JLabel("");
		benvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		benvenutoLabel.setBounds(10, -2, 352, 44);
		benvenuto.add(benvenutoLabel);
		benvenutoLabel.setText("Benvenuto, " + operatore.getNomeUtente().toUpperCase());
		
		impostazioniButton = new JButton("IMPOSTAZIONI");
		impostazioniButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				impostazioniButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				impostazioniButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore);
				setVisible(false);
			}
		});
		impostazioniButton.setFont(new Font("Arial", Font.BOLD, 15));
		impostazioniButton.setBounds(615, 11, 152, 23);
		benvenuto.add(impostazioniButton);
		
		esciButton = new JButton("ESCI");
		esciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				esciButton.setBackground(Color.RED);
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				esciButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				alertReturnToLogIn();
				
			}
		});

		
		esciButton.setFont(new Font("Arial", Font.BOLD, 15));
		esciButton.setBounds(615, 43, 152, 23);
		benvenuto.add(esciButton);
		
		filtri = new JPanel();
		filtri.setBorder(new LineBorder(Color.BLACK, 2));
		filtri.setBackground(SystemColor.control);
		filtri.setBounds(10, 99, 261, 253);
		sfondoPane.add(filtri);
		filtri.setLayout(null);
		
		filtriLabel = new JLabel("FILTRI:");
		filtriLabel.setBounds(10, 11, 212, 23);
		filtriLabel.setFont(new Font("Arial", Font.BOLD, 18));
		filtri.add(filtriLabel);
		
		areaTematicaLabel = new JLabel("Area Tematica:");
		areaTematicaLabel.setBounds(10, 47, 89, 14);
		areaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(areaTematicaLabel);
		
		annoLabel = new JLabel("Anno:");
		annoLabel.setBounds(10, 86, 89, 14);
		annoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		annoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		filtri.add(annoLabel);
		
		terminatoLabel = new JLabel("Terminato:");
		terminatoLabel.setBounds(10, 128, 89, 14);
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(terminatoLabel);
		
		parolaChiaveLabel = new JLabel("Parola Chiave:");
		parolaChiaveLabel.setBounds(10, 170, 89, 14);
		parolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(parolaChiaveLabel);
		
		areaTematicaComboBox = new JComboBox<AreeTematiche>(theController.setAreaTematicaComboBox());
		areaTematicaComboBox.setBounds(117, 43, 134, 22);
		filtri.add(areaTematicaComboBox);
				
		annoComboBox = new JComboBox<String>(theController.setAnnoComboBox());
		annoComboBox.setBounds(117, 82, 134, 22);
		filtri.add(annoComboBox);
		
		terminatoCheckBoxSi = new JCheckBox("SI");
		terminatoCheckBoxSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(terminatoCheckBoxSi.getSelectedObjects() != null)
					terminatoCheckBoxSi.setForeground(Color.GREEN);
				else
					terminatoCheckBoxSi.setForeground(Color.BLACK);
			}
		});
		terminatoCheckBoxSi.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBoxSi.setBounds(117, 124, 46, 23);
		filtri.add(terminatoCheckBoxSi);
		
		terminatoCheckBoxNo = new JCheckBox("NO");
		terminatoCheckBoxNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(terminatoCheckBoxNo.getSelectedObjects() != null)
					terminatoCheckBoxNo.setForeground(Color.RED);
				else
					terminatoCheckBoxNo.setForeground(Color.BLACK);
				
			}
		});
		terminatoCheckBoxNo.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBoxNo.setBounds(202, 124, 49, 23);
		filtri.add(terminatoCheckBoxNo);
		
		paroleChiaveTextField = new JTextField();
		paroleChiaveTextField.setFont(new Font("Arial", Font.BOLD, 13));
		paroleChiaveTextField.setBounds(117, 167, 134, 20);
		filtri.add(paroleChiaveTextField);
		paroleChiaveTextField.setColumns(10);
		
		addDeleteCorsi = new JPanel();
		addDeleteCorsi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addDeleteCorsi.setBackground(SystemColor.control);
		addDeleteCorsi.setBounds(10, 363, 261, 77);
		sfondoPane.add(addDeleteCorsi);
		addDeleteCorsi.setLayout(null);
		
		aggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
		aggiungiCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CreazioneCorsoPage ccp = new CreazioneCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		aggiungiCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiCorsoButton.setBounds(22, 11, 212, 25);
		addDeleteCorsi.add(aggiungiCorsoButton);
		
		eliminaCorsoButton = new JButton("ELIMINA CORSO");
		eliminaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EliminaCorsoPage ep = new EliminaCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		eliminaCorsoButton.setBounds(22, 41, 212, 25);
		addDeleteCorsi.add(eliminaCorsoButton);
		eliminaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(Color.BLACK, 2));
		corsiPanel.setBackground(SystemColor.control);
		corsiPanel.setBounds(281, 99, 506, 166);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		corsiScrollPane.setBounds(10, 11, 222, 114);
		corsiPanel.add(corsiScrollPane);

		corsiList = new JList<Corsi>(theController.getCorsiOperatore(operatore));
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setVisibleRowCount(10);
	
		selezionaButton = new JButton("SELEZIONA");
		selezionaButton.setFont(new Font("Arial", Font.BOLD, 15));
		selezionaButton.setBounds(20, 133, 199, 22);
		corsiPanel.add(selezionaButton);
		
		gestione = new JPanel();
		gestione.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		gestione.setBackground(SystemColor.control);
		gestione.setBounds(281, 274, 506, 166);
		sfondoPane.add(gestione);
		gestione.setLayout(null);
		
		gestioneCorsiButton = new JButton("GESTIONE CORSI");
		gestioneCorsiButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneCorsiButton.setBounds(322, 26, 174, 22);
		gestione.add(gestioneCorsiButton);
		
		gestioneLezioniButton = new JButton("GESTIONE LEZIONI");
		gestioneLezioniButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreLezioniPage gs = new GestoreLezioniPage(theController, operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				gestioneLezioniButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestioneLezioniButton.setBackground(Color.WHITE);
			}
		});
		gestioneLezioniButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneLezioniButton.setBounds(322, 71, 174, 22);
		gestione.add(gestioneLezioniButton);
		
		gestioneStudentiButton = new JButton("GESTIONE STUDENTI");
		gestioneStudentiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreStudentiPage gs = new GestoreStudentiPage(theController, operatore);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				gestioneStudentiButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gestioneStudentiButton.setBackground(Color.WHITE);
			}
		});
		gestioneStudentiButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneStudentiButton.setBounds(322, 115, 174, 22);
		gestione.add(gestioneStudentiButton);
		
		resetFiltriButton = new JButton("RESET");
		resetFiltriButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				areaTematicaComboBox.setSelectedIndex(0);
				annoComboBox.setSelectedIndex(0);
				terminatoCheckBoxSi.setSelected(false);
				terminatoCheckBoxSi.setForeground(Color.BLACK);
				paroleChiaveTextField.setText("");
				terminatoCheckBoxNo.setSelected(false);
				terminatoCheckBoxNo.setForeground(Color.BLACK);			
				
			}
		});
		resetFiltriButton.setForeground(Color.RED);
		resetFiltriButton.setBounds(10, 219, 89, 23);
		resetFiltriButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(resetFiltriButton);
		
		filtraButton = new JButton("FILTRA");
		filtraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String areaTematica = areaTematicaComboBox.getSelectedItem().toString();
				String anno = annoComboBox.getSelectedItem().toString();
				String parolaChiave = paroleChiaveTextField.getText();
				
				boolean terminatoSi , terminatoNo; 
				
				if(terminatoCheckBoxSi.isSelected())
					terminatoSi = true;
				else
					terminatoSi = false;
				
				if(terminatoCheckBoxNo.isSelected())
					terminatoNo = true;
				else
					terminatoNo = false;
				
				corsiList.setListData(theController.setCorsiFiltrati(areaTematica, anno, terminatoSi, terminatoNo, parolaChiave, operatore.getIdOperatore()));
				
			}
		});
		filtraButton.setForeground(new Color(65, 105, 225));
		filtraButton.setBounds(162, 219, 89, 23);
		filtraButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(filtraButton);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void alertReturnToLogIn() {
		Object[] opzioni = {"S�"};
		
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
