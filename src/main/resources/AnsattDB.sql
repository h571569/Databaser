
DROP SCHEMA IF EXIST oblig3 CASCADE;
CREATE SCHEMA oblig3:
SET search_path TO oblig3;

CREATE TABLE ansatt (

    ansattId   AUTO_INCREMENT, primary key,
    brukernavn char(4),unique, not null,
    fornavn    varchar(50),
    etternavn  varchar(50),
    ansdato    date,
    stilling   varchar(50),
    manedslonn smallint,
    avdelingId smallint, foreign key
);

INSERT INTO
    ansatt(brukernavn, fornavn, etternavn, ansdato, stilling, manedslonn)
values
    ('edam', 'edvar', 'andersen', '2024-06-06', 'Ingeniør', 55000);

CREATE TABLE avdeling (

    avdelingId   AUTO_INCREMENT, primary key,
    avdelingNavn varchar(50),
    ansattId       smallint, foreign key
);

INSERT INTO
    avdeling(avdelingNavn)
values
    ('HVL');

CREATE TABLE prosjekt (

    prosjektId   AUTO_INCREMENT, primary key,
    prosjektNavn varchar(50),
    beskrivelse  TEXT
);

INSERT INTO
    prosjekt(prosjektNavn, TEXT)
values
    ('JPA','lage en oblig');

CREATE TABLE ansattProsjekt (

    ansattId     smallint, primary key, foreign key,
    prosjektId   smallint, primary key, foreign key,
    rolle        varchar(50),
    arbeidstimer smallint,
);

insert into
    ansattProsjekt(rolle, arbeidstimer)
values
    ('Prosjektleder', 120);

SELECT * from ansatt;
SELECT * from avdeling;
SELECT * from prosjekt;
SELECT * from ansattProsjekt;