package ro.app.model;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "view_cont")
public class ViewCont {

    @Id
    @Column(name = "cont_id")
    private Long id;

    @Column(name = "cont_iban")
    private String iban;

    @Column(name = "cont_sold")
    private Double sold;

    @Column(name = "valuta_cod")
    private String valuta;

    @ManyToOne
    @JoinColumn(name = "client_id") // Numele coloanei din baza de date care face legătura
    @JsonBackReference // Previne buclele de serializare
    private ViewClient client;

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

    public String getValuta() {
        return valuta;
    }

    public void setValutaCod(String valuta) {
        this.valuta = valuta;
    }

    public ViewClient getClient() {
        return client;
    }

    public void setClient(ViewClient client) {
        this.client = client;
    }
}