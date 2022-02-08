package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dto.AreeTematiche;
import dto.ParoleChiave;

public class ParoleChiaveDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public ParoleChiaveDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
public Vector<ParoleChiave> getAllParoleChiave(){
		
		Vector<ParoleChiave> parole = new Vector<ParoleChiave>();
		ParoleChiave parola;
		
		parola = new ParoleChiave();
		parole.add(parola);
		
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM parole_chiave");
			
			while(rs.next()) {
				parola = new ParoleChiave(rs.getString(1));
				parole.add(parola);
			}
			
			return parole;
		}catch(SQLException e) {
			e.getMessage();
			return parole;
		}
	}
	
}
