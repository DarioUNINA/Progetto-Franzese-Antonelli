INSERT INTO aree_tematiche
VALUES('programmazione');

INSERT INTO aree_tematiche
VALUES('matematica');

INSERT INTO aree_tematiche
VALUES('calcolo');

INSERT INTO aree_tematiche
VALUES('strutture dati');

INSERT INTO aree_tematiche
VALUES('algoritmi');

INSERT INTO aree_tematiche
VALUES('filosofia');

INSERT INTO aree_tematiche
VALUES('scienze');

INSERT INTO aree_tematiche
VALUES('lingue');

INSERT INTO aree_tematiche
VALUES('ingegneria');

INSERT INTO aree_tematiche
VALUES('economia');




INSERT INTO parole_chiave
VALUES('java');

INSERT INTO parole_chiave
VALUES('algebra relazionale');

INSERT INTO parole_chiave
VALUES('grafi');

INSERT INTO parole_chiave
VALUES('fsm');

INSERT INTO parole_chiave
VALUES('reticoli');

INSERT INTO parole_chiave
VALUES('funzioni');

INSERT INTO parole_chiave
VALUES('commercio');

INSERT INTO parole_chiave
VALUES('mercati');

INSERT INTO parole_chiave
VALUES('software');

INSERT INTO parole_chiave
VALUES('network');

INSERT INTO parole_chiave
VALUES('automazione');

INSERT INTO parole_chiave
VALUES('impianti');




INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 's.demartino','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'),'a.peron','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 'm.benerecetti','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 'a.deluca','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 'f.oliva','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 'g.laccetti','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 'm.trombetti','password');

INSERT INTO operatori
VALUES(nextval('sequenza_id_operatore'), 'g.adamo','password');




INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 1, 'object_orientation', 'corso sul paradigma della programmazione ad oggetti', 1, 5, '2023');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 2, 'basi_dati', 'corso sulla gestione di database', 1, 5, '2022');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 3, 'algoritmi_strutture_dati', 'corso sullo complessita di algoritmi e strutture dati', 1, 5, '2022');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 4, 'elementi_di_informatica_teorica', 'informatica teorica', 1, 5, '2022');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 6, 'programmazione_1', 'approccio alla programmazione in c++', 2, 5, '2021');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 1, 'analisi_1', 'teoremi base di analisi matematica', 2, 10, '2019');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 1, 'ingegneria_del_software', 'studio dei software', 1, 5, '2021');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 2, 'algebra', 'corso algebra lineare e booleana', 3, 10, '2019', true);

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 4, 'chimica', 'approfondimento elementi di chimica complementare', 1, 5, '2018', true);

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 8, 'astrofisica', 'studio dei fenomeni astronomici e astrofisici', 2, 10, '2022');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 1, 'geometria', 'Conoscenze e capacità su teoria degli spazi vettoriali.', 1, 10, '2022', true);

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 2, 'diritto_privato', 'comprensione i basilari e principali istituti giusprivatistici', 1, 5, '2020',true);

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 1, 'economia_monetaria', 'dinamiche sui mercati monetari e finanziari internazionali', 2, 10,'2021');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 8, 'logistica_industriale', 'governare e pianificare le principali attività logistiche', 1, 10, '2021');

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 4, 'tecnologia_meccanica', 'processi di produzione industriale completamente automatizzati', 1, 5, '2021',true);

INSERT INTO corsi
VALUES(nextval('sequenza_id_corso'), 7, 'ricerca_operativa', ' studio scientifico dei metodi per risolvere problemi decisionali', 1, 5, '2022');





INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'eccezioni' , 'gestione delle exception', '1:30', '14/06/2023', '8:30', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'superclassi' , 'gestione delle superclassi e sottoclassi', '1:30', '14/10/2023', '8:30', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'sottoclassi', 'utilità delle sottoclassi', '2:00', '23/11/2023', '10:30', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'jframe', 'design su java', '2:00', '18/10/2023', '8:30', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'sequence diagram', 'come scrivere un sequence diagram', '1:00', '26/09/2023', '16:30', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'array list', 'struttura dati array list', '1:00', '10/11/2023', '14:00', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'database', 'colleggamento database', '1:30', '8/12/2023', '11:00', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'associazioni', 'associazioni bidimensionali', '2:00', '3/11/2023', '16:30', 1);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'algebra relazionale', 'definizione sintassi', '1:30', '28/09/2022', '8:30', 2);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'complessita computazionale', 'studio della complessita di un algoritmo', '1:30', '28/09/2022', '8:30', 3);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'grafi', 'DFS', '2:00', '01/10/2022', '16:30', 3);

INSERT into lezioni 
VALUES(nextval('sequenza_id_lezione'), 'bfs' , 'algoritmo di ricerca in profondita', '2:00', '06/11/2022', '16:30', 3);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'dfs', 'algoritmo di ricerca in ampiezza', '2:00', '01/11/2022', '8:00', 3);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'insieme diagonale' , 'dimostrazione del teormea', '1:30', '14/09/2022', '8:30', 4);

INSERT into lezioni 
VALUES(nextval('sequenza_id_lezione'), 'linguaggi finiti' , 'prodotti tra linguaggi', '2:00', '08/11/2022', '16:30', 4);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'grammatica ambigua' , 'quando si dice ambigua', '1:30', '9/11/2022', '8:30', 4);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'array', 'definizione struttura dell array', '2:00', '14/10/2021', '8:30', 5);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'stack', 'approccio a struttua dati stack', '1:30', '29/09/2021', '8:30', 5);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'successione limitata', 'studio e applicazione sulle successioni', '1:30', '27/11/2019', '10:30', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'serie' , 'serie geometrica', '2:00', '14/10/2019', '8:30', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'insiemi', 'teoria degli insiemi ', '2:00', '16/10/2019', '14:00', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'calcolo differenziale', 'regolo di derivazione', '2:00', '01/12/2019', '11:00', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'estremi relaviti', 'teorema di lagrange', '2:00', '30/09/2019', '8:30', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'numeri reali', 'estremo superiore', '2:00', '5/10/20219', '8:30', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'calcolo intregale', 'funzioni continue', '2:00', '10/12/2019', '16:30', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'derivate', 'calcolo della derivata ', '1:00', '07/12/2019', '14:00', 6);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'uml', 'linguaggio di modellazione e specifica', '1:30', '06/3/2021', '11:00', 7);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'anelli', 'struttura algebrica', '1:30', '01/12/2019', '13:00', 8);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'corrispondenze', 'relazioni binarie e applicazioni', '1:00', '20/10/2019', '8:30', 8);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'sistemi lineari', ' sistema composto da più equazioni lineari ', '1:30', '28/05/2022', '8:30', 11);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'principi della termofluidodinamica', 'primo approccio alla termofluidodinamica', '1:30', '28/05/2021', '8:30', 15);

INSERT INTO lezioni
VALUES(nextval('sequenza_id_lezione'), 'calcolo proposizionale', 'teorema di completezza ed applicazioni', '2:00', '20/4/2022', '10:30', 16);










INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'renato', 'antonelli');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'dario', 'franzese');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'gian marco', 'addati');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'alessia', 'ascolese');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'simone', 'negroni');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'simone', 'giordano');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'matteo', 'spavone');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'lorenzo', 'criscuolo');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'mario', 'molinaro');

INSERT INTO studenti
VALUES(nextval('sequenza_matricola'),'assunta', 'venturoli');




INSERT INTO iscrizioni
VALUES(1, 4, true);

INSERT INTO iscrizioni
VALUES(1, 5);

INSERT INTO iscrizioni
VALUES(1, 6, true);

INSERT INTO iscrizioni
VALUES(1, 14);

INSERT INTO iscrizioni
VALUES(2, 1);

INSERT INTO iscrizioni
VALUES(2, 4);

INSERT INTO iscrizioni
VALUES(2, 5);

INSERT INTO iscrizioni
VALUES(2, 6);

INSERT INTO iscrizioni
VALUES(2, 7);

INSERT INTO iscrizioni
VALUES(2, 10, false);

INSERT INTO iscrizioni
VALUES(2, 11);

INSERT INTO iscrizioni
VALUES(3, 2);

INSERT INTO iscrizioni
VALUES(3, 7);

INSERT INTO iscrizioni
VALUES(3, 8);

INSERT INTO iscrizioni
VALUES(4, 6);

INSERT INTO iscrizioni
VALUES(5, 6);

INSERT INTO iscrizioni
VALUES(6, 6);

INSERT INTO iscrizioni
VALUES(6, 15);

INSERT INTO iscrizioni
VALUES(7, 2);

INSERT INTO iscrizioni
VALUES(7, 6, true);

INSERT INTO iscrizioni
VALUES(7, 7);

INSERT INTO iscrizioni
VALUES(7, 8);

INSERT INTO iscrizioni
VALUES(8, 13);

INSERT INTO iscrizioni
VALUES(9, 1);

INSERT INTO iscrizioni
VALUES(9, 8);

INSERT INTO iscrizioni
VALUES(10, 1);

INSERT INTO iscrizioni
VALUES(10, 5);

INSERT INTO iscrizioni
VALUES(10, 6);





INSERT INTO presenze
VALUES(1, 14);

INSERT INTO presenze
VALUES(1, 16);

INSERT INTO presenze
VALUES(1, 19);

INSERT INTO presenze
VALUES(1, 20);

INSERT INTO presenze
VALUES(1, 25);

INSERT INTO presenze
VALUES(1, 26);

INSERT INTO presenze
VALUES(2, 14);

INSERT INTO presenze
VALUES(2, 15);

INSERT INTO presenze
VALUES(2, 16);

INSERT INTO presenze
VALUES(2, 17);

INSERT INTO presenze
VALUES(2, 20);

INSERT INTO presenze
VALUES(2, 25);

INSERT INTO presenze
VALUES(2, 26);

INSERT INTO presenze
VALUES(3, 9);

INSERT INTO presenze
VALUES(3, 28);

INSERT INTO presenze
VALUES(3, 29);

INSERT INTO presenze
VALUES(3, 24);

INSERT INTO presenze
VALUES(4, 21);

INSERT INTO presenze
VALUES(4, 23);

INSERT INTO presenze
VALUES(4, 24);

INSERT INTO presenze
VALUES(4, 25);

INSERT INTO presenze
VALUES(5, 8);

INSERT INTO presenze
VALUES(5, 23);

INSERT INTO presenze
VALUES(5, 24);

INSERT INTO presenze
VALUES(5, 26);

INSERT INTO presenze
VALUES(6, 2);

INSERT INTO presenze
VALUES(6, 20);

INSERT INTO presenze
VALUES(6, 21);

INSERT INTO presenze
VALUES(6, 23);

INSERT INTO presenze
VALUES(7, 9);

INSERT INTO presenze
VALUES(7, 21);

INSERT INTO presenze
VALUES(7, 24);

INSERT INTO presenze
VALUES(9, 1);

INSERT INTO presenze
VALUES(9, 4);

INSERT INTO presenze
VALUES(9, 6);

INSERT INTO presenze
VALUES(9, 28);

INSERT INTO presenze
VALUES(9, 29);

INSERT INTO presenze
VALUES(10, 3);

INSERT INTO presenze
VALUES(10, 4);

INSERT INTO presenze
VALUES(10, 5);

INSERT INTO presenze
VALUES(10, 8);

INSERT INTO presenze
VALUES(10, 18);

INSERT INTO presenze
VALUES(10, 19);

INSERT INTO presenze
VALUES(10, 20);

INSERT INTO presenze
VALUES(10, 24);

INSERT INTO presenze
VALUES(10, 25);




INSERT INTO temi
VALUES('programmazione', 1);

INSERT INTO temi
VALUES('strutture dati', 1);

INSERT INTO temi
VALUES('calcolo', 8);

INSERT INTO temi
VALUES('matematica', 8);

INSERT INTO temi
VALUES('matematica', 6);

INSERT INTO temi
VALUES('calcolo', 6);

INSERT INTO temi
VALUES('programmazione', 7);

INSERT INTO temi
VALUES('strutture dati', 3);

INSERT INTO temi
VALUES('algoritmi', 3);

INSERT INTO temi
VALUES('programmazione', 5);

INSERT INTO temi
VALUES('programmazione', 2);

INSERT INTO temi
VALUES('calcolo', 2);

INSERT INTO temi
VALUES('scienze', 10);

INSERT INTO temi
VALUES('ingegneria', 7);

INSERT INTO temi
VALUES('filosofia', 4);

INSERT INTO temi
VALUES('economia', 13);

INSERT INTO temi
VALUES('scienze', 6);

INSERT INTO temi
VALUES('calcolo', 16);

INSERT INTO temi
VALUES('ingegneria', 15);

INSERT INTO temi
VALUES('strutture dati', 5);

INSERT INTO temi
VALUES('scienze', 16);

INSERT INTO temi
VALUES('programmazione', 15);

INSERT INTO temi
VALUES('lingue', 12);

INSERT INTO temi
VALUES('calcolo', 4);



INSERT INTO caratterizza
VALUES('java', 1);

INSERT INTO caratterizza
VALUES('fsm', 4);

INSERT INTO caratterizza
VALUES('grafi', 3);

INSERT INTO caratterizza
VALUES('funzioni', 6);

INSERT INTO caratterizza
VALUES('reticoli', 8);

INSERT INTO caratterizza
VALUES('algebra relazionale', 8);

INSERT INTO caratterizza
VALUES('algebra relazionale', 2);

INSERT INTO caratterizza
VALUES('software', 1);

INSERT INTO caratterizza
VALUES('impianti', 14);

INSERT INTO caratterizza
VALUES('network', 10 );

INSERT INTO caratterizza
VALUES('software', 11);

INSERT INTO caratterizza
VALUES('reticoli', 6);

INSERT INTO caratterizza
VALUES('algebra relazionale', 7);

INSERT INTO caratterizza
VALUES('software', 2);




INSERT INTO domande_sicurezza
VALUES ('dove sei nato?' , nextval('sequenza_id_domanda'));

INSERT INTO domande_sicurezza
VALUES ('come si chiama il tuo primo genito ?' , nextval('sequenza_id_domanda'));

INSERT INTO domande_sicurezza
VALUES ('come si chiama il tuo animale domestico?' , nextval('sequenza_id_domanda'));




INSERT INTO domande_operatori
VALUES('napoli', '1', '1');

INSERT INTO domande_operatori
VALUES('kappa', '3', '2');

INSERT INTO domande_operatori
VALUES('luca', '2', '3');

INSERT INTO domande_operatori
VALUES('napoli', '1', '4');

INSERT INTO domande_operatori
VALUES('giulia', '2', '5');

INSERT INTO domande_operatori
VALUES('kira', '3', '6');

INSERT INTO domande_operatori
VALUES('marco', '2', '7');

INSERT INTO domande_operatori
VALUES('giotto', '3', '8');
