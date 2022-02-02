package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestoreStudentiPage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;

	
	public GestoreStudentiPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
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
		
		JPanel selzionaStudentiPanel = new JPanel();
		selzionaStudentiPanel.setBackground(SystemColor.control);
		selzionaStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		selzionaStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(selzionaStudentiPanel);
		selzionaStudentiPanel.setLayout(null);
		
		JLabel selezionaStudenteLabel = new JLabel("SELEZIONA STUDENTE");
		selezionaStudenteLabel.setForeground(new Color(65, 105, 225));
		selezionaStudenteLabel.setFont(new Font("Arial", Font.BOLD, 22));
		selezionaStudenteLabel.setBackground(Color.WHITE);
		selezionaStudenteLabel.setBounds(147, 11, 260, 33);
		selzionaStudentiPanel.add(selezionaStudenteLabel);
		
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
		indietroButton.setBounds(10, 273, 168, 23);
		selzionaStudentiPanel.add(indietroButton);
		
		JLabel studenteLabel = new JLabel("Studente:");
		studenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		studenteLabel.setBounds(111, 123, 77, 14);
		selzionaStudentiPanel.add(studenteLabel);
		
		JComboBox studentiComboBox = new JComboBox(theController.setStudenti());
		studentiComboBox.setBounds(198, 120, 157, 22);
		selzionaStudentiPanel.add(studentiComboBox);
		
		JButton eliminaStudenteButton = new JButton("ELIMINA STUDENTE");
		eliminaStudenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String studenteSelezionato = studentiComboBox.getSelectedItem().toString();
				if(studenteSelezionato.isEmpty()) {
					alertStudenteNonSelezionato();
				}else
					alertSeiSicuroDiVolerEliminareStudente();//da fare la query per l'eliminazione
			}
		});
		eliminaStudenteButton.setForeground(Color.RED);
		eliminaStudenteButton.setFont(new Font("Arial", Font.BOLD, 11));
		eliminaStudenteButton.setBounds(290, 169, 140, 33);
		selzionaStudentiPanel.add(eliminaStudenteButton);
		
		JButton panoramicaButton = new JButton("PANORAMICA");
		panoramicaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				panoramicaButton.setBackground(Color.GREEN);
			}

		public void mouseExited(java.awt.event.MouseEvent e) {
			panoramicaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//PanoramicaSingoloStudentePage gss = new PanoramicaSingoloStudentePage(theController, operatore, theController.setSingoloStudente(studentiComboBox.getItemAt(0)));
				setVisible(false);
			}
		});
		panoramicaButton.setFont(new Font("Arial", Font.BOLD, 11));
		panoramicaButton.setBounds(120, 169, 140, 33);
		selzionaStudentiPanel.add(panoramicaButton);
		
		JButton creaStudenteButton = new JButton("CREA STUDENTE");
		creaStudenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		creaStudenteButton.setBounds(370, 273, 168, 23);
		selzionaStudentiPanel.add(creaStudenteButton);
		
		setVisible(true);
	}
	
	public void alertStudenteNonSelezionato() {
		JOptionPane.showMessageDialog(this, "Studente Non Selezionato.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertSeiSicuroDiVolerEliminareStudente() {
		Object[] opzioni = {"Sì"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler eliminare lo studente ?",
				"CONFERMA ELIMINAZIONE",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			HomePage hp = new HomePage(theController, operatore);
			setVisible(false);
		}
			
		}
}
