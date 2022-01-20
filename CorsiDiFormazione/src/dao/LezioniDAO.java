package dao;

import java.sql.*;
import dto.Lezioni;

public class LezioniDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public LezioniDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	

}
