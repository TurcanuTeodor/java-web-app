# My Java Banking App

O aplicație Java simplă care gestionează clienți, conturi și tranzacții folosind o bază de date PostgreSQL. Proiectul utilizează framework-ul Spring MVC pentru gestionarea logicii aplicației și Hibernate pentru interacțiunea cu baza de date.

## Funcționalități

- **Gestionare clienți**: Adăugare, actualizare, ștergere și afișare detalii despre clienți.
- **Gestionare conturi**: Adăugare, actualizare, ștergere și afișare detalii despre conturi.
- **Gestionare tranzacții**: Adăugare, actualizare, ștergere și afișare detalii despre tranzacții.
- **Rapoarte**: Generare rapoarte despre tranzacții și clienți.
- **Interfață JSON**: Expunerea datelor prin endpoint-uri REST.
- **Conectare la PostgreSQL**: Utilizare Hibernate pentru maparea obiect-relatională (ORM).
- **Configurație Spring MVC**: Structură modulară cu servicii, controlere și modele.

## Structura Proiectului
app/ ├── pom.xml # Fișierul de configurare Maven ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── ro/ │ │ │ ├── app/ │ │ │ │ ├── controller/ # Controlerele Spring MVC │ │ │ │ ├── service/ # Servicii pentru logica aplicației │ │ │ │ ├── model/ # Entități JPA │ │ │ │ └── config/ # Configurații Spring │ │ ├── resources/ │ │ │ └── application.properties # Configurația aplicației │ │ └── webapp/ │ │ └── WEB-INF/ # Fișiere de configurare Spring MVC │ ├── test/ │ │ └── java/ # Teste unitare ├── target/ # Fișiere generate de Maven └── sql/ # Scripturi SQL pentru baze de date

## Endpoint-uri REST

### Clienți
- `GET /clients` - Obține lista tuturor clienților.
- `GET /clients/{id}` - Obține detalii despre un client după ID.
- `POST /clients` - Adaugă un client nou.
- `PUT /clients` - Actualizează un client existent.
- `DELETE /clients/{id}` - Șterge un client după ID.

### Conturi
- `GET /accounts` - Obține lista tuturor conturilor.
- `GET /accounts/{id}` - Obține detalii despre un cont după ID.
- `POST /accounts` - Adaugă un cont nou.
- `PUT /accounts` - Actualizează un cont existent.
- `DELETE /accounts/{id}` - Șterge un cont după ID.

### Tranzacții
- `GET /transactions` - Obține lista tuturor tranzacțiilor.
- `GET /transactions/filter` - Obține tranzacțiile dintr-un interval de timp.
- `POST /transactions` - Adaugă o tranzacție nouă.
- `PUT /transactions` - Actualizează o tranzacție existentă.
- `DELETE /transactions/{id}` - Șterge o tranzacție după ID.

## Configurație

### Baza de date
Aplicația folosește PostgreSQL. Configurația bazei de date se află în fișierul `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cibernetica?currentSchema=public
spring.datasource.username=postgres
spring.datasource.password=Tglstmai8
