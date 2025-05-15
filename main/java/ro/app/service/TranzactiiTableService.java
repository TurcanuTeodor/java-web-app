package ro.app.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.TranzactiiTable;

@Service
public class TranzactiiTableService {
    @PersistenceContext
    private EntityManager entityManager;

    // Adaugă o tranzacție
    public void addTransaction(TranzactiiTable tranzactie) {
        entityManager.persist(tranzactie);
    }

    // Șterge o tranzacție după ID
    public void deleteTransaction(Long id) {
        TranzactiiTable tranzactie = entityManager.find(TranzactiiTable.class, id);
        if (tranzactie == null) {
            throw new IllegalArgumentException("Tranzacția cu ID-ul " + id + " nu a fost găsită.");
        }
        entityManager.remove(tranzactie);
    }

    // Actualizează o tranzacție
    public void updateTransaction(TranzactiiTable tranzactie) {
        entityManager.merge(tranzactie);
    }
}
