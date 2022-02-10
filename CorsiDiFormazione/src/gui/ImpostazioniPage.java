package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.awt.Cursor;

public class ImpostazioniPage extends JFrame {

	private Controller theController;
	private Operatori operatore;
	
	private Component url;
	private ImageIcon imageicon;
	private JPanel contentPane;
	private JPanel impostazioniPanel;
	private JButton modificaNomeUtenteButton;
	private JButton modificaPasswordButton;
	private JButton eliminaProfiloButton;
	private JLabel impostazioniLabel;
	private JButton indietroButton;
	
	
	public ImpostazioniPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;

		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		impostazioniPanel = new JPanel();
		impostazioniPanel.setBackground(SystemColor.control);
		impostazioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		impostazioniPanel.setBounds(10, 11, 548, 307);
		contentPane.add(impostazioniPanel);
		impostazioniPanel.setLayout(null);
		
		modificaNomeUtenteButton = new JButton("MODIFICA NOME UTENTE");
		modificaNomeUtenteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificaNomeUtenteButton.setBackground(Color.WHITE);
		modificaNomeUtenteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificaNomeUtentePage mnu = new ModificaNomeUtentePage(theController, operatore);
				setVisible(false);
			}
		});
		modificaNomeUtenteButton.setFont(new Font("Arial", Font.BOLD, 15));
		modificaNomeUtenteButton.setBounds(152, 71, 237, 30);
		impostazioniPanel.add(modificaNomeUtenteButton);
		
		modificaPasswordButton = new JButton("MODIFICA PASSWORD");
		modificaPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificaPasswordButton.setBackground(Color.WHITE);
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
		
		eliminaProfiloButton = new JButton("ELIMINA PROFILO");
		eliminaProfiloButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminaProfiloButton.setForeground(Color.RED);
		eliminaProfiloButton.setBackground(Color.WHITE);
		eliminaProfiloButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alertConfermaEliminaProfilo();
			}
		});
		eliminaProfiloButton.setFont(new Font("Arial", Font.BOLD, 15));
		eliminaProfiloButton.setBounds(155, 218, 234, 30);
		impostazioniPanel.add(eliminaProfiloButton);
		
		impostazioniLabel = new JLabel("IMPOSTAZIONI");
		impostazioniLabel.setForeground(new Color(65, 105, 225));
		impostazioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		impostazioniLabel.setBackground(Color.WHITE);
		impostazioniLabel.setBounds(195, 11, 163, 33);
		impostazioniPanel.add(impostazioniLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		indietroButton.setBackground(Color.WHITE);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestoreCorsiPage hp = new GestoreCorsiPage(theController, operatore);
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
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
			
	public void alertConfermaEliminaProfilo() {
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Per Eliminare il profilo è necessario inserire la Password di sicurezza:");
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel, "Elimina Profilo",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[1]);
		
		if(option == 0) // pressing OK button
		{
			String password = pass.getText();
		    if(operatore.getPassword().equals(password))
		    	alertEliminazioneEseguita();
		    else 
		    	if(password.equals(""))
		    		alertInserirePassword();
		    	else
		    		alertPasswordErrata();
		    
		}
	}
	
	public void alertEliminazioneEseguita() {
		
		String state = theController.eliminaOperatore(operatore);
				
		if(state.equals("0")) {
			JOptionPane.showMessageDialog(this, "Account eliminato con successo","<CONFERMA>", JOptionPane.WARNING_MESSAGE);
			LogInPage lip = new LogInPage(theController);
			setVisible(false);
		}
			
		
		else
			alertErroreEliminazione(state);
	}
	
	public void alertInserirePassword() {
		JOptionPane.showMessageDialog(this, "Inserire la password","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertPasswordErrata() {
		JOptionPane.showMessageDialog(this, "Password errata","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreEliminazione(String state) {
		if(state.equals("-1"))
			JOptionPane.showMessageDialog(this, "Impossibile eliminare l'operatore.\nErrore sconosciuto " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Impossibile eliminare l'operatore.\nCodice d'errore " + state,"<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
}

