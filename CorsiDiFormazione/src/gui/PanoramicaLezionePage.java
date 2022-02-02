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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Lezioni;
import dto.Operatori;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class PanoramicaLezionePage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	private Lezioni lezione;
	
	private JList studentiList;
	
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
	
	
	public PanoramicaLezionePage(Controller controller, Operatori operatore, Lezioni lezione) {
		setResizable(false);
		
		
		theController = controller;
		this.operatore = operatore;
		this.lezione = lezione;
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(SystemColor.control);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(10, 11, 548, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(null);
		
		gestoreLezioniLabel = new JLabel("PANORAMICA LEZIONI");
		gestoreLezioniLabel.setForeground(Color.BLACK);
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniLabel.setBounds(157, 11, 243, 33);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		studentiPanel = new JPanel();
		studentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		
		studentiList = new JList();
		studentiScrollPane.setViewportView(studentiList);
		studentiList.setVisibleRowCount(10);
		studentiList.setFont(new Font("Arial", Font.BOLD, 15));
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreLezioniPage gl = new GestoreLezioniPage(theController, operatore);
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
		indietroButton.setBounds(395, 295, 163, 23);
		contentPane.add(indietroButton);
		
		lezioniPanel = new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
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
		descrizioneTextPane.setBackground(SystemColor.control);
		descrizioneTextPane.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneTextPane.setBounds(102, 133, 263, 69);
		lezioniPanel.add(descrizioneTextPane);
		descrizioneTextPane.setText(lezione.getDescrizione());
		
		aggiungiStudenteLezioneButton = new JButton("AGGIUNGI STUDENTE ALLA LEZIONE");
		aggiungiStudenteLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiStudenteLezionePage asl = new AggiungiStudenteLezionePage(theController, operatore, lezione);
				setVisible(false);
			}
		});
		aggiungiStudenteLezioneButton.setBounds(10, 296, 244, 23);
		contentPane.add(aggiungiStudenteLezioneButton);
		aggiungiStudenteLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		setVisible(true);
	}
}

