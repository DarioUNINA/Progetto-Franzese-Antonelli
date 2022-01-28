package gui;

import java.awt.BorderLayout;
import dto.Operatori;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class EliminaCorsoPage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Operatori operatore;

	
	public EliminaCorsoPage(Controller controller, Operatori operatore) {
		
		theController = controller;
		this.operatore = operatore;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JComboBox corsiComboBox = new JComboBox(theController.getCorsiOperatore(operatore));
		
		//corsiComboBox.
		corsiComboBox.setBounds(148, 97, 174, 22);
		contentPane.add(corsiComboBox);
		setVisible(true);
	}
	
	
	
	
	
		
}
