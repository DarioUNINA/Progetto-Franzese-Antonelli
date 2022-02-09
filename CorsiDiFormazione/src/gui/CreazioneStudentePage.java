package gui;

import dto.Operatori;
import dto.Studenti;
import dto.Corsi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreazioneStudentePage extends JFrame {

	private JPanel filtri;
	private Operatori operatore;
	private Controller theController;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JLabel nomeLabel;
	private JScrollPane corsiScrollPane;
	private JCheckBoxList corsiList;
	private Vector<Corsi> corsi;
	
	public CreazioneStudentePage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		corsi = theController.getCorsiOperatore(operatore);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		filtri = new JPanel();
		filtri.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(filtri);
		filtri.setLayout(null);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(49, 36, 86, 20);
		filtri.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		cognomeTextField = new JTextField();
		cognomeTextField.setBounds(49, 83, 86, 20);
		filtri.add(cognomeTextField);
		cognomeTextField.setColumns(10);
		
		nomeLabel = new JLabel("New label");
		nomeLabel.setBounds(168, 39, 46, 14);
		filtri.add(nomeLabel);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		

		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(211, 81, 175, 106);
		corsiScrollPane.setBorder(new LineBorder(Color.BLACK));
		filtri.add(corsiScrollPane);
		
		corsiList = new JCheckBoxList();
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setModel(theController.setModelCheckBoxCorsi(corsi));
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		corsiList.setBackground(Color.LIGHT_GRAY);
		corsiList.setVisibleRowCount(10);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gestioneCreazioneStudente();
				
			}
		});
		btnNewButton.setBounds(297, 216, 89, 23);
		filtri.add(btnNewButton);
	}
	
	
	public void gestioneCreazioneStudente() {
		
		Studenti studente = new Studenti(nomeTextField.getText(), cognomeTextField.getText());
		Vector<Corsi> vettoreCorsi = theController.getCorsiSelezionati(corsiList, corsi);
		String state = theController.creaStudente(studente, corsi);
		
		if(state.equals("0"))
			alertCreazioneEffettuata();
		else
			alertCreazioneFallita(state);
	}
	
	public void alertCreazioneEffettuata() {
		
		JOptionPane.showMessageDialog(this, "Studente creato con successo","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		GestoreStudentiPage page = new GestoreStudentiPage(theController, operatore);
		setVisible(false);
	}
	
	public void alertCreazioneFallita(String state) {
		
		if(state.equals("-1"))
			JOptionPane.showMessageDialog(this, "Creazione dello studente fallita a causa di un errore sconosciuto","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Creazione dello studente fallita.\nCodice d'errore: " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
	
	
}
