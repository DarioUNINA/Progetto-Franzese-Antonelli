package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;
import dto.Iscrizioni;

public class IscrizioniDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public IscrizioniDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
	public Vector<Corsi> getIscrizioneCorsiStudente(String matricola, String id_operatore){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		try {
			ResultSet rs = statement.executeQuery("(SELECT * FROM corsi con WHERE con.id_operatore = '" + id_operatore + "' AND con.nome NOT IN "
												+ "(SELECT co.nome FROM corsi co JOIN iscrizioni i ON co.id_corso = i.id_corso WHERE i.matricola = '"+ matricola + "')");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				c.setAnno(rs.getString("anno"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setParoleChiave(rs.getString("parole_chiave"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setTerminato(rs.getBoolean("terminato"));

				corsi.add(c);
				
			}
			
			return corsi;

		} catch (SQLException e) {
			e.printStackTrace();
			return corsi;
		}
		
	}

public Vector<Corsi> getDisiscrizioneCorsiStudente(String matricola, String id_operatore){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		try {
			ResultSet rs = statement.executeQuery("(SELECT * FROM corsi con WHERE con.id_operatore = '" + id_operatore + "' AND con.nome IN "
												+ "(SELECT co.nome FROM corsi co JOIN iscrizioni i ON co.id_corso = i.id_corso WHERE i.matricola = '"+ matricola + "')");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				c.setAnno(rs.getString("anno"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setParoleChiave(rs.getString("parole_chiave"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setTerminato(rs.getBoolean("terminato"));

				corsi.add(c);
				
			}
			
			return corsi;

		} catch (SQLException e) {
			e.printStackTrace();
			return corsi;
		}
		
	}
}
