package de.cvTracker.cvTracker.service;


import org.springframework.stereotype.Service;

import de.cvTracker.cvTracker.model.Notiz;
import de.cvTracker.cvTracker.repository.NotizRepository;

@Service 
public class NotizService {
    private final NotizRepository notizRepository;

    public NotizService(NotizRepository notizRepository) {
        this.notizRepository = notizRepository;
    }

    public Notiz notizErstellen(Notiz notiz){
        return notizRepository.save(notiz);
    }

    public void notizloeschen(Long id){
        notizRepository.deleteById(id);
    }

    public Notiz notizAktualisieren(Long id, Notiz notiz){
        Notiz altNotiz = notizRepository.findById(id).orElse(null);

        altNotiz.setBewerbung(notiz.getBewerbung());
        altNotiz.setDatum(notiz.getDatum());
        altNotiz.setId(notiz.getId());
        altNotiz.setInhalt(notiz.getInhalt());

        return notizRepository.save(altNotiz);
    }
}
