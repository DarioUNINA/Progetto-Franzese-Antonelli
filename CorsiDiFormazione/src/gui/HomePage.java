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
	private JScrollPane temiScrollPane;
	private JScrollPane paroleChiaveScrollPane;
	private JCheckBoxList listaParoleChiave;
	private JCheckBoxList listaTemi;
	private JCheckBoxList annoList;
	private JCheckBox terminatoCheckBoxSi;
	private JCheckBox terminatoCheckBoxNo;
	private JPanel addDeleteCorsi;
	private JButton aggiungiCorsoButton;
	private JButton eliminaCorsoButton;
	private JPanel corsiPanel;
	private JScrollPane corsiScrollPane;	
	private JScrollPane annoScrollPane;
	private JList<Corsi> corsiList;
	private JPanel gestione;
	private JButton gestioneCorsiButton;
	private JButton gestioneLezioniButton;
	private JButton gestioneStudentiButton;
	private JButton resetFiltriButton;
	private JButton filtraButton;
	private Vector<AreeTematiche> areeTematiche;
	private Vector<Corsi> corsi;
	private Vector<ParoleChiave> paroleChiave;
	private Vector<String> anni;
	private JRadioButton FullMatchRadioButton;
	private JRadioButton PartialMatchRadioButton;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel icona;

	public HomePage(Controller cont, Operatori operatore) {

		theController = cont;
		this.operatore = operatore;
		corsi = theController.getCorsiOperatore(operatore);
		anni = theController.getAllAnni();
		
		areeTematiche = theController.getAllAreeTematiche();
		paroleChiave = theController.getAllParoleChiave();

		this.getContentPane().setBackground(Color.BLUE);
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());

		setResizable(false);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		sfondoPane = new JPanel();
		sfondoPane.setBackground(new Color(65, 105, 225));
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		benvenuto = new JPanel();
		benvenuto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		benvenuto.setBackground(SystemColor.control);
		benvenuto.setBounds(64, 11, 810, 77);
		sfondoPane.add(benvenuto);
		benvenuto.setLayout(null);
		
		benvenutoLabel = new JLabel("");
		benvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		benvenutoLabel.setBounds(10, -2, 352, 44);
		benvenuto.add(benvenutoLabel);
		benvenutoLabel.setText("Benvenuto, " + operatore.getNomeUtente().toUpperCase());
		
		impostazioniButton = new JButton("IMPOSTAZIONI");
		impostazioniButton.setBackground(Color.WHITE);
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
		impostazioniButton.setBounds(648, 14, 152, 23);
		benvenuto.add(impostazioniButton);
		
		esciButton = new JButton("ESCI");
		esciButton.setBackground(Color.WHITE);
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
		esciButton.setBounds(648, 43, 152, 23);
		benvenuto.add(esciButton);
		
		filtri = new JPanel();
		filtri.setBorder(new LineBorder(Color.BLACK, 2));
		filtri.setBackground(SystemColor.control);
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
		listaParoleChiave.setBackground(Color.LIGHT_GRAY);
		listaParoleChiave.setVisibleRowCount(10);
		listaParoleChiave.setVisible(true);
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(Color.BLACK, 2));
		corsiPanel.setBackground(SystemColor.control);
		corsiPanel.setBounds(386, 99, 488, 221);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBorder(new LineBorder(Color.BLACK));
		corsiScrollPane.setBounds(10, 11, 222, 166);
		corsiPanel.add(corsiScrollPane);

		corsiList = new JList<Corsi>(corsi);
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBackground(Color.LIGHT_GRAY);
		corsiList.setVisibleRowCount(10);
		
		gestione = new JPanel();
		gestione.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		gestione.setBackground(SystemColor.control);
		gestione.setBounds(386, 331, 488, 219);
		sfondoPane.add(gestione);
		gestione.setLayout(null);
		
		gestioneCorsiButton = new JButton("GESTIONE CORSI");
		gestioneCorsiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestioneCorsiButton.setBackground(Color.WHITE);
		gestioneCorsiButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneCorsiButton.setBounds(291, 26, 174, 22);
		gestione.add(gestioneCorsiButton);
		
		gestioneLezioniButton = new JButton("GESTIONE LEZIONI");
		gestioneLezioniButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestioneLezioniButton.setBackground(Color.WHITE);
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
		gestioneLezioniButton.setBounds(291, 68, 174, 22);
		gestione.add(gestioneLezioniButton);
		
		gestioneStudentiButton = new JButton("GESTIONE STUDENTI");
		gestioneStudentiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		gestioneStudentiButton.setBackground(Color.WHITE);
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
				gestioneStudentiButton.setBackground(Color.white);
			}
		});
		gestioneStudentiButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneStudentiButton.setBounds(291, 113, 174, 22);
		gestione.add(gestioneStudentiButton);
		
		addDeleteCorsi = new JPanel();
		addDeleteCorsi.setBounds(10, 131, 261, 77);
		gestione.add(addDeleteCorsi);
		addDeleteCorsi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		addDeleteCorsi.setBackground(SystemColor.control);
		addDeleteCorsi.setLayout(null);
		
		aggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
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
		aggiungiCorsoButton.setBounds(22, 11, 212, 25);
		addDeleteCorsi.add(aggiungiCorsoButton);
		
		eliminaCorsoButton = new JButton("ELIMINA CORSO");
		eliminaCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminaCorsoButton.setBackground(Color.WHITE);
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
		
		resetFiltriButton = new JButton("RESET");
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
		filtraButton.setBorder(null);
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
						corsi = theController.setCorsiFiltratiFM(aree, anni, terminatoSi, terminatoNo, parole, operatore.getIdOperatore());
				}
					
				else
					corsi = theController.setCorsiFiltratiPM(aree, anni, terminatoSi, terminatoNo, parole, operatore.getIdOperatore());

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
		annoList.setBackground(Color.LIGHT_GRAY);
		annoList.setVisibleRowCount(10);
		
		
		temiScrollPane = new JScrollPane();
		temiScrollPane.setBounds(109, 174, 177, 108);
		filtri.add(temiScrollPane);
		temiScrollPane.setBorder(new LineBorder(Color.BLACK));
		
		listaTemi = new JCheckBoxList();
		temiScrollPane.setViewportView(listaTemi);
		listaTemi.setModel(theController.setModelCheckBox(areeTematiche));
		listaTemi.setFont(new Font("Arial", Font.BOLD, 15));
		listaTemi.setBackground(Color.LIGHT_GRAY);
		listaTemi.setVisibleRowCount(10);
		listaTemi.setVisible(true);
		annoList.setVisible(true);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBounds(10,11,100,539);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBounds(10,11,44, 539);
			}
		});
		panel.setBounds(10, 11, 44, 539);
		sfondoPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("...");
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(0, 0, 44, 23);
		panel.add(btnNewButton);

		
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
}


public void alertCorsiFM() {
	
	
	JOptionPane.showMessageDialog(this, "Non puoi eserguire un filtraggio Full Match con piu di un anno","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	
}


Vector<String> getStringheSelezionate(JCheckBoxList box, Vector<String> anni){
	
	Vector<String> vettore = new Vector<String>();
	
	for(int i=0;i<anni.size();i++)
		if(box.getModel().getElementAt(i).isSelected())
			vettore.add(anni.get(i));
	
	return vettore;
}
