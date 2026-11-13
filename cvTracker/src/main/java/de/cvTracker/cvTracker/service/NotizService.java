package de.cvTracker.cvTracker.service;


import org.springframework.stereotype.Service;

import de.cvTracker.cvTracker.model.Bewerbung;
import de.cvTracker.cvTracker.model.Notiz;
import de.cvTracker.cvTracker.repository.BewerbungRepository;
import de.cvTracker.cvTracker.repository.NotizRepository;

@Service 
public class NotizService {
    private final NotizRepository notizRepository;
    private final BewerbungRepository bewerbungRepository;



    public NotizService(NotizRepository notizRepository, BewerbungRepository bewerbungRepository) {
        this.notizRepository = notizRepository;
        this.bewerbungRepository = bewerbungRepository;
    }

    public Notiz notizErstellen(Notiz notiz){
        Long bewerbung_id = notiz.getBewerbung().getId();
        Bewerbung bewerbung = bewerbungRepository.findById(bewerbung_id).get();
        bewerbung.addNotizs(notiz);
        bewerbungRepository.save(bewerbung);
        return notizRepository.save(notiz);
    }

    public void notizloeschen(Long id){
        notizRepository.deleteById(id);
    }

    public Notiz notizAktualisieren(Long id, Notiz notiz){
        Notiz altNotiz = notizRepository.findById(id).orElse(null);

        if(notiz.getBewerbung()!=null){
            altNotiz.setBewerbung(notiz.getBewerbung());
        }
        if(notiz.getDatum()!=null){
            altNotiz.setDatum(notiz.getDatum());
        }
        if(notiz.getInhalt()!=null){
            altNotiz.setInhalt(notiz.getInhalt());
        }
        

        return notizRepository.save(altNotiz);
    }
}
