package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> afficherToutesMaintenance() {
        return maintenanceService.afficherToutesMaintenance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> afficherMaintenanceById(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.afficherMaintenanceById(id);
        return maintenance != null ? ResponseEntity.ok(maintenance) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMaintenance(@PathVariable Long id) {
        maintenanceService.supprimerMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
