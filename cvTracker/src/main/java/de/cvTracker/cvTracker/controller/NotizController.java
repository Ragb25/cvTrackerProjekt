package de.cvTracker.cvTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.cvTracker.cvTracker.model.Notiz;
import de.cvTracker.cvTracker.service.BewerbungService;
import de.cvTracker.cvTracker.service.NotizService;
/**
 * Hier ist die NotizController
 * Endpunkte um Notizen zu verwalten
 * @author = Ramane
 * **/
@RestController 
public class NotizController {
    private final NotizService notizService;
    private final BewerbungService bewerbungService;

    public NotizController(NotizService notizService, BewerbungService bewerbungService) {
        this.notizService = notizService;
        this.bewerbungService = bewerbungService;
    }

    @PostMapping ("/notizErstellen")
    public Notiz notizErstellen(@RequestBody Notiz notiz){
        return notizService.notizErstellen(notiz);
    }

    @GetMapping ("/getNotiz/{id}")
    public List <Notiz> getNotizs(@PathVariable Long id){
        return bewerbungService.getNotiz(id);
    }

    @DeleteMapping ("/notizLoeschen/{id}")
    public void notizLoeschen(@PathVariable Long id){
        notizService.notizloeschen(id);
    }

    @PutMapping ("/notizAktualisieren/{id}")
    public Notiz notizAktualisieren(@PathVariable Long id, @RequestBody Notiz notiz){
        return notizService.notizAktualisieren(id, notiz);
    }
}
