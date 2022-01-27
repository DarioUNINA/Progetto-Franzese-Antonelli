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
import javax.swing.JScrollBar;
import java.awt.Button;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private Component url;
	private Controller theController;
	private ImageIcon imageicon;
	private Operatori operatore;
	
	public HomePage(Controller cont, Operatori operatore) {
		
		imageicon = new ImageIcon("napule.png");
		theController = cont;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 11, 777, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel BenvenutoLabel = new JLabel("");
		BenvenutoLabel.setFont(new Font("Arial", Font.BOLD, 30));
		BenvenutoLabel.setBounds(10, -2, 352, 44);
		panel.add(BenvenutoLabel);
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
		panel.add(ImpostazioniButton);
		
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
				LogInPage LI = new LogInPage(theController);
				setVisible(false);
			}
		});

		
		EsciButton.setFont(new Font("Arial", Font.BOLD, 15));
		EsciButton.setBounds(615, 43, 152, 23);
		panel.add(EsciButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 99, 232, 253);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton ResetFiltriButton = new JButton("RESET");
		ResetFiltriButton.setBounds(10, 219, 89, 23);
		ResetFiltriButton.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(ResetFiltriButton);
		
		JButton FiltraButton = new JButton("FILTRA");
		FiltraButton.setBounds(133, 219, 89, 23);
		FiltraButton.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(FiltraButton);
		
		JLabel FiltriLabel = new JLabel("FILTRI:");
		FiltriLabel.setBounds(10, 11, 212, 23);
		FiltriLabel.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(FiltriLabel);
		
		JLabel AreaTematicaLabel = new JLabel("Area Tematica:");
		AreaTematicaLabel.setBounds(10, 47, 89, 14);
		AreaTematicaLabel.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(AreaTematicaLabel);
		
		JLabel AnnoLabel = new JLabel("Anno:");
		AnnoLabel.setBounds(10, 86, 89, 14);
		AnnoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		AnnoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(AnnoLabel);
		
		JLabel TerminatoLabel = new JLabel("Terminato:");
		TerminatoLabel.setBounds(10, 128, 89, 14);
		TerminatoLabel.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(TerminatoLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Parole Chiave:");
		lblNewLabel_3.setBounds(10, 170, 89, 14);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(117, 43, 105, 22);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(117, 82, 105, 22);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(117, 124, 105, 22);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(117, 166, 105, 22);
		panel_1.add(comboBox_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(10, 363, 232, 77);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton AggiungiCorsoButton = new JButton("AGGIUNGI CORSO");
		AggiungiCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		AggiungiCorsoButton.setBounds(10, 11, 212, 25);
		panel_2.add(AggiungiCorsoButton);
		
		JButton EliminaCorsoButton = new JButton("ELIMINA CORSO");
		EliminaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		EliminaCorsoButton.setBounds(10, 41, 212, 25);
		panel_2.add(EliminaCorsoButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(252, 99, 535, 166);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		List list = new List();
		list.setBounds(10, 10, 222, 146);
		panel_3.add(list);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(SystemColor.control);
		panel_3_1.setBounds(252, 274, 535, 166);
		contentPane.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JButton GestioneCorsiButton = new JButton("GESTIONE CORSI");
		GestioneCorsiButton.setFont(new Font("Arial", Font.BOLD, 13));
		GestioneCorsiButton.setBounds(351, 26, 174, 22);
		panel_3_1.add(GestioneCorsiButton);
		
		JButton GestioneLezioniButton = new JButton("GESTIONE LEZIONI");
		GestioneLezioniButton.setFont(new Font("Arial", Font.BOLD, 13));
		GestioneLezioniButton.setBounds(351, 72, 174, 22);
		panel_3_1.add(GestioneLezioniButton);
		
		JButton GestioneStudentiButton = new JButton("GESTIONE STUDENTI");
		GestioneStudentiButton.setFont(new Font("Arial", Font.BOLD, 13));
		GestioneStudentiButton.setBounds(351, 115, 174, 22);
		panel_3_1.add(GestioneStudentiButton);
		
		setVisible(true);
	}
}
