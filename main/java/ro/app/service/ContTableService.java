package ro.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.ContTable;

@Service
public class ContTableService {
    @PersistenceContext
    private EntityManager entityManager;

    // Adaugă un cont
    @Transactional
    public void addAccount(ContTable cont) {
        entityManager.persist(cont);
    }

    // Șterge un cont după ID
    @Transactional
    public void deleteAccount(Long id) {
        ContTable cont = entityManager.find(ContTable.class, id);
        if (cont == null) {
            throw new IllegalArgumentException("Contul cu ID-ul " + id + " nu a fost găsit.");
        }
        entityManager.remove(cont);
    }

    // Actualizează un cont
    @Transactional
    public void updateAccount(ContTable cont) {
        entityManager.merge(cont);
    }
    
}
