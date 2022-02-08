package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class GestoreLezioniPage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private Vector<Corsi> corsi;
	private Vector<Lezioni> lezioni;
	private Vector<String> mesi;
	private Vector<String> giorni;
	
	
	private ImageIcon imageicon;
	private JList<Lezioni> lezioniList;
	private JList<Corsi> corsiList;
	private JPanel contentPane;
	private Component url;
	private JPanel gestoreLezioniPanel;
	private JLabel gestoreLezioniLabel;
	private JPanel corsiPanel;
	private JLabel selezionaCorsoLabel;
	private JPanel lezioniPanel;
	private JButton confermaCorsoButton;
	private JLabel elencoLezioneDelCorsoLabel;
	private JButton panormaicaLezioneButton;
	private JButton eliminaLezioneButton;
	private JButton aggiungiLezioneButton;
	private JButton indietroButton;
	private JScrollPane corsiScrollPane;
	private JScrollPane lezioniScrollPane;
	private JScrollPane temiScrollPane;
	private JScrollPane mesiScrollPane;
	private JCheckBoxList mesiList;
	private JScrollPane giorniScrollPane;
	private JCheckBoxList giorniList;
	private JCheckBoxList anniList;
	
	public GestoreLezioniPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		
		theController = controller;
		this.operatore = operatore;
		corsi = theController.getCorsiOperatore(operatore);
		corsiList = new JList<Corsi>(corsi);
		mesi = theController.getMesi();
		giorni = theController.getGiorni();
		
		
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(SystemColor.control);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(10, 11, 777, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		gestoreLezioniLabel = new JLabel("GESTIONE LEZIONI");
		gestoreLezioniLabel.setForeground(new Color(65, 105, 225));
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBounds(10, 71, 222, 335);
		contentPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		lezioniPanel =  new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(242, 71, 545, 335);
		contentPane.add(lezioniPanel);
		lezioniPanel.setLayout(null);
		
		
		selezionaCorsoLabel = new JLabel("Seleziona Corso:");
		selezionaCorsoLabel.setBounds(52, 11, 121, 18);
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsiPanel.add(selezionaCorsoLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp = new HomePage(theController, operatore);
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
		indietroButton.setBounds(10, 417, 163, 23);
		contentPane.add(indietroButton);
		
		confermaCorsoButton = new JButton("CONFERMA");
		confermaCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaCorsoButton.setBackground(Color.WHITE);
		confermaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.isSelectionEmpty()) {
					alertNessunCorsoSelezionato();
				}else {
					String id_corso = corsiList.getSelectedValue().getIdCorso();
					if(theController.setAllLezioniDelCorso(id_corso).isEmpty())
						alertNessunaLezioneDisponibile();
					else {
						lezioni = theController.setAllLezioniDelCorso(id_corso);
						lezioniList.setListData(lezioni);
					}
				}
						
			}
		});
		confermaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaCorsoButton.setBounds(52, 301, 121, 23);
		corsiPanel.add(confermaCorsoButton);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(10, 40, 202, 252);
		corsiPanel.add(corsiScrollPane);
		
		
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		elencoLezioneDelCorsoLabel = new JLabel("Elenco Lezione del Corso:");
		elencoLezioneDelCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoLezioneDelCorsoLabel.setBounds(43, 11, 203, 18);
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
					PanoramicaLezionePage pl = new PanoramicaLezionePage(theController, operatore, theController.getLezione(lezioneSelezionata));
					setVisible(false);
				}
			}
		});
		panormaicaLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		panormaicaLezioneButton.setBounds(142, 295, 116, 29);
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
		eliminaLezioneButton.setBounds(10, 295, 116, 29);
		lezioniPanel.add(eliminaLezioneButton);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(10, 40, 248, 250);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniList = new JList<Lezioni>();
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(268, 0, 277, 335);
		lezioniPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblFiltri = new JLabel("FILTRI PER LEZIONI");
		lblFiltri.setBounds(64, 0, 144, 18);
		lblFiltri.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblFiltri);
		
		JLabel mesiLabel_1 = new JLabel("Giorni:");
		mesiLabel_1.setBounds(7, 22, 48, 18);
		panel.add(mesiLabel_1);
		mesiLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel mesiLabel = new JLabel("Mesi:");
		mesiLabel.setBounds(148, 22, 38, 18);
		panel.add(mesiLabel);
		mesiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton filtraButton = new JButton("FILTRA");
		filtraButton.setBounds(172, 301, 71, 23);
		panel.add(filtraButton);
		filtraButton.setForeground(Color.RED);
		filtraButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton resetButton = new JButton("RESET");
		resetButton.setBounds(30, 301, 69, 23);
		panel.add(resetButton);
		resetButton.setFont(new Font("Arial", Font.BOLD, 12));
		resetButton.setForeground(new Color(65, 105, 225));
		
		giorniScrollPane = new JScrollPane();
		giorniScrollPane.setBounds(7, 40, 120, 131);
		panel.add(giorniScrollPane);
		
		giorniList = new JCheckBoxList();
		giorniScrollPane.setViewportView(giorniList);
		giorniList.setModel(theController.setModelCheckBoxString(giorni));
		giorniList.setFont(new Font("Arial", Font.BOLD, 15));
		giorniList.setVisibleRowCount(10);
		
		mesiScrollPane = new JScrollPane();
		mesiScrollPane.setBounds(148, 40, 120, 131);
		panel.add(mesiScrollPane);
		
		mesiList = new JCheckBoxList();
		mesiScrollPane.setViewportView(mesiList);
		mesiList.setModel(theController.setModelCheckBoxString(mesi));
		mesiList.setFont(new Font("Arial", Font.BOLD, 15));
		mesiList.setVisibleRowCount(10);
		mesiList.setVisible(true);
		giorniList.setVisible(true);
		
		aggiungiLezioneButton = new JButton("AGGIUNGI LEZIONE");
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
		JOptionPane.showMessageDialog(this, "Selezionare una lezione per poter visualizzarne la paronamica.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunCorsoSelezionato() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso per poter visualizzarne le Lezioni.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
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
}
