package gui;

import java.sql.Time;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

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
		caratterizzaDAO = new CaratterizzaDAO();
		
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
	
	public Vector<String> getAllAnni(){
		
		return corsiDAO.getAnno();
	}
	
	public Vector<Corsi> setCorsiFiltratiFM(Vector<AreeTematiche> area, Vector<String> anni, boolean terminatoSi, boolean terminatoNo, Vector<ParoleChiave> parole, String idOperatore){
		
		return corsiDAO.addCorsiFiltratiFM(area, anni, terminatoSi, terminatoNo, parole, idOperatore);
	}
	
	public Vector<Corsi> setCorsiFiltratiPM(Vector<AreeTematiche> area, Vector<String> anni, boolean terminatoSi, boolean terminatoNo, Vector<ParoleChiave> parole, String idOperatore){
		
		return corsiDAO.addCorsiFiltratiPM(area, anni, terminatoSi, terminatoNo, parole, idOperatore);
	}
	
	Operatori getOperatore(String nome) {
		
		return operatoriDAO.getOperatore(nome);
	}
	
	public Vector<Corsi> getCorsiDisponibiliOperatore(Operatori op){
		
		return corsiDAO.getCorsiDisponibiliOperatore(op);		
	}
	
	
	public Vector<Corsi> getCorsiOperatore(Operatori op){
		
		return corsiDAO.getCorsiOperatore(op);		
	}
	
	public String confermaCambioNomeUtente(String nomeUtente, Operatori vecchio) {
		

		return operatoriDAO.modificaNomeUtente(nomeUtente, vecchio);
	}
	
	public String eliminaCorso(String nomeCorso) {
		
		return operatoriDAO.eliminaCorsiImpostazioni(nomeCorso);

	}

	public Operatori getOperatoreRecuperoPass(String nome) {
		
		return operatoriDAO.getOperatoreRecuperoPass(nome);
	}
	
	public String aggiungiCorsoClicked(String nome, String descrizione, Vector<ParoleChiave> paroleChiave, String anno, String presenzeMin, String maxPartecipanti, boolean terminato, String idOperatore, Vector<AreeTematiche> areeTematiche) {
		
		String state = corsiDAO.aggiungiCorso(nome, descrizione, anno, presenzeMin, maxPartecipanti, terminato, idOperatore);
		
		if(state.equals("0"))
			state = temiDAO.inserisciTemi(corsiDAO.getIdCorso(nome), areeTematiche);
			if(state.equals("0"))
				return state = caratterizzaDAO.inserisciCaratterizza(corsiDAO.getIdCorso(nome), paroleChiave);
			
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
	
	public DefaultListModel <JCheckBox> setModelCheckBox(Vector<AreeTematiche> areeTematiche, String idCorso){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
		Vector<AreeTematiche> areeSelezionate = areeTematicheDAO.getAreeSelezionate(idCorso);
		JCheckBox checkBox;
		
		for(AreeTematiche area:areeTematiche) {
			checkBox = new JCheckBox(area.getNomeArea());
			
			for(AreeTematiche a:areeSelezionate)
				if(area.getNomeArea().equals(a.getNomeArea()))
					checkBox.setSelected(true);
			
			checkBoxList.add(checkBox);
		}
		
		DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
		model.addAll(checkBoxList);
		
		return model;
		
	}
	
	public DefaultListModel <JCheckBox> setModelCheckBoxParole (Vector<ParoleChiave> paroleChiave, String idCorso){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
		Vector<ParoleChiave> paroleSelezionate = paroleChiaveDAO.getParoleSelezionate(idCorso);
		
		JCheckBox checkBox;
		
		for(ParoleChiave parola:paroleChiave) {
			checkBox = new JCheckBox(parola.getParolaChiave());
			for(ParoleChiave p:paroleSelezionate)
				if(parola.getParolaChiave().equals(p.getParolaChiave()))
					checkBox.setSelected(true);
			
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
	
	public Vector<String> getGiorniSelezionati(JCheckBoxList box){
		
		Vector<String> vettore = new Vector<String>();
		
		for(int i=0;i<31;i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(String.valueOf(i+1));
		
		return vettore;
	}
	
	public Vector<String> getMesiSelezionati(JCheckBoxList box){
		
		Vector<String> vettore = new Vector<String>();
		
		for(int i=0;i<12;i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(String.valueOf(i+1));
		
		return vettore;
	}
	
	public Vector<Time> getOrariSelezionati(JCheckBoxList box, Vector<Time> orari){
		
		Vector<Time> vettore = new Vector<Time>();
		
		for(int i=0;i<orari.size();i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(orari.get(i));
		
		return vettore;
		
	}
	
	
	public Vector<Time> getDurateSelezionate(JCheckBoxList box, Vector<Time> durate){
		
		Vector<Time> vettore = new Vector<Time>();
		
		for(int i=0;i<durate.size();i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(durate.get(i));
		
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
	
	public DefaultListModel <JCheckBox> setModelCheckBoxTime(Vector<Time> durata){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
	
		JCheckBox checkBox;

		for(Time s:durata) {
			checkBox = new JCheckBox(s.toString());
			checkBoxList.add(checkBox);
		}
		
		DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
		model.addAll(checkBoxList);
		
		return model;
		
	}
	
	
public DefaultListModel <JCheckBox> setModelCheckBoxCorsi(Vector<Corsi> corsi){
		
		Vector<JCheckBox> checkBoxList = new Vector<JCheckBox>();
	
		JCheckBox checkBox;

		for(Corsi c:corsi) {
			checkBox = new JCheckBox(c.toString());
			checkBoxList.add(checkBox);
		}
		
		DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
		model.addAll(checkBoxList);
		
		return model;
		
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
	
	public Vector<String> getAllMesi(){
		
		Vector<String> vettore = new Vector<String>();
		
		for(int i=1;i<13;i++)
			vettore.add(String.valueOf(i));
		
		return vettore;
	}
	
	public String getMese(String mese) {
		
		mese = mese.toLowerCase();
		
		if(mese == "gennaio")
			return "01";
		if(mese == "febbraio")
			return "02";
		if(mese == "marzo")
			return "03";
		if(mese =="aprile")
			return "04";
		if(mese == "maggio")
			return "05";
		if(mese == "giugno")
			return "06";
		if(mese == "luglio")
			return "07";
		if(mese == "agosto")
			return "08";
		if(mese == "settembre")
			return "09";
		if(mese == "ottobre")
			return "10";
		if(mese == "novembre")
			return "11";
		if(mese == "dicembre")
			return "12";
		
		return "-1";
	}
	
	public Vector<Lezioni> setLezioniFiltrate(Vector<String> giorni, Vector<String> mesi, Vector<Time> orario, Vector<Time> durate, String idCorso, String titolo, String anno){
		
		if(giorni.isEmpty())
			giorni = getGiorni();
		
		if(mesi.isEmpty())
			mesi = getAllMesi();
		
		return lezioniDAO.setLezioniFiltrate(giorni, mesi, orario, durate, idCorso, titolo, anno);
	}
	
	
	public ListModel<JCheckBox> setAll(ListModel<JCheckBox> model){
		
		for(int i=0;i<model.getSize();i++)
			model.getElementAt(i).setSelected(true);
		
		return model;
	}
	
	public ListModel<JCheckBox> setNone(ListModel<JCheckBox> model){
		
		for(int i=0;i<model.getSize();i++)
			model.getElementAt(i).setSelected(false);
		
		return model;
	}
	
	public String getNumeroPresenzeDelCorso(String matricola, String id_corso) {
		return presenzeDAO.getNumeroPresenzeDelCorso(matricola, id_corso);
	}
	
	public Boolean getAmmessoAdEsame(String matricola, String id_corso) {
		return iscrizioniDAO.getAmmessoAdEsame(matricola, id_corso);
	}
	
	Vector<String> getStringheSelezionate(JCheckBoxList box, Vector<String> anni){
		
		Vector<String> vettore = new Vector<String>();
		
		for(int i=0;i<anni.size();i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(anni.get(i));
		
		return vettore;
	}
	
	
	public Vector<Corsi> getCorsiSelezionati(JCheckBoxList box, Vector<Corsi> corsi){
		
		Vector<Corsi> vettore = new Vector<Corsi>();
		
		for(int i=0;i<corsi.size();i++)
			if(box.getModel().getElementAt(i).isSelected())
				vettore.add(corsi.get(i));
		
		return vettore;
		
	}

	
	public String getNumeroLezioni(String id_corso) {
		return lezioniDAO.getNumeroLezioni(id_corso);
	}

	public String creaStudente(Studenti studente, Vector<Corsi> corsi) {
		
		String state = studentiDAO.creaStudente(studente);
		
		if(state.equals("0"))
			return iscrizioniDAO.inserisciIscrizioni(studentiDAO.getLastStudenteCreato().getMatricola(), corsi);
		
		return state;
		
	}
	
	public Vector<Lezioni> getFutureLezioni(String id_corso){
		return lezioniDAO.getFutureLezioni(id_corso);
	}
	
	public Vector<Studenti> getStudentiDisponibili(String id_corso){
		
		return studentiDAO.getStudentiDisponibili(id_corso);
	}
	
	public String getIdOperatore(Operatori op) {
		return operatoriDAO.getIdOperatore(op);
	}
	
	public Vector<String> setAllStudentiAmmessi(String id_corso){
		
		return studentiDAO.setAllStudentiAmmessi(id_corso);
	}
	
	
	public double getPresenzeMedie(String idCorso) {
		
		return corsiDAO.getPresenzeMedie(idCorso);
		
	}
	
	public String minimoPresenze(String idCorso) {
		return corsiDAO.minimoPresenze(idCorso);
	}
	
	public String massimoPresenze(String idCorso) {
		return corsiDAO.massimoPresenze(idCorso);
	}
	
	public int getNumeroStudentiAmmessi(String idCorso) {
	
		return corsiDAO.getNumeroStudentiAmmessi(idCorso);
		
	}
	
	public Boolean modificaAnnoCorso(String id_corso) {
		
		return corsiDAO.modificaAnnoCorso(id_corso);
	
	}
	
	public String modificaCorsoClicked(String nome, String descrizione, Vector<ParoleChiave> paroleChiave, String anno, String presenzeMin, String maxPartecipanti, boolean terminato, String idCorso, String idOperatore, Vector<AreeTematiche> areeTematiche) {
		
		String state = corsiDAO.modificaCorso(nome, descrizione, anno, presenzeMin, maxPartecipanti, terminato, idCorso, idOperatore);
		
		if(state.equals("0"))
			state = temiDAO.inserisciTemi(corsiDAO.getIdCorso(nome), areeTematiche);
			if(state.equals("0"))
				return state = caratterizzaDAO.inserisciCaratterizza(corsiDAO.getIdCorso(nome), paroleChiave);
			
		return state;
			
			
	}
}