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
	
}
