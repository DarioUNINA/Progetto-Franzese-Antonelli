package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;
import dto.Studenti;


public class StudentiDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public StudentiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
	
	public Vector<String> getStudenti(){
		
		Vector<String> studenti = new Vector<String>();
		
		try {
			ResultSet rs = statement.executeQuery("SELECT s.matricola FROM studenti s");
			

			studenti.add("");
			
			while(rs.next()) {
				studenti.add(rs.getString(1));
			}
			
			return studenti;
		}catch(SQLException e) {
			e.getMessage();
			return studenti;
		}
	}
	
	public  Studenti getSingoloStudente(String matricola){
		
		Studenti studente = new Studenti();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM studenti s WHERE s.matricola = '" + matricola + "'");

			rs.next();
			//System.out.println(rs.getString("matricola") +rs.getString("nome") + rs.getString("cognome"));
			studente.setMatricola(rs.getString("matricola"));
			studente.setNome(rs.getString("nome"));	
			studente.setCognome(rs.getString("cognome"));
			
			
			
			return studente;
			
		} catch (SQLException e) {
			e.getMessage();
			return studente;
		}	
		
	}
	
	
	public  Vector<Corsi> getCorsiStudente(Studenti s){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM iscrizioni i JOIN corsi co ON co.id_corso = i.id_corso WHERE i.matricola = '"+ s.getMatricola() + "'");
			
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setNome(rs.getString("nome"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setParoleChiave(rs.getString("parole_chiave"));
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
