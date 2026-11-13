package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.model.*;
import de.cvTracker.cvTracker.repository.BenutzerRepository;
import de.cvTracker.cvTracker.repository.BewerbungRepository;
import de.cvTracker.cvTracker.repository.DokumentRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
/**
 * Hier ist die Klasse BewerbungService
 * @author = Ramane
 * **/
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
    /**
     * Hier muss wird die Notizen zu der Liste hinzugefügt.
     * @param antwortdatum
     * @param beschreibung
     * @param gehalt
     * @param kontaktRecruiter
     * @param linkStellenanzeige
     * @param ort
     * @param sendedatum
     * @param status
     * @param titel
     * @param unternehmen
     * @param vertragsart
     * @param benutzer
     * @param dokuments
     * @param notizs
     * @return
     */
    public Bewerbung erstelleBewerbung(LocalDate antwortdatum, String beschreibung, Double gehalt, String kontaktRecruiter, String linkStellenanzeige, String ort, LocalDate sendedatum, Status status, String titel, String unternehmen, String vertragsart, Benutzer benutzer, List<Dokument> dokuments, List<Notiz> notizs){
        Bewerbung bewerbung = new Bewerbung(antwortdatum, beschreibung, gehalt, kontaktRecruiter, linkStellenanzeige, ort, sendedatum, status, titel, unternehmen, vertragsart);
        bewerbung.setBenutzer(benutzerRepository.findById(benutzer.getId()).get());
        bewerbung.setDokuments(dokuments);
        bewerbung.setNotizs(notizs);
        return bewerbungRepository.save(bewerbung);
    }

    /**
     * Muss nur die geänderte Werte aktualisiert werden und die anderen bleiben unverändert
     * @param id
     * @param bewerbung
     * @return
     */
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

    /**
     * Gibt alle Bewerbungen zurück
     * @return
     */
    public List<Bewerbung> getBewerbungen(){
        return bewerbungRepository.findAll();
    }

    /**
     * Bewerbungen haben Dokumente und Dokumente können auch mehreren Bewerbungen gehören.
     * Darum muss die Bewerbung zuerst von der Dokumenten getrennt werden, bevor sie gelöscht werden 
     * @param id
     */
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

    /**
     * Gibt Dokumente einer Bewerbung zurück
     * @param id
     * @return
     */
    public List <Dokument> getDokuments(Long id){
        Optional<Bewerbung> bewerbung = bewerbungRepository.findById(id);
        if(!bewerbung.isEmpty()){
            return bewerbung.get().getDokuments();
        } else {
            return List.of();
        }
    }

    /**
     * Gibt alle Notizen zurück
     * @param id
     * @return
     */
    public List <Notiz> getNotiz(Long id){
        Optional<Bewerbung> bewerbung = bewerbungRepository.findById(id);
        if(!bewerbung.isEmpty()){
            return bewerbung.get().getNotizs();
        } else return List.of();
    }
}
