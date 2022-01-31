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

import dto.Operatori;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class PanoramicaLezionePage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;

	public PanoramicaLezionePage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		
		theController = controller;

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
		
		JPanel gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(SystemColor.control);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(10, 11, 548, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(null);
		
		JLabel gestoreLezioniLabel = new JLabel("PANORAMICA LEZIONI");
		gestoreLezioniLabel.setForeground(Color.RED);
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniLabel.setBounds(157, 11, 243, 33);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		JPanel studentiPanel = new JPanel();
		studentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		studentiPanel.setBounds(10, 71, 163, 213);
		contentPane.add(studentiPanel);
		studentiPanel.setLayout(null);
		
		JLabel selezionaCorsoLabel = new JLabel("Studenti Iscritti");
		selezionaCorsoLabel.setBounds(21, 7, 114, 18);
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		studentiPanel.add(selezionaCorsoLabel);
		
		JList studentiList = new JList();
		studentiList.setBounds(10, 36, 143, 166);
		studentiPanel.add(studentiList);
		studentiList.setVisibleRowCount(10);
		studentiList.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton indietroButton = new JButton("INDIETRO");
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
		
		JPanel lezioniPanel = new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(183, 71, 375, 213);
		contentPane.add(lezioniPanel);
		lezioniPanel.setLayout(null);
		
		JLabel dettagliLezioneLabel = new JLabel("Dettagli Lezione");
		dettagliLezioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dettagliLezioneLabel.setBounds(127, 11, 124, 18);
		lezioniPanel.add(dettagliLezioneLabel);
		
		JLabel titoloLabel = new JLabel("Titolo:");
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(10, 57, 45, 18);
		lezioniPanel.add(titoloLabel);
		
		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dataLabel.setBounds(215, 97, 36, 18);
		lezioniPanel.add(dataLabel);
		
		JLabel descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(10, 135, 124, 18);
		lezioniPanel.add(descrizioneLabel);
		
		JLabel durataLabel = new JLabel("Durata:");
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(200, 57, 51, 18);
		lezioniPanel.add(durataLabel);
		
		JLabel orarioLabel = new JLabel("Orario:");
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(10, 97, 51, 18);
		lezioniPanel.add(orarioLabel);
		
		JTextPane descrizioneTextPane = new JTextPane();
		descrizioneTextPane.setBounds(102, 133, 263, 69);
		lezioniPanel.add(descrizioneTextPane);
		
		JButton aggiungiStudenteLezioneButton = new JButton("AGGIUNGI STUDENTE ALLA LEZIONE");
		aggiungiStudenteLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiStudenteLezionePage asl = new AggiungiStudenteLezionePage(theController, operatore);
				setVisible(false);
			}
		});
		aggiungiStudenteLezioneButton.setBounds(10, 296, 244, 23);
		contentPane.add(aggiungiStudenteLezioneButton);
		aggiungiStudenteLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		setVisible(true);
	}
}
