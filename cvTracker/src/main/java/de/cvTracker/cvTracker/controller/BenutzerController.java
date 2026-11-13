package de.cvTracker.cvTracker.controller;

import de.cvTracker.cvTracker.model.Benutzer;
import de.cvTracker.cvTracker.service.BenutzerService;
import org.springframework.web.bind.annotation.*;

/**
 * Hier ist die BenutzerController. 
 * Endpunkt um einen Benutzer zu registrieren
 * @author = Ramane
 * **/
@RestController
public class BenutzerController {
    private final BenutzerService benutzerService;

    public BenutzerController(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }
    @PostMapping("/registrieren")
    public Benutzer registrieren(@RequestBody Benutzer benutzer){
        return benutzerService.registrieren(benutzer.getName(), benutzer.getEmail(), benutzer.getPassword());

    }
}
