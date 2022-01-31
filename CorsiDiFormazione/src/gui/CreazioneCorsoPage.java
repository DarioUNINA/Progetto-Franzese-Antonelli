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
	private JTextField descrizioneTextField;
	
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
		getContentPane().setBackground(new Color(65, 105, 225));
		creazioneCorsiPanel.setLayout(null);
		
		JPanel creaCorsoPanel = new JPanel();
		creaCorsoPanel.setBounds(10, 11, 548, 307);
		creaCorsoPanel.setBackground(SystemColor.control);
		creaCorsoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		creazioneCorsiPanel.add(creaCorsoPanel);
		creaCorsoPanel.setLayout(null);
		
		
		
		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Arial", Font.BOLD, 11));
		nomeTextField.setBounds(168, 66, 86, 20);
		nomeTextField.setColumns(10);
		creaCorsoPanel.add(nomeTextField);
		
		presenzeMinTextField = new JTextField();
		presenzeMinTextField.setFont(new Font("Arial", Font.BOLD, 11));
		presenzeMinTextField.setBounds(168, 101, 86, 20);
		presenzeMinTextField.setColumns(10);
		creaCorsoPanel.add(presenzeMinTextField);
		
		maxPartecipantiTextField = new JTextField();
		maxPartecipantiTextField.setFont(new Font("Arial", Font.BOLD, 11));
		maxPartecipantiTextField.setBounds(168, 137, 86, 20);
		maxPartecipantiTextField.setColumns(10);
		creaCorsoPanel.add(maxPartecipantiTextField);
		
		paroleChiaveTextBox = new JTextField();
		paroleChiaveTextBox.setFont(new Font("Arial", Font.BOLD, 11));
		paroleChiaveTextBox.setBounds(168, 170, 86, 20);
		paroleChiaveTextBox.setColumns(10);
		creaCorsoPanel.add(paroleChiaveTextBox);
		
		JCheckBox terminatoCheckBox = new JCheckBox("SI");
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
		terminatoCheckBox.setBounds(383, 99, 39, 23);
		creaCorsoPanel.add(terminatoCheckBox);
		
		annoTextField = new JTextField();
		annoTextField.setFont(new Font("Arial", Font.BOLD, 11));
		annoTextField.setBounds(373, 66, 86, 20);
		annoTextField.setColumns(10);
		creaCorsoPanel.add(annoTextField);
		
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
		
		
		JButton confermaButton = new JButton("CONFERMA");
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
				String anno = annoTextField.getText().toLowerCase();
				String presenzeMin = presenzeMinTextField.getText();
				String maxPartecipanti = maxPartecipantiTextField.getText();
				boolean terminato;
				
				if(terminatoCheckBox.isSelected())
					terminato = true;
				else
					terminato = false;
				
				if(theController.isDigits(presenzeMin))
					alertErroreInserimentoPresenzeMin();
				else
					if(theController.isDigits(maxPartecipanti))
						alertErroreInserimentoMaxPartecipanti();
					else
						if(theController.isDigits(anno))
							alertErroreInserimentoAnno();
						else {
								String[] prova = {"programmazione", "matematica"};
	/*manca l'array di temi */	String state = theController.aggiungiCorsoClicked(nome, descrizione, paroleChiave, anno, presenzeMin, maxPartecipanti, terminato, operatore.getIdOperatore(), prova);
									
								if(state.equals("0"))
									alertInserimentoEffettuato();
								else
									alertInserimentoNonEffettuato(state);
						}
							
				
			}	
			
		});
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(417, 273, 121, 23);
		creaCorsoPanel.add(confermaButton);
		
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
		annoLabel.setBounds(329, 68, 45, 14);
		creaCorsoPanel.add(annoLabel);
		
		JLabel terminatoLabel = new JLabel("Terminato?");
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoLabel.setBounds(296, 103, 81, 14);
		creaCorsoPanel.add(terminatoLabel);
		
		JLabel descrizioneLabel = new JLabel("  Descrizione:");
		descrizioneLabel.setFont(new Font("Arial", Font.BOLD, 15));
		descrizioneLabel.setBounds(68, 202, 97, 14);
		creaCorsoPanel.add(descrizioneLabel);
		
		JLabel areaTematicaLabel = new JLabel("Area Tematica:");
		areaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		areaTematicaLabel.setBounds(344, 138, 104, 14);
		creaCorsoPanel.add(areaTematicaLabel);
		
		descrizioneTextField = new JTextField();
		descrizioneTextField.setFont(new Font("Arial", Font.BOLD, 11));
		descrizioneTextField.setColumns(10);
		descrizioneTextField.setBounds(168, 201, 86, 20);
		creaCorsoPanel.add(descrizioneTextField);
		
		
		JScrollPane corsiScrollPane = new JScrollPane();
		corsiScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		corsiScrollPane.setBounds(296, 167, 227, 97);
		creaCorsoPanel.add(corsiScrollPane);
		
				
				
				JCheckBoxList listaTemi = new JCheckBoxList();
				corsiScrollPane.setViewportView(listaTemi);
				listaTemi.setFont(new Font("Arial", Font.BOLD, 15));
				listaTemi.setVisibleRowCount(10);
		listaTemi.setVisible(true);
		
		
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
	
	public void alertErroreInserimentoAnno() {
		JOptionPane.showMessageDialog(this, "L'anno inserito non e' valido","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}

	public void alertInserimentoNonEffettuato(String state) {

		if(state.equals("-1")) {
			
			JOptionPane.showMessageDialog(this, "Errore sconosciuto, impossibile creare il corso ","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this, "Impossibile creare il corso: codice errore " +  state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		}
			
	}

}
