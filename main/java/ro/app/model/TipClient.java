package ro.app.model;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "tip_client")
public class TipClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cod", nullable = false, unique = true)
    private String cod;

    @Column(name = "denumire", nullable = false)
    private String denumire;

    // Constructor fără argumente (necesar pentru Hibernate)
    public TipClient() {
    }

    // Constructor cu argumente
    public TipClient(String cod, String denumire) {
        this.cod = cod;
        this.denumire = denumire;
    }

    // Getteri
    public Long getId() {
        return id;
    }

    public String getCod() {
        return cod;
    }

    public String getDenumire() {
        return denumire;
    }

}