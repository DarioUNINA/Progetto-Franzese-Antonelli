package dao;

import java.sql.*;
import java.util.Vector;

import dto.AreeTematiche;

public class AreeTematicheDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public AreeTematicheDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	public Vector<String> getAree(){
		Vector<String> aree = new Vector<String>();
		
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM aree_tematiche");
			
			aree.add("");
			
			while(rs.next()) {
				aree.add(rs.getString(1));
			}
			
			return aree;
		}catch(SQLException e) {
			e.printStackTrace();
			return aree;
		}
		
		
	}
	
	
	
	
}
