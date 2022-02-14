package dao;

import java.sql.*;
import java.util.Vector;

import connection.Connessione;
import dto.AreeTematiche;

public class AreeTematicheDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public AreeTematicheDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	public Vector<AreeTematiche> getAllAreeTematiche(){
		
		Vector<AreeTematiche> aree = new Vector<AreeTematiche>();
		AreeTematiche area;
		
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM aree_tematiche");
			
			while(rs.next()) {
				area = new AreeTematiche(rs.getString(1));
				aree.add(area);
			}
			
			return aree;
		}catch(SQLException e) {
			e.getMessage();
			return aree;
		}
	}
	
	public Vector<AreeTematiche> getAreetematicheCorso(String idCorso){
		
		Vector<AreeTematiche> aree = new Vector<AreeTematiche>();
		AreeTematiche area;
		
		try {
			ResultSet rs = statement.executeQuery("SELECT t.nome_area FROM temi t WHERE t.id_corso = '" + idCorso + "'");
			
			while(rs.next()) {
				area = new AreeTematiche(rs.getString(1));
				aree.add(area);
			}
			
			return aree;
		}catch(SQLException e) {
			e.getMessage();
			return aree;
		}
	}
}