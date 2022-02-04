package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;
import dto.Studenti;


public class StudentiDAO {

	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public StudentiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
	

	public Vector<Studenti> getStudenti(){
		

		Vector<Studenti> studenti = new Vector<Studenti>();
		
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM studenti s");
			

			while(rs.next()) {
				

				Studenti s = new Studenti(rs.getString("matricola"), rs.getString("nome"), rs.getString("cognome"));
				studenti.add(s);
			}
			
			return studenti;
		}catch(SQLException e) {
			e.getMessage();
			return studenti;
		}
	}
	
	public  Studenti getSingoloStudente(String matricola){
		
		Studenti studente = new Studenti();

		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM studenti s WHERE s.matricola = '" + matricola + "'");

			rs.next();
			//System.out.println(rs.getString("matricola") +rs.getString("nome") + rs.getString("cognome"));
			studente.setMatricola(rs.getString("matricola"));
			studente.setNome(rs.getString("nome"));	
			studente.setCognome(rs.getString("cognome"));
			
			
			
			return studente;
			
		} catch (SQLException e) {
			e.getMessage();
			return studente;
		}	
		
	}
	

	public Vector<Studenti> getStudentiCorso(String id_corso, String id_lezione){
		
		Vector<Studenti> studente = new Vector<Studenti>();
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM studenti s  JOIN iscrizioni i ON s.matricola = i.matricola WHERE i.id_corso =  '" + id_corso + "' AND s. matricola NOT IN "+ 
												  "(SELECT stu.matricola FROM studenti stu  JOIN presenze pre ON stu.matricola = pre.matricola WHERE  pre.id_lezione = '" + id_lezione + "')");
			
			while(rs.next()) {

				Studenti s = new Studenti();
				s.setMatricola(rs.getString("matricola"));
				s.setNome(rs.getString("nome"));	
				s.setCognome(rs.getString("cognome"));

				studente.add(s);
				
			}
			
			return studente;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return studente;
		}
		
	}
	
	public Vector<Studenti> getAllStudentiIscrittiAllaLezione(String id_lezione){
		
		Vector<Studenti> studente = new Vector<Studenti>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM studenti s  JOIN presenze pre ON s.matricola = pre.matricola WHERE pre.id_lezione = '" + id_lezione + "'");
			
			while(rs.next()) {

				Studenti s = new Studenti();
				s.setMatricola(rs.getString("matricola"));
				s.setNome(rs.getString("nome"));	
				s.setCognome(rs.getString("cognome"));

				studente.add(s);
				
			}
			
			return studente;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return studente;
		}
	
	}
	
	public String eliminaStudente(String matricola) {
		
		try {
			
			if(!statement.execute("DELETE FROM studenti WHERE matricola = '" + matricola + "'" ))
				return "0";
			else
				return "-1";
				
		} catch (SQLException e) {
			
			return e.getSQLState();
		}
	}
	
	
}
