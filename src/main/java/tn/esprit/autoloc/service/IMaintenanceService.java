package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance ajouterMaintenance(Maintenance maintenance);

    Maintenance modifierMaintenance(Maintenance maintenance);

    List<Maintenance> afficherToutesMaintenance();

    Maintenance afficherMaintenanceById(long id);

    void supprimerMaintenance(long id);
}
