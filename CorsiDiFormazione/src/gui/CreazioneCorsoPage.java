package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Operatori;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreazioneCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	
	private JPanel creazioneCorsiPane;
	private JTextField nomeTextField;
	private JTextField presenzeMinTextField;
	private JTextField maxPartecipantiTextField;
	private JTextField paroleChiaveTextBox;
	private JTextField descrizioneTextField;
	private JTextField annoTextField;
	
	public CreazioneCorsoPage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		creazioneCorsiPane = new JPanel();
		creazioneCorsiPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(creazioneCorsiPane);
		creazioneCorsiPane.setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(32, 38, 86, 20);
		creazioneCorsiPane.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		presenzeMinTextField = new JTextField();
		presenzeMinTextField.setBounds(32, 70, 86, 20);
		creazioneCorsiPane.add(presenzeMinTextField);
		presenzeMinTextField.setColumns(10);
		
		maxPartecipantiTextField = new JTextField();
		maxPartecipantiTextField.setBounds(32, 102, 86, 20);
		creazioneCorsiPane.add(maxPartecipantiTextField);
		maxPartecipantiTextField.setColumns(10);
		
		paroleChiaveTextBox = new JTextField();
		paroleChiaveTextBox.setBounds(32, 137, 86, 20);
		creazioneCorsiPane.add(paroleChiaveTextBox);
		paroleChiaveTextBox.setColumns(10);
		
		JCheckBox terminatoCheckBox = new JCheckBox("Terminato");
		terminatoCheckBox.setBounds(32, 184, 97, 23);
		creazioneCorsiPane.add(terminatoCheckBox);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setBounds(245, 38, 146, 52);
		creazioneCorsiPane.add(descrizioneTextField);
		descrizioneTextField.setColumns(10);
		
		annoTextField = new JTextField();
		annoTextField.setBounds(245, 115, 86, 20);
		creazioneCorsiPane.add(annoTextField);
		annoTextField.setColumns(10);
		
		JButton AvantiButton = new JButton("AVANTI");
		AvantiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nome = nomeTextField.getText();
				String descrizione = descrizioneTextField.getText();
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
		AvantiButton.setBounds(245, 184, 89, 23);
		creazioneCorsiPane.add(AvantiButton);
		
		
		
		
		
		setVisible(true);
	}
}
