package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
	
	public String inserisciCaratterizza(String idCorso, Vector<ParoleChiave> parole) {
		
		String state = new String();
		
		try {
			
			for(ParoleChiave parola:parole)
				statement.execute("INSERT INTO caratterizza VALUES('"+ parola.getParolaChiave() + "','" + idCorso + "')");
			return "0";
		
		}catch(SQLException e) {
			e.printStackTrace();
			return e.getSQLState();
		}
	}
}
