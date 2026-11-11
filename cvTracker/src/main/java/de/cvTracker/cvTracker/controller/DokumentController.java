package de.cvTracker.cvTracker.controller;
import de.cvTracker.cvTracker.model.Dokument;
import de.cvTracker.cvTracker.service.BewerbungService;
import de.cvTracker.cvTracker.service.DokumentService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class DokumentController {
    DokumentService dokumentService;
    BewerbungService bewerbungService;

    @GetMapping("/documents/{id}")
    public List <Dokument> getDokuments(@PathVariable Long id){
        return bewerbungService.getDokuments(id);
    }

}
