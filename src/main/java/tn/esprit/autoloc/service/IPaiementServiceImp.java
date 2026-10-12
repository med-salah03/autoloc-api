package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class IPaiementServiceImp implements IPaiementService {
    private final PaiementRepository paiementRepository;
    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> afficherToutesPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement afficherPaiementById(long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerPaiement(long id) {
        paiementRepository.deleteById(id);

    }
}
