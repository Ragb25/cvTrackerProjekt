package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.model.*;
import de.cvTracker.cvTracker.repository.BewerbungRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BewerbungService {
    private final BewerbungRepository bewerbungRepository;

    public BewerbungService(BewerbungRepository bewerbungRepository) {
        this.bewerbungRepository = bewerbungRepository;
    }
    public Bewerbung erstelleBewerbung(LocalDate antwortdatum, String beschreibung, double gehalt, String kontaktRecruiter, String linkStellenanzeige, String ort, LocalDate sendedatum, Status status, String titel, String unternehmen, String vertragsart, Benutzer benutzer, List<Dokument> dokuments, List<Notiz> notizs){
        Bewerbung bewerbung = new Bewerbung(antwortdatum, beschreibung, gehalt, kontaktRecruiter, linkStellenanzeige, ort, sendedatum, status, titel, unternehmen, vertragsart);
        return bewerbungRepository.save(bewerbung);
    }
    public Bewerbung bewerbungAktualisieren(Long id, Bewerbung bewerbung){
        Bewerbung altBewerbung = bewerbungRepository.findById(id).orElse(null);
        altBewerbung.setAntwortdatum(bewerbung.getAntwortdatum());
        altBewerbung.setBeschreibung(bewerbung.getBeschreibung());
        altBewerbung.setGehalt(bewerbung.getGehalt());
        altBewerbung.setKontaktRecruiter(bewerbung.getKontaktRecruiter());
        altBewerbung.setLinkStellenanzeige(bewerbung.getLinkStellenanzeige());
        altBewerbung.setOrt(bewerbung.getOrt());
        altBewerbung.setSendedatum(bewerbung.getSendedatum());
        altBewerbung.setStatus(bewerbung.getStatus());
        altBewerbung.setTitel(bewerbung.getTitel());
        altBewerbung.setUnternehmen(bewerbung.getUnternehmen());
        altBewerbung.setVertragsart(bewerbung.getVertragsart());
        altBewerbung.setBenutzer(bewerbung.getBenutzer());
        altBewerbung.setDokuments(bewerbung.getDokuments());
        altBewerbung.setNotizs(bewerbung.getNotizs());

        return bewerbungRepository.save(altBewerbung);
    }
    public List<Bewerbung> getBewerbungen(){
        return bewerbungRepository.findAll();
    }

    public void deleteBewerbung(Long id){
        bewerbungRepository.deleteById(id);
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
