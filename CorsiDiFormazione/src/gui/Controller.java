package gui;

import java.sql.Time;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
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
	private ParoleChiaveDAO paroleChiaveDAO;
	private CaratterizzaDAO caratterizzaDAO;

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
		paroleChiaveDAO = new ParoleChiaveDAO();
		
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
	
	public Vector<Corsi> setCorsiFiltrati(Vector<AreeTematiche> area, String anno, boolean terminatoSi, boolean terminatoNo, Vector<ParoleChiave> parole, String idOperatore){
		
		return corsiDAO.addFiltri(area, anno, terminatoSi, terminatoNo, parole, idOperatore);
	}
	
	public Vector<Corsi> setCorsiFiltratiPartialMatch(Vector<AreeTematiche> area, String anno, boolean terminatoSi, boolean terminatoNo, Vector<ParoleChiave> parole, String idOperatore){
		
		return corsiDAO.addFiltriPartialMatch(area, anno, terminatoSi, terminatoNo, parole, idOperatore);
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
	
	public Vector<Corsi> setCorsiStudente(String matricola, String id_operatore){
		
		 return corsiDAO.getCorsiStudente(matricola, id_operatore);		
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
	
	public Vector<Studenti> getAllStudentiIscrittiAllaLezione(String id_lezione) {
		
		return studentiDAO.getAllStudentiIscrittiAllaLezione(id_lezione);
	}
	
	public String aggiungiStudenteLezioneClicked(String matricola, String id_lezione) {		
		
		return presenzeDAO.aggiungiStudenteLezione(matricola, id_lezione);
			
	}


	public String eliminaLezione(String idLezione) {
	
		return lezioniDAO.eliminaLezioneGestoreLezioni(idLezione);
	}
	
	Corsi getCorso(String id_corso) {
		
		return corsiDAO.getCorso(id_corso);
	}
	
	public DefaultListModel <JCheckBox> setModelCheckBox (Vector<AreeTematiche> areeTematiche){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
		JCheckBox checkBox;
		
		for(AreeTematiche area:areeTematiche) {
			checkBox = new JCheckBox(area.getNomeArea());
			checkBoxList.add(checkBox);
		}
		
		DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
		model.addAll(checkBoxList);
		
		return model;
		
	}
	
	public DefaultListModel <JCheckBox> setModelCheckBoxParole (Vector<ParoleChiave> paroleChiave){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
		JCheckBox checkBox;
		
		for(ParoleChiave parola:paroleChiave) {
			checkBox = new JCheckBox(parola.getParolaChiave());
			checkBoxList.add(checkBox);
		}
		
		DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
		model.addAll(checkBoxList);
		
		return model;
		
	}

	public String eliminaOperatore(Operatori operatore) {
		
		return operatoriDAO.eliminaOperatore(operatore);
		
	}
	
	public void eliminaStudente(String matricola) {
		
		studentiDAO.eliminaStudente(matricola);
	}
	
	public String aggiungiStudenteCorso(String matricola, String id_corso) {
		
		return iscrizioniDAO.aggiungiStudenteCorso(matricola, id_corso);
			
	}
	
	public String disiscriviStudenteCorso(String matricola, String id_corso) {
		
		return iscrizioniDAO.disiscriviStudenteCorso(matricola,id_corso);
	}
	
	public Vector<Lezioni> iscirizioneStudenteLezioniDelCorso(String matricola, String id_corso) {
		
		return lezioniDAO.iscirizioneStudenteLezioniDelCorso(matricola, id_corso);
	}
	
	public Vector<Corsi> setCorsiStudenteDelOperatore(String matricola, String id_operatore){
		
		 return corsiDAO.setCorsiStudenteDelOperatore(matricola, id_operatore);		
	}
	

	public String eliminaPrenotazione(String idLezione, String matricola){
		
		return presenzeDAO.eliminaPresenza(idLezione, matricola);
	}
	
	public Vector<Lezioni> getPresenzeStudente(String matricola, String id_corso) {
		
		return lezioniDAO.getPresenzeStudente(matricola, id_corso);
	}
	
	
	public Vector<Time> getDurate(){
		
		Vector<Time> durate = new Vector<Time>();
		
		Time durata = new Time(1, 00, 00);
		durate.add(durata);
		durata = new Time(1, 30, 00);
		durate.add(durata);
		durata = new Time(2, 00, 00);
		durate.add(durata);
		
		return durate;
	}
	
	
	public Vector<Time> getOrario(){
		
		Vector<Time> orari = new Vector<Time>();
		
		Time orario = new Time(8, 30, 00);
		orari.add(orario);
		orario = new Time(11, 00, 00);
		orari.add(orario);
		orario = new Time(14, 00, 00);
		orari.add(orario);
		orario = new Time(16, 30, 00);
		orari.add(orario);
		
		return orari;
	}
	
	public String creaLezione(String titolo, String descrizione, Time orario, Time durata, Date data, String idCorso) {
		
		Lezioni lezione = new Lezioni(durata, titolo , descrizione, orario, idCorso, data);
		
		return lezioniDAO.creaLezione(lezione);
	}
	
	public Vector<AreeTematiche> getAreeSelezionate(JCheckBoxList box, Vector<AreeTematiche> aree){
		
		Vector<AreeTematiche> vettore = new Vector<AreeTematiche>();
		
		for(int i=0;i<aree.size();i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(aree.get(i));
		
		return vettore;
	}
	
	
	public Vector<String> getMesi(){
		
		Vector<String> vettore = new Vector<String>();
		
		vettore.add("Gennaio");
		vettore.add("Febbraio");
		vettore.add("Marzo");
		vettore.add("Aprile");
		vettore.add("Maggio");
		vettore.add("Giugno");
		vettore.add("Luglio");
		vettore.add("Agosto");
		vettore.add("Settembre");
		vettore.add("Ottobre");
		vettore.add("Novembre");
		vettore.add("Dicembre");
		
		return vettore;
	}
	
	public DefaultListModel <JCheckBox> setModelCheckBoxString(Vector<String> mesi){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
	
		JCheckBox checkBox;

		for(String s:mesi) {
			checkBox = new JCheckBox(s);
			checkBoxList.add(checkBox);
		}
		
		DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
		model.addAll(checkBoxList);
		
		return model;
		
	}
	
	public Vector<ParoleChiave> getParoleSelezionate(JCheckBoxList box, Vector<ParoleChiave> parole){
		
	Vector<ParoleChiave> vettore = new Vector<ParoleChiave>();
	
	for(int i=0;i<parole.size();i++)
		if(box.getModel().getElementAt(i).isSelected())
			vettore.add(parole.get(i));
	
	return vettore;
	}

	public Vector<ParoleChiave> getAllParoleChiave(){
	
		return paroleChiaveDAO.getAllParoleChiave();
	
	}
	
	public Vector<String> getGiorni(){
		
		Vector<String> vettore = new Vector<String>();
		
		for(int i=1;i<32;i++)
			vettore.add(String.valueOf(i));
		
		return vettore;
	}

}
