-- View for 'cont'
CREATE OR REPLACE VIEW view_cont AS
SELECT
    c.id AS cont_id,        
    c.iban AS cont_iban,
    c.sold AS cont_sold,
    v.cod AS valuta_cod,
    cl.id AS client_id,       
    cl.nume AS client_nume,
    cl.prenume AS client_prenume
FROM cont c
JOIN valute v ON c.valuta_id = v.id
JOIN client cl ON c.client_id = cl.id;


-- View for 'client'
CREATE OR REPLACE VIEW view_client AS
SELECT
    cl.id AS client_id,      
    cl.nume AS client_nume,
    cl.prenume AS client_prenume,
    tc.denumire AS tip_client_denumire,
    ts.denumire AS sex_denumire
FROM client cl
JOIN tip_client tc ON cl.tip_client_id = tc.id
JOIN tip_sex ts ON cl.sex_id = ts.id;


-- View for 'tranzactii'
CREATE VIEW view_tranzactii AS
SELECT
    t.id AS transaction_id,
    c.iban AS cont_iban,
    tt.denumire AS tip_tranzactie_denumire,
    t.suma AS tranzactie_suma,
    t.semn AS tranzactie_semn,
    v.cod AS valuta_cod,
    t.data_tranzactie AS tranzactie_data
FROM tranzactii t
JOIN cont c ON t.cont_id = c.id
JOIN tip_tranzactie tt ON t.tip_tranzactie_id = tt.id
LEFT JOIN valute v ON t.valuta_originala = v.id;