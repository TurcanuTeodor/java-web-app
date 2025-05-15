package ro.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.ViewTranzactii;

@Service
public class ViewTranzactiiService {

    @PersistenceContext
    private EntityManager entityManager;

    // Obține toate tranzacțiile
    public List<ViewTranzactii> getAllTransactions() {
        return entityManager.createQuery("SELECT t FROM ViewTranzactii t", ViewTranzactii.class).getResultList();
    }

    // Obține tranzacțiile dintr-un interval de timp
    public List<ViewTranzactii> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Datele de început și sfârșit nu pot fi null.");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Data de început trebuie să fie înainte de data de sfârșit.");
        }
        return entityManager.createQuery(
            "SELECT t FROM ViewTranzactii t WHERE t.data BETWEEN :startDate AND :endDate", ViewTranzactii.class)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .getResultList();
    }

    // Obține numărul total de tranzacții
    public Long getTransactionCount() {
        return entityManager.createQuery("SELECT COUNT(t) FROM ViewTranzactii t", Long.class).getSingleResult();
    }

    //Serviciu pentru Obținerea Tranzacțiilor Grupate pe Tip
    public List<Object[]> getTransactionsGroupedByType() {
        return entityManager.createQuery(
            "SELECT t.tipTranzactie, SUM(t.suma) FROM ViewTranzactii t GROUP BY t.tipTranzactie",
            Object[].class
        ).getResultList();
    }

    // Serviciu pentru Obținerea Tranzacțiilor Peste o Suma Specificată
    public List<ViewTranzactii> getTransactionsAboveAmount(Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Suma trebuie să fie mai mare decât 0.");
        }
        return entityManager.createQuery(
            "SELECT t FROM ViewTranzactii t WHERE t.suma > :amount", ViewTranzactii.class
        ).setParameter("amount", amount)
        .getResultList();
    }
}