package be.epicode.GestioneDispositivi.repositories;

import be.epicode.GestioneDispositivi.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendentiDAO extends JpaRepository<Dipendente, Integer> {
}
