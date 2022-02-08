package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import dto.ParoleChiave;
import dto.Caratterizza;

public class CaratterizzaDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public CaratterizzaDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
}
