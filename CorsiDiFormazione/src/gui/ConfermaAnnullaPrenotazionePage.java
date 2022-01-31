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

public class ConfermaAnnullaPrenotazionePage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;
	
	public ConfermaAnnullaPrenotazionePage(Controller controller, Operatori operatore) {
		
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
		
		JPanel annullaPrenotaLezioneStudentiPanel = new JPanel();
		annullaPrenotaLezioneStudentiPanel.setBackground(SystemColor.control);
		annullaPrenotaLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		annullaPrenotaLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(annullaPrenotaLezioneStudentiPanel);
		annullaPrenotaLezioneStudentiPanel.setLayout(null);
		
		JLabel annullaPrenotazioneLezioneLabel = new JLabel("ANNULLA PRENOTAZIONE");
		annullaPrenotazioneLezioneLabel.setForeground(new Color(65, 105, 225));
		annullaPrenotazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		annullaPrenotazioneLezioneLabel.setBackground(Color.WHITE);
		annullaPrenotazioneLezioneLabel.setBounds(130, 11, 290, 33);
		annullaPrenotaLezioneStudentiPanel.add(annullaPrenotazioneLezioneLabel);
		
		JButton indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnnullaPrenotazionePage ap = new AnnullaPrenotazionePage(theController, operatore);
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
		annullaPrenotaLezioneStudentiPanel.add(indietroButton);
		
		JButton confermaButton = new JButton("CONFERMA");
		confermaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		annullaPrenotaLezioneStudentiPanel.add(confermaButton);
		
		JLabel selezionareLezioneLabel = new JLabel("Selezionare lezione:");
		selezionareLezioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareLezioneLabel.setBounds(42, 131, 145, 23);
		annullaPrenotaLezioneStudentiPanel.add(selezionareLezioneLabel);
		
		JComboBox lezioniComboBox = new JComboBox();
		lezioniComboBox.setBounds(193, 132, 163, 22);
		annullaPrenotaLezioneStudentiPanel.add(lezioniComboBox);
		
		setVisible(true);
	}

}
