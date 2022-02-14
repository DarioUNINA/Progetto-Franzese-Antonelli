package gui;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;

import dto.Corsi;
import dto.Operatori;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class EliminaCorsoPage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	
	private ImageIcon imageicon;
	private Component url;
	private JPanel contentPane;
	private JComboBox corsiComboBox;
	private JButton confermaButton;
	private JPanel eliminaCorsoPanel;
	private JLabel eliminazioneCorsoLabel;
	private JButton indietroButton;
	private JLabel selezionaCorsoLabel;
	private Vector <Corsi> corsi;

	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public EliminaCorsoPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		

		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eliminaCorsoPanel = new JPanel();
		eliminaCorsoPanel.setBackground(grigioChiaro);
		eliminaCorsoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		eliminaCorsoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(eliminaCorsoPanel);
		eliminaCorsoPanel.setLayout(null);
		
		eliminazioneCorsoLabel = new JLabel("ELIMINAZIONE CORSO");
		eliminazioneCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		eliminazioneCorsoLabel.setForeground(Color.BLACK);
		eliminazioneCorsoLabel.setBackground(Color.WHITE);
		eliminazioneCorsoLabel.setBounds(153, 11, 247, 33);
		eliminaCorsoPanel.add(eliminazioneCorsoLabel);
		
		selezionaCorsoLabel = new JLabel("Selezionare Corso da voler eliminare:");
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionaCorsoLabel.setForeground(Color.RED);
		selezionaCorsoLabel.setBounds(138, 75, 267, 23);
		eliminaCorsoPanel.add(selezionaCorsoLabel);
		
		corsi = theController.getCorsiOperatore(operatore);
		corsiComboBox = new JComboBox(corsi);
		corsiComboBox.setFont(new Font("Arial", Font.BOLD, 13));
		corsiComboBox.setBounds(193, 122, 165, 22);
		eliminaCorsoPanel.add(corsiComboBox);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(corsiComboBox.getSelectedItem()==null)
					alertCorsoNonSelezionato();
				else
					alertConfermaEliminazioneCorso(corsiComboBox.getSelectedItem().toString());
					
				
			}
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(193, 170, 165, 33);
		eliminaCorsoPanel.add(confermaButton);

		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
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
		eliminaCorsoPanel.add(indietroButton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void alertCorsoNonSelezionato() {
		JOptionPane.showMessageDialog(this, "Selezionare un corso!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	
	public void alertConfermaEliminazioneCorso(String corso) {
		Object[] opzioni = {"Sì"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler eliminare il corso " + corso + " ?",
				"CONFERMA DI USCITA",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			String state = theController.eliminaCorso(corso);
			
			if(state.equals("0"))
				alertEliminazioneEffettuata();
			else
				alertEliminazioneFallita(state);
			
			
		}
			
	}
	
	public void alertEliminazioneEffettuata() {
		
		JOptionPane.showMessageDialog(this, "Corso eliminato con successo","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);

		GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
		setVisible(false);
		
	}
	
	public void alertEliminazioneFallita(String state) {
		
		if(state.equals("-1"))
			JOptionPane.showMessageDialog(this, "Impossibile eliminare il corso a causa di un errore sconosciuto","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Impossibile eliminare il corso, codice d'errore: " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);


	}

}
