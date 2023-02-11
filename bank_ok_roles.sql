-- ADMIN ROLE
CREATE ROLE admin WITH LOGIN PASSWORD 'admin' CREATEROLE;


-- CLIENT ROLE
CREATE ROLE client WITH LOGIN PASSWORD 'client';

-- CHARGER_CLIENTELE ROLE
CREATE ROLE charger_clientele WITH LOGIN PASSWORD 'charger_clientele' CREATEROLE;

-- VISITEUR ROLE
CREATE ROLE visiteur WITH LOGIN PASSWORD 'visiteur';

REVOKE ALL ON DATABASE bank_ok FROM admin, client, charger_clientele, visiteur;
GRANT CONNECT ON DATABASE bank_ok TO admin, client, charger_clientele, visiteur;

GRANT ALL ON TABLE ChargerClientele, Client, Compte, TransactionBancaire TO admin;
GRANT INSERT, SELECT ON TABLE Client TO visiteur;
GRANT INSERT, SELECT, UPDATE ON TABLE Client TO client;
GRANT SELECT, UPDATE ON TABLE Compte TO client;
GRANT SELECT ON TABLE ChargerClientele TO charger_clientele;
GRANT SELECT, UPDATE ON TABLE Client TO charger_clientele;
GRANT SELECT, INSERT ON TABLE TransactionBancaire TO client;