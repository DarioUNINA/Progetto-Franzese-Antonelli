package dao;

import java.sql.*;
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


}
