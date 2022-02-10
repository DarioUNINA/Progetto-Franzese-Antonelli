package gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.border.LineBorder;



import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;

public class LogInPage extends JFrame {

	private Controller theController;
	
	private ImageIcon imageicon;
	private Component url;
	private JPanel contentPane;
	private JPanel logInPanel;
	private JTextField nomeUtenteField;
	private JPasswordField passwordField;
	private JLabel nomeUtenteLabel;
	private JLabel passwordLabel;
	private JButton accediButton;
	private JLabel passwordDimenticataLabel;
	private JPanel registratiPanel;
	private JButton registratiButton;
	private JLabel bENVENUTOLabel;
	
	final Color azzurro;
	final Color azzurroChiaro;
	final Color grigio;
	final Color grigioChiaro;
	
	public LogInPage(Controller controller) {
		
		
		imageicon = new ImageIcon("napule.png");
		theController = controller;
		setIconImage(imageicon.getImage());
		
		azzurro = new Color(153,211,223);
		azzurroChiaro = new Color(136,187,214);
		grigio = new Color(205,205,205);
		grigioChiaro = new Color(233,233,233);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		logInPanel = new JPanel();
		logInPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		logInPanel.setBackground(azzurroChiaro);
		logInPanel.setBounds(61, 55, 764, 394);
		contentPane.add(logInPanel);
		logInPanel.setLayout(null);

		nomeUtenteField = new JTextField();
		nomeUtenteField.setFont(new Font("Arial", Font.BOLD, 20));
		nomeUtenteField.setBounds(300, 87, 166, 39);
		logInPanel.add(nomeUtenteField);
		nomeUtenteField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.BOLD, 20));
		passwordField.setBounds(300, 152, 166, 35);
		logInPanel.add(passwordField);

		nomeUtenteLabel = new JLabel(" Nome Utente:");
		nomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 32));
		nomeUtenteLabel.setBounds(68, 89, 234, 37);
		logInPanel.add(nomeUtenteLabel);

		passwordLabel = new JLabel("      Password:");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 32));
		passwordLabel.setBounds(68, 152, 222, 33);
		logInPanel.add(passwordLabel);

		accediButton = new JButton("ACCEDI");
		accediButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accediButton.setBackground(Color.WHITE);
		accediButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				accediButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				accediButton.setBackground(Color.WHITE);
			}
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
				String Nome = nomeUtenteField.getText().toLowerCase();
				String Pass = passwordField.getText().toLowerCase();
				
				if(Nome.isEmpty())
					alertNomeUtenteNonInserito();
				else 
					if(Pass.isEmpty())
						alertPasswordNonInserita();
					else
						if(!controller.logInClicked(Nome, Pass))
							alertLogInFallito();
						else
						{			
							GestoreCorsiPage hp = new GestoreCorsiPage(theController,theController.getOperatore(Nome));
							setVisible(false);
						}
					
				nomeUtenteField.setText("");
				passwordField.setText("");
	
			}	
		});

		accediButton.setFont(new Font("Arial", Font.BOLD, 18));
		accediButton.setBounds(300, 226, 166, 35);
		logInPanel.add(accediButton);

		passwordDimenticataLabel = new JLabel("Hai dimenticato la Password?");
		passwordDimenticataLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		passwordDimenticataLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				RecuperoPassPage rpp = new RecuperoPassPage(theController);
				setVisible(false);
			}
		});
		
		passwordDimenticataLabel.setFont(new Font("Arial", Font.BOLD, 20));
		passwordDimenticataLabel.setBounds(243, 309, 294, 24);
		logInPanel.add(passwordDimenticataLabel);

		registratiPanel = new JPanel();
		registratiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		registratiPanel.setBackground(azzurroChiaro);
		registratiPanel.setBounds(61, 478, 764, 55);
		contentPane.add(registratiPanel);

		registratiButton = new JButton("REGISTRATI");
		registratiButton.setBounds(304, 11, 156, 31);
		registratiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registratiButton.setBackground(Color.WHITE);
		registratiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registratiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				registratiButton.setBackground(Color.ORANGE);
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				registratiButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				RegistrazionePage rp = new RegistrazionePage(theController);
				setVisible(false);
			}
		});
		registratiPanel.setLayout(null);
		registratiButton.setFont(new Font("Arial", Font.BOLD, 18));
		registratiPanel.add(registratiButton);

		bENVENUTOLabel = new JLabel("BENVENUTO");
		bENVENUTOLabel.setBackground(new Color(255, 255, 255));
		bENVENUTOLabel.setForeground(Color.WHITE);
		bENVENUTOLabel.setBounds(346, 11, 200, 33);
		bENVENUTOLabel.setFont(new Font("Arial", Font.BOLD, 32));
		contentPane.add(bENVENUTOLabel);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void alertLogInFallito() {
		JOptionPane.showMessageDialog(this, "Nome utente o password non trovati, riprova.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}

	public void alertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(this, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}

	public void alertPasswordNonInserita() {
		JOptionPane.showMessageDialog(this, "Password non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
}
