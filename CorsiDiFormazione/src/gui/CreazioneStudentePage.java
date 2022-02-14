package gui;

import dto.Operatori;
import dto.Studenti;
import utilities.JCheckBoxList;
import dto.Corsi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class CreazioneStudentePage extends JFrame {

	private Operatori operatore;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	
	
	private JPanel creaStudentePanel;
	private JPanel inserisciDatiStudentePanel;
	private JLabel inserireDatiStudenteLabel;
	private JLabel inserireNomeStudenteLabel;
	private JLabel inserireCognomeStudenteLabel;
	private JLabel corsiDovePoterIscrivereLable;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JScrollPane corsiScrollPane;
	private JCheckBoxList corsiList;
	private JButton confermaButton;
	private JButton indietroButton;
	private Vector<Corsi> corsi;
	
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	
	public CreazioneStudentePage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		corsi = theController.getCorsiDisponibiliOperatore(operatore);
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		creaStudentePanel = new JPanel();
		creaStudentePanel.setBackground(blu);
		creaStudentePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(creaStudentePanel);
		creaStudentePanel.setLayout(null);
		
		inserisciDatiStudentePanel = new JPanel();
		inserisciDatiStudentePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		inserisciDatiStudentePanel.setBounds(10, 11, 548, 307);
		inserisciDatiStudentePanel.setBackground(grigioChiaro);
		creaStudentePanel.add(inserisciDatiStudentePanel);
		inserisciDatiStudentePanel.setLayout(null);
			
		inserireNomeStudenteLabel = new JLabel("Inserire Nome Studente:");
		inserireNomeStudenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		inserireNomeStudenteLabel.setBounds(59, 68, 183, 39);
		inserisciDatiStudentePanel.add(inserireNomeStudenteLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(59, 97, 191, 20);
		nomeTextField.setColumns(10);
		inserisciDatiStudentePanel.add(nomeTextField);
		
		inserireCognomeStudenteLabel = new JLabel("Inserire cognome Studente:");
		inserireCognomeStudenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		inserireCognomeStudenteLabel.setBounds(296, 68, 203, 39);
		inserisciDatiStudentePanel.add(inserireCognomeStudenteLabel);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setBounds(296, 97, 191, 20);
		inserisciDatiStudentePanel.add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		inserireDatiStudenteLabel = new JLabel("INSERIRE DATI STUDENTE");
		inserireDatiStudenteLabel.setForeground(Color.BLACK);
		inserireDatiStudenteLabel.setFont(new Font("Arial", Font.BOLD, 22));
		inserireDatiStudenteLabel.setBackground(Color.WHITE);
		inserireDatiStudenteLabel.setBounds(127, 11, 300, 26);
		inserisciDatiStudentePanel.add(inserireDatiStudenteLabel);
		
		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(183, 146, 175, 137);
		inserisciDatiStudentePanel.add(corsiScrollPane);
		corsiScrollPane.setBorder(new LineBorder(Color.BLACK));
		
		corsiList = new JCheckBoxList();
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setModel(theController.setModelCheckBoxCorsi(corsi));
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBackground(azzurroChiaro);
		corsiList.setVisibleRowCount(10);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nomeTextField.getText().equals("") || cognomeTextField.getText().equals(""))
					alertNomeCognomeMancante();
				else
					gestioneCreazioneStudente();
				
			}
		});
		confermaButton.setBounds(412, 273, 126, 23);
		inserisciDatiStudentePanel.add(confermaButton);
		
		corsiDovePoterIscrivereLable = new JLabel("Corsi dove poter iscrivere lo Studente");
		corsiDovePoterIscrivereLable.setFont(new Font("Arial", Font.BOLD, 15));
		corsiDovePoterIscrivereLable.setBounds(137, 118, 283, 39);
		inserisciDatiStudentePanel.add(corsiDovePoterIscrivereLable);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				indietroButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				indietroButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreStudentiPage gsp = new GestoreStudentiPage(theController, operatore);
				setVisible(false);
			}
		});
		indietroButton.setBounds(10, 273, 126, 23);
		inserisciDatiStudentePanel.add(indietroButton);
		
		setLocationRelativeTo(null);
		setVisible(true);
		if(corsi.isEmpty())
			alertNessunCorsoDisponibile();
	}
	
	
	public void gestioneCreazioneStudente() {
		
		Studenti studente = new Studenti(nomeTextField.getText(), cognomeTextField.getText());
		Vector<Corsi> vettoreCorsi = theController.getCorsiSelezionati(corsiList, corsi);
		String state = theController.creaStudente(studente, corsi);
		
		if(state.equals("0"))
			alertCreazioneEffettuata();
		else
			alertCreazioneFallita(state);
	}
	
	public void alertCreazioneEffettuata() {
		
		JOptionPane.showMessageDialog(this, "Studente creato con successo","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		GestoreStudentiPage page = new GestoreStudentiPage(theController, operatore);
		setVisible(false);
	}
	
	public void alertCreazioneFallita(String state) {
		
		if(state.equals("-1"))
			JOptionPane.showMessageDialog(this, "Creazione dello studente fallita a causa di un errore sconosciuto","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Creazione dello studente fallita.\nCodice d'errore: " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
	
	public void alertNomeCognomeMancante() {
		
		JOptionPane.showMessageDialog(this, "Inserire tutti i campi per creare uno studente","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void alertNessunCorsoDisponibile() {
		JOptionPane.showMessageDialog(this, "Non ci sono Corsi disponibili.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);		
	}
}
