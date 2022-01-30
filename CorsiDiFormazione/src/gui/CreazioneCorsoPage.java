package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class CreazioneCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private Component url;
	private ImageIcon imageicon;

	
	private JPanel creazioneCorsiPanel;
	private JTextField nomeTextField;
	private JTextField presenzeMinTextField;
	private JTextField maxPartecipantiTextField;
	private JTextField paroleChiaveTextBox;
	private JTextField annoTextField;
	
	public CreazioneCorsoPage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		creazioneCorsiPanel = new JPanel();
		creazioneCorsiPanel.setBorder(new LineBorder(Color.BLACK));
		setContentPane(creazioneCorsiPanel);
		getContentPane().setBackground(Color.ORANGE);
		creazioneCorsiPanel.setLayout(null);
			

		JPanel creaCorsoPanel = new JPanel();
		creaCorsoPanel.setBounds(10, 11, 548, 307);
		creaCorsoPanel.setBackground(SystemColor.control);
		creaCorsoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		creazioneCorsiPanel.add(creaCorsoPanel);
		creaCorsoPanel.setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(168, 66, 86, 20);
		nomeTextField.setColumns(10);
		creaCorsoPanel.add(nomeTextField);
		
		presenzeMinTextField = new JTextField();
		presenzeMinTextField.setBounds(168, 101, 86, 20);
		presenzeMinTextField.setColumns(10);
		creaCorsoPanel.add(presenzeMinTextField);
		
		maxPartecipantiTextField = new JTextField();
		maxPartecipantiTextField.setBounds(168, 137, 86, 20);
		maxPartecipantiTextField.setColumns(10);
		creaCorsoPanel.add(maxPartecipantiTextField);
		
		paroleChiaveTextBox = new JTextField();
		paroleChiaveTextBox.setBounds(168, 170, 86, 20);
		paroleChiaveTextBox.setColumns(10);
		creaCorsoPanel.add(paroleChiaveTextBox);
		
		JCheckBox terminatoCheckBox = new JCheckBox("SI");
		terminatoCheckBox.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBox.setBounds(383, 99, 39, 23);
		creaCorsoPanel.add(terminatoCheckBox);
		
		annoTextField = new JTextField();
		annoTextField.setBounds(373, 66, 86, 20);
		annoTextField.setColumns(10);
		creaCorsoPanel.add(annoTextField);
		
		JTextPane descrizioneTextPane = new JTextPane();
		descrizioneTextPane.setFont(new Font("Arial", Font.BOLD, 12));
		descrizioneTextPane.setBounds(373, 137, 148, 53);
		descrizioneTextPane.setBorder(new LineBorder(Color.BLACK));
		creaCorsoPanel.add(descrizioneTextPane);
		
		JButton indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp = new HomePage(theController, operatore);
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
		creaCorsoPanel.add(indietroButton);
		
		
		JButton avantiButton = new JButton("AVANTI");
		avantiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				avantiButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				avantiButton.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nome = nomeTextField.getText();
				String descrizione = descrizioneTextPane.getText();
				String paroleChiave = paroleChiaveTextBox.getText();
				String anno = annoTextField.getText();
				String presenzeMin = presenzeMinTextField.getText();
				String maxPartecipanti = maxPartecipantiTextField.getText();
				boolean terminato;
				
				if(terminatoCheckBox.isSelected())
					terminato = true;
				else
					terminato = false;
				
				if(theController.aggiungiCorsoClicked(nome, descrizione, paroleChiave, anno, presenzeMin, maxPartecipanti, terminato, operatore.getIdOperatore()).equals("0"))
					System.out.println("aggiunto");
				else
					System.out.println("non aggiugno");
				
				
				
			}
			
		});
		avantiButton.setFont(new Font("Arial", Font.BOLD, 15));
		avantiButton.setBounds(417, 273, 121, 23);
		creaCorsoPanel.add(avantiButton);
		
		JLabel creazioneCorsoLabel = new JLabel("CREAZIONE CORSO");
		creazioneCorsoLabel.setForeground(Color.BLACK);
		creazioneCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		creazioneCorsoLabel.setBackground(Color.WHITE);
		creazioneCorsoLabel.setBounds(164, 11, 227, 33);
		creaCorsoPanel.add(creazioneCorsoLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomeLabel.setBounds(120, 68, 45, 14);
		creaCorsoPanel.add(nomeLabel);
		
		JLabel presenzeMinimeLabel = new JLabel("Presenze Minime:");
		presenzeMinimeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		presenzeMinimeLabel.setBounds(38, 104, 127, 14);
		creaCorsoPanel.add(presenzeMinimeLabel);
		
		JLabel massimoPartecipantiLabel = new JLabel("Massimo Partecipanti:");
		massimoPartecipantiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		massimoPartecipantiLabel.setBounds(10, 139, 155, 14);
		creaCorsoPanel.add(massimoPartecipantiLabel);
		
		JLabel parolaChiaveLabel = new JLabel("Parola Chiave:");
		parolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 15));
		parolaChiaveLabel.setBounds(62, 172, 103, 14);
		creaCorsoPanel.add(parolaChiaveLabel);
		
		JLabel annoLabel = new JLabel("Anno:");
		annoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		annoLabel.setBounds(331, 68, 45, 14);
		creaCorsoPanel.add(annoLabel);
		
		JLabel terminatoLabel = new JLabel("Terminato?");
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoLabel.setBounds(296, 103, 81, 14);
		creaCorsoPanel.add(terminatoLabel);
		
		JLabel descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(283, 139, 89, 14);
		creaCorsoPanel.add(descrizioneLabel);
		
		
		
		
		setVisible(true);
	}
}
