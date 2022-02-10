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
	private JButton indietroButton;
	
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
	
	public GestoreLezioniPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		
		theController = controller;
		this.operatore = operatore;
		
		
		
		corsi = theController.getCorsiOperatore(operatore);
		corsiList = new JList<Corsi>(corsi);
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

		
		mesi = theController.getMesi();
		giorni = theController.getGiorni();
		durata = theController.getDurate();
		orario = theController.getOrario();

		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(SystemColor.control);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(10, 11, 864, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		gestoreLezioniLabel = new JLabel("GESTIONE LEZIONI");
		gestoreLezioniLabel.setForeground(new Color(65, 105, 225));
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBounds(10, 71, 222, 445);
		contentPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		lezioniPanel =  new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(242, 71, 632, 445);
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
		indietroButton.setBounds(10, 527, 163, 23);
		contentPane.add(indietroButton);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(10, 40, 202, 394);
		corsiPanel.add(corsiScrollPane);
		
		
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		elencoLezioneDelCorsoLabel = new JLabel("Elenco Lezione del Corso:");
		elencoLezioneDelCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoLezioneDelCorsoLabel.setBounds(59, 11, 203, 18);
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
		panormaicaLezioneButton.setBounds(173, 405, 116, 29);
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
		eliminaLezioneButton.setBounds(10, 405, 116, 29);
		lezioniPanel.add(eliminaLezioneButton);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(11, 40, 278, 354);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniList = new JList<Lezioni>();
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		filtriPanel = new JPanel();
		filtriPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		filtriPanel.setBounds(306, 0, 326, 445);
		lezioniPanel.add(filtriPanel);
		filtriPanel.setLayout(null);
		
		filtriLabel = new JLabel("FILTRI PER LEZIONI");
		filtriLabel.setBounds(90, 11, 144, 18);
		filtriLabel.setFont(new Font("Arial", Font.BOLD, 15));
		filtriPanel.add(filtriLabel);
		
		giorniLabel = new JLabel("Giorni:");
		giorniLabel.setBounds(20, 100, 48, 18);
		filtriPanel.add(giorniLabel);
		giorniLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		mesiLabel = new JLabel("Mesi:");
		mesiLabel.setBounds(196, 100, 38, 18);
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
		//			if(vettoreGiorni.isEmpty() && !vettoreMesi.isEmpty()) {
			//			vettoreGiorni = theController.getGiorni();
						lezioni = theController.setLezioniFiltrate(vettoreGiorni, vettoreMesi, vettoreOrario, vettoreDurate, corsiList.getSelectedValue().getIdCorso(), titoloTextField.getText().toLowerCase(), corsiList.getSelectedValue().getAnno());
				//	}else{
					//	lezioni = theController.setLezioniFiltrate(vettoreGiorni, vettoreMesi, vettoreOrario, vettoreDurate, corsiList.getSelectedValue().getIdCorso(), titoloTextField.getText().toLowerCase(), corsiList.getSelectedValue().getAnno());
						lezioniList.setListData(lezioni);
					}
			}
		});
		filtraButton.setBackground(Color.WHITE);
		filtraButton.setBounds(210, 411, 104, 23);
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
			}
		});
		resetButton.setBackground(Color.WHITE);
		resetButton.setBounds(20, 411, 104, 23);
		filtriPanel.add(resetButton);
		resetButton.setFont(new Font("Arial", Font.BOLD, 12));
		resetButton.setForeground(new Color(65, 105, 225));
		
		giorniScrollPane = new JScrollPane();
		giorniScrollPane.setBounds(20, 117, 120, 128);
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
		giorniList.setModel(theController.setModelCheckBoxString(giorni));
		giorniList.setFont(new Font("Arial", Font.BOLD, 15));
		giorniList.setVisibleRowCount(10);
		
		orarioScrollPane = new JScrollPane();
		orarioScrollPane.setBounds(20, 297, 118, 92);
		filtriPanel.add(orarioScrollPane);
		
		orarioList = new JCheckBoxList();
		orarioScrollPane.setColumnHeaderView(orarioList);
		orarioList.setModel(theController.setModelCheckBoxTime(orario));
		orarioList.setFont(new Font("Arial", Font.BOLD, 15));
		orarioList.setVisibleRowCount(10);
		
		durataScrollPane = new JScrollPane();
		durataScrollPane.setBounds(196, 297, 118, 92);
		filtriPanel.add(durataScrollPane);
		
		durataList = new JCheckBoxList();
		durataScrollPane.setViewportView(durataList);
		durataList.setModel(theController.setModelCheckBoxTime(durata));
		durataList.setFont(new Font("Arial", Font.BOLD, 15));
		durataList.setVisibleRowCount(10);
		
		orarioLabel = new JLabel("Orario:");
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(20, 281, 60, 18);
		filtriPanel.add(orarioLabel);
		
		durataLabel = new JLabel("Durata:");
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(196, 281, 60, 18);
		filtriPanel.add(durataLabel);
		
		mesiScrollPane = new JScrollPane();
		mesiScrollPane.setBounds(196, 117, 118, 126);
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
		mesiList.setModel(theController.setModelCheckBoxString(mesi));
		mesiList.setFont(new Font("Arial", Font.BOLD, 15));
		mesiList.setVisibleRowCount(10);
		
		titoloTextField = new JTextField();
		titoloTextField.setBounds(126, 53, 86, 20);
		filtriPanel.add(titoloTextField);
		titoloTextField.setColumns(10);
		
		titoloLabel = new JLabel("Titolo:");
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(68, 53, 48, 18);
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
		setAllGiorniRadioButton.setBounds(20, 243, 109, 23);
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
		setAllMesiRadioButton.setBounds(196, 243, 109, 23);
		filtriPanel.add(setAllMesiRadioButton);
		
				
		aggiungiLezioneButton = new JButton("AGGIUNGI LEZIONE");
		aggiungiLezioneButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiLezioneButton.setBounds(652, 527, 222, 23);			
		contentPane.add(aggiungiLezioneButton);			
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
}
