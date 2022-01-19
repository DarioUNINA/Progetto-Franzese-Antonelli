package CorsiDiFormazione;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class HomePage extends JFrame {


	private JPanel contentPane;
	private JTextField passwordtextField_;
	private JTextField NomeUtenteField_1;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
					
					frame.getContentPane().setBackground(Color.	LIGHT_GRAY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NomeUtenteLabel = new JLabel(" Nome Utente:");
		NomeUtenteLabel.setBounds(128, 69, 105, 41);
		contentPane.add(NomeUtenteLabel);
		
		JLabel PasswordLabel_ = new JLabel("      Password:");
		PasswordLabel_.setBounds(128, 102, 105, 41);
		contentPane.add(PasswordLabel_);
		
		JButton AccediButton = new JButton("ACCEDI");
		AccediButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AccediButton.setBounds(233, 143, 106, 32);
		contentPane.add(AccediButton);
		AccediButton.setBackground(Color.WHITE);
		
		JButton PasswordDimenticataButton = new JButton("Hai dimenticato la Password?");
		PasswordDimenticataButton.setAction(action);
		PasswordDimenticataButton.setBounds(170, 195, 232, 20);
		contentPane.add(PasswordDimenticataButton);
		PasswordDimenticataButton.setBackground(Color.WHITE);
		
		JButton RegistrazioneButton = new JButton("REGISTRATI");
		RegistrazioneButton.setBounds(10, 290, 105, 32);
		contentPane.add(RegistrazioneButton);
		RegistrazioneButton.setBackground(Color.RED);
		
		passwordtextField_ = new JTextField();
		passwordtextField_.setColumns(10);
		passwordtextField_.setBounds(223, 112, 127, 20);
		contentPane.add(passwordtextField_);
		
		NomeUtenteField_1 = new JTextField();
		NomeUtenteField_1.setColumns(10);
		NomeUtenteField_1.setBounds(223, 79, 127, 20);
		contentPane.add(NomeUtenteField_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("ciao");
		}
	}
}
