package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IEmployeService {

    Employe ajouterEmploye(Employe employe);

    Employe modifierEmploye(Employe employe);

    List<Employe> afficherToutesEmployes();

    Employe afficherEmployeById(Long id);

    void supprimerEmploye(Employe employe);


}
