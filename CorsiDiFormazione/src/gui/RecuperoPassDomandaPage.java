package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import dto.Operatori;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class RecuperoPassDomandaPage extends JFrame {

	
	private Controller theController;
	private Operatori operatore;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel recuperoPanel;
	private JLabel rECUPEROPASSWORDLabel;
	private JButton confermaButton;
	private JButton indietroButton;
	private JLabel domandaLabel;
	private JTextField rispostaDomandaField;
	private JLabel rispostaLabel;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color blu;
	final Color grigioChiaro;

	public RecuperoPassDomandaPage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		blu = new Color(0,51,78);
		grigioChiaro = new Color(219,235,250);
		
		setResizable(false);
		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recuperoPanel = new JPanel();
		recuperoPanel.setBackground(grigioChiaro);
		recuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		recuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(recuperoPanel);
		recuperoPanel.setLayout(null);
		
		rECUPEROPASSWORDLabel = new JLabel("RECUPERO PASSWORD");
		rECUPEROPASSWORDLabel.setForeground(Color.BLACK);
		rECUPEROPASSWORDLabel.setFont(new Font("Arial", Font.BOLD, 22));
		rECUPEROPASSWORDLabel.setBackground(Color.WHITE);
		rECUPEROPASSWORDLabel.setBounds(139, 11, 268, 33);
		recuperoPanel.add(rECUPEROPASSWORDLabel);
		
		confermaButton = new JButton("CONFERMA");
		confermaButton.setBackground(Color.WHITE);
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(212, 171, 121, 27);
		recuperoPanel.add(confermaButton);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		recuperoPanel.add(indietroButton);
		
		domandaLabel = new JLabel("Domanda Di Sicurezza: " + theController.setDomandaLabelRecuperoPassPage(operatore));
		domandaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		domandaLabel.setBounds(73, 79, 465, 14);
		recuperoPanel.add(domandaLabel);
		
		rispostaDomandaField = new JTextField();
		rispostaDomandaField.setBackground(Color.WHITE);
		rispostaDomandaField.setFont(new Font("Arial", Font.BOLD, 13));
		rispostaDomandaField.setBounds(202, 140, 205, 20);
		recuperoPanel.add(rispostaDomandaField);
		rispostaDomandaField.setColumns(10);
		
		rispostaLabel = new JLabel("Inserire Risposta:");
		rispostaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		rispostaLabel.setBounds(73, 143, 131, 14);
		recuperoPanel.add(rispostaLabel);
		
		
		//LISTNER
		
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestoreConfermaRisposta();
			}

			public void mouseEntered(MouseEvent e) {
				confermaButton.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent e) {
				confermaButton.setBackground(Color.WHITE);
			}
		});
		
		
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				indietroButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				indietroButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RecuperoPassPage rpp = new RecuperoPassPage(theController);
				setVisible(false);
			}
		});
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//ALERT
	public void alertRispostaNonValida(String state) {
		
		if(state.equals("-1"))
			JOptionPane.showMessageDialog(this, "Risposta Errata","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "E\' stato riscontarto un errore","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);

	}	
	
	//GESTORI
	
	public void gestoreConfermaRisposta() {
		String state  = theController.confermaRispostaSicurezzaClicked(rispostaDomandaField.getText().toLowerCase(), operatore);

		if(state.equals("0")) {
			ModificaPasswordPage pg = new ModificaPasswordPage(theController, operatore);
			setVisible(false);
		}else
			alertRispostaNonValida(state);
	}
}
