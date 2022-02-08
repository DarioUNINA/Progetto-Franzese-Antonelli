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

public class GestoreLezioniPage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private Vector<Corsi> corsi;
	private Vector<Lezioni> lezioni;
	
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
	
	public GestoreLezioniPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		
		theController = controller;
		this.operatore = operatore;
		corsi = theController.getCorsiOperatore(operatore);
		corsiList = new JList<Corsi>(corsi);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new LineBorder(Color.BLACK));
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
		
		selezionaCorsoLabel = new JLabel("Seleziona Corso:");
		selezionaCorsoLabel.setBounds(52, 11, 121, 18);
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsiPanel.add(selezionaCorsoLabel);
		
		indietroButton = new JButton("INDIETRO");
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
		
		lezioniPanel = new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(242, 71, 545, 335);
		contentPane.add(lezioniPanel);
		lezioniPanel.setLayout(null);
		
		confermaCorsoButton = new JButton("CONFERMA");
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
		panormaicaLezioneButton.setBounds(314, 212, 179, 37);
		lezioniPanel.add(panormaicaLezioneButton);
		
		eliminaLezioneButton = new JButton("ELIMINA");
		eliminaLezioneButton.setForeground(Color.RED);
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
		eliminaLezioneButton.setBounds(314, 100, 179, 37);
		lezioniPanel.add(eliminaLezioneButton);
		
		lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(10, 40, 248, 284);
		lezioniPanel.add(lezioniScrollPane);
		
		lezioniList = new JList<Lezioni>();
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		aggiungiLezioneButton = new JButton("AGGIUNGI LEZIONE");
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
		aggiungiLezioneButton.setBounds(565, 418, 222, 23);
		contentPane.add(aggiungiLezioneButton);
		aggiungiLezioneButton.setFont(new Font("Arial", Font.BOLD, 15));
		
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
