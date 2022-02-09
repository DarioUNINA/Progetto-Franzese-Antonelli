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

public class PanoramicaSingoloStudentePage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private JList<Corsi> corsiList;
	private Studenti studente;
	private JList<Lezioni> lezioniList;
	private String[] nomeColonne = {"Corso", "Numero Presenze"};
	private Vector<Corsi> corsi;
	private Vector<Corsi> corsiAmmessi;
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
	private JTable corsiAmmessiTable;
	private JScrollPane tabelCorsiScrollPane;
	
	
	public PanoramicaSingoloStudentePage(Controller cont, Operatori operatore, Studenti studente) {
		
		theController = cont;
		this.operatore = operatore;
		this.studente = studente;
		
		corsi = theController.setCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiList = new JList<Corsi> (corsi);
		corsiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		imageicon = new ImageIcon("napule.png");
		
		setIconImage(imageicon.getImage());

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		sfondoPane = new JPanel();
		sfondoPane.setBackground(new Color(65, 105, 225));
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		studentePanel = new JPanel();
		studentePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentePanel.setBackground(SystemColor.control);
		studentePanel.setBounds(10, 11, 864, 77);
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
		indietroButton.setBounds(702, 43, 152, 23);
		studentePanel.add(indietroButton);
		
		corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBounds(10, 99, 206, 451);
		sfondoPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		elencoCorsiLabel = new JLabel("ELENCO CORSI:");
		elencoCorsiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoCorsiLabel.setBounds(44, 11, 131, 14);
		corsiPanel.add(elencoCorsiLabel);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(10, 36, 186, 350);
		corsiPanel.add(corsiScrollPane);
		
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		
		confermaButton = new JButton("MOSTRA PRENOTAZIONI");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.isSelectionEmpty()) {
					alertNessunCorsoSelezionato();
				}else{
					if(theController.getPresenzeStudente(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso()).isEmpty()) {
						alertNessunaLezioneDisponibile();
						lezioni = theController.getPresenzeStudente(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
						lezioniList.setListData(lezioni);
					}else {
						lezioni = theController.getPresenzeStudente(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
						lezioniList.setListData(lezioni);
					}
				}
			}
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 10));
		confermaButton.setBounds(10, 397, 186, 43);
		corsiPanel.add(confermaButton);
		
		lezioniPanel = new JPanel();
		lezioniPanel.setLayout(null);
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(226, 99, 232, 451);
		sfondoPane.add(lezioniPanel);
		
		elencoLezioniLabel = new JLabel("PRENOTAZIONI EFFETTUATE");
		elencoLezioniLabel.setFont(new Font("Arial", Font.BOLD, 14));
		elencoLezioniLabel.setBounds(10, 11, 205, 14);
		lezioniPanel.add(elencoLezioniLabel);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(10, 36, 212, 404);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniList = new JList<Lezioni>();
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		
		corsiAmmessoPanel = new JPanel();
		corsiAmmessoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiAmmessoPanel.setBounds(468, 99, 406, 451);
		sfondoPane.add(corsiAmmessoPanel);
		corsiAmmessoPanel.setLayout(null);
		
		corsiAmmessoLabel = new JLabel("CORSI ALLA QUALE SI E' AMMESSI ");
		corsiAmmessoLabel.setBounds(49, 11, 263, 14);
		corsiAmmessoPanel.add(corsiAmmessoLabel);
		corsiAmmessoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		iscriviAdUnCorsoButton = new JButton("ISCRIVI AD UN CORSO");
		iscriviAdUnCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iscriviAdUnCorsoButton.setBackground(Color.WHITE);
		iscriviAdUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				corsi = theController.setIscrizioneCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
				if(corsi.isEmpty())
					alertNonCiSonoCorsiDisponibili();
				else {
					AggiungiStudenteCorsoPage asc = new AggiungiStudenteCorsoPage(theController, operatore, studente);
					setVisible(false);
				}
			}
		});
		iscriviAdUnCorsoButton.setFont(new Font("Arial", Font.BOLD, 13));
		iscriviAdUnCorsoButton.setBounds(10, 331, 191, 43);
		corsiAmmessoPanel.add(iscriviAdUnCorsoButton);
		
		disiscriviDaUnCorsoButton = new JButton("DISISCRIVI DA UN CORSO");
		disiscriviDaUnCorsoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		disiscriviDaUnCorsoButton.setBackground(Color.WHITE);
		disiscriviDaUnCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					GestioneDisiscrizione();
			}
		});
		disiscriviDaUnCorsoButton.setFont(new Font("Arial", Font.BOLD, 12));
		disiscriviDaUnCorsoButton.setBounds(205, 331, 191, 43);
		corsiAmmessoPanel.add(disiscriviDaUnCorsoButton);
		
		prenotaLezioneButton = new JButton("PRENOTA LEZIONE");
		prenotaLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prenotaLezioneButton.setBackground(Color.WHITE);
		prenotaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(corsiList.getSelectedValue() == null)
					alertNessunCorsoSelezionato();
				else {
					lezioni = theController.iscirizioneStudenteLezioniDelCorso(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
					if(lezioni.isEmpty())
						alertNonCiSonolezioniDisponibili();
					else {
						ConfermaPrenotaLezionePage page = new ConfermaPrenotaLezionePage(theController, operatore, studente, corsiList.getSelectedValue());
						setVisible(false);
					}
				}
					
			}
		});
		prenotaLezioneButton.setFont(new Font("Arial", Font.BOLD, 13));
		prenotaLezioneButton.setBounds(10, 397, 191, 43);
		corsiAmmessoPanel.add(prenotaLezioneButton);
		
		annullaPrenotazioneButton = new JButton("ANNULLA PRENOTAZIONE");
		annullaPrenotazioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		annullaPrenotazioneButton.setBackground(Color.WHITE);
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
		annullaPrenotazioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		annullaPrenotazioneButton.setBounds(205, 397, 191, 43);
		corsiAmmessoPanel.add(annullaPrenotazioneButton);
		
		tabelCorsiScrollPane = new JScrollPane();
		tabelCorsiScrollPane.setBounds(10, 181, 386, -128);
		corsiAmmessoPanel.add(tabelCorsiScrollPane);
		
		corsiAmmessiTable = new JTable();
		tabelCorsiScrollPane.setViewportView(corsiAmmessiTable);
		corsiAmmessiTable.setBackground(Color.orange);
		corsiAmmessiTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		corsiAmmessiTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"CORSO", "DESCRIZIONE", "AMMESSO?"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		corsiAmmessiTable.getColumnModel().getColumn(1).setResizable(false);
		corsiAmmessiTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		corsiAmmessiTable.setRowSelectionAllowed(false);
		corsiAmmessiTable.setFont(new Font("Microsoft YaheiUI", Font.PLAIN, 14));
		corsiAmmessiTable.setGridColor(Color.GREEN);
		corsiAmmessiTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		corsiAmmessiTable.setModel(new DefaultTableModel(new String[5][3],new String[] {"ciao", "aoo", "asd"}));
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		if(corsi.isEmpty())
			alertStudenteSenzaCorsi();
	}
	
	public void alertNonCiSonolezioniDisponibili() {
		JOptionPane.showMessageDialog(this, "Non ci sono lezioni disponibili per "+ corsiList.getSelectedValue().getNome().toUpperCase() + "!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNonCiSonoCorsiDisponibili() {
		
		JOptionPane.showMessageDialog(this, "Non ci sono corsi disponibili dove poter iscrivere lo studente!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertStudenteSenzaCorsi() {
		JOptionPane.showMessageDialog(this, "Studente iscritto a nessun Corso!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunCorsoSelezionato() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunaLezioneDisponibile() {
		JOptionPane.showMessageDialog(this, "Non ci sono lezioni per il Corso selezionato.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);		
	}
	
	
	public void GestioneDisiscrizione() {
		
		if(corsiList.isSelectionEmpty())
			alertNessunCorsoSelezionato();
		else 
			alertConfermaEliminazioneIscrizione();
	}
	
	
	
	public void alertStudenteDisiscrittoCorrettamente() {
		
		JOptionPane.showMessageDialog(this, "Studente disiscritto correttamente!","<CONFERMA>", JOptionPane.WARNING_MESSAGE);
		corsi = theController.setCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiList.setListData(corsi);
		lezioni = theController.getPresenzeStudente(studente.getMatricola(), corsiList.getSelectedValue().getIdCorso());
		lezioniList.setListData(lezioni);
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
}
