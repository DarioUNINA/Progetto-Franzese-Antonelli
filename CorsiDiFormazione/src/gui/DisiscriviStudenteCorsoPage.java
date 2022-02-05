package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dto.Corsi;
import dto.Operatori;
import dto.Studenti;

public class DisiscriviStudenteCorsoPage extends JFrame {
	
	private Controller theController;
	private Operatori operatore;
	private Studenti studente;
	private Vector<Corsi> corsi;
	private JComboBox<Corsi> corsiComboBox;
	
	private ImageIcon imageicon;
	private Component url;
	private JPanel contentPane;
	private JPanel disiscriviLezioneStudentiPanel;
	private JLabel aggiungiStudenteAlCorsoLabel;
	private JButton indietroButton;
	private JButton eliminaButton;
	private JLabel selezionareCorsoLabel;
	private JLabel datiStudenteLabel;
	
	public DisiscriviStudenteCorsoPage(Controller controller, Operatori operatore, Studenti studente) {
		setResizable(false);
		
		theController = controller;
		this.operatore = operatore;
		this.studente = studente;

		corsi =theController.setDisiscrizioneCorsiStudente(studente.getMatricola(), operatore.getIdOperatore());
		corsiComboBox = new JComboBox<Corsi>(corsi);
		
		
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
		
		disiscriviLezioneStudentiPanel = new JPanel();
		disiscriviLezioneStudentiPanel.setBackground(SystemColor.control);
		disiscriviLezioneStudentiPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		disiscriviLezioneStudentiPanel.setBounds(10, 11, 548, 307);
		contentPane.add(disiscriviLezioneStudentiPanel);
		disiscriviLezioneStudentiPanel.setLayout(null);
		
		aggiungiStudenteAlCorsoLabel = new JLabel("DISISCRIVI STUDENTE DAL CORSO");
		aggiungiStudenteAlCorsoLabel.setForeground(new Color(65, 105, 225));
		aggiungiStudenteAlCorsoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		aggiungiStudenteAlCorsoLabel.setBackground(Color.WHITE);
		aggiungiStudenteAlCorsoLabel.setBounds(86, 11, 385, 33);
		disiscriviLezioneStudentiPanel.add(aggiungiStudenteAlCorsoLabel);
		
		indietroButton = new JButton("INDIETRO");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanoramicaSingoloStudentePage gss = new PanoramicaSingoloStudentePage(theController, operatore, studente);
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
		disiscriviLezioneStudentiPanel.add(indietroButton);
		
		eliminaButton = new JButton("ELIMINA");
		eliminaButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				eliminaButton.setBackground(Color.GREEN);
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				eliminaButton.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String state = theController.disiscriviStudenteCorso(studente.getMatricola(), corsi.get(corsiComboBox.getSelectedIndex()).getIdCorso());
				
				if(state.equals("0")) {
					alertStudenteDisiscrittoCorrettamente();
					PanoramicaSingoloStudentePage pssp = new  PanoramicaSingoloStudentePage(theController, operatore, studente);
					setVisible(false);
				}else
					alertErroreDisiscrizioneStudente(state);
				
			}
		});
		eliminaButton.setFont(new Font("Arial", Font.BOLD, 15));
		eliminaButton.setBounds(417, 274, 121, 23);
		disiscriviLezioneStudentiPanel.add(eliminaButton);
		
		selezionareCorsoLabel = new JLabel("Selezionare corso:");
		selezionareCorsoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		selezionareCorsoLabel.setBounds(51, 131, 136, 23);
		disiscriviLezioneStudentiPanel.add(selezionareCorsoLabel);
		
		corsiComboBox.setBounds(193, 132, 163, 22);
		disiscriviLezioneStudentiPanel.add(corsiComboBox);
		
		datiStudenteLabel = new JLabel("STUDENTE:  " + studente.getMatricola() + ",  " + studente.getCognome().toUpperCase() + ",  " + studente.getNome().toUpperCase());
		datiStudenteLabel.setFont(new Font("Arial", Font.BOLD, 15));
		datiStudenteLabel.setBounds(51, 106, 414, 14);
		disiscriviLezioneStudentiPanel.add(datiStudenteLabel);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		if(corsiComboBox.getSelectedItem() == null) {
			alertNonCiSonoCorsiDisponibili();
			PanoramicaSingoloStudentePage pssp = new  PanoramicaSingoloStudentePage(theController, operatore, studente);
			setVisible(false);
		}
	}

	public void alertNonCiSonoCorsiDisponibili() {
		JOptionPane.showMessageDialog(this, "Lo studente non � iscritto a nessun corso del professore: " + operatore.getNomeUtente().toUpperCase()  + "!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertStudenteDisiscrittoCorrettamente() {
		JOptionPane.showMessageDialog(this, "Studente disiscritto correttamente!","<CONFERMA>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertErroreDisiscrizioneStudente(String state) {
			JOptionPane.showMessageDialog(this, "Errore durante l'iscrizione al corso","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
}
