	CREATE SEQUENCE sequenza_id_corso
	START 1
	INCREMENT 1
	OWNED BY corsi.id_corso;
	
	CREATE SEQUENCE sequenza_id_operatore
	START 1
	INCREMENT 1
	OWNED BY operatori.id_operatore;
	
	CREATE SEQUENCE sequenza_id_lezione
	START 1
	INCREMENT 1
	OWNED BY lezioni.id_lezione;
	
	CREATE SEQUENCE sequenza_matricola
	START 1
	INCREMENT 1
	OWNED BY studenti.matricola;
	
	CREATE SEQUENCE sequenza_id_domanda
	START 1
	INCREMENT 1
	OWNED BY domande_sicurezza.id_domanda;
	
	
	
