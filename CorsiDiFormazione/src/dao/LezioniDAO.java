package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;
import dto.Lezioni;
import dto.Operatori;

public class LezioniDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public LezioniDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}

	
	public Vector<Lezioni> getAllLezioniDelCorso(String id_corso) {
		
		Vector<Lezioni> lezioni = new Vector<Lezioni>();
		
		try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM lezioni l WHERE l.id_corso = '" + id_corso + "'");
				
				
				while(rs.next()) {

					Lezioni l = new Lezioni();
					l.setIdLezione(rs.getString("id_lezione"));
					l.setTitolo(rs.getString("titolo"));
					l.setDescrizione(rs.getString("descrizione"));
					l.setDurata(rs.getString("durata"));
					l.setData(rs.getDate("data"));
					l.setOrario(rs.getString("orario"));
					l.setIdCorso(id_corso);

					lezioni.add(l);
					
				}
		
				return lezioni;
			}catch(SQLException e) {
				
				e.printStackTrace();
				return lezioni;
		}
	}
	
	public Lezioni getLezioni(String titolo){
		
		Lezioni lezione = new Lezioni();
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM lezioni le  WHERE le.titolo = '"+  titolo + "'");
			
			rs.next();
			lezione.setIdLezione(rs.getString("id_lezione"));
			lezione.setTitolo(titolo);
			lezione.setDescrizione(rs.getString("descrizione"));
			lezione.setDurata(rs.getString("durata"));
			lezione.setData(rs.getDate("data"));
			lezione.setOrario(rs.getString("orario"));
			lezione.setIdCorso(rs.getString("id_corso"));


			return lezione;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return lezione;
		}			

	}	
}
