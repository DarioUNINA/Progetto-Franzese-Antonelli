package dao;

import java.sql.*;
import java.util.Vector;

import dto.AreeTematiche;
import dto.Temi;

public class TemiDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public TemiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public String inserisciTemi(String idCorso, Vector<AreeTematiche> areeTematiche) {
		
		try {
			
			for(AreeTematiche area:areeTematiche) 
				statement.execute("INSERT INTO temi VALUES('"+ area.getNomeArea() + "','" + idCorso + "')");
			
			return "0";

		}catch(SQLException e) {
			
			e.printStackTrace();
			return e.getSQLState();
		}
		
	}
	
	public String eliminaTemi(String idCorso) {
		
		try {
			
			if(!statement.execute("DELETE FROM temi t WHERE t.id_corso = '" + idCorso + "'"))
				return "0";
			else
				return "-1";
			
		}catch(SQLException e) {
			return e.getSQLState();
		}
		
	}
	
}
