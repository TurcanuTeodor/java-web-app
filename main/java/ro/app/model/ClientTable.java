package ro.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class ClientTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nume", nullable = false)
    @NotNull(message = "Numele clientului nu poate fi null")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @ManyToOne
    @JoinColumn(name = "tip_client_id", nullable = false)
    @NotNull(message = "Tipul clientului nu poate fi null")
    private TipClient tipClient;

    @ManyToOne
    @JoinColumn(name = "sex_id", nullable = false)
    @NotNull(message = "Sexul clientului nu poate fi null")
    private TipSex sex;

    // Constructor fără argumente (necesar pentru Hibernate)
    public ClientTable() {
    }

    // Constructor cu argumente
    public ClientTable(String nume, String prenume, TipClient tipClient, TipSex sex) {
        this.nume = nume;
        this.prenume = prenume;
        this.tipClient = tipClient;
        this.sex = sex;
    }

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public TipClient getTipClient() {
        return tipClient;
    }

    public void setTipClient(TipClient tipClient) {
        this.tipClient = tipClient;
    }

    public TipSex getSex() {
        return sex;
    }

    public void setSex(TipSex sex) {
        this.sex = sex;
    }
}