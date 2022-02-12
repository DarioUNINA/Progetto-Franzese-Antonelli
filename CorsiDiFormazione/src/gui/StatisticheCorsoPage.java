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

public class StatisticheCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private Corsi corso;
	private JList<String> studentiList;

	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel sfondoPane;
	private JPanel statistichePanel;
	private JLabel statisticheCorsoLabel;
	private JLabel nomeCorsoLabel;
	private JLabel numeroMinPresenzeLezioneLabel;
	private JLabel numeroMaxPresenzeLezioneLabel;
	private JLabel presenzeMedieLabel;
	private JLabel studentiAmmessiLabel;
	private JScrollPane studentiAmmessiScrollPane;
	private JButton indietroButton;
	private JProgressBar mediaRiempimentoProgressBar;
	private Vector<String> studenti;

	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color grigio;
	final Color grigioChiaro;
	
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
		statistichePanel.setBounds(10, 11, 864, 539);
		sfondoPane.add(statistichePanel);
		statistichePanel.setLayout(null);
		
		statisticheCorsoLabel = new JLabel("STATISTICHE CORSO");
		statisticheCorsoLabel.setBounds(315, 7, 234, 26);
		statisticheCorsoLabel.setForeground(Color.BLACK);
		statisticheCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		statisticheCorsoLabel.setBackground(Color.WHITE);
		statistichePanel.add(statisticheCorsoLabel);
		
		nomeCorsoLabel = new JLabel("Corso: " + corso.getNome().toUpperCase());
		nomeCorsoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		nomeCorsoLabel.setBounds(60, 103, 412, 24);
		statistichePanel.add(nomeCorsoLabel);
		
		numeroMinPresenzeLezioneLabel = new JLabel("Numero Min di presenze a Lezione: " + theController.minimoPresenze(corso.getIdCorso()));
		numeroMinPresenzeLezioneLabel.setFont(new Font("Arial", Font.BOLD, 20));
		numeroMinPresenzeLezioneLabel.setBounds(22, 275, 450, 24);
		statistichePanel.add(numeroMinPresenzeLezioneLabel);
		
		numeroMaxPresenzeLezioneLabel = new JLabel("Numero Max di presenze a Lezione: " + theController.massimoPresenze(corso.getIdCorso()));
		numeroMaxPresenzeLezioneLabel.setFont(new Font("Arial", Font.BOLD, 20));
		numeroMaxPresenzeLezioneLabel.setBounds(22, 240, 475, 24);
		statistichePanel.add(numeroMaxPresenzeLezioneLabel);
		
		presenzeMedieLabel = new JLabel("Presenze medie per lezione: " + String.valueOf(theController.getPresenzeMedie(corso.getIdCorso())));
		presenzeMedieLabel.setFont(new Font("Arial", Font.BOLD, 20));
		presenzeMedieLabel.setBounds(22, 310, 346, 24);
		statistichePanel.add(presenzeMedieLabel);
		
		studentiAmmessiLabel = new JLabel("Studenti Ammessi : " + theController.getNumeroStudentiAmmessi(corso.getIdOperatore()));
		studentiAmmessiLabel.setFont(new Font("Arial", Font.BOLD, 20));
		studentiAmmessiLabel.setBounds(22, 205, 254, 24);
		statistichePanel.add(studentiAmmessiLabel);
		
		studentiAmmessiScrollPane = new JScrollPane();
		studentiAmmessiScrollPane.setBounds(528, 183, 254, 244);
		statistichePanel.add(studentiAmmessiScrollPane);
		
		studentiAmmessiScrollPane.setViewportView(studentiList);
		studentiList.setVisibleRowCount(10);
		studentiList.setFont(new Font("Arial", Font.BOLD, 18));
		studentiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		studentiList.setBackground(new Color(136, 187, 214));
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreCorsiPage glp = new GestoreCorsiPage(theController, operatore);
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
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 501, 127, 27);
		statistichePanel.add(indietroButton);
		
		JLabel percentualeRiempimentoLabel_1 = new JLabel("Percentuale Riempimento Lezioni:");
		percentualeRiempimentoLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		percentualeRiempimentoLabel_1.setBounds(22, 345, 346, 24);
		statistichePanel.add(percentualeRiempimentoLabel_1);
		
		JLabel numeroLezioniLabel = new JLabel("Numero Lezioni: " + theController.getNumeroLezioni(corso.getIdCorso()));
		numeroLezioniLabel.setFont(new Font("Arial", Font.BOLD, 20));
		numeroLezioniLabel.setBounds(22, 168, 384, 26);
		statistichePanel.add(numeroLezioniLabel);
		
		
		mediaRiempimentoProgressBar = new JProgressBar();
		mediaRiempimentoProgressBar.setBackground(Color.WHITE);
		mediaRiempimentoProgressBar.setForeground(Color.BLACK);
		mediaRiempimentoProgressBar.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 13));
		mediaRiempimentoProgressBar.setStringPainted(true);
		mediaRiempimentoProgressBar.setBounds(32, 380, 302, 20);
		mediaRiempimentoProgressBar.setValue((int)theController.getPresenzeMedie(corso.getIdCorso())/corso.getMaxPartecipanti());
		statistichePanel.add(mediaRiempimentoProgressBar);
		
		JLabel studentiIscrittiLabel = new JLabel("Studenti Iscritti (" + String.valueOf(studenti.size())  + ")");
		studentiIscrittiLabel.setFont(new Font("Arial", Font.BOLD, 20));
		studentiIscrittiLabel.setBounds(548, 158, 189, 14);
		statistichePanel.add(studentiIscrittiLabel);

		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
