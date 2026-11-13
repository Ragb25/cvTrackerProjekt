package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.model.*;
import de.cvTracker.cvTracker.repository.BenutzerRepository;
import de.cvTracker.cvTracker.repository.BewerbungRepository;
import de.cvTracker.cvTracker.repository.DokumentRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BewerbungService {
    private final BewerbungRepository bewerbungRepository;
    private final BenutzerRepository benutzerRepository;
    private final DokumentRepository dokumentRepository;

    
    
    public BewerbungService(BewerbungRepository bewerbungRepository, BenutzerRepository benutzerRepository,
            DokumentRepository dokumentRepository) {
        this.bewerbungRepository = bewerbungRepository;
        this.benutzerRepository = benutzerRepository;
        this.dokumentRepository = dokumentRepository;
    }
    public Bewerbung erstelleBewerbung(LocalDate antwortdatum, String beschreibung, Double gehalt, String kontaktRecruiter, String linkStellenanzeige, String ort, LocalDate sendedatum, Status status, String titel, String unternehmen, String vertragsart, Benutzer benutzer, List<Dokument> dokuments, Notiz notizs){
        Bewerbung bewerbung = new Bewerbung(antwortdatum, beschreibung, gehalt, kontaktRecruiter, linkStellenanzeige, ort, sendedatum, status, titel, unternehmen, vertragsart);
        bewerbung.setBenutzer(benutzerRepository.findById(benutzer.getId()).get());
        bewerbung.setDokuments(dokuments);
        bewerbung.addNotizs(notizs);
        return bewerbungRepository.save(bewerbung);
    }
    public Bewerbung bewerbungAktualisieren(Long id, Bewerbung bewerbung){
        Bewerbung altBewerbung = bewerbungRepository.findById(id).orElse(null);

        if (bewerbung.getAntwortdatum() != null) altBewerbung.setAntwortdatum(bewerbung.getAntwortdatum());
        if (bewerbung.getBeschreibung() != null) altBewerbung.setBeschreibung(bewerbung.getBeschreibung());
        if (bewerbung.getGehalt() != null) altBewerbung.setGehalt(bewerbung.getGehalt());
        if (bewerbung.getKontaktRecruiter() != null) altBewerbung.setKontaktRecruiter(bewerbung.getKontaktRecruiter());
        if (bewerbung.getLinkStellenanzeige() != null) altBewerbung.setLinkStellenanzeige(bewerbung.getLinkStellenanzeige());
        if (bewerbung.getOrt() != null) altBewerbung.setOrt(bewerbung.getOrt());
        if (bewerbung.getSendedatum() != null) altBewerbung.setSendedatum(bewerbung.getSendedatum());
        if (bewerbung.getStatus() != null) altBewerbung.setStatus(bewerbung.getStatus());
        if (bewerbung.getTitel() != null) altBewerbung.setTitel(bewerbung.getTitel());
        if (bewerbung.getUnternehmen() != null) altBewerbung.setUnternehmen(bewerbung.getUnternehmen());
        if (bewerbung.getVertragsart() != null) altBewerbung.setVertragsart(bewerbung.getVertragsart());
        if (bewerbung.getBenutzer() != null) altBewerbung.setBenutzer(bewerbung.getBenutzer());
        if (bewerbung.getDokuments() != null) altBewerbung.setDokuments(bewerbung.getDokuments());
        if (bewerbung.getNotizs() != null) altBewerbung.setNotizs(bewerbung.getNotizs());

        return bewerbungRepository.save(altBewerbung);
    }
    public List<Bewerbung> getBewerbungen(){
        return bewerbungRepository.findAll();
    }

    public void deleteBewerbung(Long id){
    Bewerbung bewerbung = bewerbungRepository.findById(id).orElse(null);
    
    if (bewerbung != null) {
        for (Dokument dokument : bewerbung.getDokuments()) {
            dokument.getBewerbungs().remove(bewerbung);
            dokumentRepository.save(dokument);
        }
        bewerbungRepository.deleteById(id);
    }
    }

    public List <Dokument> getDokuments(Long id){
        Optional<Bewerbung> bewerbung = bewerbungRepository.findById(id);
        if(!bewerbung.isEmpty()){
            return bewerbung.get().getDokuments();
        } else {
            return List.of();
        }
    }

    public List <Notiz> getNotiz(Long id){
        Optional<Bewerbung> bewerbung = bewerbungRepository.findById(id);
        if(!bewerbung.isEmpty()){
            return bewerbung.get().getNotizs();
        } else return List.of();
    }
}
