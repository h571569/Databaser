
DROP SCHEMA IF EXIST oblig3 CASCADE;
CREATE SCHEMA oblig3:
SET search_path TO oblig3;

CREATE TABLE ansatt (

    ansattid serial, primary key,
    brukernavn char(4), unique, not null,
    fornavn varchar(25), not null,
    etternavn varchar(25), not null,
    ansdato date, not null,
    stilling varchar(25), not null,
    manedslonn smallint, not null,
    avdeling varchar(25), not null,
    prosjekter varchar(255) not null
);

INSERT INTO
    ansatt
values
    (0, edam, edvar, andersen, 2024:06:06, leder, 55000, IT, DB107);

SELECT * from ansatt;