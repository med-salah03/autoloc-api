package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping
    public List<Employe> afficherToutesEmployes() {
        return employeService.afficherToutesEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> afficherEmployeById(@PathVariable Long id) {
        Employe employe = employeService.afficherEmployeById(id);
        return employe != null ? ResponseEntity.ok(employe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmploye(@PathVariable Long id) {
        Employe employe = employeService.afficherEmployeById(id);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        employeService.supprimerEmploye(employe);
        return ResponseEntity.noContent().build();
    }
}
