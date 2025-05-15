package ro.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cont")
public class ContTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "iban", nullable = false, unique = true)
    private String iban;

    @Column(name = "sold", nullable = false)
    private Double sold;

    @ManyToOne
    @JoinColumn(name = "valuta_id")
    private Valute valuta;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientTable client;

    @OneToMany(mappedBy = "cont", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TranzactiiTable> tranzactii;

    // Constructor fără argumente (necesar pentru Hibernate)
    public ContTable() {
    }

    // Constructor cu argumente
    public ContTable(String iban, Double sold, Valute valuta, ClientTable client) {
        this.iban = iban;
        this.sold = sold;
        this.valuta = valuta;
        this.client = client;
    }

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public Valute getValuta() {
        return valuta;
    }

    public void setValuta(Valute valuta) {
        this.valuta = valuta;
    }

    public ClientTable getClient() {
        return client;
    }

    public void setClient(ClientTable client) {
        this.client = client;
    }

    public List<TranzactiiTable> getTranzactii() {
        return tranzactii;
    }

    public void setTranzactii(List<TranzactiiTable> tranzactii) {
        this.tranzactii = tranzactii;
    }
}