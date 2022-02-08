package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import dto.ParoleChiave;
import dto.Caratterizza;

public class CaretterizzaDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public CaretterizzaDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
}
