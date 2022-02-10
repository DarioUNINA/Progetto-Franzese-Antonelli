package dao;

import java.sql.*;
import java.util.Vector;

import dto.AreeTematiche;
import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;
import dto.ParoleChiave;
import dto.Studenti;

public class CorsiDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public CorsiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
	public Vector<String> getAnno(){
		
		Vector<String> anno = new Vector<String>();
		
		try {
			ResultSet rs = statement.executeQuery("SELECT DISTINCT anno FROM corsi ORDER BY anno");
			
			while(rs.next()) {
				anno.add(rs.getString(1));
			}
			
			return anno;
		}catch(SQLException e) {
			e.getMessage();
			return anno;
		}
	}
	
	public Vector<Corsi> addCorsiFiltratiFM(Vector<AreeTematiche> area, Vector<String> anni, boolean terminatoSi, boolean terminatoNo, Vector<ParoleChiave> parole, String idOperatore) {
		
		Vector<Corsi> corsiFiltrati = new Vector<Corsi>();
		
		String query = "SELECT DISTINCT c.id_corso, c.id_operatore, c.nome, c.descrizione, c.presenze_min, c.max_partecipanti, c.anno, c.terminato FROM corsi c ";
		
		if(!area.isEmpty())
			query = query + "JOIN temi te ON c.id_corso = te.id_corso WHERE "; 
		else
			query = query + "WHERE ";
		
		for(AreeTematiche a:area)
			query = query + " c.id_corso IN (SELECT t.id_corso FROM temi t WHERE t.nome_area = '" + a.getNomeArea() + "' ) AND "; 
		
		for(String anno:anni)
			query = query + " c.anno = '" +  anno + "'  AND ";
	
		for(ParoleChiave p:parole)
			query = query + "c.id_corso IN (SELECT ca.id_corso FROM caratterizza ca WHERE ca.parola_chiave = '" + p.getParolaChiave()+ "' ) AND "; 
		
		if(terminatoSi)
			query = query + " c.terminato = true AND";
		
		if(terminatoNo)
			query = query + " c.terminato = false AND";
			
		query = query + " c.id_operatore = '" + idOperatore + "'";	
		
		
		try {
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {

				Corsi c = new Corsi();
				
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(idOperatore);
				c.setNome(rs.getString("nome"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setAnno(rs.getString("anno"));
				c.setTerminato(rs.getBoolean("terminato"));
				
				corsiFiltrati.add(c);
				
			}
				
			return corsiFiltrati;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return corsiFiltrati;
		}
	}
	
	
public Vector<Corsi> addCorsiFiltratiPM(Vector<AreeTematiche> area, Vector<String> anni, boolean terminatoSi, boolean terminatoNo, Vector<ParoleChiave> parole, String idOperatore) {
		
		Vector<Corsi> corsiFiltrati = new Vector<Corsi>();
		
		String query = "SELECT DISTINCT c.id_corso, c.id_operatore, c.nome, c.descrizione, c.presenze_min, c.max_partecipanti, c.anno, c.terminato FROM corsi c ";
		
		if(!area.isEmpty())
			query = query + "JOIN temi te ON c.id_corso = te.id_corso WHERE c.id_operatore = '" + idOperatore + "' AND (";
		else
			query = query + "WHERE c.id_operatore = '" + idOperatore + "' AND (";
		
		for(AreeTematiche a:area)
			query = query + " c.id_corso IN (SELECT t.id_corso FROM temi t WHERE t.nome_area = '" + a.getNomeArea() + "' ) OR "; 
		
		if(!area.isEmpty())
			query = query + " 1= 0 ) AND (";
		else
			query = query + " 1 = 1 ) AND (";
		
		
		for(String anno:anni)
			query = query + " c.anno = '" +  anno + "'  OR ";
		
		if(!anni.isEmpty())
			query = query + " 1= 0 ) AND ("; 
		else
			query = query + " 1 = 1 ) AND ( ";
		
	
		for(ParoleChiave p:parole)
			query = query + "c.id_corso IN (SELECT ca.id_corso FROM caratterizza ca WHERE ca.parola_chiave = '" + p.getParolaChiave()+ "' ) OR "; 
		
		if(!parole.isEmpty())
			query = query + " 1 = 0 ) ";
		else
			query = query + " 1 = 1 ) ";
		
		if(terminatoSi)
			query = query + " AND c.terminato = true";
		
		if(terminatoNo)
			query = query + "  AND  c.terminato = false";
			
		try {
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {

				Corsi c = new Corsi();
				
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(idOperatore);
				c.setNome(rs.getString("nome"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setAnno(rs.getString("anno"));
				c.setTerminato(rs.getBoolean("terminato"));
				
				corsiFiltrati.add(c);
				
			}
				
			return corsiFiltrati;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return corsiFiltrati;
		}
	}
	
	public Vector<Corsi> getCorsiDisponibiliOperatore(Operatori op){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM corsi co  JOIN partecipanti p ON co.id_corso = p.id_corso"
					+ " WHERE co.id_operatore = '"+ op.getIdOperatore() + "' AND co.max_partecipanti > p.partecipanti AND co.terminato = false");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				c.setAnno(rs.getString("anno"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(op.getIdOperatore());
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setTerminato(rs.getBoolean("terminato"));

				corsi.add(c);
			}
			
			return corsi;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return corsi;
		}
	}		

		
	
	
public Vector<Corsi> getCorsiOperatore(Operatori op){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM corsi co " + " WHERE co.id_operatore = '"+ op.getIdOperatore()  + "' ");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				c.setAnno(rs.getString("anno"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(op.getIdOperatore());
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setTerminato(rs.getBoolean("terminato"));

				corsi.add(c);
			}
			
			return corsi;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return corsi;
		}
		
	}

	public String aggiungiCorso(String nome, String descrizione, String anno, String presenzeMin, String maxPartecipanti, boolean terminato, String idOperatore) {
		
		try {
			
			if(!statement.execute("INSERT INTO corsi VALUES (nextval('sequenza_id_corso'), '" + idOperatore + "' , '" + nome + "' , '" + descrizione
					+ "', '" + presenzeMin + "', '" + maxPartecipanti + "' , '" + anno + "')" ))
				return "0";
			else 
				return "-1";
		}catch(SQLException e) {
			
			e.printStackTrace();
			return e.getSQLState();
		}
		
	}

	public String getIdCorso(String nome) {
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT c.id_corso FROM corsi c WHERE c.nome = '" + nome + "'");
			
			rs.next();
			
			return rs.getString("id_corso");
		}catch(SQLException e) {
			
			e.printStackTrace();
			return "";
			
		}
	}
	
	public  Vector<Corsi> getCorsiStudente(String matricola, String id_operatore){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM iscrizioni i JOIN corsi co ON co.id_corso = i.id_corso WHERE i.matricola = '"+ matricola + "' AND co.id_operatore = '" + id_operatore + "'");
			
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setNome(rs.getString("nome"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setAnno(rs.getString("anno"));
				c.setTerminato(rs.getBoolean("terminato"));
				
				corsi.add(c);	
			}
			
			return corsi;
		}catch(SQLException e) {
			
			e.printStackTrace();
			return corsi;
		}
	}

	public Corsi getCorso(String id_corso){
	
		Corsi corso = new Corsi();
	
	
		try {
		
			ResultSet rs = statement.executeQuery("SELECT * FROM corsi c  WHERE c.id_corso = '"+  id_corso + "'");
		
			rs.next();
			corso.setIdCorso(rs.getString("id_corso"));
			corso.setIdOperatore(rs.getString("id_operatore"));
			corso.setNome(rs.getString("nome"));
			corso.setDescrizione(rs.getString("descrizione"));
			corso.setPresenzeMin(rs.getInt("presenze_min"));
			corso.setMaxPartecipanti(rs.getInt("max_partecipanti"));
			corso.setAnno(rs.getString("anno"));
			corso.setTerminato(rs.getBoolean("terminato"));


			return corso;
		
		}catch(SQLException e) {
		
			e.printStackTrace();
			return corso;
		}			

	}
	
public  Vector<Corsi>setCorsiStudenteDelOperatore(String matricola, String id_operatore){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM corsi co JOIN iscrizioni i ON co.id_corso = i.id_corso WHERE id_operatore = '" + id_operatore + "' AND i.matricola = '" + matricola + "'");
			
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setNome(rs.getString("nome"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setAnno(rs.getString("anno"));
				c.setTerminato(rs.getBoolean("terminato"));
				
				corsi.add(c);	
			}
			
			return corsi;
		}catch(SQLException e) {
			
			e.printStackTrace();
			return corsi;
		}
	}

}
