package dao;

import java.sql.*;

import connection.Connessione;
import dto.Presenze;

public class PresenzeDAO {
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public PresenzeDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public String aggiungiStudenteLezione(String matricola, String id_lezione) {
				
		try {
			
			if(!statement.execute("INSERT INTO presenze VALUES ('" + matricola +"', '" + id_lezione +"')"))
				return "0";
			else 
				return "-1";
		}catch(SQLException e) {
			
			e.printStackTrace();
			return e.getSQLState();
		}
	}
	
	
	public String eliminaPresenza(String idLezione, String matricola) {
		
		try {
			
			if(!statement.execute("DELETE FROM presenze WHERE matricola = '" + matricola +"'AND id_lezione = '" + idLezione +"'"))
				return "0";
			else 
				return "-1";
		}catch(SQLException e) {
			
			e.printStackTrace();
			return e.getSQLState();
		}
	}
	
	public String getNumeroPresenzeDelCorso(String matricola, String id_corso) {
		
		String presenze;
		try {
			
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM presenze pre JOIN lezioni l ON pre.id_lezione = l.id_lezione WHERE l.id_corso = '" + id_corso + "' AND pre.matricola = '" + matricola + "'");
			
			rs.next();
			presenze = String.valueOf(rs.getInt(1));
			return presenze;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getSQLState();
		}
	}
}
