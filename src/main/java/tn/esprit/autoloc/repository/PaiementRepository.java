package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.ModePaiement;
import tn.esprit.autoloc.domain.Paiement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    // Mots-cles Spring Data
    List<Paiement> findByContratIdContrat(Long idContrat);

    List<Paiement> findByModePaiement(ModePaiement modePaiement);

    List<Paiement> findByDatePaiementBetween(LocalDate debut, LocalDate fin);

    // JPQL : somme des paiements sur une periode (null s'il n'y en a aucun)
    @Query("SELECT SUM(p.montant) FROM Paiement p WHERE p.datePaiement BETWEEN :debut AND :fin")
    BigDecimal calculerTotalEntre(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin);
}
