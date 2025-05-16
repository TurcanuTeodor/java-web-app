package ro.app.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "view_tranzactii")
public class ViewTranzactii {

    @Id
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "cont_iban")
    private String iban;

    @Column(name = "tip_tranzactie_denumire")
    private String tipTranzactie;

    @Column(name = "tranzactie_suma")
    private Double suma;

    @Column(name = "tranzactie_semn")
    private String semn; // Changed to String to match the view definition

    @Column(name = "valuta_cod")
    private String valuta;

    @Column(name = "tranzactie_data")
    private LocalDateTime data;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public String getTipTranzactie() { return tipTranzactie; }
    public void setTipTranzactie(String tipTranzactie) { this.tipTranzactie = tipTranzactie; }

    public Double getSuma() { return suma; }
    public void setSuma(Double suma) { this.suma = suma; }

    public String getSemn() { return semn; }
    public void setSemn(String semn) { this.semn = semn; }

    public String getValuta() { return valuta; }
    public void setValuta(String valuta) { this.valuta = valuta; }

    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
