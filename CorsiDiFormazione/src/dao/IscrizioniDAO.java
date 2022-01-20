package dao;

import java.sql.*;
import dto.Iscrizioni;

public class IscrizioniDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public IscrizioniDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

}
