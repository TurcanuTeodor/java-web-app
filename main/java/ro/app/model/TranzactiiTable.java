package ro.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tranzactii")
public class TranzactiiTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cont_id", nullable = false)
    private ContTable cont;

    @ManyToOne
    @JoinColumn(name = "tip_tranzactie_id", nullable = false)
    private TipTranzactie tipTranzactie;

    @Column(name = "suma", nullable = false)
    private Double suma;

    @Column(name = "suma_originala", nullable = false)
    private Double sumaOriginala;

    @ManyToOne
    @JoinColumn(name = "valuta_originala")
    private Valute valutaOriginala;

    @Column(name = "semn", nullable = false)
    private String semn;

    @Column(name = "explicatii")
    private String explicatii;

    @Column(name = "data_tranzactie", nullable = false)
    private LocalDateTime dataTranzactie;

    // Constructor fără argumente (necesar pentru Hibernate)
    public TranzactiiTable() {
    }

    // Constructor cu argumente
    public TranzactiiTable(ContTable cont, TipTranzactie tipTranzactie, Double suma, Double sumaOriginala, Valute valutaOriginala, String semn, String explicatii, LocalDateTime dataTranzactie) {
        this.cont = cont;
        this.tipTranzactie = tipTranzactie;
        this.suma = suma;
        this.sumaOriginala = sumaOriginala;
        this.valutaOriginala = valutaOriginala;
        this.semn = semn;
        this.explicatii = explicatii;
        this.dataTranzactie = dataTranzactie;
    }

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContTable getCont() {
        return cont;
    }

    public void setCont(ContTable cont) {
        this.cont = cont;
    }

    public TipTranzactie getTipTranzactie() {
        return tipTranzactie;
    }

    public void setTipTranzactie(TipTranzactie tipTranzactie) {
        this.tipTranzactie = tipTranzactie;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public Double getSumaOriginala() {
        return sumaOriginala;
    }

    public void setSumaOriginala(Double sumaOriginala) {
        this.sumaOriginala = sumaOriginala;
    }

    public Valute getValutaOriginala() {
        return valutaOriginala;
    }

    public void setValutaOriginala(Valute valutaOriginala) {
        this.valutaOriginala = valutaOriginala;
    }

    public String getSemn() {
        return semn;
    }

    public void setSemn(String semn) {
        this.semn = semn;
    }

    public String getExplicatii() {
        return explicatii;
    }

    public void setExplicatii(String explicatii) {
        this.explicatii = explicatii;
    }

    public LocalDateTime getDataTranzactie() {
        return dataTranzactie;
    }

    public void setDataTranzactie(LocalDateTime dataTranzactie) {
        this.dataTranzactie = dataTranzactie;
    }
}