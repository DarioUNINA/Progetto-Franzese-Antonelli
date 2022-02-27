
--1)
	CREATE FUNCTION check_inserimento_in_terminato()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione INTEGER;
	BEGIN
		SELECT COUNT (*) INTO violazione
		FROM corsi s
		WHERE s.id_corso = NEW.id_corso AND s.terminato = true;
		
		IF (violazione>0) THEN
			RAISE SQLSTATE '10005';
			ROLLBACK;
			RAISE EXCEPTION 'ATTENZIONE : il corso e termianto';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER inserimento_in_terminato
	AFTER INSERT ON lezioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_inserimento_in_terminato();



--2)
	CREATE OR REPLACE FUNCTION check_ammissione()
	RETURNS TRIGGER AS 
	$$
	DECLARE p_min INTEGER;
			p_studente INTEGER;
			codice_corso VARCHAR(100);
	
	BEGIN
	
		SELECT l.id_corso INTO codice_corso
		FROM presenze p JOIN lezioni l ON p.id_lezione = l.id_lezione
		WHERE p.id_lezione = NEW.id_lezione;
	
		SELECT COUNT(*) INTO p_studente
		FROM presenze p JOIN lezioni l ON p.id_lezione = l.id_lezione
		WHERE p.matricola = NEW.matricola
		AND l.id_corso = codice_corso;
	
		SELECT presenze_min INTO p_min
		FROM corsi c
		WHERE c.id_corso = codice_corso;
	
		IF( p_studente >= p_min ) THEN
			UPDATE iscrizioni i SET ammesso = TRUE WHERE i.matricola = NEW.matricola AND i.id_corso =  codice_corso;
		END IF;
		RETURN NEW;
	
	END

	$$ LANGUAGE plpgsql;

	CREATE OR REPLACE TRIGGER ammissione
	AFTER INSERT ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_ammissione();

	

--3)
	CREATE FUNCTION check_max_partecipanti()
	RETURNS TRIGGER AS
	$$
	DECLARE iscritti INTEGER;
			max_p INTEGER;
	BEGIN
		SELECT COUNT (matricola) INTO iscritti
		FROM iscrizioni i JOIN corsi c ON i.id_corso = c.id_corso
		WHERE i.id_corso = new.id_corso;
		
		SELECT c.max_partecipanti INTO max_p
		FROM iscrizioni i JOIN corsi c ON i.id_corso = c.id_corso
		WHERE i.id_corso = NEW.id_corso;
		
		IF (iscritti > max_p) THEN	
			RAISE SQLSTATE '10006';
			ROLLBACK;
			RAISE EXCEPTION 'e stato raggiunto il numero massimo di partecipanti al corso';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER max_partetcipanti
	AFTER INSERT ON iscrizioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_max_partecipanti();

   
--9)	
	CREATE OR REPLACE FUNCTION check_data_lezione()
	RETURNS TRIGGER AS
	$$
	DECLARE data_lezione DATE;
	BEGIN
		SELECT data INTO data_lezione
		FROM lezioni l
		WHERE l.id_lezione = NEW.id_lezione;
		
		IF (data_lezione < CURRENT_DATE) THEN 
			RAISE SQLSTATE '10007';
			ROLLBACK;
			RAISE EXCEPTION 'La lezione si e gia conclusa';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;
	
	CREATE OR REPLACE TRIGGER data_lezioni
	AFTER INSERT ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_data_lezione();
	
--8) 
	
	CREATE FUNCTION check_presenza_contemporanea()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione INTEGER;
			startt TIME WITHOUT TIME ZONE;
			endt TIME WITHOUT TIME ZONE;
            datat DATE;
	BEGIN
		
		SELECT l.orario INTO startt
		FROM lezioni l
		WHERE new.id_lezione = l.id_lezione;
		
		SELECT l.orario+l.durata INTO endt
		FROM lezioni l
		WHERE new.id_lezione = l.id_lezione;
        
		SELECT l.data into datat
		FROM lezioni l
		WHERE new.id_lezione = l.id_lezione;
		
		SELECT COUNT (*) INTO violazione
		FROM presenze pr JOIN lezioni le ON pr.id_lezione = le.id_lezione
		WHERE pr.matricola = NEW.matricola AND le.data = datat AND ((le.orario BETWEEN startt AND endt) OR (le.orario+le.durata BETWEEN startt AND endt) OR (le.orario < startt AND le.orario+le.durata > endt)); 	
    
        IF (violazione > 1) THEN	
			RAISE SQLSTATE '10008';
			ROLLBACK;
			RAISE EXCEPTION 'Ti sei gia iscritto ad una lezione in contemporanea';
		END IF;
		RETURN NEW;
	END
	
	$$ LANGUAGE plpgsql;
	
	CREATE TRIGGER presenza_contemporanea
	AFTER INSERT ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_presenza_contemporanea();
	
--11)
	CREATE FUNCTION check_iscrizione_terminato()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione INTEGER;
	BEGIN
		SELECT COUNT (*) INTO violazione 
		FROM corsi c JOIN iscrizioni i ON c.id_corso = i.id_corso
		WHERE i.id_corso = new.id_corso AND c.terminato = true;
		
		IF violazione > 0 THEN
		RAISE SQLSTATE '10009';
		ROLLBACK;
		RAISE EXCEPTION 'Il corso gia e terminato';
		END IF;
		RETURN NEW;
	END
	
	$$ LANGUAGE plpgsql;
	
	CREATE TRIGGER iscrizione_in_terminato
	AFTER INSERT ON iscrizioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_iscrizione_terminato();

--12) 
	CREATE FUNCTION check_lezione_iscrizione()
	RETURNS TRIGGER AS
	$$
	DECLARE contatore INTEGER;
	BEGIN
		SELECT COUNT (*) INTO contatore
		FROM presenze p JOIN lezioni l ON p.id_lezione = l.id_lezione
		WHERE p.id_lezione = NEW.id_lezione AND l.id_corso IN (
		
		SELECT i.id_corso
		FROM iscrizioni i
		WHERE i.matricola = NEW.matricola);
		
		IF contatore = 0 THEN
			RAISE SQLSTATE '10010';
			ROLLBACK;
			RAISE EXCEPTION 'Non sei iscritto al corso';
		END IF;
		RETURN NEW;
	END;
	
	$$ LANGUAGE plpgsql;
	
	CREATE TRIGGER lezione_iscrizione
	AFTER INSERT ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_lezione_iscrizione();
	
	
--14)	
	CREATE FUNCTION check_lunghezza_password()
	RETURNS TRIGGER AS
	$$
	DECLARE index INTEGER;
			stringa VARCHAR(100);
	BEGIN
		SELECT o.password INTO stringa
		FROM operatori o
		WHERE o.nome_utente = NEW.nome_utente;
		
		stringa = SUBSTRING(stringa, 6, 100);
		IF(stringa = '')THEN
			RAISE SQLSTATE '10001';
			ROLLBACK;
			RAISE EXCEPTION 'La password deve contentere almeno 6 caratteri';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER lunghezza_password_violata
	AFTER INSERT ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_lunghezza_password();
	
	
	
	
	CREATE FUNCTION check_lunghezza_nome_utente()
	RETURNS TRIGGER AS
	$$
	DECLARE index INTEGER;
			stringa VARCHAR(100);
	BEGIN
		SELECT o.nome_utente INTO stringa
		FROM operatori o
		WHERE o.nome_utente = NEW.nome_utente;
		
		stringa = SUBSTRING(stringa, 4, 100);
		IF(stringa = '')THEN
			RAISE SQLSTATE '10002';
			ROLLBACK;
			RAISE EXCEPTION 'Il nome utente deve contentere almeno 4 caratteri';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER lunghezza_nome_utente_violata
	AFTER INSERT ON operatori
	FOR EACH ROW#
	EXECUTE PROCEDURE check_lunghezza_nome_utente();
	
--15)
	CREATE FUNCTION check_caratteri_speciali_nome_utente()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione INTEGER;
	BEGIN
		SELECT COUNT(*) INTO violazione
		FROM operatori o
		WHERE o.nome_utente = NEW.nome_utente AND 
			( o.nome_utente like '%!%' OR o.nome_utente like '%@%' OR o.nome_utente like '%#%' OR o.nome_utente like '%$%');
		
		IF(violazione>0)THEN
			RAISE SQLSTATE '10003';
			ROLLBACK;
			RAISE EXCEPTION 'Il nome utente non puo contenere caratteri speciali';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER nome_utente_caratteri_speciali
	AFTER INSERT ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_caratteri_speciali_nome_utente();
	
	
	
	CREATE FUNCTION check_caratteri_speciali_password()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione INTEGER;
	BEGIN
		SELECT COUNT(*) INTO violazione
		FROM operatori o
		WHERE o.password like '%!%' OR o.password like '%@%' OR o.password like '%#%' OR o.password like '%$%';
		
		IF(violazione>0)THEN
			RAISE SQLSTATE '10004';
			ROLLBACK;
			RAISE EXCEPTION 'La password non puo contenere caratteri speciali';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER password_caratteri_speciali
	AFTER INSERT ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_caratteri_speciali_password();
	
--16) Trigger per gli update
		

	CREATE TRIGGER update_nome_utente_caratteri_speciali
	AFTER UPDATE ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_caratteri_speciali_nome_utente();
	
	
	CREATE TRIGGER update_password_caratteri_speciali
	AFTER UPDATE ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_caratteri_speciali_password();
	
	CREATE TRIGGER update_lunghezza_password_violata
	AFTER UPDATE ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_lunghezza_password();
	
	CREATE TRIGGER update_lunghezza_nome_utente_violata
	AFTER UPDATE ON operatori
	FOR EACH ROW
	EXECUTE PROCEDURE check_lunghezza_nome_utente();
	
--17) 
	CREATE OR REPLACE FUNCTION check_eliminazione_presenza()
	RETURNS TRIGGER AS
	$$
	DECLARE data_lezione DATE;
	BEGIN
		SELECT data INTO data_lezione
		FROM presenze p JOIN lezioni l ON p.id_lezione = l.id_lezione
		WHERE p.id_lezione = OLD.id_lezione;
		
		IF(EXISTS (SELECT * FROM studenti WHERE matricola = old.matricola)) THEN
			IF (data_lezione < CURRENT_DATE) THEN 
				RAISE SQLSTATE '10011';
				ROLLBACK;
				RAISE EXCEPTION 'La lezione si e gia conclusa';
			END IF;
		END IF;
		RETURN OLD;
	END
	$$ LANGUAGE plpgsql;
	
	CREATE OR REPLACE TRIGGER eliminazione_presenza
	AFTER DELETE ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_eliminazione_presenza();
	

--18)
	CREATE FUNCTION check_creazione_lezione_contemporanea()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione INTEGER;
			startt TIME WITHOUT TIME ZONE;
			endt TIME WITHOUT TIME ZONE;
            datat DATE;
	BEGIN
		
		SELECT l.orario INTO startt
		FROM lezioni l
		WHERE new.id_lezione = l.id_lezione;
		
		SELECT l.orario+l.durata INTO endt
		FROM lezioni l
		WHERE new.id_lezione = l.id_lezione;
        
		SELECT l.data into datat
		FROM lezioni l
		WHERE new.id_lezione = l.id_lezione;
		
		SELECT COUNT (*) INTO violazione
		FROM lezioni le
		WHERE le.id_corso = NEW.id_corso AND le.data = datat AND ((le.orario BETWEEN startt AND endt) OR (le.orario+le.durata BETWEEN startt AND endt) OR (le.orario < startt AND le.orario+le.durata > endt)); 	
    
        IF (violazione > 1) THEN	
			RAISE SQLSTATE '10012';
			ROLLBACK;
			RAISE EXCEPTION 'Hai gia lezioni allo stesso orario dello stesso giorno';
		END IF;
		RETURN NEW;
	END
	
	$$ LANGUAGE plpgsql;
	
	CREATE TRIGGER creazione_lezione_contemporanea
	AFTER INSERT ON lezioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_creazione_lezione_contemporanea();

--19)

	CREATE VIEW partecipanti(id_corso, partecipanti) AS (	
	SELECT i.id_corso, count (matricola)
	from iscrizioni i
	group by (id_corso)
)

--20)

	CREATE OR REPLACE FUNCTION check_data_lezione_corso()
	RETURNS TRIGGER AS
	$$
	DECLARE anno VARCHAR(100);
	BEGIN
		
		select c.anno into anno
		from corsi c
		where c.id_corso = new.id_corso;
		
		IF (CAST(EXTRACT(YEAR FROM new.data) AS VARCHAR(100)) <> anno) THEN
			RAISE SQLSTATE '10013';
			ROLLBACK;
			RAISE EXCEPTION 'la data della lezione non corrisponde con l anno del corso';
		END IF;
		
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;
	
	CREATE OR REPLACE TRIGGER data_lezione_corso
	AFTER INSERT ON lezioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_data_lezione_corso();
	
--21)

	CREATE VIEW presenze_totali(presenze, id_corso) AS(
		SELECT COUNT(matricola), co.id_corso
		FROM (presenze p JOIN lezioni l ON p.id_lezione = l.id_lezione) JOIN corsi co ON l.id_corso = co.id_corso
		GROUP BY co.id_corso
	)


--22) 
	CREATE OR REPLACE FUNCTION presenze_medie(idcorso VARCHAR(100))
	RETURNS FLOAT AS
	$$
	DECLARE n_lezioni FLOAT;
			risultato FLOAT;
			n_presenze FLOAT;
	BEGIN
	
		SELECT count(l.id_corso) INTO n_lezioni
		FROM lezioni l
		WHERE l.id_corso = idcorso
		GROUP BY(l.id_corso);

		SELECT pt.presenze into n_presenze
		FROM presenze_totali pt
		WHERE pt.id_corso = idcorso;		
		
		risultato := n_presenze/n_lezioni;
		
		RETURN risultato;
	END
	$$ LANGUAGE plpgsql;

--23)

	CREATE VIEW presenze_studente_corso(matricola, id_corso, presenze) AS(
		SELECT p.matricola, l.id_corso, COUNT(p.matricola)
		FROM presenze p join lezioni l on p.id_lezione = l.id_lezione
		GROUP BY p.matricola, l.id_corso
	)

--24)

	CREATE OR REPLACE TRIGGER update_data_lezioni
	AFTER UPDATE ON lezioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_data_lezione();
	
	CREATE TRIGGER update_lezione_contemporanea
	AFTER UPDATE ON lezioni
	FOR EACH ROW
	EXECUTE PROCEDURE check_creazione_lezione_contemporanea();
	
--25)
	CREATE OR REPLACE FUNCTION check_update_ammissione()
	RETURNS TRIGGER AS 
	$$
	DECLARE cursore cursor for (select * from presenze_studente_corso p where p.id_corso = new.id_corso);
	BEGIN
		FOR a IN cursore
		LOOP
			IF a.presenze < new.presenze_min THEN
				UPDATE iscrizioni set ammesso = false WHERE matricola = a.matricola;
			ELSE
				UPDATE iscrizioni set ammesso = true WHERE matricola = a.matricola;
			END IF;
		END LOOP;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE OR REPLACE TRIGGER update_ammissione
	AFTER UPDATE ON corsi
	FOR EACH ROW
	EXECUTE PROCEDURE check_update_ammissione();
	
--26)

	CREATE OR REPLACE FUNCTION update_lezioni_terminato()
	RETURNS TRIGGER AS 
	$$
	BEGIN
		IF new.terminato THEN
			DELETE from lezioni l where l.id_corso = new.id_corso AND l.data > CURRENT_DATE;
		END IF;
	RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE OR REPLACE TRIGGER check_update_lezioni_terminato
	AFTER UPDATE ON corsi
	FOR EACH ROW
	EXECUTE PROCEDURE update_lezioni_terminato();
		
	
--27)
	
	CREATE FUNCTION check_lezione_corso_terminato()
	RETURNS TRIGGER AS
	$$
	DECLARE violazione BOOLEAN;
	BEGIN
		SELECT co.terminato INTO violazione
		FROM corsi co JOIN lezioni l on co.id_corso = l.id_corso
		WHERE l.id_lezione = new.id_lezione;
		
		IF (violazione) THEN
			RAISE SQLSTATE '10013';
			ROLLBACK;
			RAISE EXCEPTION 'ATTENZIONE : il corso della lezione che hai scelto e termianto';
		END IF;
		RETURN NEW;
	END
	$$ LANGUAGE plpgsql;

	CREATE TRIGGER lezione_corso_terminato
	AFTER INSERT ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_lezione_corso_terminato();
	
	CREATE TRIGGER update_lezione_corso_terminato
	AFTER UPDATE ON presenze
	FOR EACH ROW
	EXECUTE PROCEDURE check_lezione_corso_terminato();
	