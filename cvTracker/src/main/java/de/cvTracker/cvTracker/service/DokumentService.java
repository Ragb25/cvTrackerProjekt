package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.repository.DokumentRepository;

import org.springframework.stereotype.Service;

import de.cvTracker.cvTracker.model.Dokument;

@Service 
public class DokumentService {
    private final DokumentRepository dokumentRepository;

    public DokumentService(DokumentRepository dokumentRepository) {
        this.dokumentRepository = dokumentRepository;
    }
    public Dokument dokumentHinzufuegen(Dokument dokument){
        return dokumentRepository.save(dokument);
    }
    public void dokumentLoeschen(Long id){
        dokumentRepository.deleteById(id);
    }
}
