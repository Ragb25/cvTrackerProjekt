package de.cvTracker.cvTracker.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Hier ist die Bewerbungsklasse
 * @author = Ramane
 * **/

@Entity
public class Bewerbung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate antwortdatum;
    private String beschreibung;
    private double gehalt;
    private String kontaktRecruiter;
    private String linkStellenanzeige;
    private String ort;
    private LocalDate sendedatum;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String titel;
    private String unternehmen;
    private String vertragsart;
    @ManyToOne
    private Benutzer benutzer;
    @ManyToMany(mappedBy = "bewerbungs")
    private List<Dokument> dokuments;
    @OneToMany(mappedBy = "bewerbung")
    private List<Notiz> notizs;

    public Bewerbung(){}

     public Bewerbung(LocalDate antwortdatum, String beschreibung, double gehalt, String kontaktRecruiter, String linkStellenanzeige, String ort, LocalDate sendedatum, Status status, String titel, String unternehmen, String vertragsart){
         this.antwortdatum = antwortdatum;
         this.beschreibung = beschreibung;
         this.gehalt = gehalt;
         this.kontaktRecruiter = kontaktRecruiter;
         this.linkStellenanzeige = linkStellenanzeige;
         this.ort = ort;
         this.sendedatum = sendedatum;
         this.status = status;
         this.titel = titel;
         this.unternehmen = unternehmen;
         this.vertragsart = vertragsart;

     }

    public LocalDate getAntwortdatum() {
        return antwortdatum;
    }

    public void setAntwortdatum(LocalDate antwortdatum) {
        this.antwortdatum = antwortdatum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public String getKontaktRecruiter() {
        return kontaktRecruiter;
    }

    public void setKontaktRecruiter(String kontaktRecruiter) {
        this.kontaktRecruiter = kontaktRecruiter;
    }

    public String getLinkStellenanzeige() {
        return linkStellenanzeige;
    }

    public void setLinkStellenanzeige(String linkStellenanzeige) {
        this.linkStellenanzeige = linkStellenanzeige;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public LocalDate getSendedatum() {
        return sendedatum;
    }

    public void setSendedatum(LocalDate sendedatum) {
        this.sendedatum = sendedatum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUnternehmen() {
        return unternehmen;
    }

    public void setUnternehmen(String unternehmen) {
        this.unternehmen = unternehmen;
    }

    public String getVertragsart() {
        return vertragsart;
    }

    public void setVertragsart(String vertragsart) {
        this.vertragsart = vertragsart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public List<Dokument> getDokuments() {
        return dokuments;
    }

    public void setDokuments(List<Dokument> dokuments) {
        this.dokuments = dokuments;
    }

    public List<Notiz> getNotizs() {
        return notizs;
    }

    public void setNotizs(List<Notiz> notizs) {
        this.notizs = notizs;
    }
}
