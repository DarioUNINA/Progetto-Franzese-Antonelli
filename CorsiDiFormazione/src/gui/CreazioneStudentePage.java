package gui;

import dto.Operatori;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreazioneStudentePage extends JFrame {

	private JPanel contentPane;
	private Operatori operatore;
	private Controller theController;

	
	public CreazioneStudentePage(Controller controller, Operatori operatore) {
		
		this.operatore = operatore;
		theController = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
