package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JYearChooser;

import dto.AreeTematiche;
import dto.Corsi;
import dto.Operatori;
import dto.ParoleChiave;

public class ModificheCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private Corsi corso;
	private Vector<AreeTematiche> areeTematiche;
	private Vector<ParoleChiave> parole;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel creazioneCorsiPanel;
	private JTextField nomeTextField;
	private JTextField presenzeMinTextField;
	private JTextField maxPartecipantiTextField;
	private JTextField descrizioneTextField;
	private JCheckBox terminatoCheckBox;
	private JButton indietroButton;
	private JButton confermaButton;
	private JPanel creaCorsoPanel;
	private JLabel alertLabel2;
	private JLabel alertLabel;
	private JLabel modificaCorsoLabel;
	private JLabel nomeLabel;
	private JLabel presenzeMinimeLabel;
	private JLabel massimoPartecipantiLabel;
	private JLabel parolaChiaveLabel;
	private JLabel annoLabel;
	private JLabel terminatoLabel;
	private JLabel descrizioneLabel;
	private JLabel areaTematicaLabel;
	private JScrollPane temiScrollPane;
	private JCheckBoxList listaTemi;
	private JScrollPane paroleScrollPane;
	private JCheckBoxList listaParole;
	private JYearChooser annoChooser;

	final Color azzurro;
	final Color azzurroChiaro;
	final Color grigio;
	final Color grigioChiaro;
	
	public ModificheCorsoPage(Controller cont, Operatori operatore, Corsi corso) {
		
		theController = cont;
		this.operatore = operatore;
		this.corso = corso;
		areeTematiche = theController.getAllAreeTematiche();
		areeTematiche.remove(0);
		parole = theController.getAllParoleChiave();
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		grigio = new Color(205,205,205);
		grigioChiaro = new Color(233,233,233);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		creazioneCorsiPanel = new JPanel();
		creazioneCorsiPanel.setBorder(new LineBorder(Color.BLACK));
		creazioneCorsiPanel.setBackground(azzurro);
		setContentPane(creazioneCorsiPanel);
		creazioneCorsiPanel.setLayout(null);
		
		creaCorsoPanel = new JPanel();
		creaCorsoPanel.setBounds(10, 11, 864, 539);
		creaCorsoPanel.setBackground(grigioChiaro);
		creaCorsoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		creazioneCorsiPanel.add(creaCorsoPanel);
		creaCorsoPanel.setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setText(corso.getNome());
		nomeTextField.setBorder(new LineBorder(Color.BLACK));
		nomeTextField.setBounds(187, 90, 190, 23);
		nomeTextField.setFont(new Font("Arial", Font.BOLD, 13));
		nomeTextField.setColumns(10);
		creaCorsoPanel.add(nomeTextField);
		
		presenzeMinTextField = new JTextField();
		presenzeMinTextField.setText(String.valueOf(corso.getPresenzeMin()));
		presenzeMinTextField.setBorder(new LineBorder(Color.BLACK));
		presenzeMinTextField.setBounds(187, 153, 189, 25);
		presenzeMinTextField.setFont(new Font("Arial", Font.BOLD, 13));
		presenzeMinTextField.setColumns(10);
		creaCorsoPanel.add(presenzeMinTextField);
		
		maxPartecipantiTextField = new JTextField();
		maxPartecipantiTextField.setText(String.valueOf(corso.getMaxPartecipanti()));
		maxPartecipantiTextField.setBorder(new LineBorder(Color.BLACK));
		maxPartecipantiTextField.setBounds(188, 218, 189, 25);
		maxPartecipantiTextField.setFont(new Font("Arial", Font.BOLD, 13));
		maxPartecipantiTextField.setColumns(10);
		creaCorsoPanel.add(maxPartecipantiTextField);
		
		terminatoCheckBox = new JCheckBox("SI");
		if(corso.isTerminato()) {
			terminatoCheckBox.setSelected(true);
			terminatoCheckBox.setForeground(Color.GREEN);
		}
		terminatoCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(terminatoCheckBox.getSelectedObjects() != null)
					terminatoCheckBox.setForeground(Color.GREEN);
				else
					terminatoCheckBox.setForeground(Color.BLACK);
			}
		});
		terminatoCheckBox.setBounds(521, 145, 48, 33);
		
		terminatoCheckBox.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBox.setBackground(grigioChiaro);
		creaCorsoPanel.add(terminatoCheckBox);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBounds(10, 495, 137, 33);
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
		creaCorsoPanel.add(indietroButton);

		temiScrollPane = new JScrollPane();
		temiScrollPane.setBackground(Color.LIGHT_GRAY);
		temiScrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		temiScrollPane.setBounds(150, 304, 227, 180);
		creaCorsoPanel.add(temiScrollPane);
		
		listaTemi = new JCheckBoxList();
		listaTemi.setModel(theController.setModelCheckBox(areeTematiche));
		temiScrollPane.setViewportView(listaTemi);
		listaTemi.setBackground(azzurroChiaro);
		listaTemi.setFont(new Font("Arial", Font.BOLD, 15));
		listaTemi.setVisibleRowCount(10);
		listaTemi.setVisible(true);
		
		paroleScrollPane = new JScrollPane();
		paroleScrollPane.setBorder(new LineBorder(Color.BLACK, 2));
		paroleScrollPane.setBounds(487, 304, 227, 180);
		creaCorsoPanel.add(paroleScrollPane);
		
		listaParole = new JCheckBoxList();
		listaParole.setModel(theController.setModelCheckBoxParole(parole));
		paroleScrollPane.setViewportView(listaParole);
		listaParole.setBackground(azzurroChiaro);
		listaParole.setFont(new Font("Arial", Font.BOLD, 15));
		listaParole.setVisibleRowCount(10);
		listaParole.setVisible(true);

		annoChooser = new JYearChooser();
		if(!theController.modificaAnnoCorso(corso.getIdCorso()))
			annoChooser.getSpinner().setEnabled(true);
		else
			annoChooser.getSpinner().setEnabled(false);
		annoChooser.setBounds(521, 90, 86, 20);
		annoChooser.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		annoChooser.getSpinner().setBounds(0, 0, 86, 20);
		creaCorsoPanel.add(annoChooser);
		annoChooser.setLayout(null);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBounds(717, 495, 137, 33);
		confermaButton.setBackground(Color.WHITE);
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				
//				if(nomeTextField.getText().equals(""))
//					alertNomeNonInserito();
//				else
//					gestoreCreazioneStudente();
				
				
			}	
			
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(confermaButton);
		
		modificaCorsoLabel = new JLabel("MODIFICHE CORSO");
		modificaCorsoLabel.setBounds(315, 11, 238, 33);
		modificaCorsoLabel.setForeground(Color.BLACK);
		modificaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 25));
		modificaCorsoLabel.setBackground(Color.WHITE);
		creaCorsoPanel.add(modificaCorsoLabel);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(132, 94, 58, 19);
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 17));
		creaCorsoPanel.add(nomeLabel);
		
		presenzeMinimeLabel = new JLabel("Presenze Minime:");
		presenzeMinimeLabel.setBounds(44, 153, 146, 19);
		presenzeMinimeLabel.setFont(new Font("Arial", Font.BOLD, 17));
		creaCorsoPanel.add(presenzeMinimeLabel);
		
		massimoPartecipantiLabel = new JLabel("Massimo Partecipanti:");
		massimoPartecipantiLabel.setBounds(10, 218, 179, 20);
		massimoPartecipantiLabel.setFont(new Font("Arial", Font.BOLD, 17));
		creaCorsoPanel.add(massimoPartecipantiLabel);
		
		parolaChiaveLabel = new JLabel("Parola Chiave:");
		parolaChiaveLabel.setBounds(150, 280, 137, 23);
		parolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 18));
		creaCorsoPanel.add(parolaChiaveLabel);
		
		annoLabel = new JLabel("Anno:");
		annoLabel.setBounds(453, 92, 58, 14);
		annoLabel.setFont(new Font("Arial", Font.BOLD, 17));
		creaCorsoPanel.add(annoLabel);
		
		terminatoLabel = new JLabel("Terminato?");
		terminatoLabel.setBounds(414, 150, 97, 20);
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 17));
		creaCorsoPanel.add(terminatoLabel);
		
		descrizioneLabel = new JLabel("  Descrizione:");
		descrizioneLabel.setBounds(414, 222, 97, 14);
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(descrizioneLabel);
		
		areaTematicaLabel = new JLabel("Area Tematica:");
		areaTematicaLabel.setBounds(488, 280, 137, 23);
		areaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		creaCorsoPanel.add(areaTematicaLabel);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setText(corso.getDescrizione());
		descrizioneTextField.setBorder(new LineBorder(Color.BLACK));
		descrizioneTextField.setBounds(521, 218, 333, 25);
		descrizioneTextField.setFont(new Font("Arial", Font.BOLD, 13));
		descrizioneTextField.setColumns(10);
		creaCorsoPanel.add(descrizioneTextField);
		
		alertLabel = new JLabel("Non \u00E8 possibile modificare l'anno");
		alertLabel.setForeground(Color.RED);
		alertLabel.setBounds(521, 109, 168, 14);
		creaCorsoPanel.add(alertLabel);
		
		alertLabel2 = new JLabel("se ci sono lezioni programmate!");
		alertLabel2.setForeground(Color.RED);
		alertLabel2.setBounds(521, 121, 168, 14);
		creaCorsoPanel.add(alertLabel2);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void alertErroreInserimentoMaxPartecipanti() {
		JOptionPane.showMessageDialog(this, "Il massimo numero di partecipanti inserito non e' valido","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreInserimentoPresenzeMin() {
		JOptionPane.showMessageDialog(this, "Le presenze minime inserite non sono valide","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertInserimentoEffettuato() {
		
		JOptionPane.showMessageDialog(this, "Corso modificato correttamente","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);

		GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
		setVisible(false);
	}
	
	public void alertInserimentoNonEffettuato(String state) {

		if(state.equals("-1")) 
			JOptionPane.showMessageDialog(this, "Errore sconosciuto, impossibile creare il corso ","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else 
			if(state.equals("23505"))
				JOptionPane.showMessageDialog(this, "Impossibile modificare il corso, esiste gia' un corso con lo stesso nome" +  state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Impossibile creare il corso: codice errore " +  state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}

	public void gestoreCreazioneStudente() {
		
		String nome = nomeTextField.getText().toLowerCase();
		String descrizione = descrizioneTextField.getText().toLowerCase();
		String anno = String.valueOf(annoChooser.getYear());
		String presenzeMin = presenzeMinTextField.getText();
		String maxPartecipanti = maxPartecipantiTextField.getText();
		boolean terminato;
		Vector<ParoleChiave> paroleChiave = theController.getParoleSelezionate(listaParole, parole);
		Vector<AreeTematiche> aree = theController.getAreeSelezionate(listaTemi, areeTematiche);
		
		if(terminatoCheckBox.isSelected())
			terminato = true;
		else
			terminato = false;
		
		if(!theController.isDigits(presenzeMin))
			alertErroreInserimentoPresenzeMin();
		else
			if(!theController.isDigits(maxPartecipanti))
				alertErroreInserimentoMaxPartecipanti();
			else {
					
					String state = theController.modificaCorsoClicked(nome, descrizione, paroleChiave, anno, presenzeMin, maxPartecipanti, terminato, corso.getIdCorso(), operatore.getIdOperatore() , aree);
						
					if(state.equals("0"))
						alertInserimentoEffettuato();
					else
						alertInserimentoNonEffettuato(state);
			}
	}
}
