package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;

public class ModificaLezionePage extends JFrame {

	private Controller theController;
	private Operatori operatore;
	private Lezioni lezione;
	
	private ImageIcon imageicon;
	private JPanel creazioneLezioniPanel;
	private Component url;
	private JTextField titoloTextField;
	private JTextField descrizioneTextField;
	private JPanel modificheLezionePanel;
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
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public ModificaLezionePage(Controller controller, Operatori operatore, Lezioni lezione) {
		
		setResizable(false);
		
		this.operatore = operatore;
		theController = controller;
		durate = theController.getDurate();
		orari = theController.getOrario();
		this.lezione = lezione;
		
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		creazioneLezioniPanel = new JPanel();
		creazioneLezioniPanel.setBorder(new LineBorder(Color.BLACK));
		creazioneLezioniPanel.setBackground(blu);
		setContentPane(creazioneLezioniPanel);
		creazioneLezioniPanel.setLayout(null);
			
		
		modificheLezionePanel = new JPanel();
		modificheLezionePanel.setBounds(10, 11, 548, 307);
		modificheLezionePanel.setBackground(grigioChiaro);
		modificheLezionePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		creazioneLezioniPanel.add(modificheLezionePanel);
		modificheLezionePanel.setLayout(null);
		
		calendario = new JCalendar();
		calendario.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendario.getYearChooser().getSpinner().setEnabled(false);
		calendario.setBounds(310, 55, 228, 151);
		calendario.getYearChooser().setYear(Integer.parseInt(theController.getAnnoLezione(lezione.getIdCorso())));
		calendario.getDayChooser().setDay(Integer.parseInt(theController.getGiornoLezione(lezione.getIdLezione())));
		calendario.getMonthChooser().setMonth(lezione.getData().getMonth());
		modificheLezionePanel.add(calendario);

		creazioneLezioneLabel = new JLabel("MODIFICHE LEZIONE");
		creazioneLezioneLabel.setForeground(Color.BLACK);
		creazioneLezioneLabel.setFont(new Font("Arial", Font.BOLD, 22));
		creazioneLezioneLabel.setBackground(Color.WHITE);
		creazioneLezioneLabel.setBounds(159, 11, 227, 33);
		modificheLezionePanel.add(creazioneLezioneLabel);
		
		titoloLabel = new JLabel("Titolo:" );
		titoloLabel.setFont(new Font("Arial", Font.BOLD, 15));
		titoloLabel.setBounds(16, 52, 45, 18);
		modificheLezionePanel.add(titoloLabel);
		
		durataLabel = new JLabel("Durata:");
		durataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		durataLabel.setBounds(10, 140, 51, 18);
		modificheLezionePanel.add(durataLabel);
		
		orarioLabel = new JLabel("Orario:");
		orarioLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orarioLabel.setBounds(10, 94, 51, 18);
		modificheLezionePanel.add(orarioLabel);
		
		dataLabel = new JLabel("Data:");
		dataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dataLabel.setBounds(264, 55, 36, 18);
		modificheLezionePanel.add(dataLabel);
		
		descrizioneLabel = new JLabel("Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(10, 185, 124, 18);
		modificheLezionePanel.add(descrizioneLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanoramicaLezionePage plp = new PanoramicaLezionePage(theController, operatore, lezione);
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
		modificheLezionePanel.add(indietroButton);
		

		durataComboBox = new JComboBox<Time>(durate);
		durataComboBox.setBounds(71, 139, 134, 22);
		durataComboBox.setSelectedItem(lezione.getDurata());
		modificheLezionePanel.add(durataComboBox);
		
		orarioComboBox = new JComboBox<Time>(orari);
		orarioComboBox.setBounds(71, 93, 134, 22);
		orarioComboBox.setSelectedItem(lezione.getOrario());
		modificheLezionePanel.add(orarioComboBox);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setBackground(Color.WHITE);
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
				
				gestoreModificaLezione();
				
			}
		});	
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 274, 121, 23);
		modificheLezionePanel.add(confermaButton);
		
		titoloTextField = new JTextField();
		titoloTextField.setFont(new Font("Arial", Font.BOLD, 11));
		titoloTextField.setColumns(10);
		titoloTextField.setBounds(71, 53, 134, 20);
		titoloTextField.setText(lezione.getTitolo());
		modificheLezionePanel.add(titoloTextField);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setFont(new Font("Arial", Font.BOLD, 11));
		descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(105, 186, 170, 20);
		descrizioneTextField.setText(lezione.getDescrizione());
		modificheLezionePanel.add(descrizioneTextField);
	
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void alertModificaEffettuata() {
		
		JOptionPane.showMessageDialog(this, "Lezione modificata con successo","CONFERMA", JOptionPane.INFORMATION_MESSAGE);
		
		PanoramicaLezionePage plp = new PanoramicaLezionePage(theController, operatore, theController.getLezione(lezione.getIdLezione()));
		setVisible(false);
		
	}
	
	public void alertModificaFallita( String state) {
		
		if(state.equals("10012"))
			JOptionPane.showMessageDialog(this, "ATTENZIONE: ha gia creato una lezione in contemporanea, si prega di modificare l'orario","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("23505"))
				JOptionPane.showMessageDialog(this, "Attenzione, esiste gia una lezione con lo stesso titolo.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Impossibile creare la lezione a causa di un errore sconosciuto","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
	
	
	public void alertTitoloNonInserito() {
		
		JOptionPane.showMessageDialog(this, "Inserire il titolo della lezione","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	
	public void gestoreModificaLezione() {
		
		String titolo = titoloTextField.getText().toLowerCase();
		
		
		if(titolo.equals(""))
			alertTitoloNonInserito();
		else {
			
			String descrizione = descrizioneTextField.getText().toLowerCase();
			Time orarioLezione = (Time)orarioComboBox.getSelectedItem();
			Time durataLezione = (Time)durataComboBox.getSelectedItem();
			Date data = calendario.getDate();
			
			String state = theController.modificaLezione(titolo, descrizione, orarioLezione, durataLezione, data, lezione.getIdLezione());
			
			if(state.equals("0"))
				alertModificaEffettuata();
			else
				alertModificaFallita(state);
		}
		
	}
	
}
