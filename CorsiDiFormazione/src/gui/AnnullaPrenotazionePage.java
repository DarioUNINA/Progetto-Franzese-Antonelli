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

public class AnnullaPrenotazionePage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;
	private Studenti studente;
	
	public AnnullaPrenotazionePage(Controller controller, Operatori operatore,Studenti studente) {
		setResizable(false);
		
		theController = controller;

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
		
		JPanel annullaLezioneStudentiPanel = new JPanel();
		annullaLezioneStudentiPanel.setBackground(SystemColor.control);
		annullaLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		annullaLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(annullaLezioneStudentiPanel);
		annullaLezioneStudentiPanel.setLayout(null);
		
		JLabel annullaPrenotazioneLezioneLabel = new JLabel("ANNULLA PRENOTAZIONE ");
		annullaPrenotazioneLezioneLabel.setForeground(new Color(65, 105, 225));
		annullaPrenotazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		annullaPrenotazioneLezioneLabel.setBackground(Color.WHITE);
		annullaPrenotazioneLezioneLabel.setBounds(127, 11, 301, 33);
		annullaLezioneStudentiPanel.add(annullaPrenotazioneLezioneLabel);
		
		JButton indietroButton = new JButton("INDIETRO");
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
		annullaLezioneStudentiPanel.add(indietroButton);
		
		JButton confermaButton = new JButton("CONFERMA");
		confermaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ConfermaAnnullaPrenotazionePage cap = new ConfermaAnnullaPrenotazionePage(theController, operatore, studente);
				setVisible(false);
			}
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		annullaLezioneStudentiPanel.add(confermaButton);
		
		JLabel selezionareCorsoLabel = new JLabel("Selezionare corso:");
		selezionareCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareCorsoLabel.setBounds(51, 131, 136, 23);
		annullaLezioneStudentiPanel.add(selezionareCorsoLabel);
		
		JComboBox corsiComboBox = new JComboBox();
		corsiComboBox.setBounds(193, 132, 163, 22);
		annullaLezioneStudentiPanel.add(corsiComboBox);
		
		setVisible(true);
	}

}
