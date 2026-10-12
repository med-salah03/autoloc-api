package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class IEquipementServiceImp implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement modifierEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> afficherToutesEquipement() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement afficherEquipementById(long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEquipement(long id) {
        equipementRepository.deleteById(id);

    }
}
