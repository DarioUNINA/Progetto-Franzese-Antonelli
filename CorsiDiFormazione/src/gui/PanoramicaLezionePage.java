package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Lezioni;
import dto.Operatori;
import dto.Studenti;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.FlowLayout;

public class PanoramicaLezionePage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private Lezioni lezione;
	private Vector<Studenti> studenti;
	
	private JList<Studenti> studentiList;
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel gestoreLezioniPanel;
	private JLabel gestoreLezioniLabel;
	private JPanel studentiPanel;
	private JLabel studentiIscrittiLabel;
	private JScrollPane studentiScrollPane;
	private JButton indietroButton;
	private JPanel lezioniPanel;
	private JLabel dettagliLezioneLabel;
	private JLabel titoloLabel;
	private JLabel dataLabel;
	private JLabel descrizioneLabel;
	private JLabel durataLabel;
	private JLabel orarioLabel;
	private JTextPane descrizioneTextPane;
	private JButton aggiungiStudenteLezioneButton;
	private JButton modificaLezioneButton;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public PanoramicaLezionePage(Controller controller, Operatori operatore, Lezioni lezione) {
		setResizable(false);
		
		
		theController = controller;
		this.operatore = operatore;
		this.lezione = lezione;
		studenti = theController.getAllStudentiIscrittiAllaLezione(lezione.getIdLezione());
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		studentiList = new JList<Studenti>(studenti);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		
		contentPane = new JPanel();
		contentPane.setBackground(blu);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(grigioChiaro);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(10, 11, 548, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		gestoreLezioniLabel = new JLabel("PANORAMICA LEZIONE");
		gestoreLezioniLabel.setForeground(Color.BLACK);
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		studentiPanel = new JPanel();
		studentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentiPanel.setBackground(grigioChiaro);
		studentiPanel.setBounds(10, 71, 163, 213);
		contentPane.add(studentiPanel);
		studentiPanel.setLayout(null);
		
		studentiIscrittiLabel = new JLabel("Studenti Iscritti");
		studentiIscrittiLabel.setBounds(21, 7, 114, 18);
		studentiIscrittiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		studentiPanel.add(studentiIscrittiLabel);
		
		studentiScrollPane = new JScrollPane();
		studentiScrollPane.setBounds(10, 36, 143, 166);
		studentiPanel.add(studentiScrollPane);
		
		studentiScrollPane.setViewportView(studentiList);
		studentiList.setVisibleRowCount(10);
		studentiList.setBackground(azzurroChiaro);
		studentiList.setFont(new Font("Arial", Font.BOLD, 15));
		studentiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);	
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 295, 163, 23);
		contentPane.add(indietroButton);
		
		lezioniPanel = new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBackground(grigioChiaro);
		lezioniPanel.setBounds(183, 71, 375, 213);
		contentPane.add(lezioniPanel);
		lezioniPanel.setLayout(null);
		
		dettagliLezioneLabel = new JLabel("Dettagli Lezione");
		dettagliLezioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dettagliLezioneLabel.setBounds(127, 11, 124, 18);
		lezioniPanel.add(dettagliLezioneLabel);
		
		titoloLabel = new JLabel("Titolo: " + lezione.getTitolo() );
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(10, 57, 195, 18);
		lezioniPanel.add(titoloLabel);
		
		dataLabel = new JLabel("Data: " + lezione.getData());
		dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dataLabel.setBounds(215, 97, 150, 18);
		lezioniPanel.add(dataLabel);
		
		descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(10, 135, 124, 18);
		lezioniPanel.add(descrizioneLabel);
		
		durataLabel = new JLabel("Durata: " + lezione.getDurata());
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(215, 57, 150, 18);
		lezioniPanel.add(durataLabel);
		
		orarioLabel = new JLabel("Orario: " + lezione.getOrario());
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(10, 97, 195, 18);
		lezioniPanel.add(orarioLabel);
		
		descrizioneTextPane = new JTextPane();
		descrizioneTextPane.setEditable(false);
		descrizioneTextPane.setBackground(grigioChiaro);
		descrizioneTextPane.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneTextPane.setBounds(102, 133, 263, 69);
		lezioniPanel.add(descrizioneTextPane);
		descrizioneTextPane.setText(lezione.getDescrizione());
		
		aggiungiStudenteLezioneButton = new JButton("AGGIUNGI STUDENTE ALLA LEZIONE");
		aggiungiStudenteLezioneButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		aggiungiStudenteLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aggiungiStudenteLezioneButton.setBackground(Color.WHITE);
		aggiungiStudenteLezioneButton.setBounds(342, 295, 216, 23);
		contentPane.add(aggiungiStudenteLezioneButton);
		aggiungiStudenteLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		modificaLezioneButton = new JButton("MODIFICA LEZIONE");
		modificaLezioneButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificaLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		modificaLezioneButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		modificaLezioneButton.setBackground(Color.WHITE);
		modificaLezioneButton.setBounds(183, 296, 152, 22);
		contentPane.add(modificaLezioneButton);
		
		
		//LISTNER
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.gestoreLezioniPage(operatore);
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
		
		
		aggiungiStudenteLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestoreAggiungiStudente();
				
			}
		});
		
		
		modificaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.modificaLezionePage(operatore, lezione);
				setVisible(false);
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	//ALERT
	public void alertNonCiSonoStudenti() {
		JOptionPane.showMessageDialog(this, "Non ci sono Studenti da poter aggiungere alla lezione","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	
	//GESTORI
	
	public void gestoreAggiungiStudente() {
		
		if(theController.getStudentiCorso(lezione.getIdCorso(), lezione.getIdLezione()).isEmpty()) {
			alertNonCiSonoStudenti();
		}else {
			theController.aggiungiStudenteLezionePage(operatore, lezione);
			setVisible(false);
		}
	}
}

