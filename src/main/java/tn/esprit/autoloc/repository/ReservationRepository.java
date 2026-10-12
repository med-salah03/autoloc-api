package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Mots-cles Spring Data
    List<Reservation> findByStatut(StatutReservation statut);

    List<Reservation> findByClientIdClient(Long idClient);

    List<Reservation> findByVehiculeIdVehicule(Long idVehicule);

    List<Reservation> findByDateDebutBetween(LocalDate debut, LocalDate fin);

    long countByStatut(StatutReservation statut);

    // JPQL : nombre de reservations (hors statut exclu) qui chevauchent la periode pour un vehicule
    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.vehicule.idVehicule = :idVehicule "
            + "AND r.statut <> :statutExclu AND r.dateDebut <= :fin AND r.dateFin >= :debut")
    long countChevauchements(@Param("idVehicule") Long idVehicule,
                             @Param("debut") LocalDate debut,
                             @Param("fin") LocalDate fin,
                             @Param("statutExclu") StatutReservation statutExclu);
}
