package ro.app.model;

import java.util.List;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Immutable
@Table(name = "view_client")
public class ViewClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_nume")
    @NotNull(message = "Numele clientului nu poate fi null")
    private String nume;

    @Column(name = "client_prenume")
    @NotNull(message = "Prenumele clientului nu poate fi null")
    private String prenume;

    @Column(name = "tip_client_denumire")
    @NotNull(message = "Tipul clientului nu poate fi null")
    @Pattern(
        regexp = "Persoana Fizica|Persoana Juridica|Organizatie Non-Guvernamentala",
        message = "Tipul clientului trebuie să fie 'Persoana Fizica', 'Persoana Juridica' sau 'Organizatie Non-Guvernamentala'"
    )
    private String tipClient;

    @Column(name = "sex_denumire")
    @NotNull(message = "Sexul clientului nu poate fi null")
    @Pattern(
        regexp = "Masculin|Feminin|Nespecificat",
        message = "Sexul clientului trebuie să fie 'Masculin', 'Feminin' sau 'Nespecificat'"
    )
    private String sex;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Previne buclele de serializare
    private List<ViewCont> conturi;

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTipClient() {
        return tipClient;
    }

    public void setTipClient(String tipClient) {
        this.tipClient = tipClient;
    }

    public String getSex() {
        return sex;
    }

    public void setSexDenumire(String sex) {
        this.sex = sex;
    }

    public List<ViewCont> getConturi() {
        return conturi;
    }

    public void setAccounts(List<ViewCont> conturi) {
        this.conturi = conturi;
    }
}