package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.repository.BewerbungRepository;
import de.cvTracker.cvTracker.repository.DokumentRepository;

import org.springframework.stereotype.Service;

import de.cvTracker.cvTracker.model.Bewerbung;
import de.cvTracker.cvTracker.model.Dokument;
/**
 * Hier ist die Klasse DokumentService
 * @author = Ramane
 * **/
@Service 
public class DokumentService {
    private final DokumentRepository dokumentRepository;
    private  final BewerbungRepository bewerbungRepository;

    public DokumentService(DokumentRepository dokumentRepository, BewerbungRepository bewerbungRepository) {
        this.dokumentRepository = dokumentRepository;
        this.bewerbungRepository = bewerbungRepository;
    }
    
    /**
     * Ein Dokument muss zu einem Bewerbung gehören
     * @param dokument
     * @return
     */
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

    /**
     * 
     * @param id
     */
    public void dokumentLoeschen(Long id){
        dokumentRepository.deleteById(id);
    }
}
