package CorsiDiFormazione;



import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import org.w3c.dom.events.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
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

public class HomePage extends JFrame {


	private JPanel contentPane;
	private Component url;
	private JTextField NomeUtenteField;
	private JPasswordField passwordField;

	private Controller theController ;
	private ImageIcon imageicon;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public HomePage(Controller controller) {
		imageicon = new ImageIcon("napule.png");
		theController = controller;
		setIconImage(imageicon.getImage());
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LogInPanel = new JPanel();
		LogInPanel.setBounds(69, 55, 662, 270);
		contentPane.add(LogInPanel);
		LogInPanel.setLayout(null);
		
		NomeUtenteField = new JTextField();
		NomeUtenteField.setBounds(269, 55, 121, 20);
		LogInPanel.add(NomeUtenteField);
		NomeUtenteField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(269, 105, 121, 20);
		LogInPanel.add(passwordField);
		
		JLabel NomeUtenteLabel = new JLabel("Nome Utente:");
		NomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		NomeUtenteLabel.setBounds(154, 57, 101, 14);
		LogInPanel.add(NomeUtenteLabel);
		
		JLabel PasswordLabel = new JLabel("      Password:");
		PasswordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		PasswordLabel.setBounds(154, 107, 101, 14);
		LogInPanel.add(PasswordLabel);
		
		JButton AccediButton = new JButton("ACCEDI");
		AccediButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				AccediButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				AccediButton.setBackground(Color.WHITE);
			}
		});
		

		AccediButton.setFont(new Font("Arial", Font.BOLD, 15));
		AccediButton.setBounds(269, 151, 121, 27);
		LogInPanel.add(AccediButton);
		
		JLabel PasswordDimenticataLabel = new JLabel("Hai dimenticato la Password?");
		PasswordDimenticataLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				System.out.println("cambiami");
			}
		});
		PasswordDimenticataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		PasswordDimenticataLabel.setBounds(227, 211, 207, 14);
		LogInPanel.add(PasswordDimenticataLabel);
		
		JPanel RegistratiPanel = new JPanel();
		RegistratiPanel.setBounds(69, 348, 662, 47);
		contentPane.add(RegistratiPanel);
		RegistratiPanel.setLayout(null);
		
		JButton RegistratiButton = new JButton("REGISTRATI");
		RegistratiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				RegistratiButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				RegistratiButton.setBackground(Color.WHITE);
			}
		});
	
		RegistratiButton.setBounds(262, 11, 137, 27);
		RegistratiButton.setFont(new Font("Arial", Font.BOLD, 15));
		RegistratiPanel.add(RegistratiButton);
		
		JLabel BENVENUTOLabel = new JLabel("BENVENUTO");
		BENVENUTOLabel.setBackground(new Color(255, 255, 255));
		BENVENUTOLabel.setForeground(new Color(0, 0, 0));
		BENVENUTOLabel.setBounds(324, 11, 150, 33);
		BENVENUTOLabel.setFont(new Font("Arial", Font.BOLD, 22));
		contentPane.add(BENVENUTOLabel);
		setVisible(true);
	}
}
