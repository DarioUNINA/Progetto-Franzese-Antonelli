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

	
	public boolean insertDomandeOperatori(DomandeOperatori dop){
		
		try {
			System.out.println("l'id della domanda e " + dop.getIdDomanda() +  " l'id dell operatore e " +  dop.getIdOperatore() + dop.getRisposta());
			statement.execute("INSERT INTO domande_operatori VALUES ('" + dop.getRisposta() + "' , '" + dop.getIdDomanda() + 
					"', '" + dop.getIdOperatore() + "')");
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
		public String getIdDomanda2(Operatori op) {
			
			try {
				ResultSet rs = statement.executeQuery("SELECT do.id_domanda FROM operatori o  JOIN domande_operatori do ON o.id_operatore = do.id_operatore ");
				
				rs.next();
				return rs.getString("id_domanda");
			
			}catch(SQLException e) {
				
				//da gestire
				return "";
			}
		}
		
		
		public String getDomandaOperatore(String id) {
			System.out.println("l id e " + id);
			
			try {
				
				ResultSet rs = statement.executeQuery("SELECT ds.domanda FROM domande_sicurezza ds JOIN domande_operatori dop ON dop.id_domanda = ds.id_domanda"
						+ " WHERE dop.id_operatore = '" + id + "'" );
				
				rs.next();
				return rs.getString("domanda");
			}catch(SQLException e) {
				e.printStackTrace();
				return"";
			}
		}
		
		
		public boolean checkRisposta(String Risposta, String id_operatore) {
			
			try {
				
				ResultSet rs = statement.executeQuery("SELECT FROM domande_sicurezza ds JOIN domande_operatori "
						+ "dop ON ds.id_domanda = dop.id_domanda WHERE dop.id_operatore = '" + id_operatore + "' AND dop.risposta = '" + Risposta + "'"); //da completare
				
				return rs.next();
			}catch(SQLException e) {
				
				e.printStackTrace();
				return false;
			}
		}
}

