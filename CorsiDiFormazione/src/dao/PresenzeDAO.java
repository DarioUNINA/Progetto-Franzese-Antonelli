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
		
		//String state;
		
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
}
