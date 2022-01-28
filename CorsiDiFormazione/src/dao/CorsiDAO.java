package dao;

import java.sql.*;
import java.util.Vector;

import dto.Corsi;

public class CorsiDAO {
	
	private Connessione connessione;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public CorsiDAO() {
		
		connessione = Connessione.getConnessione();
		statement = connessione.getStatement();
	}
	
	public Vector<String> getAnno(){
		
		Vector<String> anno = new Vector<String>();
		
		try {
			ResultSet rs = statement.executeQuery("SELECT DISTINCT anno FROM corsi ORDER BY anno");
			
			anno.add("");
			
			while(rs.next()) {
				anno.add(rs.getString(1));
			}
			
			return anno;
		}catch(SQLException e) {
			e.getMessage();
			return anno;
		}
	}
	
	public Vector<Corsi> addFiltri(String areaTematica, String anno, boolean terminato, String parolaChiave) {
		
		Vector<Corsi> corsiFiltrati = new Vector<Corsi>();
		Corsi c = new Corsi();
		
		String query;
		
		query = "SELECT * FROM corsi c JOIN temi t ON c.id_corso = t.id_corso WHERE ";
		
		if(!areaTematica.equals(""))
			query = query + " c.nome_area = '" + areaTematica +  "'  AND ";
		
		if(!anno.equals("")) 
			query = query + " c.anno = '" +  anno + "'  AND ";
	
		
		if(!parolaChiave.equals(""))
			query = query + "parole_chiave = '" + parolaChiave + "' AND";
		
		query = query + "c.terminato = '"  + terminato + "'";
		
		try {
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				 System.out.println(query);
				c.setIdCorso(rs.getString("id_corso"));
				c.setIdOperatore(rs.getString("id_operatore"));
				c.setIdOperatore(rs.getString("nome"));
				c.setDescrizione(rs.getString("descrizione"));
				c.setPresenzeMin(rs.getInt("presenze_min"));
				c.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				c.setParoleChiave(rs.getString("parole_chiave"));
				c.setAnno(rs.getString("anno"));
				c.setTerminato(rs.getBoolean("terminato"));
				//System.out.println(c.getIdCorso() + " "+ c.getIdOperatore() +" "+ c.getNome() + " "+c.getDescrizione() + " "+c.getPresenzeMin()  +" "+ c.getMaxPartecipanti() + " "+c.getParoleChiave() +" "+ c.getAnno()   );
				corsiFiltrati.add(c);
				
			}
			
			
			return corsiFiltrati;
		} catch (Exception e) {
			return corsiFiltrati;
		}
	}
}
