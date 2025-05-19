package ro.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ReportService {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Object[]> getTransactionSummary() {
        try {
            return entityManager.createQuery(
                "SELECT t.iban, SUM(t.suma) FROM ViewTranzactii t GROUP BY t.iban"
            ).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Eroare la obținerea rezumatului tranzacțiilor", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> getTransactionSummaryByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        try {
            return entityManager.createQuery(
                "SELECT t.iban, SUM(t.suma) FROM ViewTranzactii t WHERE t.data BETWEEN :startDate AND :endDate GROUP BY t.iban"
            )
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Eroare la obținerea rezumatului tranzacțiilor pe intervalul de date", e);
        }
    }
}