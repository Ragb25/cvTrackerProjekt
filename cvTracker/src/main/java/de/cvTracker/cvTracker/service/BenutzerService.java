package de.cvTracker.cvTracker.service;

import de.cvTracker.cvTracker.repository.BenutzerRepository;
import org.springframework.stereotype.Service;
import de.cvTracker.cvTracker.model.Benutzer;
/**
 * Hier ist die Klasse BenutzerService
 * @author = Ramane
 * **/
@Service
public class BenutzerService {

    private final BenutzerRepository benutzerRepository;

    public BenutzerService(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }
    /**
     * Muss geprüft werden ob der Nutzer noch keinen Konto besitzt
     * @param name
     * @param email
     * @param password
     * @return
     */
    public Benutzer registrieren(String name, String email, String password){
        if(benutzerRepository.findByEmail(email)==null){
            Benutzer benutzer = new Benutzer(email, name, password);
            return benutzerRepository.save(benutzer);
        }
        else return benutzerRepository.findByEmail(email);
    }
}
