package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

    // Mots-cles Spring Data
    List<Agence> findByVille(String ville);

    List<Agence> findByNomContainingIgnoreCase(String nom);

    boolean existsByNomAndVille(String nom, String ville);

    // JPQL : agences possedant au moins N vehicules
    @Query("SELECT a FROM Agence a WHERE SIZE(a.vehicules) >= :nb")
    List<Agence> findAgencesAvecAuMoinsNVehicules(@Param("nb") int nb);
}
