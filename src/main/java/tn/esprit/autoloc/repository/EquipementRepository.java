package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Equipement;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

    // Mots-cles Spring Data
    Optional<Equipement> findByLibelle(String libelle);

    List<Equipement> findByLibelleContainingIgnoreCase(String libelle);

    // JPQL (ManyToMany) : equipements d'un vehicule
    @Query("SELECT e FROM Equipement e JOIN e.vehicules v WHERE v.idVehicule = :idVehicule")
    List<Equipement> findByVehiculeId(@Param("idVehicule") Long idVehicule);
}
