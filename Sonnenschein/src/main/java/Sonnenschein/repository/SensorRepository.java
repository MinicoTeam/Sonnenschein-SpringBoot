package Sonnenschein.repository;

import Sonnenschein.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<SensorData, Long> {
    // Methoden zur Abfrage und Speicherung der Sensordaten
}