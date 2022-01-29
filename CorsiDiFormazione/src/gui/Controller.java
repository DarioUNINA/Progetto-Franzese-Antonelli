package gui;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import dao.*;
import dto.*;

public class Controller {

	private LogInPage logIn;
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
		
		
		logIn = new LogInPage(this);

	}
	
	public boolean logInClicked(String user, String pass) {
		
		Operatori op = new Operatori (user, pass);
		return operatoriDAO.LogIn(op);
		
	}
	
	public String CheckNomeClicked(String user) {
		
		Operatori op = new Operatori(user);
		return operatoriDAO.CheckNome(op);
		
	}
	
	public String registrazioneClicked(String nome, String pass, String domanda, String risposta) {
		
		Operatori op = new Operatori(nome, pass);
		
		String state = operatoriDAO.insertOperatore(op);
		if(!state.equals("0"))
			return state;
		
		DomandeOperatori dop = new DomandeOperatori(domandeSicurezzaDAO.getIdDomanda(domanda), operatoriDAO.getIdOperatore(op), risposta);
		
		return domandeOperatoriDAO.insertDomandeOperatori(dop);	
		
	}
		
	public Vector<String> getDomandeSicurezza() {
		
		return domandeSicurezzaDAO.getDomande();
	}
	
	public String setDomandaLabelRecuperoPassPage(String nome) {
		
		Operatori op = new Operatori(nome);
		return domandeOperatoriDAO.getDomandaOperatore(operatoriDAO.getIdOperatoreNoPassword(op));
	
	}
	
	public String confermaRispostaSicurezzaClicked(String Risposta, String NomeUtente) {
		
		Operatori op = new Operatori(NomeUtente);
		return domandeOperatoriDAO.checkRisposta(Risposta, operatoriDAO.getIdOperatoreNoPassword(op));
		
	}

	public String confermaCambioPassword(String nomeUtente, String pass) {

		return operatoriDAO.modificaPassword(nomeUtente, pass);
	}
	
	public Vector<String> setAreaTematicaComboBox() {
		
		return areeTematicheDAO.getAree();
	}
	
	public Vector<String> setAnnoComboBox(){
		
		return corsiDAO.getAnno();
	}
	
	public Vector<Corsi> setCorsiFiltrati(String areaTematica, String anno, boolean terminato, String parolaChiave){
		
		return corsiDAO.addFiltri(areaTematica, anno, terminato, parolaChiave);
	}
	Operatori getOperatore(String nome) {
		
		return operatoriDAO.getOperatore(nome);
	}
	
	public Vector<Corsi> getCorsiOperatore(Operatori op){
		
		return corsiDAO.getCorsiOperatore(op);		
	}
	
	public String confermaCambioNomeUtente(String nomeUtente, String vecchioNome) {

		return operatoriDAO.modificaNomeUtente(nomeUtente, vecchioNome);
	}
	
	public void eliminaCorso(Operatori operatore) {
		
		operatoriDAO.eliminaCorso(operatore);
		
		
	}



}


