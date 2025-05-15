CREATE TABLE tip_client (
    id SERIAL PRIMARY KEY,
    cod VARCHAR(10) UNIQUE NOT NULL,
    denumire VARCHAR(50) NOT NULL
);

CREATE TABLE valute (
    id SERIAL PRIMARY KEY,
    cod VARCHAR(5) UNIQUE NOT NULL,
    denumire VARCHAR(20) NOT NULL
);

CREATE TABLE tip_tranzactie (
    id SERIAL PRIMARY KEY,
    cod VARCHAR(10) UNIQUE NOT NULL,
    denumire VARCHAR(50) NOT NULL
);

CREATE TABLE tip_sex (
    id SERIAL PRIMARY KEY,
    cod VARCHAR(5) NOT NULL,
    denumire VARCHAR(50) NOT NULL,
    UNIQUE (id, cod)
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    nume VARCHAR(50) NOT NULL,
    prenume VARCHAR(50),
    tip_client_id INTEGER NOT NULL,
    sex_id INTEGER NOT NULL,
    FOREIGN KEY (tip_client_id) REFERENCES tip_client(id) ON DELETE CASCADE,
    FOREIGN KEY (sex_id) REFERENCES tip_sex(id) ON DELETE CASCADE
);

CREATE TABLE cont (
    id SERIAL PRIMARY KEY,
    iban VARCHAR(34) UNIQUE NOT NULL,
    sold NUMERIC(15,2) NOT NULL,
    valuta_id INTEGER REFERENCES valute(id) ON DELETE SET NULL,
    client_id INTEGER REFERENCES client(id) ON DELETE CASCADE
);

CREATE TABLE tranzactii (
    id SERIAL PRIMARY KEY,
    cont_id INTEGER REFERENCES cont(id) ON DELETE CASCADE,
    tip_tranzactie_id INTEGER REFERENCES tip_tranzactie(id) ON DELETE CASCADE,
    suma NUMERIC(15,2) CHECK (suma >= 0) NOT NULL,
    suma_originala NUMERIC(15,2) NOT NULL,
    valuta_originala INTEGER REFERENCES valute(id),
    semn CHAR(1) CHECK (semn IN ('+', '-')) NOT NULL,
    explicatii TEXT,
    data_tranzactie TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE adrese_email (
    id SERIAL PRIMARY KEY,
    client_id INTEGER REFERENCES client(id) ON DELETE CASCADE,
    email VARCHAR(100) NOT NULL,
    UNIQUE(client_id, email)
);

CREATE TABLE date_de_contact (
    id SERIAL PRIMARY KEY,
    client_id INTEGER REFERENCES client(id) ON DELETE CASCADE,
    telefon VARCHAR(20),
    email_alternativ VARCHAR(100),
    persoana_contact VARCHAR(100),
    site_web VARCHAR(100)
);


