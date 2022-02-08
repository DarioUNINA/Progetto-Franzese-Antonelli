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

import dto.AreeTematiche;
import dto.Operatori;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JScrollPane;
import com.toedter.calendar.JYearChooser;

public class CreazioneCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private Vector<AreeTematiche> areeTematiche;
	
	private ImageIcon imageicon;
	private Component url;
	private JPanel creazioneCorsiPanel;
	private JTextField nomeTextField;
	private JTextField presenzeMinTextField;
	private JTextField maxPartecipantiTextField;
	private JTextField paroleChiaveTextBox;
	private JTextField descrizioneTextField;
	private JCheckBox terminatoCheckBox;
	private JButton indietroButton;
	private JButton confermaButton;
	private JPanel creaCorsoPanel;
	private JLabel creazioneCorsoLabel;
	private JLabel nomeLabel;
	private JLabel presenzeMinimeLabel;
	private JLabel massimoPartecipantiLabel;
	private JLabel parolaChiaveLabel;
	private JLabel annoLabel;
	private JLabel terminatoLabel;
	private JLabel descrizioneLabel;
	private JLabel areaTematicaLabel;
	private JScrollPane corsiScrollPane;
	private JCheckBoxList listaTemi;
	private JYearChooser annoChooser;

	
	public CreazioneCorsoPage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		areeTematiche = theController.getAllAreeTematiche();
		areeTematiche.remove(0);
		
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		creazioneCorsiPanel = new JPanel();
		creazioneCorsiPanel.setBorder(new LineBorder(Color.BLACK));
		setContentPane(creazioneCorsiPanel);
		getContentPane().setBackground(new Color(65, 105, 225));
		creazioneCorsiPanel.setLayout(null);
		
		creaCorsoPanel = new JPanel();
		creaCorsoPanel.setBounds(10, 11, 548, 307);
		creaCorsoPanel.setBackground(SystemColor.control);
		creaCorsoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		creazioneCorsiPanel.add(creaCorsoPanel);
		creaCorsoPanel.setLayout(null);
		
		
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(168, 66, 86, 20);
		nomeTextField.setFont(new Font("Arial", Font.BOLD, 11));
		nomeTextField.setColumns(10);
		creaCorsoPanel.add(nomeTextField);
		
		presenzeMinTextField = new JTextField();
		presenzeMinTextField.setBounds(168, 101, 86, 20);
		presenzeMinTextField.setFont(new Font("Arial", Font.BOLD, 11));
		presenzeMinTextField.setColumns(10);
		creaCorsoPanel.add(presenzeMinTextField);
		
		maxPartecipantiTextField = new JTextField();
		maxPartecipantiTextField.setBounds(168, 137, 86, 20);
		maxPartecipantiTextField.setFont(new Font("Arial", Font.BOLD, 11));
		maxPartecipantiTextField.setColumns(10);
		creaCorsoPanel.add(maxPartecipantiTextField);
		
		paroleChiaveTextBox = new JTextField();
		paroleChiaveTextBox.setBounds(168, 170, 86, 20);
		paroleChiaveTextBox.setFont(new Font("Arial", Font.BOLD, 11));
		paroleChiaveTextBox.setColumns(10);
		creaCorsoPanel.add(paroleChiaveTextBox);
		
		terminatoCheckBox = new JCheckBox("SI");
		terminatoCheckBox.setBounds(383, 99, 39, 23);
		terminatoCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(terminatoCheckBox.getSelectedObjects() != null)
					terminatoCheckBox.setForeground(Color.GREEN);
				else
					terminatoCheckBox.setForeground(Color.BLACK);
			}
		});
		terminatoCheckBox.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(terminatoCheckBox);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setBounds(10, 273, 121, 23);
		indietroButton.setBackground(Color.WHITE);
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
		creaCorsoPanel.add(indietroButton);

		corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(296, 167, 227, 97);
		corsiScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		creaCorsoPanel.add(corsiScrollPane);
		
		listaTemi = new JCheckBoxList();
		listaTemi.setModel(theController.setModelCheckBox(areeTematiche));
		corsiScrollPane.setViewportView(listaTemi);
		listaTemi.setFont(new Font("Arial", Font.BOLD, 15));
		listaTemi.setVisibleRowCount(10);
		listaTemi.setVisible(true);

		annoChooser = new JYearChooser();
		annoChooser.setBounds(387, 66, 48, 20);
		annoChooser.getSpinner().setBounds(0, 0, 48, 20);
		creaCorsoPanel.add(annoChooser);
		annoChooser.setLayout(null);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setBounds(417, 273, 121, 23);
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
				
				String nome = nomeTextField.getText().toLowerCase();
				String descrizione = descrizioneTextField.getText().toLowerCase();
				String paroleChiave = paroleChiaveTextBox.getText().toLowerCase();
				String anno = String.valueOf(annoChooser.getYear());
				String presenzeMin = presenzeMinTextField.getText();
				String maxPartecipanti = maxPartecipantiTextField.getText();
				boolean terminato;
				Vector<AreeTematiche> aree = theController.getAreeSelezionate(listaTemi, areeTematiche);
				
				if(terminatoCheckBox.isSelected())
					terminato = true;
				else
					terminato = false;
				
				if(!theController.isDigits(presenzeMin))
					alertErroreInserimentoPresenzeMin();
				else
					if(!theController.isDigits(maxPartecipanti))
						alertErroreInserimentoMaxPartecipanti();
					else {
							
							String state = theController.aggiungiCorsoClicked(nome, descrizione, paroleChiave, anno, presenzeMin, maxPartecipanti, terminato, operatore.getIdOperatore(), aree);
								
							if(state.equals("0"))
								alertInserimentoEffettuato();
							else
								alertInserimentoNonEffettuato(state);
					}
			}	
			
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(confermaButton);
		
		creazioneCorsoLabel = new JLabel("CREAZIONE CORSO");
		creazioneCorsoLabel.setBounds(164, 11, 227, 33);
		creazioneCorsoLabel.setForeground(Color.BLACK);
		creazioneCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		creazioneCorsoLabel.setBackground(Color.WHITE);
		creaCorsoPanel.add(creazioneCorsoLabel);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(120, 68, 45, 14);
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(nomeLabel);
		
		presenzeMinimeLabel = new JLabel("Presenze Minime:");
		presenzeMinimeLabel.setBounds(38, 104, 127, 14);
		presenzeMinimeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(presenzeMinimeLabel);
		
		massimoPartecipantiLabel = new JLabel("Massimo Partecipanti:");
		massimoPartecipantiLabel.setBounds(10, 139, 155, 14);
		massimoPartecipantiLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(massimoPartecipantiLabel);
		
		parolaChiaveLabel = new JLabel("Parola Chiave:");
		parolaChiaveLabel.setBounds(62, 172, 103, 14);
		parolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(parolaChiaveLabel);
		
		annoLabel = new JLabel("Anno:");
		annoLabel.setBounds(332, 67, 45, 14);
		annoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(annoLabel);
		
		terminatoLabel = new JLabel("Terminato?");
		terminatoLabel.setBounds(296, 103, 81, 14);
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(terminatoLabel);
		
		descrizioneLabel = new JLabel("  Descrizione:");
		descrizioneLabel.setBounds(68, 202, 97, 14);
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(descrizioneLabel);
		
		areaTematicaLabel = new JLabel("Area Tematica:");
		areaTematicaLabel.setBounds(344, 138, 104, 14);
		areaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		creaCorsoPanel.add(areaTematicaLabel);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setBounds(168, 201, 86, 20);
		descrizioneTextField.setFont(new Font("Arial", Font.BOLD, 11));
		descrizioneTextField.setColumns(10);
		creaCorsoPanel.add(descrizioneTextField);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void alertErroreInserimentoPresenzeMin() {
		JOptionPane.showMessageDialog(this, "Le presenze minime inserite non sono valide","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertInserimentoEffettuato() {
		
		JOptionPane.showMessageDialog(this, "Corso aggiunto correttamente","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);

		HomePage hp = new HomePage(theController, operatore);
		setVisible(false);
	}
	
	public void alertErroreInserimentoMaxPartecipanti() {
		JOptionPane.showMessageDialog(this, "Il massimo numero di partecipanti inserito non e' valido","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	

	public void alertInserimentoNonEffettuato(String state) {

		if(state.equals("-1")) 
			JOptionPane.showMessageDialog(this, "Errore sconosciuto, impossibile creare il corso ","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else 
			if(state.equals("23505"))
				JOptionPane.showMessageDialog(this, "Impossibile creare il corso, esiste gia' un corso con lo stesso nome" +  state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Impossibile creare il corso: codice errore " +  state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}
}
