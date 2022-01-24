package dao;

import java.sql.*;
import dto.Operatori;

public class OperatoriDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public OperatoriDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public boolean LogIn(Operatori op) {
		
		try{
			ResultSet rs = statement.executeQuery("SELECT * FROM operatori WHERE nome = '" + op.getNomeUtente().toLowerCase() +  
						"' AND password = '" +  op.getPassword().toLowerCase()+ "'");
			
			return rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		
		
	}
}
