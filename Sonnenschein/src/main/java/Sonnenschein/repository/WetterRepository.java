package Sonnenschein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sonnenschein.model.WetterData;

@Repository
public interface WetterRepository extends JpaRepository<WetterData, Long> {
    // Methoden zur Abfrage und Speicherung der Wetterdaten
}