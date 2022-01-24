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
	
	public boolean LogInClicked(String user, String pass) {
		
		Operatori op = new Operatori (user, pass);
		return operatoriDAO.LogIn(op);
		
	}
	
	
	public boolean AccediClicked (String nome, String pass) {
		if(nome.isEmpty()) {
			AlertNomeUtenteNonInserito();
		}
		else 
		{
			if(pass.isEmpty()) {
				AlertPasswordNonInserita();
			}
			else
				{
					if(LogInClicked(nome, pass)) {
						return true;
					}else
					{
						AlertLogInFallito();
						return false;
					}
						
						
				}
		}
		return false;
	}
	
	public void AlertLogInFallito() {
		JOptionPane.showMessageDialog(homePage, "Nome utente o password non validi, riprova.","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	
	public void AlertNomeUtenteNonInserito() {
		JOptionPane.showMessageDialog(homePage, "Nome Utente non inserito!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
	public void AlertPasswordNonInserita() {
		JOptionPane.showMessageDialog(homePage, "Password non inserita!","<ATTENZIONE>", JOptionPane.WARNING_MESSAGE);
	}
	
}
