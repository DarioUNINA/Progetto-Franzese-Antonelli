package dao;

import java.sql.*;
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
}
