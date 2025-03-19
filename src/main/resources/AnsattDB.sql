
DROP SCHEMA IF EXIST oblig3 CASCADE;
CREATE SCHEMA oblig3:
SET search_path TO oblig3;

CREATE TABLE ansatt (

    ansattid serial, primary key,
    brukernavn char(4), unique,
    fornavn varchar(25),
    etternavn varchar(25),
    ansdato date,
    stilling varchar(25),
    manedslonn smallint,
    avdeling varchar(25),
    prosjekter varchar(255)
);

INSERT INTO
    ansatt
values
    (0, edam, edvar, andersen, 2024:06:06, leder, 55000, IT, DB107);

SELECT * from ansatt;