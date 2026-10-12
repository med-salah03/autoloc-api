package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Maintenance;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

    // Mots-cles Spring Data
    List<Maintenance> findByVehiculeIdVehicule(Long idVehicule);

    List<Maintenance> findByDateDebutBetween(LocalDate debut, LocalDate fin);

    List<Maintenance> findByDescriptionContainingIgnoreCase(String motCle);

    // JPQL : maintenances en cours a une date donnee (pas de date de fin ou pas encore terminee)
    @Query("SELECT m FROM Maintenance m WHERE m.dateDebut <= :date AND (m.dateFin IS NULL OR m.dateFin >= :date)")
    List<Maintenance> findEnCours(@Param("date") LocalDate date);
}
