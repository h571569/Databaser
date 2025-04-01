
DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;


CREATE TABLE avdeling (

                          avdelingId   SERIAL primary key,
                          avdelingNavn varchar(50),
                          sjefId     int not null
);

CREATE TABLE ansatt (

    ansattId   SERIAL primary key,
    brukernavn char(4) unique not null,
    fornavn    varchar(50),
    etternavn  varchar(50),
    ansdato    date,
    stilling   varchar(50),
    manedslonn int,
    avdelingId int not null,
    foreign key (avdelingId) references avdeling(avdelingId)
);

alter table avdeling add foreign key (sjefId) references ansatt(ansattId);

INSERT INTO
    ansatt(brukernavn, fornavn, etternavn, ansdato, stilling, manedslonn, avdelingId)
values
    ('edam', 'edvar', 'andersen', '2024-06-06', 'Ingeniør', 55000,1),
    ('fred','fredrik', 'furustøl','2022-01-09','backend',60000,1),
    ('wesl','wesley','soumele','2025-03-29','frontend',49000,2),
    ('jona','jonas','glambek','2019-05-08','fullstack',66000,2),
    ('gaby','gabriel','hugaas','2019-09-30','seniordev',95000,2),
    ('elif','elias','frette','2023-04-07','developer',70000,2);



INSERT INTO
    avdeling(avdelingNavn)
values
    ('IT-Avdeling'),
    ('WebDev-Avdeling');

UPDATE avdeling set sjefId = 1 where avdelingId = 1;
UPDATE avdeling set sjefId = 5 where avdelingId = 2;

CREATE TABLE prosjekt (

    prosjektId   SERIAL primary key,
    prosjektNavn varchar(50),
    beskrivelse  TEXT
);

INSERT INTO
    prosjekt(prosjektNavn, TEXT)
values
    ('obligProsjekt','lage en oblig'),
    ('NasaProsjekt','fikse sattelitt forbindelse'),
    ('MilitærKryptering', 'kryptere data for militæret');

CREATE TABLE prosjektDeltagelse (

    ansattId     int, primary key,
    prosjektId   int, primary key,
    rolle        varchar(50),
    arbeidstimer int,
    foreign key (ansattId) references ansatt(ansattId),
    foreign key (prosjektId) references prosjekt(prosjektId)
);

INSERT INTO prosjektDeltagelse
values (1,1,'leder',100),
       (2,1,'developer',60),
       (3,2,'leder',90),
       (4,2,'developer',60),
       (5,3,'leder',95),
       (6,3,'developer',50);