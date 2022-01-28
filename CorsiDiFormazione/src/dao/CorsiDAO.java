package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;
import dto.Operatori;

public class CorsiDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public CorsiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public Vector<Corsi> getCorsiOperatore(Operatori op){
		
		Vector<Corsi> corsi = new Vector<Corsi>();
		
		Corsi c = new Corsi();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT co.nome FROM corsi co JOIN operatori op ON co.id_operatore = op.id_operatore"
					+ " WHERE op.id_operatore = '"+ op.getIdOperatore() + "'");
			
			while(rs.next()) {
				
				c.setNome(rs.getString("nome"));
				
				corsi.add(c);
			}
			
			return corsi;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return corsi;
		}
		
		
		
		
	}
}
