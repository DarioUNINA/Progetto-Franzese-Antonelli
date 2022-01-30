package dao;

import java.sql.*;
import dto.Temi;

public class TemiDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public TemiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public String inserisciTemi(String idCorso, String [] areeTematiche) {
		
		try {
			
			for(String area:areeTematiche) 
				statement.execute("INSERT INTO temi VALUES('"+ area + "','" + idCorso + "')");
			return "0";

		}catch(SQLException e) {
			
			e.printStackTrace();
			return e.getSQLState();
		}
		
	}
	
}
