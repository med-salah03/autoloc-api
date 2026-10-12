package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.RoleEmploye;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    // Mots-cles Spring Data
    List<Employe> findByRole(RoleEmploye role);

    List<Employe> findByNomContainingIgnoreCase(String nom);

    List<Employe> findByAgenceIdAgence(Long idAgence);

    long countByAgenceIdAgence(Long idAgence);

    // JPQL : employes d'une ville
    @Query("SELECT e FROM Employe e WHERE e.agence.ville = :ville")
    List<Employe> findByVilleAgence(@Param("ville") String ville);
}
