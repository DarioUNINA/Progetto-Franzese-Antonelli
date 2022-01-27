package dao;

import java.sql.*;
import java.util.Vector;

import dto.DomandeOperatori;
import dto.DomandeSicurezza;

public class DomandeSicurezzaDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public DomandeSicurezzaDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
	public String getIdDomanda(String domanda) {
		
		try {
			ResultSet rs = statement.executeQuery("SELECT d.id_domanda FROM domande_sicurezza d WHERE d.domanda = '" + domanda + "'");
			
			rs.next();
			return rs.getString("id_domanda");
		}catch(SQLException e) {
			//da gestire
			e.printStackTrace();
			return " ";
		}
		
	}
	
	public String getDomandaUtente(DomandeOperatori dop) {
		
		try {
			ResultSet rs = statement.executeQuery("SELECT ds.domanda FROM domande_sicurezza ds WHERE ds.id_domanda = '" + dop.getIdDomanda() + "'");
	
			rs.next();
			return rs.getString("domanda");
			
		} catch (Exception e) {
			return "";
		}
	}

	public Vector<String> getDomande() {
		
		Vector<String> domande = new Vector<String>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM domande_sicurezza");
			
			while(rs.next())
				domande.add(rs.getString(1));

			return domande;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return domande;
		}

		
		
		
	}

}
