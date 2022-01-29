package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Corsi;
import dto.Operatori;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class HomePage extends JFrame {

	private JPanel sfondoPane;
	private Component url;
	private Controller theController;
	private ImageIcon imageicon;
	private Operatori operatore;
	private JTextField paroleChiaveTextField;
	
	public HomePage(Controller cont, Operatori operatore) {
		
		imageicon = new ImageIcon("napule.png");
		theController = cont;
		setIconImage(imageicon.getImage());

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		sfondoPane = new JPanel();
		sfondoPane.setBackground(new Color(65, 105, 225));
		sfondoPane.setBorder(null);
		setContentPane(sfondoPane);
		sfondoPane.setLayout(null);
		
		JPanel benvenuto = new JPanel();
		benvenuto.setBackground(SystemColor.control);
		benvenuto.setBounds(10, 11, 777, 77);
		sfondoPane.add(benvenuto);
		benvenuto.setLayout(null);
		
		JLabel benvenutoLabel = new JLabel("");
		benvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		benvenutoLabel.setBounds(10, -2, 352, 44);
		benvenuto.add(benvenutoLabel);
		benvenutoLabel.setText("Benvenuto, " + operatore.getNomeUtente().toUpperCase());
		
		JButton impostazioniButton = new JButton("IMPOSTAZIONI");
		impostazioniButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				impostazioniButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				impostazioniButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ImpostazioniPage imp = new ImpostazioniPage(theController, operatore);
				setVisible(false);
			}
		});
		impostazioniButton.setFont(new Font("Arial", Font.BOLD, 15));
		impostazioniButton.setBounds(615, 11, 152, 23);
		benvenuto.add(impostazioniButton);
		
		JButton esciButton = new JButton("ESCI");
		esciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				esciButton.setBackground(Color.RED);
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				esciButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				alertReturnToLogIn();
				
			}
		});

		
		esciButton.setFont(new Font("Arial", Font.BOLD, 15));
		esciButton.setBounds(615, 43, 152, 23);
		benvenuto.add(esciButton);
		
		JPanel filtri = new JPanel();
		filtri.setBackground(SystemColor.control);
		filtri.setBounds(10, 99, 261, 253);
		sfondoPane.add(filtri);
		filtri.setLayout(null);
		
		JLabel filtriLabel = new JLabel("FILTRI:");
		filtriLabel.setBounds(10, 11, 212, 23);
		filtriLabel.setFont(new Font("Arial", Font.BOLD, 18));
		filtri.add(filtriLabel);
		
		JLabel areaTematicaLabel = new JLabel("Area Tematica:");
		areaTematicaLabel.setBounds(10, 47, 89, 14);
		areaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(areaTematicaLabel);
		
		JLabel annoLabel = new JLabel("Anno:");
		annoLabel.setBounds(10, 86, 89, 14);
		annoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		annoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		filtri.add(annoLabel);
		
		JLabel terminatoLabel = new JLabel("Terminato:");
		terminatoLabel.setBounds(10, 128, 89, 14);
		terminatoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(terminatoLabel);
		
		JLabel parolaChiaveLabel = new JLabel("Parola Chiave:");
		parolaChiaveLabel.setBounds(10, 170, 89, 14);
		parolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 12));
		filtri.add(parolaChiaveLabel);
		
		JComboBox areaTematicaComboBox = new JComboBox(theController.setAreaTematicaComboBox());
		areaTematicaComboBox.setBounds(117, 43, 134, 22);
		filtri.add(areaTematicaComboBox);
				
		JComboBox annoComboBox = new JComboBox(theController.setAnnoComboBox());
		annoComboBox.setBounds(117, 82, 134, 22);
		filtri.add(annoComboBox);
		
		JCheckBox terminatoCheckBox = new JCheckBox("SI");
		terminatoCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(terminatoCheckBox.getSelectedObjects() != null)
					terminatoCheckBox.setForeground(Color.GREEN);
				else
					terminatoCheckBox.setForeground(Color.BLACK);
			}
		});
		terminatoCheckBox.setFont(new Font("Arial", Font.BOLD, 15));
		terminatoCheckBox.setBounds(117, 124, 46, 23);
		filtri.add(terminatoCheckBox);
		
		paroleChiaveTextField = new JTextField();
		paroleChiaveTextField.setBounds(117, 167, 134, 20);
		filtri.add(paroleChiaveTextField);
		paroleChiaveTextField.setColumns(10);
		
		JPanel addDeleteCorsi = new JPanel();
		addDeleteCorsi.setBackground(SystemColor.control);
		addDeleteCorsi.setBounds(10, 363, 261, 77);
		sfondoPane.add(addDeleteCorsi);
		addDeleteCorsi.setLayout(null);
		
		JButton aggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
		aggiungiCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		aggiungiCorsoButton.setBounds(22, 11, 212, 25);
		addDeleteCorsi.add(aggiungiCorsoButton);
		
		JButton eliminaCorsoButton = new JButton("ELIMINA CORSO");
		eliminaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EliminaCorsoPage ep = new EliminaCorsoPage(theController, operatore);
				setVisible(false);
				
			}
		});
		eliminaCorsoButton.setBounds(22, 41, 212, 25);
		addDeleteCorsi.add(eliminaCorsoButton);
		eliminaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		JPanel corsi = new JPanel();
		corsi.setBackground(SystemColor.control);
		corsi.setBounds(281, 99, 506, 166);
		sfondoPane.add(corsi);
		corsi.setLayout(null);
		
		List corsiList = new List();
		corsiList.setBounds(10, 10, 222, 146);
		corsi.add(corsiList);
		
		JPanel gestione = new JPanel();
		gestione.setBackground(SystemColor.control);
		gestione.setBounds(281, 274, 506, 166);
		sfondoPane.add(gestione);
		gestione.setLayout(null);
		
		JButton gestioneCorsiButton = new JButton("GESTIONE CORSI");
		gestioneCorsiButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneCorsiButton.setBounds(322, 26, 174, 22);
		gestione.add(gestioneCorsiButton);
		
		JButton gestioneLezioniButton = new JButton("GESTIONE LEZIONI");
		gestioneLezioniButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneLezioniButton.setBounds(322, 71, 174, 22);
		gestione.add(gestioneLezioniButton);
		
		JButton gestioneStudentiButton = new JButton("GESTIONE STUDENTI");
		gestioneStudentiButton.setFont(new Font("Arial", Font.BOLD, 13));
		gestioneStudentiButton.setBounds(322, 115, 174, 22);
		gestione.add(gestioneStudentiButton);
		
		JButton resetFiltriButton = new JButton("RESET");
		resetFiltriButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				areaTematicaComboBox.setSelectedIndex(0);
				annoComboBox.setSelectedIndex(0);
				terminatoCheckBox.setSelected(false);
				terminatoCheckBox.setForeground(Color.BLACK);
				paroleChiaveTextField.setText("");
		
			}
		});
		resetFiltriButton.setForeground(Color.RED);
		resetFiltriButton.setBounds(10, 219, 89, 23);
		resetFiltriButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(resetFiltriButton);
		
		JButton filtraButton = new JButton("FILTRA");
		filtraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String areaTematica = areaTematicaComboBox.getSelectedItem().toString();
				String anno = annoComboBox.getSelectedItem().toString();
				boolean terminato ; 
				if(terminatoCheckBox.isSelected())
					terminato = true;
				else
					terminato = false;
				
				String parolaChiave = paroleChiaveTextField.getText();	
				
				Vector<Corsi> prova;
				
				prova = theController.setCorsiFiltrati(areaTematica, anno, terminato, parolaChiave);
					
			}
		});
		filtraButton.setForeground(new Color(65, 105, 225));
		filtraButton.setBounds(162, 219, 89, 23);
		filtraButton.setFont(new Font("Arial", Font.BOLD, 15));
		filtri.add(filtraButton);
		
		setVisible(true);
	}
	
	
	public void alertReturnToLogIn() {
		Object[] opzioni = {"Sì"};
		
		int n = JOptionPane.showOptionDialog(this,
				"Sei sicuro di voler uscire?",
				"CONFERMA DI USCITA",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opzioni,
				opzioni[0]);
		if(n==0) {
			LogInPage LI = new LogInPage(theController);
			setVisible(false);
		}
			
		}
}
