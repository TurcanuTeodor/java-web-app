--Totalul tranzactiilor per client, impartit pe semn si tip de tranzactie
SELECT 
    c.nume || ' ' || c.prenume AS nume_client,
    tt.denumire AS tip_tranzactie,
    t.semn,
    SUM(t.suma) AS total_suma
FROM tranzactii t
JOIN cont ct ON t.cont_id = ct.id
JOIN client c ON ct.client_id = c.id
JOIN tip_tranzactie tt ON t.tip_tranzactie_id = tt.id
GROUP BY c.nume, c.prenume, tt.denumire, t.semn
ORDER BY nume_client, tt.denumire, t.semn;

--Clienti cu mai mult de un cont+ sold total
SELECT 
    c.nume || ' ' || c.prenume AS nume_client,
    COUNT(ct.id) AS nr_conturi,
    SUM(ct.sold) AS sold_total
FROM client c
JOIN cont ct ON c.id = ct.client_id
GROUP BY c.id
HAVING COUNT(ct.id) > 1
ORDER BY sold_total DESC;


--Clienti care au facut tranzactii în valute diferite fata de valuta contului
SELECT 
    c.nume || ' ' || c.prenume AS nume_client,
    ct.iban,
    v1.cod AS valuta_cont,
    v2.cod AS valuta_tranzactie
FROM tranzactii t
JOIN cont ct ON t.cont_id = ct.id
JOIN client c ON ct.client_id = c.id
JOIN valute v1 ON ct.valuta_id = v1.id
JOIN valute v2 ON t.valuta_originala = v2.id
WHERE ct.valuta_id IS NOT NULL AND t.valuta_originala IS NOT NULL
  AND ct.valuta_id != t.valuta_originala;


--Sold total pe tip de client, împartit pe sexe
SELECT 
    tc.denumire AS tip_client,
    ts.denumire AS sex,
    SUM(ct.sold) AS sold_total
FROM cont ct
JOIN client c ON ct.client_id = c.id
JOIN tip_client tc ON c.tip_client_id = tc.id
JOIN tip_sex ts ON c.sex_id = ts.id
GROUP BY tc.denumire, ts.denumire
ORDER BY tc.denumire, ts.denumire;


--Top 5 clienti cu cele mai multe tranzactii
SELECT 
    c.nume || ' ' || c.prenume AS nume_client,
    COUNT(t.id) AS nr_tranzactii
FROM tranzactii t
JOIN cont ct ON t.cont_id = ct.id
JOIN client c ON ct.client_id = c.id
GROUP BY c.id
ORDER BY nr_tranzactii DESC
LIMIT 5;


--Tranzactii care au explicatii ti au fost efectuate în ultimele 7 zile
SELECT 
    c.nume || ' ' || c.prenume AS nume_client,
    t.suma,
    t.explicatii,
    t.data_tranzactie
FROM tranzactii t
JOIN cont ct ON t.cont_id = ct.id
JOIN client c ON ct.client_id = c.id
WHERE t.explicatii IS NOT NULL AND t.data_tranzactie >= CURRENT_DATE - INTERVAL '7 days'
ORDER BY t.data_tranzactie DESC;


--Clasificam clientii în functie de soldul total
SELECT 
    c.nume || ' ' || c.prenume AS nume_client,
    SUM(ct.sold) AS sold_total,
    CASE
        WHEN SUM(ct.sold) >= 10000 THEN 'VIP'
        WHEN SUM(ct.sold) BETWEEN 5000 AND 9999.99 THEN 'Standard'
        ELSE 'Basic'
    END AS categorie_client
FROM client c
JOIN cont ct ON c.id = ct.client_id
GROUP BY c.id
ORDER BY sold_total DESC;

