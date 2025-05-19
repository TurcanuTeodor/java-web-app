package ro.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ro.app.model.ClientTable;
import ro.app.model.ContactInfoTable;

@Service
public class ContactInfoService {
    @PersistenceContext
    private EntityManager entityManager;

    // Adaugă date de contact
    @Transactional
    public ContactInfoTable addContact(ContactInfoTable contact) {
        // Atașează clientul existent la entitatea de contact
        ClientTable client = entityManager.find(ClientTable.class, contact.getClient().getId());
        if (client == null) {
            throw new IllegalArgumentException("Clientul nu există!");
        }
        contact.setClient(client);
        entityManager.persist(contact);
        return contact;
    }
}