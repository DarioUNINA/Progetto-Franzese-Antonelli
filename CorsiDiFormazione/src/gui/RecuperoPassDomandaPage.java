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

import dto.Operatori;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperoPassDomandaPage extends JFrame {

	private JPanel contentPane;
	private Component url;

	private Controller theController;
	private Operatori operatore;
	
	private ImageIcon imageicon;
	private JTextField DomandaText;
	private JTextField rispostaDomandaField;
	

	public RecuperoPassDomandaPage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		
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
		
		JPanel recuperoPanel = new JPanel();
		recuperoPanel.setBackground(SystemColor.control);
		recuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		recuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(recuperoPanel);
		recuperoPanel.setLayout(null);
		
		JLabel rECUPEROPASSWORDLabel = new JLabel("RECUPERO PASSWORD");
		rECUPEROPASSWORDLabel.setForeground(Color.BLACK);
		rECUPEROPASSWORDLabel.setFont(new Font("Arial", Font.BOLD, 22));
		rECUPEROPASSWORDLabel.setBackground(Color.WHITE);
		rECUPEROPASSWORDLabel.setBounds(139, 11, 268, 33);
		recuperoPanel.add(rECUPEROPASSWORDLabel);
		
		JButton confermaButton = new JButton("CONFERMA");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String state  = theController.confermaRispostaSicurezzaClicked(rispostaDomandaField.getText().toLowerCase(), operatore);

				if(state.equals("0")) {
					ModificaPasswordPage pg = new ModificaPasswordPage(theController, operatore);
					setVisible(false);
				}else
					alertRispostaNonValida(state);
			}
		});

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
				
			}
		});
		
		confermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaButton.setBounds(212, 171, 121, 27);
		recuperoPanel.add(confermaButton);
		
		JButton indietroButton = new JButton("INDIETRO");
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
		
		indietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		indietroButton.setBounds(10, 273, 121, 23);
		recuperoPanel.add(indietroButton);
		
		JLabel domandaLabel = new JLabel("Domanda Di Sicurezza: " + theController.setDomandaLabelRecuperoPassPage(operatore));
		domandaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		domandaLabel.setBounds(73, 79, 465, 14);
		recuperoPanel.add(domandaLabel);
		
		rispostaDomandaField = new JTextField();
		rispostaDomandaField.setFont(new Font("Arial", Font.BOLD, 13));
		rispostaDomandaField.setBounds(202, 140, 220, 20);
		recuperoPanel.add(rispostaDomandaField);
		rispostaDomandaField.setColumns(10);
		
		JLabel rispostaLabel = new JLabel("Inserire Risposta:");
		rispostaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		rispostaLabel.setBounds(73, 143, 131, 14);
		recuperoPanel.add(rispostaLabel);
		
		setVisible(true);
	}
	
	
	public void alertRispostaNonValida(String state) {
		
		if(state.equals("-1"))
			JOptionPane.showMessageDialog(this, "Risposta Errata","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "E\' stato riscontarto un errore","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);


		
		
	}
	
	
}
