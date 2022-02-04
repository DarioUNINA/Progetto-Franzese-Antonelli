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
	
	public String CheckNome(Operatori op) {
		
		try {
			ResultSet rs = statement.executeQuery("SELECT o.id_operatore FROM operatori o WHERE nome_utente = '" + op.getNomeUtente() + "'");
			
			if(rs.next())
				return "0";
			else
				return "-1";
		}catch(SQLException e) {
			
			e.printStackTrace();
			return "-1";
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
	
	public String modificaPassword(Operatori op, String pass) {
		
		try {
			
				if(!statement.execute("UPDATE operatori SET password = '" + pass + "' WHERE nome_utente = '" + op.getNomeUtente() + "'" ))
					return "0";
				else
					return "-1";
		}catch(SQLException e) {
		
			return e.getSQLState();
		}
		
	}
	
	
	public Operatori getOperatore(String nome) {
			
		Operatori op = new Operatori(nome);
			
		try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM operatori o WHERE o.nome_utente = '" + nome + "'");
				
				rs.next();
				op.setIdOperatore(rs.getString("id_operatore"));
				op.setPassword(rs.getString("password"));
				
				return op;
			}catch(SQLException e) {
				
				e.printStackTrace();
				return op;
		}
			
	}
	
	public String modificaNomeUtente(String nuovoNome, Operatori vecchio) {
		
		try {
			
				if(!statement.execute("UPDATE operatori SET nome_utente = '" + nuovoNome + "' WHERE nome_utente = '" + vecchio.getNomeUtente() + "'" ))
					return "0";
				else
					return "-1";
		}catch(SQLException e) {
		
			return e.getSQLState();
		}
		
	}
	
	public Operatori getOperatoreRecuperoPass(String nome) {
		
		Operatori op = new Operatori(nome);
			
		try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM operatori o WHERE o.nome_utente = '" + nome + "'");
				
				rs.next();
				op.setIdOperatore(rs.getString("id_operatore"));
				
				return op;
			}catch(SQLException e) {
				
				e.printStackTrace();
				return op;
		}
	}
	
	public String eliminaCorsiImpostazioni(String nomeCorso) {
		
		try {
			
			if(!statement.execute("DELETE FROM corsi WHERE nome = '" + nomeCorso + "'" ))
				return "0";
			else
				return "-1";
			
			
		} catch (SQLException e) {
			return e.getSQLState();
		}
	}
	
	public String eliminaOperatore(Operatori operatore) {
		
		try {
			
			if(!statement.execute("DELETE FROM operatori WHERE id_operatore = '" + operatore.getIdOperatore() + "'" ))
				return "0";
			else
				return "-1";
			
			
		} catch (SQLException e) {
			return e.getSQLState();
		}
	}
}
