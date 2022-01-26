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
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class RecuperoPassDomandaPage extends JFrame {

	private JPanel contentPane;
	private Component url;

	private Controller theController;
	private ImageIcon imageicon;
	private JTextField DomandaText;
	private JTextField RispostaDomandaField;
	

	public RecuperoPassDomandaPage(Controller con) {
		
		setResizable(false);
		
		
		imageicon = new ImageIcon("napule.png");
		theController = con;
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel RecuperoPanel = new JPanel();
		RecuperoPanel.setBackground(SystemColor.control);
		RecuperoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		RecuperoPanel.setBounds(10, 11, 548, 307);
		contentPane.add(RecuperoPanel);
		RecuperoPanel.setLayout(null);
		
		JLabel RECUPEROPASSWORDLabel = new JLabel("RECUPERO PASSWORD");
		RECUPEROPASSWORDLabel.setForeground(Color.BLACK);
		RECUPEROPASSWORDLabel.setFont(new Font("Arial", Font.BOLD, 22));
		RECUPEROPASSWORDLabel.setBackground(Color.WHITE);
		RECUPEROPASSWORDLabel.setBounds(139, 11, 268, 33);
		RecuperoPanel.add(RECUPEROPASSWORDLabel);
		
		JButton ConfermaButton = new JButton("CONFERMA");
		ConfermaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ConfermaButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ConfermaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		ConfermaButton.setFont(new Font("Arial", Font.BOLD, 15));
		ConfermaButton.setBounds(211, 148, 121, 27);
		RecuperoPanel.add(ConfermaButton);
		
		JButton IndietroButton = new JButton("INDIETRO");
		IndietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				IndietroButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				IndietroButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RecuperoPassPage rpp = new RecuperoPassPage(theController);
				setVisible(false);
			}
		});
		
		IndietroButton.setFont(new Font("Arial", Font.BOLD, 15));
		IndietroButton.setBounds(10, 273, 121, 23);
		RecuperoPanel.add(IndietroButton);
		
		JLabel DoamandaLabel = new JLabel("");
		DoamandaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		DoamandaLabel.setBounds(139, 77, 268, 14);
		RecuperoPanel.add(DoamandaLabel);
		
		RispostaDomandaField = new JTextField();
		RispostaDomandaField.setFont(new Font("Arial", Font.BOLD, 15));
		RispostaDomandaField.setBounds(139, 102, 268, 20);
		RecuperoPanel.add(RispostaDomandaField);
		RispostaDomandaField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(84, 231, -19, -33);
		RecuperoPanel.add(list);
		
		JLabel RispostaLabel = new JLabel("Inserire Risposta:");
		RispostaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		RispostaLabel.setBounds(10, 106, 131, 14);
		RecuperoPanel.add(RispostaLabel);
		
		setVisible(true);
	}
}
