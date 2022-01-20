package dao;

import java.sql.*;
import dto.Studenti;


public class StudentiDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public StudentiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
}
