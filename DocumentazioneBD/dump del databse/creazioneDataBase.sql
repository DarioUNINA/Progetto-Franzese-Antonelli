-- Database: CorsiDiFormazioneDB

-- DROP DATABASE IF EXISTS "CorsiDiFormazioneDB";

CREATE DATABASE "CorsiDiFormazioneDB"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Italian_Italy.1252'
    LC_CTYPE = 'Italian_Italy.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "CorsiDiFormazioneDB"
    IS 'Database per la gestione di corsi di formazione';

