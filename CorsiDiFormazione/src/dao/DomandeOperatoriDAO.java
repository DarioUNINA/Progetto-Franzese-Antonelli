package dao;


import java.sql.*;
import dto.DomandeOperatori;

public class DomandeOperatoriDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public DomandeOperatoriDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public boolean insertDomandeOperatori(DomandeOperatori dop){
		
		ResultSet rs = statement.executeQuery("INSERT INTO domande_operatori VALUES ('")
		
		
		
	}
}