package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Candidat;
import com.jobs.microservice.service.CandidatServiceImpl;
import com.jobs.microservice.web.exceptions.CandidatNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les candidats.")
@RestController
public class CandidatController {

    private CandidatServiceImpl candidatServiceImpl;

    @Autowired
    public CandidatController(CandidatServiceImpl candidatServiceImpl) {
        this.candidatServiceImpl = candidatServiceImpl;
    }

    @ApiOperation(value = "Ajouter un candidat.")
    @PostMapping(value = "/candidats")
    public ResponseEntity<Void> addCandidat(@RequestBody Candidat candidat) {

        Candidat candidat1 = candidatServiceImpl.save(candidat);

        if (candidat == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(candidat1.getIdCandidat())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "Affiche la liste de tous les candidats disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/candidats")
    public List<Candidat> getCandidats() {

        List<Candidat> candidats = candidatServiceImpl.findAll();

        if (candidats.isEmpty()) throw new CandidatNotFoundException("Aucun candidat n'est disponible");

        return candidats;

    }

    @ApiOperation(value = "Récupère un candidat grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/candidats/{idCandidat}")
    public Optional<Candidat> getCandidat(@PathVariable Long idCandidat) {

        Optional<Candidat> candidat = candidatServiceImpl.findById(idCandidat);

        if (!candidat.isPresent())
            throw new CandidatNotFoundException("Le candidat correspondant à l'id " + idCandidat + " n'existe pas");

        return candidat;
    }

    @ApiOperation(value = "Supprimer un candidat grâce à son ID à condition que celui-ci soit en base de donnée!")
    @DeleteMapping(value = "/candidats/{idCandidat}")
    public void supprimerCandidat(@PathVariable Long idCandidat) {
        candidatServiceImpl.delete(idCandidat);
    }

    @ApiOperation(value = "Modifier un candidat excepté que le candidat passé en paramètre a le même Id qu'un candidat existant")
    @PutMapping(value = "/candidats")
    public void updateFormation(@RequestBody Candidat candidat) {
        candidatServiceImpl.save(candidat);
    }
}