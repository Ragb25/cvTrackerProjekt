package de.cvTracker.cvTracker.controller;

import de.cvTracker.cvTracker.model.Bewerbung;
import de.cvTracker.cvTracker.service.BewerbungService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class BewerbungController {
    private final BewerbungService bewerbungService;

    public BewerbungController(BewerbungService bewerbungService) {
        this.bewerbungService = bewerbungService;
    }
    @PostMapping("/bewerbungErstellen")
    public Bewerbung bewerbungErstellen(@RequestBody Bewerbung bewerbung){
        return bewerbungService.erstelleBewerbung(bewerbung.getAntwortdatum(), bewerbung.getBeschreibung(), bewerbung.getGehalt(), bewerbung.getKontaktRecruiter(), bewerbung.getLinkStellenanzeige(), bewerbung.getOrt(), bewerbung.getSendedatum(), bewerbung.getStatus(), bewerbung.getTitel(), bewerbung.getUnternehmen(), bewerbung.getVertragsart(), bewerbung.getBenutzer(), bewerbung.getDokuments(), bewerbung.getNotizs());
    }

    @PutMapping("/bewerbungen/{id}")
    public Bewerbung bewerbungAktualisieren(@RequestBody Bewerbung bewerbung, @PathVariable Long id){
        return bewerbungService.bewerbungAktualisieren(id, bewerbung);
    }

    @GetMapping("/bewerbungen")
    public List<Bewerbung> getBewerbungen(){
        return bewerbungService.getBewerbungen();
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteBewerbung(@PathVariable Long id){
        bewerbungService.deleteBewerbung(id);
    }

}
