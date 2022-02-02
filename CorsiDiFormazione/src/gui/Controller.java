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
		
	public Vector<DomandeSicurezza> getDomandeSicurezza() {
		
		return domandeSicurezzaDAO.getDomande();
	}
	
	public String setDomandaLabelRecuperoPassPage(Operatori operatore) {

		return domandeOperatoriDAO.getDomandaOperatore(operatoriDAO.getIdOperatoreNoPassword(operatore));
	
	}
	
	public String confermaRispostaSicurezzaClicked(String Risposta, Operatori operatore) {
		

		return domandeOperatoriDAO.checkRisposta(Risposta, operatoriDAO.getIdOperatoreNoPassword(operatore));
		
	}

	public String confermaCambioPassword(Operatori op, String pass) {

		return operatoriDAO.modificaPassword(op, pass);
	}
	
	public Vector<AreeTematiche> setAreaTematicaComboBox() {
		
		return areeTematicheDAO.getAllAreeTematiche();
	}
	
	public Vector<String> setAnnoComboBox(){
		
		return corsiDAO.getAnno();
	}
	
	public Vector<Corsi> setCorsiFiltrati(String areaTematica, String anno, boolean terminatoSi, boolean terminatoNo, String parolaChiave, String idOperatore){
		
		return corsiDAO.addFiltri(areaTematica, anno, terminatoSi, terminatoNo, parolaChiave, idOperatore);
	}
	
	Operatori getOperatore(String nome) {
		
		return operatoriDAO.getOperatore(nome);
	}
	
	public Vector<Corsi> getCorsiOperatore(Operatori op){
		
		return corsiDAO.getCorsiOperatore(op);		
	}
	
	public String confermaCambioNomeUtente(String nomeUtente, Operatori vecchio) {
		

		return operatoriDAO.modificaNomeUtente(nomeUtente, vecchio);
	}
	
	public void eliminaCorso(String nomeCorso) {
		
		operatoriDAO.eliminaCorsiImpostazioni(nomeCorso);

	}

	public Operatori getOperatoreRecuperoPass(String nome) {
		
		return operatoriDAO.getOperatoreRecuperoPass(nome);
	}
	
	public String aggiungiCorsoClicked(String nome, String descrizione, String paroleChiave, String anno, String presenzeMin, String maxPartecipanti, boolean terminato, String idOperatore, Vector<AreeTematiche> areeTematiche) {
		
		String state = corsiDAO.aggiungiCorso(nome, descrizione, paroleChiave, anno, presenzeMin, maxPartecipanti, terminato, idOperatore);
		
		if(state.equals("0"))
			return temiDAO.inserisciTemi(corsiDAO.getIdCorso(nome), areeTematiche);
		else
			return state;
			
			
	}
	
	public boolean isDigits(String stringa) {
		
		try {
			
			Integer.parseInt(stringa);
			
			return true;
		}catch(NumberFormatException e) {
			
			return false;
		}
	}
	
	public Vector<Studenti> setStudenti(){
		
		return studentiDAO.getStudenti();
	}
	
	Studenti setSingoloStudente(String matricola){
		
		return studentiDAO.getSingoloStudente(matricola);
	}
	
	public Vector<Corsi> setCorsiStudente(Studenti s){
		
		 return corsiDAO.getCorsiStudente(s);		
	}
	
	
	public Vector<Lezioni> setAllLezioniDelCorso(String id_corso) {
		
		return lezioniDAO.getAllLezioniDelCorso(id_corso);
	}
	
	public Vector<Corsi> setIscrizioneCorsiStudente(String matricola, String id_operatore){
		
		return iscrizioniDAO.getIscrizioneCorsiStudente(matricola, id_operatore);
	}
	
	public Vector<Corsi> setDisiscrizioneCorsiStudente(String matricola, String id_operatore){
		
		return iscrizioniDAO.getDisiscrizioneCorsiStudente(matricola, id_operatore);
	}
	
	Lezioni getLezione(String titolo) {
		
		return lezioniDAO.getLezioni(titolo);
	}
	
	public Vector<Studenti> getStudentiCorso(String id_corso, String id_lezione){
		
		return studentiDAO.getStudentiCorso(id_corso, id_lezione);
	}
	
	public Vector<AreeTematiche> getAllAreeTematiche(){
		
		return areeTematicheDAO.getAllAreeTematiche();
	}
	
	public Vector<Studenti> getAllStudentiIscrittiAllaLezione(String id_lezione) {//da finire
		
		return studentiDAO.getAllStudentiIscrittiAllaLezione(id_lezione);
	}

}


