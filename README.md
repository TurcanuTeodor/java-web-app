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
- `GET /accounts/count` - Obține numărul total de conturi.
- `GET /accounts/total-balance` - Obține soldul total al conturilor.

### Tranzacții
- `GET /transactions` - Obține lista tuturor tranzacțiilor.
- `GET /transactions/filter` - Obține tranzacțiile dintr-un interval de timp.
- `POST /transactions` - Adaugă o tranzacție nouă.
- `PUT /transactions` - Actualizează o tranzacție existentă.
- `DELETE /transactions/{id}` - Șterge o tranzacție după ID.
- `GET /transactions/count` - Obține numărul total de tranzacții.
- `GET /transactions/grouped-by-type` - Obține tranzacțiile grupate pe tip.
- `GET /transactions/above-amount` - Obține tranzacțiile care depășesc o anumită sumă.

### Rapoarte
- `GET /transactions/summary` - Obține un rezumat al tranzacțiilor.
- `GET /transactions/summary-by-date` - Obține un rezumat al tranzacțiilor pe un interval de timp.
