package de.cvTracker.cvTracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Dokument {
    private String dateiname;
    private String dateityp;
    private LocalDate hochladedatum;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String kategorie;
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

    public String getHochladedatum() {
        return hochladedatum;
    }

    public void setHochladedatum(String hochladedatum) {
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
