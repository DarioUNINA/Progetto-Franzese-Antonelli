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
	private DomandeSicurezzaDAO domandeSicurezzaDAO;
	private DomandeOperatoriDAO domandeOperatoriDAO;

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
		domandeSicurezzaDAO = new DomandeSicurezzaDAO ();
		domandeOperatoriDAO = new DomandeOperatoriDAO();
		
		
		homePage = new HomePage(this);

	}
	
	public boolean logInClicked(String user, String pass) {
		
		Operatori op = new Operatori (user, pass);
		return operatoriDAO.LogIn(op);
		
	}

	public boolean homePageAccediClicked (String nome, String pass) {
		if(nome.isEmpty())
			alertNomeUtenteNonInserito();
		else 
			if(pass.isEmpty())
				alertPasswordNonInserita();
			else
				if(logInClicked(nome, pass))
					return true;
				else
				{
					alertLogInFallito();
					return false;
				}

		return false;
	}
	
	public void alertLogInFallito() {
		JOptionPane.showMessageDialog(homePage, "Nome utente o password non validi, riprova.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(homePage, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertPasswordNonInserita() {
		JOptionPane.showMessageDialog(homePage, "Password non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public boolean registrazionePageConfermaClicked(String nome, String pass, String domanda, String risposta) {
		
		if(nome.isEmpty())
			alertNomeUtenteNonInserito();
		else 
			if(pass.isEmpty())
				alertPasswordNonInserita();
				else
					if(risposta.isEmpty())
						alertRispostaNonInserita();
					else
						return registrazioneClicked(nome, pass, domanda, risposta);
		return false;
	}
					
	public boolean registrazioneClicked(String nome, String pass, String domanda, String risposta) {
		
		Operatori op = new Operatori(nome, pass);
		if(!operatoriDAO.insertOperatore(op)) {
			return false;
		}
		DomandeOperatori dop = new DomandeOperatori(domandeSicurezzaDAO.getIdDomanda(domanda), operatoriDAO.getIdOperatore(op), risposta);
		
		return domandeOperatoriDAO.insertDomandeOperatori(dop);
				
	}
			
	public void alertRispostaNonInserita() {
		JOptionPane.showMessageDialog(homePage, "Risposta non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
}
