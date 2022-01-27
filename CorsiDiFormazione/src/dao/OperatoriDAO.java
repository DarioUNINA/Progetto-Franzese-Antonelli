package dao;

import java.sql.*;

import javax.swing.JOptionPane;

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
			
			ResultSet rs = statement.executeQuery("SELECT * FROM operatori WHERE nome_utente = '" + op.getNomeUtente() +  
						"' AND password = '" +  op.getPassword()+ "'");
			
			return rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public String getIdOperatore(Operatori op) {
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT o.id_operatore FROM operatori o WHERE o.nome_utente = '" + op.getNomeUtente() +  
							"' AND o.password = '" +  op.getPassword()+ "'");
			
			rs.next();
			return rs.getString("id_operatore");
		
		}catch(SQLException e) {
			
			System.out.println(e);
			return "";
		}
	}
	
	public String insertOperatore(Operatori op) {
		
		try {
			statement.execute("INSERT INTO operatori VALUES (nextval('sequenza_id_operatore'), '" + op.getNomeUtente() +  
							"', '" +  op.getPassword()+ "');");
			return "0";
		
		}catch(SQLException e) {
			
			return e.getSQLState();
		}
	}
	
	public boolean CheckNome(Operatori op) {
		
		try {
			ResultSet rs = statement.executeQuery("SELECT o.id_operatore FROM operatori o WHERE nome_utente = '" + op.getNomeUtente() + "'");
			
			return rs.next();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getIdOperatoreNoPassword(Operatori op) {
			
		try {
			ResultSet rs = statement.executeQuery("SELECT o.id_operatore FROM operatori o WHERE o.nome_utente = '" + op.getNomeUtente() + "'");
			
			rs.next();
			return rs.getString("id_operatore");
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			return "";
		}
	}
	
	public boolean modificaPassword(String nome, String pass) {
		
		try {
			
				return !statement.execute("UPDATE operatori SET password = '" + pass + "' WHERE nome_utente = '" + nome + "'" );
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
}
