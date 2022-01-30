package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImpostazioniPage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;
	
	public ImpostazioniPage(Controller controller, Operatori operatore) {
		
		theController = controller;

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
		
		JPanel impostazioniPanel = new JPanel();
		impostazioniPanel.setBackground(SystemColor.control);
		impostazioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		impostazioniPanel.setBounds(10, 11, 548, 307);
		contentPane.add(impostazioniPanel);
		impostazioniPanel.setLayout(null);
		
		JButton modificaNomeUtenteButton = new JButton("MODIFICA NOME UTENTE");
		modificaNomeUtenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificaNomeUtente mnu = new ModificaNomeUtente(theController, operatore);
				setVisible(false);
			}
		});
		modificaNomeUtenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		modificaNomeUtenteButton.setBounds(152, 71, 237, 30);
		impostazioniPanel.add(modificaNomeUtenteButton);
		
		JButton modificaPasswordButton = new JButton("MODIFICA PASSWORD");
		modificaPasswordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificaPasswordPage mpp = new ModificaPasswordPage(theController, operatore);
				setVisible(false);
			}
		});
		modificaPasswordButton.setFont(new Font("Arial", Font.BOLD, 15));
		modificaPasswordButton.setBounds(152, 143, 237, 30);
		impostazioniPanel.add(modificaPasswordButton);
		
		JButton eliminaProfiloButton = new JButton("ELIMINA PROFILO");
		eliminaProfiloButton.setFont(new Font("Arial", Font.BOLD, 15));
		eliminaProfiloButton.setBounds(155, 218, 234, 30);
		impostazioniPanel.add(eliminaProfiloButton);
		
		JLabel impostazioniLabel = new JLabel("IMPOSTAZIONI");
		impostazioniLabel.setForeground(new Color(65, 105, 225));
		impostazioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		impostazioniLabel.setBackground(Color.WHITE);
		impostazioniLabel.setBounds(195, 11, 163, 33);
		impostazioniPanel.add(impostazioniLabel);
		
		JButton indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage hp = new HomePage(theController, operatore);
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
		indietroButton.setBounds(10, 273, 121, 23);
		impostazioniPanel.add(indietroButton);
		
		setVisible(true);
	}
			
	
}

