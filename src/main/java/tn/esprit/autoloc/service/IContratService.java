package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);

    Contrat modifierContrat(Contrat contrat);

    List<Contrat> afficherToutesContrat();

    Contrat afficherContratById(long id);

    void supprimerContrat(long id);

}
