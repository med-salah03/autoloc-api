package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IContratServiceImp implements IContratService{
    private final ContratRepository contratRepository;
    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> afficherToutesContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat afficherContratById(long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerContrat(long id) {
         contratRepository.deleteById(id);
    }
}
