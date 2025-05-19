package ro.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "date_de_contact")
public class ContactInfoTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientTable client;

    @Size(max = 20)
    @Column(name = "telefon")
    private String telefon;

    @Size(max = 100)
    @Column(name = "email_alternativ")
    @Email
    private String emailAlternativ;

    @Size(max = 100)
    @Column(name = "persoana_contact")
    private String persoanaContact;

    @Size(max = 100)
    @Column(name = "site_web")
    private String siteWeb;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ClientTable getClient() { return client; }
    public void setClient(ClientTable client) { this.client = client; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getEmailAlternativ() { return emailAlternativ; }
    public void setEmailAlternativ(String emailAlternativ) { this.emailAlternativ = emailAlternativ; }

    public String getPersoanaContact() { return persoanaContact; }
    public void setPersoanaContact(String persoanaContact) { this.persoanaContact = persoanaContact; }

    public String getSiteWeb() { return siteWeb; }
    public void setSiteWeb(String siteWeb) { this.siteWeb = siteWeb; }
}
