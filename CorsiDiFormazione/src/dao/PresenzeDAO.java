package dao;

import java.sql.*;
import dto.Presenze;

public class PresenzeDAO {
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public PresenzeDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}


}
