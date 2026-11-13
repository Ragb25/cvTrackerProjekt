package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.repository.BewerbungRepository;
import de.cvTracker.cvTracker.repository.DokumentRepository;

import org.springframework.stereotype.Service;

import de.cvTracker.cvTracker.model.Bewerbung;
import de.cvTracker.cvTracker.model.Dokument;

@Service 
public class DokumentService {
    private final DokumentRepository dokumentRepository;
    private  final BewerbungRepository bewerbungRepository;
    public DokumentService(DokumentRepository dokumentRepository, BewerbungRepository bewerbungRepository) {
        this.dokumentRepository = dokumentRepository;
        this.bewerbungRepository = bewerbungRepository;
    }
    
    public Dokument dokumentHinzufuegen(Dokument dokument){
    Dokument gespeichertesDokument = dokumentRepository.save(dokument);

    if (dokument.getBewerbungs() != null){
        for (Bewerbung b : dokument.getBewerbungs()) {
        Bewerbung bewerbung = bewerbungRepository.findById(b.getId()).get();
        bewerbung.getDokuments().add(gespeichertesDokument);
        bewerbungRepository.save(bewerbung);
        }
    }

    return gespeichertesDokument;
}
    public void dokumentLoeschen(Long id){
        dokumentRepository.deleteById(id);
    }
}
