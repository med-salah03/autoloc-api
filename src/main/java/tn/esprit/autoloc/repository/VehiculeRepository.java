package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Mots-cles Spring Data
    Optional<Vehicule> findByImmatriculation(String immatriculation);

    List<Vehicule> findByStatut(StatutVehicule statut);

    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    List<Vehicule> findByMarqueIgnoreCase(String marque);

    List<Vehicule> findByStatutAndCategorie(StatutVehicule statut, CategorieVehicule categorie);

    List<Vehicule> findByAgenceIdAgenceAndStatut(Long idAgence, StatutVehicule statut);

    List<Vehicule> findByTarifJournalierLessThanEqual(BigDecimal tarifMax);

    // JPQL (ManyToMany) : vehicules possedant un equipement donne
    @Query("SELECT v FROM Vehicule v JOIN v.equipements e WHERE e.libelle = :libelle")
    List<Vehicule> findByEquipement(@Param("libelle") String libelle);

    // JPQL : vehicules disponibles sur une periode (aucune reservation active qui chevauche)
    @Query("SELECT v FROM Vehicule v WHERE v.statut = :statut AND NOT EXISTS ("
            + "SELECT r FROM Reservation r WHERE r.vehicule = v AND r.statut <> :statutExclu "
            + "AND r.dateDebut <= :fin AND r.dateFin >= :debut)")
    List<Vehicule> findDisponibles(@Param("debut") LocalDate debut,
                                   @Param("fin") LocalDate fin,
                                   @Param("statut") StatutVehicule statut,
                                   @Param("statutExclu") StatutReservation statutExclu);
}
