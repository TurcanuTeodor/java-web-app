package ro.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.ViewCont;

@Service
public class ViewContService {

    @PersistenceContext
    private EntityManager entityManager;

    // Obține toate conturile
    public List<ViewCont> getAllAccounts() {
        return entityManager.createQuery("SELECT a FROM ViewCont a", ViewCont.class).getResultList();
    }

    // Obține un cont după ID
    public ViewCont getAccountById(Long id) {
        return entityManager.find(ViewCont.class, id);
    }

    // Obține numărul total de conturi
    public Long getAccountCount() {
        return entityManager.createQuery("SELECT COUNT(a) FROM ViewCont a", Long.class).getSingleResult();
    }

    // Serviciu pentru Obținerea Soldului Total pe Conturi
    public Double getTotalBalance() {
        return entityManager.createQuery("SELECT SUM(a.contSold) FROM ViewCont a", Double.class).getSingleResult();
    }
}