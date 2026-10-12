package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Mots-cles Spring Data
    Optional<Client> findByEmail(String email);

    Optional<Client> findByNumPermis(String numPermis);

    boolean existsByEmail(String email);

    List<Client> findByDateInscriptionAfter(LocalDate date);

    // JPQL : recherche par nom ou prenom
    @Query("SELECT c FROM Client c WHERE LOWER(c.nom) LIKE LOWER(CONCAT('%', :motCle, '%')) "
            + "OR LOWER(c.prenom) LIKE LOWER(CONCAT('%', :motCle, '%'))")
    List<Client> rechercherParNomOuPrenom(@Param("motCle") String motCle);
}
