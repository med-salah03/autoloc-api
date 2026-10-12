package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Contrat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

    // Mots-cles Spring Data
    List<Contrat> findByValide(boolean valide);

    List<Contrat> findByDateSignatureBetween(LocalDate debut, LocalDate fin);

    List<Contrat> findByMontantTotalGreaterThan(BigDecimal montant);

    // Contrat associe a une reservation (OneToOne)
    Optional<Contrat> findByReservationIdReservation(Long idReservation);

    // JPQL : total deja paye pour un contrat (null s'il n'y a aucun paiement)
    @Query("SELECT SUM(p.montant) FROM Contrat c JOIN c.paiements p WHERE c.idContrat = :idContrat")
    BigDecimal calculerTotalPaye(@Param("idContrat") Long idContrat);
}
