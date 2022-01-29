package gui;

import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import dto.Operatori;

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

public class LogInPage extends JFrame {

	private JPanel contentPane;
	private Component url;
	private JTextField nomeUtenteField;
	private JPasswordField passwordField;

	private Controller theController;
	private ImageIcon imageicon;

	
	public LogInPage(Controller controller) {
		
		imageicon = new ImageIcon("napule.png");
		theController = controller;
		setIconImage(imageicon.getImage());

		this.setLocationRelativeTo(null);
		
	//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	//	this.setLocation((screenSize.width / 2) - (this.getWidth() / 2 ), (screenSize.height / 2 ) - (this.getHeight() / 2 ));
		
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

		JPanel logInPanel = new JPanel();
		logInPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		logInPanel.setBounds(69, 55, 662, 270);
		contentPane.add(logInPanel);
		logInPanel.setLayout(null);

		nomeUtenteField = new JTextField();
		nomeUtenteField.setBounds(269, 55, 121, 20);
		logInPanel.add(nomeUtenteField);
		nomeUtenteField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(269, 105, 121, 20);
		logInPanel.add(passwordField);

		JLabel nomeUtenteLabel = new JLabel("Nome Utente:");
		nomeUtenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomeUtenteLabel.setBounds(154, 57, 101, 14);
		logInPanel.add(nomeUtenteLabel);

		JLabel passwordLabel = new JLabel("      Password:");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passwordLabel.setBounds(154, 107, 101, 14);
		logInPanel.add(passwordLabel);

		JButton accediButton = new JButton("ACCEDI");
		accediButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				accediButton.setBackground(Color.GREEN);
			};

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
							Operatori op = theController.getOperatore(Nome);
							HomePage hp = new HomePage(theController,op);
							setVisible(false);
						}
					
				nomeUtenteField.setText("");
				passwordField.setText("");
	
			}	
		});

		accediButton.setFont(new Font("Arial", Font.BOLD, 15));
		accediButton.setBounds(269, 151, 121, 27);
		logInPanel.add(accediButton);

		JLabel passwordDimenticataLabel = new JLabel("Hai dimenticato la Password?");
		passwordDimenticataLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				RecuperoPassPage rpp = new RecuperoPassPage(theController);
				setVisible(false);
			}
		});
		
		passwordDimenticataLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passwordDimenticataLabel.setBounds(227, 211, 207, 14);
		logInPanel.add(passwordDimenticataLabel);

		JPanel registratiPanel = new JPanel();
		registratiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		registratiPanel.setBounds(69, 348, 662, 47);
		contentPane.add(registratiPanel);
		registratiPanel.setLayout(null);

		JButton registratiButton = new JButton("REGISTRATI");
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

		registratiButton.setBounds(262, 11, 137, 27);
		registratiButton.setFont(new Font("Arial", Font.BOLD, 15));
		registratiPanel.add(registratiButton);

		JLabel bENVENUTOLabel = new JLabel("BENVENUTO");
		bENVENUTOLabel.setBackground(new Color(255, 255, 255));
		bENVENUTOLabel.setForeground(new Color(0, 0, 0));
		bENVENUTOLabel.setBounds(324, 11, 150, 33);
		bENVENUTOLabel.setFont(new Font("Arial", Font.BOLD, 22));
		contentPane.add(bENVENUTOLabel);
		
		
		
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
