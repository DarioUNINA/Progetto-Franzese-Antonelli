package dao;

import java.sql.*;
import dto.Connessione;

public class AreeTematicheDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public AreeTematicheDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

}
