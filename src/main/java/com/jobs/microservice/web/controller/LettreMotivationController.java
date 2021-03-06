package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Candidat;
import com.jobs.microservice.model.LettreMotivation;
import com.jobs.microservice.service.CandidatServiceImpl;
import com.jobs.microservice.service.LettreMotivationServiceImpl;
import com.jobs.microservice.web.exceptions.CandidatNotFoundException;
import com.jobs.microservice.web.exceptions.LettreMotivationNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les lettres de motivation .")
@RestController
public class LettreMotivationController {

    private LettreMotivationServiceImpl lettreMotivationServiceImpl;
    private CandidatServiceImpl candidatServiceImpl;

    @Autowired
    public LettreMotivationController(LettreMotivationServiceImpl lettreMotivationServiceImpl, CandidatServiceImpl candidatServiceImpl) {
        this.lettreMotivationServiceImpl = lettreMotivationServiceImpl;
        this.candidatServiceImpl = candidatServiceImpl;
    }

    @ApiOperation(value = "Ajouter une lettre de motivation.")
    @PostMapping(value = "/lettres")
    public ResponseEntity<Void> addLettreMotivation(@RequestBody LettreMotivation lettreMotivation) {

        LettreMotivation lettreMotivation1 = lettreMotivationServiceImpl.save(lettreMotivation);

        if (lettreMotivation == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lettreMotivation1.getIdLettreMotivation())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "Affiche la liste de tous les lettres disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/lettres")
    public List<LettreMotivation> getLettres() {

        List<LettreMotivation> lettres = lettreMotivationServiceImpl.findAll();

        if (lettres.isEmpty()) throw new LettreMotivationNotFoundException("Aucune lettre n'est disponible");

        return lettres;

    }

    @ApiOperation(value = "Récupère les lettres de motivation d'un candidat grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/lettres/{idCandidat}")
    public Collection<LettreMotivation> getLettresByIdCandidat(@PathVariable Long idCandidat) {

        Optional<Candidat> candidat = candidatServiceImpl.findById(idCandidat);

        if (!candidat.isPresent())
            throw new CandidatNotFoundException("Le candidat correspondant à l'id " + idCandidat + " n'existe pas");

        return candidat.get().getLettreMotivations();
    }

    @ApiOperation(value = "Supprimer une lettre de motivation grâce à son ID à condition que celle-ci soit en base de donnée!")
    @DeleteMapping(value = "/lettres/{idLettreMotivation}")
    public void supprimerLettreMotivation(@PathVariable Long idLettreMotivation) {
        lettreMotivationServiceImpl.delete(idLettreMotivation);
    }

    @ApiOperation(value = "Modifier une lettre de motivation excepté que la lettre passé en paramètre a le même Id qu'une lettre existant")
    @PutMapping(value = "/lettres")
    public void updateLettreMotivation(@RequestBody LettreMotivation lettreMotivation) {
        lettreMotivationServiceImpl.save(lettreMotivation);
    }
}