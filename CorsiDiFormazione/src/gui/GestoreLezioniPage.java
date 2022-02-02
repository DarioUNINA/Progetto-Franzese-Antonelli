package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Operatori;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.Vector;
import javax.swing.JScrollPane;
import dto.Corsi;
import dto.Lezioni;

public class GestoreLezioniPage extends JFrame {

	private JPanel contentPane;
	private Controller theController;
	private Component url;
	private ImageIcon imageicon;
	private Operatori operatore;
	private JList lezioniList;
	
	public GestoreLezioniPage(Controller controller, Operatori operatore) {
		setResizable(false);
		
		
		theController = controller;

		imageicon = new ImageIcon("napule.png");
		setIconImage(imageicon.getImage());
		setTitle("GESTIONE CORSI DI FORMAZIONE");
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel gestoreLezioniPanel = new JPanel();
		gestoreLezioniPanel.setBackground(SystemColor.control);
		gestoreLezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		gestoreLezioniPanel.setBounds(10, 11, 548, 49);
		contentPane.add(gestoreLezioniPanel);
		gestoreLezioniPanel.setLayout(null);
		
		JLabel gestoreLezioniLabel = new JLabel("GESTIONE LEZIONI");
		gestoreLezioniLabel.setForeground(new Color(65, 105, 225));
		gestoreLezioniLabel.setFont(new Font("Arial", Font.BOLD, 22));
		gestoreLezioniLabel.setBackground(Color.WHITE);
		gestoreLezioniLabel.setBounds(164, 11, 223, 33);
		gestoreLezioniPanel.add(gestoreLezioniLabel);
		
		JPanel corsiPanel = new JPanel();
		corsiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		corsiPanel.setBounds(10, 71, 163, 213);
		contentPane.add(corsiPanel);
		corsiPanel.setLayout(null);
		
		JLabel selezionaCorsoLabel = new JLabel("Seleziona Corso:");
		selezionaCorsoLabel.setBounds(21, 7, 121, 18);
		selezionaCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		corsiPanel.add(selezionaCorsoLabel);
		
		JScrollPane corsiScrollPane = new JScrollPane();
		corsiScrollPane.setBounds(10, 36, 143, 134);
		corsiPanel.add(corsiScrollPane);
		
		JList<Corsi> corsiList = new JList<Corsi>(theController.getCorsiOperatore(operatore));
		corsiScrollPane.setViewportView(corsiList);
		corsiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		corsiList.setVisibleRowCount(10);
		corsiList.setFont(new Font("Arial", Font.BOLD, 15));
		
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
		indietroButton.setBounds(395, 295, 163, 23);
		contentPane.add(indietroButton);
		
		JPanel lezioniPanel = new JPanel();
		lezioniPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lezioniPanel.setBounds(183, 71, 375, 213);
		contentPane.add(lezioniPanel);
		lezioniPanel.setLayout(null);
		
		JScrollPane lezioniScrollPane = new JScrollPane();
		lezioniScrollPane.setBounds(10, 40, 201, 162);
		lezioniPanel.add(lezioniScrollPane);
		
		JList<Lezioni> lezioniList = new JList<Lezioni>();
		lezioniScrollPane.setViewportView(lezioniList);
		lezioniList.setVisibleRowCount(10);
		lezioniList.setFont(new Font("Arial", Font.BOLD, 15));
		lezioniList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton confermaCorsoButton = new JButton("CONFERMA");
		confermaCorsoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id_corso = corsiList.getSelectedValue().getIdCorso();
				if(theController.setAllLezioniDelCorso(id_corso).isEmpty())
					alertNessunaLezioneDisponibile();
				else
					lezioniList.setListData(theController.setAllLezioniDelCorso(id_corso));
			}
		});
		confermaCorsoButton.setFont(new Font("Arial", Font.BOLD, 15));
		confermaCorsoButton.setBounds(21, 179, 121, 23);
		corsiPanel.add(confermaCorsoButton);
		
		JLabel elencoLezioneDelCorsoLabel = new JLabel("Elenco Lezione del Corso:");
		elencoLezioneDelCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		elencoLezioneDelCorsoLabel.setBounds(10, 11, 203, 18);
		lezioniPanel.add(elencoLezioneDelCorsoLabel);
		
		JButton panormaicaLezioneButton = new JButton("PANORAMICA");
		panormaicaLezioneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String lezioneSelezionata = lezioniList.getSelectedValue().getTitolo();
				PanoramicaLezionePage pl = new PanoramicaLezionePage(theController, operatore, theController.getLezione(lezioneSelezionata));
				setVisible(false);
			}
		});
		panormaicaLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		panormaicaLezioneButton.setBounds(223, 73, 142, 23);
		lezioniPanel.add(panormaicaLezioneButton);
		
		JButton eliminaLezioneButton = new JButton("ELIMINA");
		eliminaLezioneButton.setFont(new Font("Arial", Font.BOLD, 12));
		eliminaLezioneButton.setBounds(223, 147, 142, 23);
		lezioniPanel.add(eliminaLezioneButton);
		
		JButton aggiungiLezioneButton_1 = new JButton("AGGIUNGI LEZIONE");
		aggiungiLezioneButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreazioneLezionePage clp = new CreazioneLezionePage(theController, operatore);
				setVisible(false);
			}
		});
		aggiungiLezioneButton_1.setBounds(20, 296, 142, 23);
		contentPane.add(aggiungiLezioneButton_1);
		aggiungiLezioneButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		setVisible(true);
	}
	
	public void alertNessunaLezioneDisponibile() {
		JOptionPane.showMessageDialog(this, "Non ci sono lezione per il Corso selezionato.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);	
	}
}
