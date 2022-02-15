package dao;

import java.sql.*;
import java.util.Vector;

import connection.Connessione;
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
			ResultSet rs = statement.executeQuery("SELECT * FROM corsi con WHERE con.id_operatore = '" + id_operatore + "' AND con.terminato = false AND con.nome NOT IN "
												+ "(SELECT co.nome FROM corsi co JOIN iscrizioni i ON co.id_corso = i.id_corso WHERE i.matricola = '"+ matricola + "')"
												+ " AND con.max_partecipanti > (SELECT par.partecipanti FROM partecipanti par WHERE par.id_corso = con.id_corso)");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				c.setAnno(rs.getString("anno"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
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
			ResultSet rs = statement.executeQuery("SELECT * FROM corsi con WHERE con.id_operatore = '" + id_operatore + "' AND con.nome IN "
												+ "(SELECT co.nome FROM corsi co JOIN iscrizioni i ON co.id_corso = i.id_corso WHERE i.matricola = '"+ matricola + "') ");
			
			while(rs.next()) {

				Corsi c = new Corsi();
				c.setNome(rs.getString("nome"));
				c.setAnno(rs.getString("anno"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
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

	public String aggiungiStudenteCorso(String matricola, String id_corso) {
	
		try {
		
			if(!statement.execute("INSERT INTO iscrizioni VALUES ('" + matricola +"', '" + id_corso +"')"))
				return "0";
			else 
				return "-1";
		
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getSQLState();
		}
	}
	
	public String disiscriviStudenteCorso(String matricola, String id_corso) {
		
		try {
		
			if(!statement.execute("DELETE FROM iscrizioni WHERE matricola = '" + matricola + "' AND id_corso = '" +  id_corso + "'"))
				return "0";
			else 
				return "-1";
		
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getSQLState();
		}
	}
	
	public Boolean getAmmessoAdEsame(String matricola, String id_corso) {
		
		Boolean ammesso;
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT ammesso FROM iscrizioni WHERE matricola =  '" + matricola + "' AND id_corso = '" + id_corso + "'" );
			
			rs.next();
			ammesso = rs.getBoolean("ammesso");
			
			return ammesso;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String inserisciIscrizioni(String matricola, Vector<Corsi> corsi) {
		
		String state;
		
		try {
			
			for(Corsi corso:corsi)
				statement.execute("INSERT INTO iscrizioni VALUES ('" + matricola + "' , '" + corso.getIdCorso() + "')");
			
			return "0";
		}catch(SQLException e) {
			
			e.printStackTrace();
			return e.getSQLState();
		}
	}
		
		public int getNumeroStudentiIscritti(String idCorso) {
			
			try {
				
				ResultSet rs = statement.executeQuery("SELECT COUNT (i.matricola), id_corso FROM iscrizioni i WHERE i.id_corso = '"+ idCorso + "' GROUP BY(i.id_corso)");
				rs.next();
				return rs.getInt(1);
			}catch(SQLException e) {
			//	e.printStackTrace();
				return 0;
			}
		}
	
}