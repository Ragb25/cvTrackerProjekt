package de.cvTracker.cvTracker.controller;
import de.cvTracker.cvTracker.model.Dokument;
import de.cvTracker.cvTracker.service.BewerbungService;
import de.cvTracker.cvTracker.service.DokumentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Hier ist die Dokumentkontroller
 * Endpunkte um Dokumente zu verwalten
 * @author = Ramane
 * **/
@RestController 
public class DokumentController {
    private final DokumentService dokumentService;
    private final BewerbungService bewerbungService;

    public DokumentController(DokumentService dokumentService, BewerbungService bewerbungService) {
        this.dokumentService = dokumentService;
        this.bewerbungService = bewerbungService;
    }

    @GetMapping("/dokuments/{id}")
    public List <Dokument> getDokuments(@PathVariable Long id){
        return bewerbungService.getDokuments(id);
    }

    @PostMapping ("/dokumentHinzufuegen")
    public Dokument dokumentHinzufuegen(@RequestBody Dokument dokument){
        return dokumentService.dokumentHinzufuegen(dokument);
    }

    @DeleteMapping("/dokumentLoeschen/{id}")
    public void dokumentLoeschen(@PathVariable Long id){
        dokumentService.dokumentLoeschen(id);
    }

}
