package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Lezioni;
import dto.Operatori;
import dto.Studenti;
import java.awt.Cursor;

public class AggiungiStudenteLezionePage extends JFrame {

	private Controller theController;
	private Operatori operatore;
	private Lezioni lezione;
	private JComboBox<Studenti> studentiComboBox;
	private Vector<Studenti> elencoStudenti;
	
	private JPanel contentPane;
	private Component url;
	private ImageIcon imageicon;
	private JPanel selzionaStudentiPanel;
	private JLabel selezionaStudenteLabel;
	private JButton indietroButton;
	private JLabel studenteLabel;
	private JButton confermaButton;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;
	
	public AggiungiStudenteLezionePage(Controller controller, Operatori operatore, Lezioni lezione) {
		setResizable(false);
		
		theController = controller;
		this.operatore= operatore;
		this.lezione = lezione;
		
		elencoStudenti = theController.getStudentiCorso(lezione.getIdCorso(), lezione.getIdLezione());
		studentiComboBox = new JComboBox<Studenti>(elencoStudenti);
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
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
		
		selzionaStudentiPanel = new JPanel();
		selzionaStudentiPanel.setBackground(grigioChiaro);
		selzionaStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		selzionaStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(selzionaStudentiPanel);
		selzionaStudentiPanel.setLayout(null);
		
		selezionaStudenteLabel = new JLabel("SELEZIONA STUDENTE");
		selezionaStudenteLabel.setForeground(new Color(65, 105, 225));
		selezionaStudenteLabel.setFont(new Font("Arial", Font.BOLD, 22));
		selezionaStudenteLabel.setBackground(Color.WHITE);
		selezionaStudenteLabel.setBounds(147, 11, 260, 33);
		selzionaStudentiPanel.add(selezionaStudenteLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 168, 23);
		selzionaStudentiPanel.add(indietroButton);
		
		studenteLabel = new JLabel("Studente:");
		studenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		studenteLabel.setBounds(111, 123, 77, 14);
		selzionaStudentiPanel.add(studenteLabel);
		
		
		studentiComboBox.setBounds(198, 120, 157, 22);
		selzionaStudentiPanel.add(studentiComboBox);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(370, 273, 168, 23);
		selzionaStudentiPanel.add(confermaButton);
		
		//LISTNER
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				theController.panoramicaLezionePage(operatore, lezione);
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
		
		confermaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				gestoreAggiungiStudenteLezione();
			}
			
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//ALERT
	
	public void alertStudenteAggiuntoCorrettamente() {
		JOptionPane.showMessageDialog(this, "Studente aggiunto correttamente alle lezione.","<CONFERMA>", JOptionPane.INFORMATION_MESSAGE);
		theController.panoramicaLezionePage(operatore, lezione);
	}
	
	public void alertAggiuntaFallita(String state) {
		
		if(state.equals("10007"))
			JOptionPane.showMessageDialog(this, "Attenzione: non � possibile iscrivere studenti a lezioni concluse","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			if(state.equals("10008"))
				JOptionPane.showMessageDialog(this, "Attenzione: lo studente e' gia' iscritto a lezioni in contemporanea a quella selezionata","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void gestoreAggiungiStudenteLezione() {
		String state = theController.aggiungiStudenteLezioneClicked(elencoStudenti.get((studentiComboBox.getSelectedIndex())).getMatricola() ,lezione.getIdLezione());
		
		if(state.equals("0"))
			alertStudenteAggiuntoCorrettamente();
		else
			alertAggiuntaFallita(state);
	}
}
