package gui;

import javax.swing.JOptionPane;

import dao.*;
import dto.*;

public class Controller {

	private HomePage homePage;
	private CorsiDAO corsiDAO;
	private AreeTematicheDAO areeTematicheDAO;
	private IscrizioniDAO iscrizioniDAO;
	private LezioniDAO lezioniDAO;
	private OperatoriDAO operatoriDAO;
	private PresenzeDAO presenzeDAO;
	private StudentiDAO studentiDAO;
	private TemiDAO temiDAO;

	public static void main(String[] args) {

		Controller controller = new Controller();

	}

	public Controller() {

		corsiDAO = new CorsiDAO();
		areeTematicheDAO = new AreeTematicheDAO();
		iscrizioniDAO = new IscrizioniDAO();
		lezioniDAO = new LezioniDAO();
		operatoriDAO = new OperatoriDAO();
		presenzeDAO = new PresenzeDAO();
		studentiDAO = new StudentiDAO();
		temiDAO = new TemiDAO();
		
		homePage = new HomePage(this);

	}
	
	public void AccediClicked(String user, String pass) {
		
		
		Operatori op = new Operatori (user, pass);
		if(operatoriDAO.LogIn(op))
			System.out.println("login effettuato");
		else
			System.out.println("login non effettuato");
		
	}
	
	
	public void AlertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(homePage, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void AlertPasswordNonInserita() {
		JOptionPane.showMessageDialog(homePage, "Password non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
}
