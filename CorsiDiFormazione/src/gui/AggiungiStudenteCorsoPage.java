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
import dto.Studenti;

public class AggiungiStudenteCorsoPage extends JFrame {

	private Operatori operatore;
	private Studenti studente;
	private Controller theController;

	private JPanel contentPane;
	private Component url;
	private ImageIcon imageicon;
	private JPanel prenotaLezioneStudentiPanel;
	private JLabel aggiungiStudenteAlCorsoLabel;
	private JButton indietroButton;
	private JButton aggiungiButton;
	private JLabel selezionareCorsoLabel;
	private JComboBox corsiComboBox;
	private JLabel datiStudenteLabel;
	

	
	public AggiungiStudenteCorsoPage(Controller controller, Operatori operatore, Studenti studente) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		this.studente = studente;

		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prenotaLezioneStudentiPanel.setBackground(SystemColor.control);
		prenotaLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		prenotaLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(prenotaLezioneStudentiPanel);
		prenotaLezioneStudentiPanel.setLayout(null);
		
		aggiungiStudenteAlCorsoLabel = new JLabel("AGGIUNGI STUDENTE AL CORSO");
		aggiungiStudenteAlCorsoLabel.setForeground(new Color(65, 105, 225));
		aggiungiStudenteAlCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		aggiungiStudenteAlCorsoLabel.setBackground(Color.WHITE);
		aggiungiStudenteAlCorsoLabel.setBounds(98, 11, 367, 33);
		prenotaLezioneStudentiPanel.add(aggiungiStudenteAlCorsoLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanoramicaSingoloStudentePage gss = new PanoramicaSingoloStudentePage(theController, operatore, studente);
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
		indietroButton.setBounds(10, 273, 121, 23);
		prenotaLezioneStudentiPanel.add(indietroButton);
		
		aggiungiButton = new JButton("AGGIUGI");
		aggiungiButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				aggiungiButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				aggiungiButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		aggiungiButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiButton.setBounds(417, 274, 121, 23);
		prenotaLezioneStudentiPanel.add(aggiungiButton);
		
		selezionareCorsoLabel = new JLabel("Selezionare corso:");
		selezionareCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareCorsoLabel.setBounds(51, 131, 136, 23);
		prenotaLezioneStudentiPanel.add(selezionareCorsoLabel);
		
		corsiComboBox = new JComboBox(theController.setIscrizioneCorsiStudente(studente.getMatricola(), operatore.getIdOperatore()));
		corsiComboBox.setBounds(193, 132, 163, 22);
		prenotaLezioneStudentiPanel.add(corsiComboBox);
		
		datiStudenteLabel = new JLabel("STUDENTE:" + studente.getMatricola() + ", " + studente.getCognome() + ", " + studente.getNome());
		datiStudenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		datiStudenteLabel.setBounds(51, 55, 414, 14);
		prenotaLezioneStudentiPanel.add(datiStudenteLabel);
		
		setVisible(true);
	}

}
