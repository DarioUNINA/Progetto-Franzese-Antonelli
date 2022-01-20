package dao;

import java.sql.*;
import dto.Temi;

public class TemiDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public TemiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

}
