package de.cvTracker.cvTracker.repository;

import de.cvTracker.cvTracker.model.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenutzerRepository extends JpaRepository <Benutzer, Long>{

    Benutzer findByEmail(String email);

}
