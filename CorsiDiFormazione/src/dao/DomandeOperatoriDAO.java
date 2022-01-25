package dao;


import java.sql.*;
import dto.DomandeOperatori;

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
			System.out.println(dop.getIdDomanda() +  " " +  dop.getIdOperatore() + dop.getRisposta());
			statement.execute("INSERT INTO domande_operatori VALUES ('" + dop.getRisposta() + "' , '" + dop.getIdDomanda() + 
					"', '" + dop.getIdOperatore() + "')");
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}
}