package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;
import dto.Operatori;

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
			
			anno.add("");
			
			while(rs.next()) {
				anno.add(rs.getString(1));
			}
			
			return anno;
		}catch(SQLException e) {
			e.getMessage();
			return anno;
		}
	}
	
	public Vector<Corsi> addFiltri(String areaTematica, String anno, boolean terminatoSi, boolean terminatoNo, String parolaChiave, String idOperatore) {
		
		Vector<Corsi> corsiFiltrati = new Vector<Corsi>();
		
		String query;
		
		query = "SELECT * FROM corsi c JOIN temi t ON c.id_corso = t.id_corso WHERE ";
		
		if(!areaTematica.equals(""))
			query = query + " t.nome_area = '" + areaTematica +  "'  AND ";
		
		if(!anno.equals("")) 
			query = query + " c.anno = '" +  anno + "'  AND ";
	
		
		if(!parolaChiave.equals(""))
			query = query + " parole_chiave = '" + parolaChiave + "' AND ";
		
		if(terminatoSi)
			if(!terminatoNo) 
				query = query + " terminato = true AND";
		
		if(terminatoNo)
			if(!terminatoSi)
				query = query + " terminato = false AND";
			
		query = query + " c.id_operatore = '" + idOperatore + "'";
	//	query = query + " 1926=1926";
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
				c.setParoleChiave(rs.getString("parole_chiave"));
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
	
	public Vector<Corsi> getCorsiOperatore(Operatori op){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT co.nome FROM corsi co JOIN operatori op ON co.id_operatore = op.id_operatore"
					+ " WHERE op.id_operatore = '"+ op.getIdOperatore() + "'");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				corsi.add(c);
				
			}
			
			return corsi;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return corsi;
		}
		
		
		
		
	}

	public String aggiungiCorso(String nome, String descrizione, String paroleChiave, String anno, String presenzeMin, String maxPartecipanti, boolean terminato, String idOperatore) {
		
		String state;
		
		try {
			
			if(!statement.execute("INSERT INTO corsi VALUES (nextval('sequenza_id_lezione'), " + idOperatore + " , " + nome + " , " + descrizione
					+ ", " + presenzeMin + " , " + maxPartecipanti + " , " + paroleChiave + " , " + anno + ")" ))
				return "0";
			else 
				return "-1";
		}catch(SQLException e) {
			
			return e.getSQLState();
		}
		
	}




}
