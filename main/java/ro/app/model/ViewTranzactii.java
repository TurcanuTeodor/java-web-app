package ro.app.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Immutable
@Table(name = "view_tranzactii")
public class ViewTranzactii {

    @Id
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "cont_iban")
    @NotNull(message = "IBAN-ul nu poate fi null")
    private String iban;

    @Column(name = "tip_tranzactie_denumire")
    @NotNull(message = "Tipul tranzacției nu poate fi null")
    @Pattern(regexp = "Transfer|Retragere|Depunere|Plata|Comision Bancar|Incasare|Ordin Plata", message = "Tipul tranzacției trebuie să fie unul valid (Transfer, Retragere, Depunere, Plata, Comision, Incasare, Comision Bancar, Ordin Plata)")
    private String tipTranzactie;

    @Column(name = "tranzactie_suma")
    @NotNull(message = "Suma tranzacției nu poate fi null")
    @Min(value = 0, message = "Suma tranzacției trebuie să fie pozitivă")
    private Double suma;

    @Column(name = "tranzactie_semn")
    @NotNull(message = "Semnul tranzacției nu poate fi null")
    @Pattern(regexp = "\\+|-", message = "Semnul tranzacției trebuie să fie '+' sau '-'")
    private String semn; // Changed to String to match the view definition

    @Column(name = "valuta_cod")
    @NotNull(message = "Codul valutei nu poate fi null")
    @Pattern(regexp = "RON|EUR|USD|GBP|CHF|JPY|CAD", message = "Codul valutei trebuie să fie unul valid (RON, EUR, USD, GBP, CHF, JPY, CAD)")
    private String valuta;

    @Column(name = "tranzactie_data")
    @NotNull(message = "Data tranzacției nu poate fi null")
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
