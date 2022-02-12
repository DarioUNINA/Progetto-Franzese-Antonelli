package dao;


import java.sql.*;
import dto.DomandeOperatori;
import dto.Operatori;

public class DomandeOperatoriDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public DomandeOperatoriDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public String insertDomandeOperatori(DomandeOperatori dop){
		
		try {
			statement.execute("INSERT INTO domande_operatori VALUES ('" + dop.getRisposta() + "' , '" + dop.getIdDomanda() + 
					"', '" + dop.getIdOperatore() + "')");
			
			return "0";
		}catch(SQLException e) {
			return e.getSQLState();
		}
		
	}
	
	public String getDomandaOperatore(String id) {
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT ds.domanda FROM domande_sicurezza ds JOIN domande_operatori dop ON dop.id_domanda = ds.id_domanda"
					+ " WHERE dop.id_operatore = '" + id + "'" );
			
			rs.next();
			return rs.getString("domanda");
		}catch(SQLException e) {
			e.printStackTrace();
			return "Errore";
		}
	}
		
	public String checkRisposta(String Risposta, String id_operatore) {
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT FROM domande_sicurezza ds JOIN domande_operatori "
					+ "dop ON ds.id_domanda = dop.id_domanda WHERE dop.id_operatore = '" 
					+ id_operatore + "' AND dop.risposta = '" + Risposta + "'");
			
			if(rs.next())
				return "0";
			else
				return "-1";
		}catch(SQLException e) {
			
			return e.getSQLState();
		}
	}
}