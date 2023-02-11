DROP DATABASE IF EXISTS bank_ok;
CREATE DATABASE bank_ok;

\c bank_ok

DROP TABLE IF EXISTS TransactionBancaire;
DROP TYPE IF EXISTS type_transaction;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS ChargerClientele;

CREATE TABLE ChargerClientele (
    id_charger_clientele SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    mot_de_passe VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE Client (
    id_client SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    adresse VARCHAR(255),
    mot_de_passe VARCHAR(255),
    email VARCHAR(255),
    telephone VARCHAR(10),
    numero_cin VARCHAR(12),
    id_charger_clientele INTEGER default null,
    verifie BOOLEAN DEFAULT false,
    FOREIGN KEY (id_charger_clientele) REFERENCES ChargerClientele(id_charger_clientele)
);

CREATE TABLE Compte (
    num_compte SERIAL PRIMARY KEY,
    solde MONEY DEFAULT 0,
    date_ouverture TIMESTAMP DEFAULT now(), 
    id_client INTEGER,
    FOREIGN KEY (id_client) REFERENCES Client(id_client)
);

CREATE TYPE type_transaction AS ENUM ('depot', 'retrait');

CREATE TABLE TransactionBancaire (
    id_transaction SERIAL PRIMARY KEY,
    montant MONEY,
    date_transaction DATE,
    type type_transaction,
    num_compte_depart INTEGER,
    num_compte_arrive INTEGER,
    FOREIGN KEY (num_compte_depart) REFERENCES Compte(num_compte),
    FOREIGN KEY (num_compte_arrive) REFERENCES Compte(num_compte)
);