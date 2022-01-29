package gui;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EliminaCorsoPage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Operatori operatore;
	private Component url;
	private ImageIcon imageicon;


	
	public EliminaCorsoPage(Controller controller, Operatori operatore) {
		
		theController = controller;
		this.operatore = operatore;
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel eliminaCorsoPanel = new JPanel();
		eliminaCorsoPanel.setBackground(SystemColor.control);
		eliminaCorsoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		eliminaCorsoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(eliminaCorsoPanel);
		eliminaCorsoPanel.setLayout(null);
		
		JLabel eliminazioneCorsoLabel = new JLabel("ELIMINAZIONE CORSO");
		eliminazioneCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		eliminazioneCorsoLabel.setForeground(Color.BLACK);
		eliminazioneCorsoLabel.setBackground(Color.WHITE);
		eliminazioneCorsoLabel.setBounds(153, 11, 247, 33);
		eliminaCorsoPanel.add(eliminazioneCorsoLabel);
		
		JLabel selezionaCorsoLabel = new JLabel("Selezionare Corso da voler eliminare:");
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionaCorsoLabel.setForeground(Color.RED);
		selezionaCorsoLabel.setBounds(138, 75, 267, 23);
		eliminaCorsoPanel.add(selezionaCorsoLabel);
		
		JComboBox corsiComboBox = new JComboBox(theController.getCorsiOperatore(operatore));
		corsiComboBox.setBounds(193, 122, 165, 22);
		eliminaCorsoPanel.add(corsiComboBox);
		
		JButton confermaButton = new JButton("CONFERMA");
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
		eliminaCorsoPanel.add(indietroButton);
		
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
			theController.eliminaCorso(corso);
		}
			
		}
		
}
