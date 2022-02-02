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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Lezioni;
import dto.Operatori;
import dto.Studenti;

public class AggiungiStudenteLezionePage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;
	private Lezioni lezione;
	private JComboBox<Studenti> studentiComboBox;
	private Vector<Studenti> elencoStudenti;
	
	public AggiungiStudenteLezionePage(Controller controller, Operatori operatore, Lezioni lezione) {
		setResizable(false);
		
		theController = controller;
		this.operatore= operatore;
		this.lezione = lezione;

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
				PanoramicaLezionePage pl = new PanoramicaLezionePage(theController, operatore, lezione);
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
		
		elencoStudenti =(theController.getStudentiCorso(lezione.getIdCorso(), lezione.getIdLezione()));
		
		studentiComboBox = new JComboBox<Studenti>(elencoStudenti);
		studentiComboBox.setBounds(198, 120, 157, 22);
		selzionaStudentiPanel.add(studentiComboBox);
		
		JButton confermaButton = new JButton("CONFERMA");
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(370, 273, 168, 23);
		selzionaStudentiPanel.add(confermaButton);
		
		setVisible(true);
	}

}
