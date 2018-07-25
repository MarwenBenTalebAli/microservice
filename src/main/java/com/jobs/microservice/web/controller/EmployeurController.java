package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Employeur;
import com.jobs.microservice.service.EmployeurServiceImpl;
import com.jobs.microservice.web.exceptions.EmployeurNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les employeurs.")
@RestController
public class EmployeurController {

    private EmployeurServiceImpl employeurServiceImpl;

    @Autowired
    public EmployeurController(EmployeurServiceImpl employeurServiceImpl) {
        this.employeurServiceImpl = employeurServiceImpl;
    }

    @ApiOperation(value = "Ajouter un employeur.")
    @PostMapping(value = "/employeurs")
    public ResponseEntity<Void> addEmployeur(@RequestBody Employeur employeur) {

        Employeur employeur1 = employeurServiceImpl.save(employeur);

        if (employeur == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idEmployeur}")
                .buildAndExpand(employeur1.getIdEmployeur())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "Affiche la liste de tous les employeurs disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/employeurs")
    public List<Employeur> getEmployeurs() {

        List<Employeur> employeurs = employeurServiceImpl.findAll();

        if (employeurs.isEmpty()) throw new EmployeurNotFoundException("Aucun employeur n'est disponible");

        return employeurs;

    }

    @ApiOperation(value = "Récupère un employeur grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/employeurs/{idEmployeur}")
    public Optional<Employeur> getEmployeur(@PathVariable Long idEmployeur) {

        Optional<Employeur> employeur = employeurServiceImpl.findById(idEmployeur);

        if (!employeur.isPresent())
            throw new EmployeurNotFoundException("L' employeur correspondant à l'id " + idEmployeur + " n'existe pas");

        return employeur;
    }

    @ApiOperation(value = "Supprimer un employeur grâce à son ID à condition que celui-ci soit en base de donnée!")
    @DeleteMapping(value = "/employeurs/{idEmployeur}")
    public void supprimerEmployeur(@PathVariable Long idEmployeur) {
        employeurServiceImpl.delete(idEmployeur);
    }

    @ApiOperation(value = "Modifier un employeur excepté que le candidat passé en paramètre a le même Id qu'un candidat existant")
    @PutMapping(value = "/employeurs")
    public void updateEmployeur(@RequestBody Employeur employeur) {
        employeurServiceImpl.save(employeur);
    }
}