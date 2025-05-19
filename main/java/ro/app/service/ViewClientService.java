package ro.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.ViewClient;

@Service
public class ViewClientService {

    @PersistenceContext
    private EntityManager entityManager;

    // Obține toți clienții
    public List<ViewClient> getAllClients() {
        return entityManager.createQuery("SELECT c FROM ViewClient c", ViewClient.class).getResultList();
    }

    // Obține un client după ID
    @Transactional
    public ViewClient getClientById(Long id) {
        ViewClient client = entityManager.find(ViewClient.class, id);
        if (client != null) {
            Hibernate.initialize(client.getConturi()); // Încarcă explicit relația accounts
        }
        return client;
    }

    // Obține numărul total de clienți
    public Long getClientCount() {
        return entityManager.createQuery("SELECT COUNT(c) FROM ViewClient c", Long.class).getSingleResult();
    }

    // Obține clienții cu cele mai multe conturi
    public List<Object[]> getClientsWithMostAccounts() {
        return entityManager.createQuery(
            "SELECT c.nume, c.prenume, COUNT(co.id) " +
            "FROM ViewClient c JOIN c.conturi co " +
            "GROUP BY c.nume, c.prenume " +
            "ORDER BY COUNT(co.id) DESC",
            Object[].class
        ).setMaxResults(5) // Limitează la primii 5 clienți
        .getResultList();
    }

    public Map<String, Object> getClientContactDetails(Long id) {
        String query = "SELECT c.client_nume, c.client_prenume, ae.email, dc.telefon, dc.email_alternativ, dc.persoana_contact, dc.site_web " +
                    "FROM view_client c " +
                    "LEFT JOIN adrese_email ae ON c.client_id = ae.client_id " +
                    "LEFT JOIN date_de_contact dc ON c.client_id = dc.client_id " +
                    "WHERE c.client_id = :id";

        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) entityManager.createNativeQuery(query)
                                            .setParameter("id", id)
                                            .getResultList();

        if (results.isEmpty()) {
            return new HashMap<>();
        }

        Object[] row = results.get(0);

        Map<String, Object> contactDetails = new HashMap<>();
        contactDetails.put("nume", row[0]);
        contactDetails.put("prenume", row[1]);
        contactDetails.put("email", row[2]);
        contactDetails.put("telefon", row[3]);
        contactDetails.put("emailAlternativ", row[4]);
        contactDetails.put("persoanaContact", row[5]);
        contactDetails.put("siteWeb", row[6]);

        return contactDetails;
    }
}