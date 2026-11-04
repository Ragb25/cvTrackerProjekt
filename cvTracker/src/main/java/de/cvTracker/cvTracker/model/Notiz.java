package de.cvTracker.cvTracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Notiz {
    private LocalDate datum;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String inhalt;
    @ManyToOne
    private Bewerbung bewerbung;

    public Notiz(){}

    public Notiz(LocalDate datum, String inhalt){
        this.datum = datum;
        this.inhalt = inhalt;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public Bewerbung getBewerbung() {
        return bewerbung;
    }

    public void setBewerbung(Bewerbung bewerbung) {
        this.bewerbung = bewerbung;
    }
}
