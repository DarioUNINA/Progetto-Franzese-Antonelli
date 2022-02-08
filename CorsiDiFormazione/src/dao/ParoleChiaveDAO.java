package dao;

import java.sql.ResultSet;
import java.sql.Statement;

import dto.ParoleChiave;

public class ParoleChiaveDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public ParoleChiaveDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
}
