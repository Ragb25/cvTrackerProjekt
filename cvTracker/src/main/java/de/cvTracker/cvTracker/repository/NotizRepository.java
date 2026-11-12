package de.cvTracker.cvTracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import de.cvTracker.cvTracker.model.Notiz;

public interface NotizRepository extends JpaRepository <Notiz, Long>{}
