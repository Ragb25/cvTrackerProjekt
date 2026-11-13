package de.cvTracker.cvTracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Dokument {
    private String dateiname;
    private String dateityp;
    private LocalDate hochladedatum;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kategorie;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    private List<Bewerbung> bewerbungs;

    public Dokument(){}

    public Dokument(String dateiname, String dateityp, LocalDate hochladedatum, String kategorie){
        this.dateiname = dateiname;
        this.dateityp = dateityp;
        this.hochladedatum = hochladedatum;
        this.kategorie = kategorie;
    }

    public String getDateiname() {
        return dateiname;
    }

    public void setDateiname(String dateiname) {
        this.dateiname = dateiname;
    }

    public String getDateityp() {
        return dateityp;
    }

    public void setDateityp(String dateityp) {
        this.dateityp = dateityp;
    }

    public LocalDate getHochladedatum() {
        return hochladedatum;
    }

    public void setHochladedatum(LocalDate hochladedatum) {
        this.hochladedatum = hochladedatum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public List<Bewerbung> getBewerbungs() {
        return bewerbungs;
    }

    public void setBewerbungs(List<Bewerbung> bewerbungs) {
        this.bewerbungs = bewerbungs;
    }
}
