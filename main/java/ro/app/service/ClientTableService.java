package ro.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.ClientTable;

@Service
public class ClientTableService {
    @PersistenceContext
    private EntityManager entityManager;

    // Adaugă un client
    @Transactional
    public void addClient(ClientTable client) {
        entityManager.persist(client);
    }

    // Șterge un client după ID
    @Transactional
    public void deleteClient(Long id) {
        ClientTable client = entityManager.find(ClientTable.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
    }
 
    // Actualizează un client
    @Transactional
    public void updateClient(ClientTable client) {
        entityManager.merge(client);
    }
    
}
