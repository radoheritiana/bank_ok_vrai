
CREATE OR REPLACE FUNCTION select_client_not_verified() RETURNS SETOF client AS $$
BEGIN
    RETURN QUERY SELECT * FROM client WHERE verifie = false;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION select_client_by_id(_id_client integer) RETURNS SETOF client AS $$
BEGIN
    RETURN QUERY SELECT * FROM client WHERE id_client = _id_client;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE update_client(_id_client integer, _id_charge integer) AS $$ 
BEGIN
    UPDATE client SET verifie = true, id_charger_clientele = _id_charge WHERE id_client = _id_client;
    call creer_compte(_id_client);
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE creer_compte(_id_client int) AS $$
BEGIN
 INSERT INTO compte (id_client) VALUES (_id_client);
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION select_transaction_by_id_client(_id_client integer) RETURNS SETOF transactionbancaire AS $$
DECLARE
    numero_compte_client integer;
BEGIN
    SELECT num_compte INTO numero_compte_client FROM compte WHERE id_client = _id_client;
    RETURN QUERY SELECT * FROM TransactionBancaire WHERE num_compte_depart = numero_compte_client OR num_compte_arrive = numero_compte_client;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION select_user_by_id_charge_clientele(_id_charger_clientele integer) RETURNS SETOF client AS $$
BEGIN 
    RETURN QUERY SELECT * FROM client WHERE id_charger_clientele LIKE _id_charger_clientele;
END;
$$ LANGUAGE plpgsql;
