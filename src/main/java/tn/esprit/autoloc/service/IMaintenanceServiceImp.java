package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IMaintenanceServiceImp implements IMaintenanceService{
    private final MaintenanceRepository maintenanceRepository;
    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> afficherToutesMaintenance() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance afficherMaintenanceById(long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerMaintenance(long id) {
        maintenanceRepository.deleteById(id);

    }
}
