package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.sql.Time;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Corsi;
import dto.Operatori;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;

public class CreazioneLezionePage extends JFrame {

	private Controller theController;
	private Operatori operatore;
	
	private ImageIcon imageicon;
	private JPanel creazioneLezioniPanel;
	private Component url;
	private JTextField titoloTextField;
	private JTextField descrizioneTextField;
	private JPanel creaLezionePanel;
	private JLabel creazioneLezioneLabel;
	private JLabel titoloLabel;
	private JLabel durataLabel;
	private JLabel orarioLabel;
	private JLabel dataLabel;
	private JLabel descrizioneLabel;
	private JButton indietroButton;
	private JButton confermaButton;
	private JComboBox<Time> durataComboBox;
	private JComboBox<Time> orarioComboBox;
	private Vector<Time> durate;
	private Vector<Time> orari;
	private JCalendar calendario;
	
	
	
	public CreazioneLezionePage(Controller controller, Operatori operatore, Corsi corso) {
		setResizable(false);
		
		this.operatore = operatore;
		theController = controller;
		durate = theController.getDurate();
		orari = theController.getOrario();
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		creazioneLezioniPanel = new JPanel();
		creazioneLezioniPanel.setBorder(new LineBorder(Color.BLACK));
		setContentPane(creazioneLezioniPanel);
		getContentPane().setBackground(new Color(65, 105, 225));
		creazioneLezioniPanel.setLayout(null);
			
		
		creaLezionePanel = new JPanel();
		creaLezionePanel.setBounds(10, 11, 548, 307);
		creaLezionePanel.setBackground(SystemColor.control);
		creaLezionePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		creazioneLezioniPanel.add(creaLezionePanel);
		creaLezionePanel.setLayout(null);
		
		calendario = new JCalendar();
		calendario.setBounds(310, 55, 228, 151);
		creaLezionePanel.add(calendario);
		
		creazioneLezioneLabel = new JLabel("CREAZIONE LEZIONE");
		creazioneLezioneLabel.setForeground(Color.BLACK);
		creazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		creazioneLezioneLabel.setBackground(Color.WHITE);
		creazioneLezioneLabel.setBounds(159, 11, 227, 33);
		creaLezionePanel.add(creazioneLezioneLabel);
		
		titoloLabel = new JLabel("Titolo:");
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(16, 52, 45, 18);
		creaLezionePanel.add(titoloLabel);
		
		durataLabel = new JLabel("Durata:");
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(10, 140, 51, 18);
		creaLezionePanel.add(durataLabel);
		
		orarioLabel = new JLabel("Orario:");
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(10, 94, 51, 18);
		creaLezionePanel.add(orarioLabel);
		
		dataLabel = new JLabel("Data:");
		dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dataLabel.setBounds(264, 55, 36, 18);
		creaLezionePanel.add(dataLabel);
		
		descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(10, 185, 124, 18);
		creaLezionePanel.add(descrizioneLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreLezioniPage glp = new GestoreLezioniPage(theController, operatore);
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
		creaLezionePanel.add(indietroButton);
		

		durataComboBox = new JComboBox<Time>(durate);
		durataComboBox.setBounds(71, 139, 103, 22);
		creaLezionePanel.add(durataComboBox);
		
		orarioComboBox = new JComboBox<Time>(orari);
		orarioComboBox.setBounds(71, 93, 103, 22);
		creaLezionePanel.add(orarioComboBox);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String titolo = titoloTextField.getText().toLowerCase();
				String descrizione = descrizioneTextField.getText().toLowerCase();
				Time orarioLezione = (Time)orarioComboBox.getSelectedItem();
				Time durataLezione = (Time)durataComboBox.getSelectedItem();
				Date data = calendario.getDate();
				
				String state = theController.creaLezione(titolo, descrizione, orarioLezione, durataLezione, data, corso.getIdCorso());
				
				if(state.equals("0"))
					alertInserimentoEffettuato();
				else
					alertInserimentoFallito(state);
					
				
				
			}
		});	
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		creaLezionePanel.add(confermaButton);
		
		titoloTextField = new JTextField();
		titoloTextField.setFont(new Font("Arial", Font.BOLD, 11));
		titoloTextField.setColumns(10);
		titoloTextField.setBounds(71, 53, 103, 20);
		creaLezionePanel.add(titoloTextField);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setFont(new Font("Arial", Font.BOLD, 11));
		descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(105, 186, 170, 20);
		creaLezionePanel.add(descrizioneTextField);
	
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void alertInserimentoEffettuato() {
		JOptionPane.showMessageDialog(this, "Lezione creata con successo","CONFERMA", JOptionPane.INFORMATION_MESSAGE);
		}
	
	public void alertInserimentoFallito(String state) {
		
		if(state.equals("10012"))
			JOptionPane.showMessageDialog(this, "ATTENZIONE: ha gia creato una lezione in contemporanea, si prega di modificare l'orario","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("23505"))
				JOptionPane.showMessageDialog(this, "Attenzione, esiste gia una lezione con lo stesso titolo.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Impossibile creare la lezione a causa di un errore sconosciuto","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
}
