package ro.app.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ro.app.model.TranzactiiTable;

@Service
public class TranzactiiTableService {
    @PersistenceContext
    private EntityManager entityManager;

    // Adaugă o tranzacție
    @Transactional
    public void addTransaction(TranzactiiTable tranzactie) {
        tranzactie.setDataTranzactie(LocalDateTime.now()); // setează data curentă
        entityManager.persist(tranzactie);
    }

    // Șterge o tranzacție după ID
    @Transactional
    public void deleteTransaction(Long id) {
        TranzactiiTable tranzactie = entityManager.find(TranzactiiTable.class, id);
        if (tranzactie == null) {
            throw new IllegalArgumentException("Tranzacția cu ID-ul " + id + " nu a fost găsită.");
        }
        entityManager.remove(tranzactie);
    }

    // Actualizează o tranzacție
    @Transactional
    public void updateTransaction(TranzactiiTable tranzactie) {
        entityManager.merge(tranzactie);
    }
}
