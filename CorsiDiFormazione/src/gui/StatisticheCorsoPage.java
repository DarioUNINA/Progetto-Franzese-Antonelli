package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Corsi;
import dto.Operatori;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import dto.Studenti;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Cursor;

public class StatisticheCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private Corsi corso;

	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel infoPanel;
	private JPanel sfondoPane;
	private JPanel statistichePanel;
	private JPanel studentiPanel;
	private JLabel statisticheCorsoLabel;
	private JLabel nomeCorsoLabel;
	private JLabel numeroMinPresenzeLezioneLabel;
	private JLabel numeroMaxPresenzeLezioneLabel;
	private JLabel percentualeRiempimentoLabel;
	private JLabel presenzeMedieLabel;
	private JProgressBar mediaRiempimentoProgressBar;
	private Vector<String> studenti;
	private JLabel studentiIscrittiLabel;
	private JLabel studentiAmmessiLabel;
	private JLabel numeroLezioniLabel;
	private JButton indietroButton;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color grigio;
	final Color grigioChiaro;
	private JList<String> studentiList;
	private JScrollPane studenitAmmessiScrollPane;
	private JLabel terminatoLabel;
	private JLabel terminatoValueLabel;
	private JLabel terminatoNoLabel;
	
	public StatisticheCorsoPage(Controller cont, Operatori operatore, Corsi corso) {
		
		theController = cont;
		this.operatore = operatore;
		this.corso = corso;
		studenti = theController.setAllStudentiAmmessi(corso.getIdCorso());
		studentiList = new JList<String>(studenti);
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		grigio = new Color(205,205,205);
		grigioChiaro = new Color(233,233,233);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());

		setResizable(false);
		
		getContentPane().setBackground(grigio);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		sfondoPane = new JPanel();
		sfondoPane.setBackground(azzurro);
		sfondoPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		statistichePanel = new JPanel();
		statistichePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		statistichePanel.setBackground(grigioChiaro);
		statistichePanel.setBounds(10, 11, 864, 44);
		sfondoPane.add(statistichePanel);
		statistichePanel.setLayout(null);
		
		statisticheCorsoLabel = new JLabel("STATISTICHE CORSO");
		statisticheCorsoLabel.setBounds(315, 7, 234, 26);
		statisticheCorsoLabel.setForeground(Color.BLACK);
		statisticheCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		statisticheCorsoLabel.setBackground(Color.WHITE);
		statistichePanel.add(statisticheCorsoLabel);
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		infoPanel.setBackground(grigioChiaro);
		infoPanel.setBounds(332, 66, 542, 484);
		sfondoPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		nomeCorsoLabel = new JLabel("Corso: " + corso.getNome().toUpperCase());
		nomeCorsoLabel.setBounds(10, 11, 522, 24);
		infoPanel.add(nomeCorsoLabel);
		nomeCorsoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		numeroMinPresenzeLezioneLabel = new JLabel("Numero Min di presenze a Lezione: " + theController.minimoPresenze(corso.getIdCorso()));
		numeroMinPresenzeLezioneLabel.setBounds(10, 167, 522, 24);
		infoPanel.add(numeroMinPresenzeLezioneLabel);
		numeroMinPresenzeLezioneLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		numeroMaxPresenzeLezioneLabel = new JLabel("Numero Max di presenze a Lezione: " + theController.massimoPresenze(corso.getIdCorso()));
		numeroMaxPresenzeLezioneLabel.setFont(new Font("Arial", Font.BOLD, 20));
		numeroMaxPresenzeLezioneLabel.setBounds(10, 256, 522, 24);
		infoPanel.add(numeroMaxPresenzeLezioneLabel);
		
		presenzeMedieLabel = new JLabel("Presenze medie per lezione: " + String.valueOf(theController.getPresenzeMedie(corso.getIdCorso())));
		presenzeMedieLabel.setBounds(10, 337, 329, 24);
		infoPanel.add(presenzeMedieLabel);
		presenzeMedieLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		percentualeRiempimentoLabel = new JLabel("Percentuale Riempimento Lezioni:");
		percentualeRiempimentoLabel.setBounds(118, 418, 346, 24);
		infoPanel.add(percentualeRiempimentoLabel);
		percentualeRiempimentoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		mediaRiempimentoProgressBar = new JProgressBar();
		mediaRiempimentoProgressBar.setBounds(75, 453, 418, 20);		
		mediaRiempimentoProgressBar.setBackground(Color.WHITE);
		mediaRiempimentoProgressBar.setForeground(Color.BLACK);
		mediaRiempimentoProgressBar.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 13));
		mediaRiempimentoProgressBar.setStringPainted(true);
		mediaRiempimentoProgressBar.setValue((int)theController.getPresenzeMedie(corso.getIdCorso())/studenti.size());
		infoPanel.add(mediaRiempimentoProgressBar);
		
		terminatoLabel = new JLabel("Terminato: " );
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		terminatoLabel.setBounds(10, 86, 109, 24);
		infoPanel.add(terminatoLabel);
		
		terminatoValueLabel = new JLabel("SI");
		terminatoValueLabel.setForeground(Color.RED);
		terminatoValueLabel.setFont(new Font("Arial", Font.BOLD, 20));
		terminatoValueLabel.setBounds(140, 86, 30, 24);
		infoPanel.add(terminatoValueLabel);
		
		if(corso.isTerminato()) {
			terminatoValueLabel.setText("SI");
			terminatoValueLabel.setForeground(Color.RED);
		}else {
			terminatoValueLabel.setText("NO");
			terminatoValueLabel.setForeground(Color.GREEN);
		}
		
		studentiPanel = new JPanel();
		studentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentiPanel.setBounds(10, 66, 312, 484);
		sfondoPane.add(studentiPanel);
		studentiPanel.setLayout(null);
		
		studenitAmmessiScrollPane = new JScrollPane();
		studenitAmmessiScrollPane.setBounds(10, 31, 292, 284);
		studentiPanel.add(studenitAmmessiScrollPane);
		
		studenitAmmessiScrollPane.setViewportView(studentiList);
		studentiList.setVisibleRowCount(10);
		studentiList.setFont(new Font("Arial", Font.BOLD, 18));
		studentiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		studentiList.setBackground(new Color(136, 187, 214));
		
		studentiIscrittiLabel = new JLabel("Studenti Iscritti (" + studenti.size() + ")");
		studentiIscrittiLabel.setBounds(66, 0, 189, 33);
		studentiPanel.add(studentiIscrittiLabel);
		studentiIscrittiLabel.setFont(new Font("Arial", Font.BOLD, 20));
	
		studentiAmmessiLabel = new JLabel("Studenti Ammessi : " + theController.getNumeroStudentiAmmessi(corso.getIdCorso()));
		studentiAmmessiLabel.setFont(new Font("Arial", Font.BOLD, 20));
		studentiAmmessiLabel.setBounds(10, 326, 254, 24);
		studentiPanel.add(studentiAmmessiLabel);
		
		numeroLezioniLabel = new JLabel("Numero Lezioni: " + theController.getNumeroLezioni(corso.getIdCorso()));
		numeroLezioniLabel.setFont(new Font("Arial", Font.BOLD, 20));
		numeroLezioniLabel.setBounds(10, 378, 384, 26);
		studentiPanel.add(numeroLezioniLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setBounds(10, 446, 292, 27);
		studentiPanel.add(indietroButton);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBackground(Color.WHITE);

		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
