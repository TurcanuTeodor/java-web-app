INSERT INTO tip_client (cod, denumire) VALUES
('PF', 'Persoana Fizica'),
('PJ', 'Persoana Juridica'),
('ONG', 'Organizatie Non-Guvernamentala');


INSERT INTO valute (cod, denumire) VALUES
('RON', 'Leu Romanesc'),
('EUR', 'Euro'),
('USD', 'Dolar American'),
('GBP', 'Lira Sterlina'),
('CHF', 'Franc Elvetian'),
('JPY', 'Yen Japonez'),
('CAD', 'Dolar Canadian');


INSERT INTO tip_tranzactie (cod, denumire) VALUES
('DEP', 'Depunere'),
('RET', 'Retragere'),
('TRF', 'Transfer'),
('PLT', 'Plata'),
('INC', 'Incasare'),
('COM', 'Comision Bancar'),
('OP','Ordin Plata');


INSERT INTO tip_sex (cod, denumire) VALUES
('M', 'Masculin'),
('F', 'Feminin'),
('N', 'Nespecificat');


INSERT INTO client (nume, prenume, tip_client_id, sex_id) VALUES
('Popescu', 'Ion', (SELECT id FROM tip_client WHERE cod = 'PF'), (SELECT id FROM tip_sex WHERE cod = 'M')),
('Ionescu', 'Maria', (SELECT id FROM tip_client WHERE cod = 'PF'), (SELECT id FROM tip_sex WHERE cod = 'F')),
('Dumitru', 'Andreea', (SELECT id FROM tip_client WHERE cod = 'PF'), (SELECT id FROM tip_sex WHERE cod = 'F')),
('Matei', 'Alexandru', (SELECT id FROM tip_client WHERE cod = 'PF'), (SELECT id FROM tip_sex WHERE cod = 'M')),
('SC Firma', 'SRL', (SELECT id FROM tip_client WHERE cod = 'PJ'), (SELECT id FROM tip_sex WHERE cod = 'N')),
('IT Solutions', 'SRL', (SELECT id FROM tip_client WHERE cod = 'PJ'), (SELECT id FROM tip_sex WHERE cod = 'N')),
('Asociatia', 'Inimi Deschise', (SELECT id FROM tip_client WHERE cod = 'ONG'), (SELECT id FROM tip_sex WHERE cod = 'N')),
('Fundatia', 'Speranta', (SELECT id FROM tip_client WHERE cod = 'ONG'), (SELECT id FROM tip_sex WHERE cod = 'N'));


INSERT INTO cont (iban, sold, valuta_id, client_id) VALUES
('RO49AAAA1B31000000000001', 12500.50, (SELECT id FROM valute WHERE cod = 'RON'),1),
('DE89370400440532013000', 2300.00, (SELECT id FROM valute WHERE cod = 'EUR'), 2),
('FR7630006000011234567890189', 3800.00, (SELECT id FROM valute WHERE cod = 'USD'), 3),
('GB29NWBK60161331926819', 5100.00, (SELECT id FROM valute WHERE cod = 'GBP'),4),
('RO59AAAA1B31000000000002', 85000.00, (SELECT id FROM valute WHERE cod = 'RON'), 5),
('RO61AAAA1B31000000000003', 19000.00, (SELECT id FROM valute WHERE cod = 'RON'), 6),
('CH9300762011623852957', 12000.75, (SELECT id FROM valute WHERE cod = 'CHF'), 7),
('JP12BANK0000111111111111', 650000.00, (SELECT id FROM valute WHERE cod = 'JPY'), 8),
('RO12RZBR0000060012345678', 15000.00, (SELECT id FROM valute WHERE cod = 'RON'),1),
('JP89BOJA1234567890123456', 800000.00, (SELECT id FROM valute WHERE cod = 'JPY'), 1),
('CA1098765432109876543210', 3500.00, (SELECT id FROM valute WHERE cod = 'CAD'),2),
('RO99AAAA1B31000000000002', 20000.00, (SELECT id FROM valute WHERE cod = 'RON'),5);


INSERT INTO tranzactii (cont_id, tip_tranzactie_id, suma, suma_originala, valuta_originala, semn, explicatii) VALUES
((SELECT id FROM cont WHERE iban = 'RO49AAAA1B31000000000001'), (SELECT id FROM tip_tranzactie WHERE cod = 'DEP'), 1000.00, 1000.00, (SELECT id FROM valute WHERE cod = 'RON'), '+', 'Depunere salariu'),
((SELECT id FROM cont WHERE iban = 'DE89370400440532013000'), (SELECT id FROM tip_tranzactie WHERE cod = 'RET'), 500.00, 500.00, (SELECT id FROM valute WHERE cod = 'EUR'), '-', 'Retragere ATM'),
((SELECT id FROM cont WHERE iban = 'FR7630006000011234567890189'), (SELECT id FROM tip_tranzactie WHERE cod = 'PLT'), 300.00, 300.00, (SELECT id FROM valute WHERE cod = 'USD'), '-', 'Plata Amazon'),
((SELECT id FROM cont WHERE iban = 'GB29NWBK60161331926819'), (SELECT id FROM tip_tranzactie WHERE cod = 'TRF'), 2000.00, 2000.00, (SELECT id FROM valute WHERE cod = 'GBP'), '-', 'Transfer catre client'),
((SELECT id FROM cont WHERE iban = 'RO59AAAA1B31000000000002'), (SELECT id FROM tip_tranzactie WHERE cod = 'INC'), 20000.00, 20000.00, (SELECT id FROM valute WHERE cod = 'RON'), '+', 'Incasare factura'),
((SELECT id FROM cont WHERE iban = 'RO61AAAA1B31000000000003'), (SELECT id FROM tip_tranzactie WHERE cod = 'COM'), 25.00, 25.00, (SELECT id FROM valute WHERE cod = 'RON'), '-', 'Comision lunar'),
((SELECT id FROM cont WHERE iban = 'CH9300762011623852957'), (SELECT id FROM tip_tranzactie WHERE cod = 'TRF'), 500.00, 500.00, (SELECT id FROM valute WHERE cod = 'CHF'), '-', 'Transfer catre ONG'),
((SELECT id FROM cont WHERE iban = 'JP12BANK0000111111111111'), (SELECT id FROM tip_tranzactie WHERE cod = 'OP'), 100000.00, 100000.00, (SELECT id FROM valute WHERE cod = 'JPY'), '-', 'Ordin de plata catre furnizor'),
((SELECT id FROM cont WHERE iban = 'RO12RZBR0000060012345678'), (SELECT id FROM tip_tranzactie WHERE cod = 'DEP'), 1000.00, 1000.00, (SELECT id FROM valute WHERE cod = 'RON'), '+', 'Depunere numerar'),
((SELECT id FROM cont WHERE iban = 'DE89370400440532013000'), (SELECT id FROM tip_tranzactie WHERE cod = 'RET'), 500.00, 500.00, (SELECT id FROM valute WHERE cod = 'EUR'), '-', 'Retragere bancomat'),
((SELECT id FROM cont WHERE iban = 'RO49AAAA1B31000000000001'), (SELECT id FROM tip_tranzactie WHERE cod = 'TRF'), 20000.00, 20000.00, (SELECT id FROM valute WHERE cod = 'RON'), '+', 'Transfer de fonduri'),
((SELECT id FROM cont WHERE iban = 'GB29NWBK60161331926819'), (SELECT id FROM tip_tranzactie WHERE cod = 'PLT'), 200.00, 230.00, (SELECT id FROM valute WHERE cod = 'EUR'), '-', 'Plata internationala'),
((SELECT id FROM cont WHERE iban = 'CH9300762011623852957'), (SELECT id FROM tip_tranzactie WHERE cod = 'INC'), 300.00, 300.00, (SELECT id FROM valute WHERE cod = 'CHF'), '+', 'Incasare sponsorizare'),
((SELECT id FROM cont WHERE iban = 'JP89BOJA1234567890123456'), (SELECT id FROM tip_tranzactie WHERE cod = 'COM'), 50.00, 7800.00, (SELECT id FROM valute WHERE cod = 'JPY'), '-', 'Comision conversie'),
((SELECT id FROM cont WHERE iban = 'CA1098765432109876543210'), (SELECT id FROM tip_tranzactie WHERE cod = 'OP'), 1200.00, 1200.00, (SELECT id FROM valute WHERE cod = 'CAD'), '-', 'Ordin de plată factură'),
((SELECT id FROM cont WHERE iban = 'RO99AAAA1B31000000000002'), (SELECT id FROM tip_tranzactie WHERE cod = 'PLT'), 500.00, 500.00, (SELECT id FROM valute WHERE cod = 'RON'), '-', 'Plată utilități'),
((SELECT id FROM cont WHERE iban = 'RO12RZBR0000060012345678'), (SELECT id FROM tip_tranzactie WHERE cod = 'TRF'), 3000.00, 3000.00, (SELECT id FROM valute WHERE cod = 'RON'), '-', 'Transfer către contul personal');


INSERT INTO date_de_contact (client_id, telefon, email_alternativ, persoana_contact, site_web) VALUES
(1, '0722123456', 'popescu.ion@gmail.com', 'Popescu Ion', NULL),
(2, '0733987654', 'maria.ionescu@yahoo.com', 'Ionescu Maria', NULL),
(3, '0744111222', 'andreea.dumitru@mail.com', 'Dumitru Andreea', NULL),
(4, '0755667788', 'alex.matei@email.com', 'Matei Alexandru', NULL),
(5, '0211234567', 'contact@scfirma.ro', 'Responsabil Financiar', 'www.scfirma.ro'),
(6, '0219876543', 'support@itsolutions.ro', 'IT Dept.', 'www.itsolutions.ro'),
(7, '0314567890', 'info@inimideschise.org', 'Ana Dragomir', 'www.inimideschise.org'),
(8, '0319988776', 'contact@speranta.org', 'Cristina Munteanu', 'www.fundatiasperanta.ro');


INSERT INTO adrese_email (client_id, email) VALUES
(1, 'popescu.ion@gmail.com'),
(2, 'ionescu.maria@protonmail.com'),
(3, 'a.dumitru@outlook.com'),
(4, 'alexandru.matei@ymail.com'),
(5, 'office@firma-srl.ro'),
(5, 'vanzari@firma-srl.ro'),
(6, 'admin@itsolutions.ro'),
(6, 'devteam@itsolutions.ro'),
(7, 'asociatia@inimideschise.org'),
(8, 'fundatia.speranta@gmail.com');





