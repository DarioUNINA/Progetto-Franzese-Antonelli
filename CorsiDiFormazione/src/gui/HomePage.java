package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Operatori;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	private JPanel SfondoPane;
	private Component url;
	private Controller theController;
	private ImageIcon imageicon;
	private Operatori operatore;
	private JTextField ParoleChiaveTextField;
	
	public HomePage(Controller cont, Operatori operatore) {
		
		imageicon = new ImageIcon("napule.png");
		theController = cont;
		setIconImage(imageicon.getImage());

		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 490);
		SfondoPane = new JPanel();
		SfondoPane.setBackground(new Color(65, 105, 225));
		SfondoPane.setBorder(null);
		setContentPane(SfondoPane);
		SfondoPane.setLayout(null);
		
		JPanel Benvenuto = new JPanel();
		Benvenuto.setBackground(SystemColor.control);
		Benvenuto.setBounds(10, 11, 777, 77);
		SfondoPane.add(Benvenuto);
		Benvenuto.setLayout(null);
		
		JLabel BenvenutoLabel = new JLabel("");
		BenvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		BenvenutoLabel.setBounds(10, -2, 352, 44);
		Benvenuto.add(BenvenutoLabel);
		BenvenutoLabel.setText("Benvenuto, " + operatore.getNomeUtente().toUpperCase());
		
		JButton ImpostazioniButton = new JButton("IMPOSTAZIONI");
		ImpostazioniButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ImpostazioniButton.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImpostazioniButton.setBackground(Color.WHITE);
			}
		});
		ImpostazioniButton.setFont(new Font("Arial", Font.BOLD, 15));
		ImpostazioniButton.setBounds(615, 11, 152, 23);
		Benvenuto.add(ImpostazioniButton);
		
		JButton EsciButton = new JButton("ESCI");
		EsciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				EsciButton.setBackground(Color.RED);
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				EsciButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				alertReturnToLogIn();
				
			}
		});

		
		EsciButton.setFont(new Font("Arial", Font.BOLD, 15));
		EsciButton.setBounds(615, 43, 152, 23);
		Benvenuto.add(EsciButton);
		
		JPanel Filtri = new JPanel();
		Filtri.setBackground(SystemColor.control);
		Filtri.setBounds(10, 99, 232, 253);
		SfondoPane.add(Filtri);
		Filtri.setLayout(null);
		
		JButton ResetFiltriButton = new JButton("RESET");
		ResetFiltriButton.setBounds(10, 219, 89, 23);
		ResetFiltriButton.setFont(new Font("Arial", Font.BOLD, 15));
		Filtri.add(ResetFiltriButton);
		
		JButton FiltraButton = new JButton("FILTRA");
		FiltraButton.setBounds(133, 219, 89, 23);
		FiltraButton.setFont(new Font("Arial", Font.BOLD, 15));
		Filtri.add(FiltraButton);
		
		JLabel FiltriLabel = new JLabel("FILTRI:");
		FiltriLabel.setBounds(10, 11, 212, 23);
		FiltriLabel.setFont(new Font("Arial", Font.BOLD, 18));
		Filtri.add(FiltriLabel);
		
		JLabel AreaTematicaLabel = new JLabel("Area Tematica:");
		AreaTematicaLabel.setBounds(10, 47, 89, 14);
		AreaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		Filtri.add(AreaTematicaLabel);
		
		JLabel AnnoLabel = new JLabel("Anno:");
		AnnoLabel.setBounds(10, 86, 89, 14);
		AnnoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		AnnoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		Filtri.add(AnnoLabel);
		
		JLabel TerminatoLabel = new JLabel("Terminato:");
		TerminatoLabel.setBounds(10, 128, 89, 14);
		TerminatoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		Filtri.add(TerminatoLabel);
		
		JLabel ParolaChiaveLabel = new JLabel("Parola Chiave:");
		ParolaChiaveLabel.setBounds(10, 170, 89, 14);
		ParolaChiaveLabel.setFont(new Font("Arial", Font.BOLD, 12));
		Filtri.add(ParolaChiaveLabel);
		
		JComboBox AreaTematicaComboBox = new JComboBox();
		AreaTematicaComboBox.setBounds(117, 43, 105, 22);
		Filtri.add(AreaTematicaComboBox);
		
		JComboBox AnnoComboBox = new JComboBox();
		AnnoComboBox.setBounds(117, 82, 105, 22);
		Filtri.add(AnnoComboBox);
		
		JCheckBox TerminatoCheckBox = new JCheckBox("SI");
		TerminatoCheckBox.setBounds(117, 124, 46, 23);
		Filtri.add(TerminatoCheckBox);
		
		ParoleChiaveTextField = new JTextField();
		ParoleChiaveTextField.setBounds(117, 167, 105, 20);
		Filtri.add(ParoleChiaveTextField);
		ParoleChiaveTextField.setColumns(10);
		
		JPanel AddDeleteCorsi = new JPanel();
		AddDeleteCorsi.setBackground(SystemColor.control);
		AddDeleteCorsi.setBounds(10, 363, 232, 77);
		SfondoPane.add(AddDeleteCorsi);
		AddDeleteCorsi.setLayout(null);
		
		JButton AggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
		AggiungiCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		AggiungiCorsoButton.setBounds(10, 11, 212, 25);
		AddDeleteCorsi.add(AggiungiCorsoButton);
		
		JButton EliminaCorsoButton = new JButton("ELIMINA CORSO");
		EliminaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		EliminaCorsoButton.setBounds(10, 41, 212, 25);
		AddDeleteCorsi.add(EliminaCorsoButton);
		
		JPanel Corsi = new JPanel();
		Corsi.setBackground(SystemColor.control);
		Corsi.setBounds(252, 99, 535, 166);
		SfondoPane.add(Corsi);
		Corsi.setLayout(null);
		
		List CorsiList = new List();
		CorsiList.setBounds(10, 10, 222, 146);
		Corsi.add(CorsiList);
		
		JPanel Gestione = new JPanel();
		Gestione.setBackground(SystemColor.control);
		Gestione.setBounds(252, 274, 535, 166);
		SfondoPane.add(Gestione);
		Gestione.setLayout(null);
		
		JButton GestioneCorsiButton = new JButton("GESTIONE CORSI");
		GestioneCorsiButton.setFont(new Font("Arial", Font.BOLD, 13));
		GestioneCorsiButton.setBounds(351, 26, 174, 22);
		Gestione.add(GestioneCorsiButton);
		
		JButton GestioneLezioniButton = new JButton("GESTIONE LEZIONI");
		GestioneLezioniButton.setFont(new Font("Arial", Font.BOLD, 13));
		GestioneLezioniButton.setBounds(351, 72, 174, 22);
		Gestione.add(GestioneLezioniButton);
		
		JButton GestioneStudentiButton = new JButton("GESTIONE STUDENTI");
		GestioneStudentiButton.setFont(new Font("Arial", Font.BOLD, 13));
		GestioneStudentiButton.setBounds(351, 115, 174, 22);
		Gestione.add(GestioneStudentiButton);
		
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
