package dao;

import java.sql.*;
import java.util.Vector;
import java.util.Date;

import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;

public class LezioniDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public LezioniDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public Vector<Lezioni> getAllLezioniDelCorso(String id_corso) {
		
		Vector<Lezioni> lezioni = new Vector<Lezioni>();
		
		try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM lezioni l WHERE l.id_corso = '" + id_corso + "'");
				
				
				while(rs.next()) {

					Lezioni l = new Lezioni();
					l.setIdLezione(rs.getString("id_lezione"));
					l.setTitolo(rs.getString("titolo"));
					l.setDescrizione(rs.getString("descrizione"));
					l.setDurata(rs.getTime("durata"));
					l.setData(rs.getDate("data"));
					l.setOrario(rs.getTime("orario"));
					l.setIdCorso(id_corso);

					lezioni.add(l);
				}
		
				return lezioni;
			}catch(SQLException e) {
				
				e.printStackTrace();
				return lezioni;
		}
	}
	
	public Lezioni getLezioni(String titolo){
		
		Lezioni lezione = new Lezioni();
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM lezioni le  WHERE le.titolo = '"+  titolo + "'");
			
			rs.next();
			lezione.setIdLezione(rs.getString("id_lezione"));
			lezione.setTitolo(titolo);
			lezione.setDescrizione(rs.getString("descrizione"));
			lezione.setDurata(rs.getTime("durata"));
			lezione.setData(rs.getDate("data"));
			lezione.setOrario(rs.getTime("orario"));
			lezione.setIdCorso(rs.getString("id_corso"));


			return lezione;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return lezione;
		}			

	}	
	
	public String eliminaLezioneGestoreLezioni(String idLezione) {
		
		try {
			
			if(!statement.execute("DELETE FROM lezioni WHERE id_lezione = '" + idLezione + "'" ))
				return "0";
			else
				return "-1";
			
			
		} catch (SQLException e) {
			return e.getSQLState();
		}
	}
	
	public Vector<Lezioni> iscirizioneStudenteLezioniDelCorso(String matricola, String id_corso) {
		
		Vector<Lezioni> lezioni = new Vector<Lezioni>();
		
		try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM lezioni l WHERE l.id_corso = '" + id_corso + "' AND l.id_lezione NOT IN " 
													 + "( SELECT pre.id_lezione FROM presenze pre WHERE matricola = '" + matricola + "')");
				
				
				while(rs.next()) {

					Lezioni l = new Lezioni();
					l.setIdLezione(rs.getString("id_lezione"));
					l.setTitolo(rs.getString("titolo"));
					l.setDescrizione(rs.getString("descrizione"));
					l.setDurata(rs.getTime("durata"));
					l.setData(rs.getDate("data"));
					l.setOrario(rs.getTime("orario"));
					l.setIdCorso(id_corso);

					lezioni.add(l);
				}
		
				return lezioni;
			}catch(SQLException e) {
				
				e.printStackTrace();
				return lezioni;
		}
	}
	
	public Vector<Lezioni> getPresenzeStudente(String matricola, String id_corso) {
		
		Vector<Lezioni> lezioni = new Vector<Lezioni>();
		
		try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM lezioni l WHERE l.id_corso = '" + id_corso + "' AND l.id_lezione IN " 
													 + "( SELECT pre.id_lezione FROM presenze pre WHERE matricola = '" + matricola + "')");
				
				
				while(rs.next()) {

					Lezioni l = new Lezioni();
					l.setIdLezione(rs.getString("id_lezione"));
					l.setTitolo(rs.getString("titolo"));
					l.setDescrizione(rs.getString("descrizione"));
					l.setDurata(rs.getTime("durata"));
					l.setData(rs.getDate("data"));
					l.setOrario(rs.getTime("orario"));
					l.setIdCorso(id_corso);

					lezioni.add(l);
				}
		
				return lezioni;
			}catch(SQLException e) {
				
				e.printStackTrace();
				return lezioni;
		}
	}

	
	public String creaLezione(Lezioni lezione) {
		
		try {
			
			if(!statement.execute("INSERT INTO lezioni VALUES (nextval('sequenza_id_lezione'),'" + lezione.getTitolo() + "', '" + lezione.getDescrizione() + "', '" + lezione.getDurata().getHours() + ":"+ lezione.getDurata().getMinutes() + 
					 "', '" + lezione.getData() +  "', '" + lezione.getOrario().getHours() + ":" + lezione.getOrario().getMinutes() + "','" + lezione.getIdCorso() + "')"))
				return "0";
			else
				return "-1";
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getSQLState();
		}
		
	}
	
	public Vector<Lezioni> setLezioniFiltrate(Vector<String> giorni, Vector<String> mesi, Vector<Time> orari, Vector<Time> durate, String idCorso, String titolo, String anno){
		
		Vector<Lezioni> lezioni = new Vector<Lezioni>();
		
		Lezioni lezione;
		
		String query = "SELECT * FROM lezioni l WHERE l.id_corso = '" + idCorso + "' AND (";
		
		for(String giorno:giorni) 
			for(String mese:mesi)
				if(isValid(giorno, mese))
					query = query + " l.data = '" + giorno + "/" + mese + "/" + anno + "' OR ";

		query = query + "false ) AND (";	

		for(Time durata:durate)
			query = query + "l.durata = '" + durata.getHours() + ":" + durata.getMinutes() + "' OR ";
		
		if(durate.isEmpty())	
			query = query + "true ) AND (";
		else
			query = query + "false ) AND (";
		
		for(Time orario:orari)
			query = query + "l.orario = '" + orario.getHours() + ":" + orario.getMinutes() + "' OR ";
		
		if(orari.isEmpty())
			query = query + "true )";
		else
			query = query + "false )";
		
		if(!titolo.equals(""))
			query = query + "AND l.titolo = '" + titolo + "'";
		
		System.out.println(query);
		
		try {
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				
				lezione = new Lezioni();
				lezione.setData(rs.getDate("data"));
				lezione.setDescrizione(rs.getString("descrizione"));
				lezione.setDurata(rs.getTime("durata"));
				lezione.setIdCorso(idCorso);
				lezione.setIdLezione(rs.getString("id_lezione"));
				lezione.setOrario(rs.getTime("orario"));
				lezione.setTitolo(rs.getString("titolo"));
				
				lezioni.add(lezione);
			
			}
			
			return lezioni;
				
		}catch(SQLException e) {
			e.printStackTrace();
			return lezioni;
		}
	}
	
	
	public boolean isValid(String giorno , String mese) {
		
		if(Integer.parseInt(giorno)>28 && Integer.parseInt(mese) == 2)
			return false;
		
		if(giorno.equals("31") && ((mese.equals("11") || mese.equals("4") || mese.equals("6") || mese.equals("9"))))
			return false;
		
		return true;
	}
	
	public String getNumeroLezioni(String id_corso) {
		
		String numeroLezioni;
		try {
			
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM lezioni WHERE id_corso = '" + id_corso + "'");
			
			rs.next();
			numeroLezioni = String.valueOf(rs.getInt(1));
			return numeroLezioni;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getSQLState();
		}
	}
	
}
