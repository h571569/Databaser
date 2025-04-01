
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

CREATE TABLE ansatt (

    ansattId   AUTO_INCREMENT, primary key,
    brukernavn char(4),unique, not null,
    fornavn    varchar(50),
    etternavn  varchar(50),
    ansdato    date,
    stilling   varchar(50),
    manedslonn int,
    avdelingId int,
    foreign key (avdelingId) references avdeling(avdelingId)

);

INSERT INTO
    ansatt(brukernavn, fornavn, etternavn, ansdato, stilling, manedslonn)
values
    ('edam', 'edvar', 'andersen', '2024-06-06', 'Ingeniør', 55000),
    ('fred','fredrik', 'furustøl','2022-01-09','backend',60000),
    ('wesl','wesley','soumele','2025-03-29','frontend',49000),
    ('jona','jonas','glambek','2019-05-08','fullstack',66000),
    ('gaby','gabriel','hugaas','2019-09-31','seniordev',95000),
    ('elif','elias','frette','2023-04-07','developer',70000);


CREATE TABLE avdeling (

    avdelingId   AUTO_INCREMENT, primary key,
    avdelingNavn varchar(50),
    sjefId     int,
    foreign key (sjefId) references ansatt(ansattId);
);

INSERT INTO
    avdeling(avdelingNavn)
values
    ('IT-Avdeling'),
    ("WebDev-Avdeling");

UPDATE avdeling set sjefId = 1 where avdelingId = 1;
UPDATE avdeling set sjefId = 5 where avdelingId = 2;

CREATE TABLE prosjekt (

    prosjektId   AUTO_INCREMENT, primary key,
    prosjektNavn varchar(50),
    beskrivelse  TEXT
);

INSERT INTO
    prosjekt(prosjektNavn, TEXT)
values
    ('obligProsjekt','lage en oblig'),
    ("NasaProsjekt", "fikse sattelitt forbindelse"),
    ("MilitærKryptering", "kryptere data for militæret");

CREATE TABLE prosjektDeltagelse (

    ansattId     int, primary key,
    prosjektId   int, primary key,
    rolle        varchar(50),
    arbeidstimer int,
    foreign key (ansattId) references ansatt(ansattId),
    foreign key (prosjektId) references prosjekt(prosjektId)
);