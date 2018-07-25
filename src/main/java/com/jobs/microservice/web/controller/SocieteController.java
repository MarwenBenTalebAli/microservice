package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Societe;
import com.jobs.microservice.service.SocieteServiceImpl;
import com.jobs.microservice.web.exceptions.EmploiNotFoundException;
import com.jobs.microservice.web.exceptions.SocieteNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les Societes.")
@RestController
public class SocieteController {

    private SocieteServiceImpl societeServiceImpl;

    @Autowired
    public SocieteController(SocieteServiceImpl societeServiceImpl) {
        this.societeServiceImpl = societeServiceImpl;
    }

    @ApiOperation(value = "Affiche la liste de tous les societes disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/societes")
    public List<Societe> getSocietes() {

        List<Societe> societes = societeServiceImpl.findAll();

        if (societes.isEmpty()) throw new SocieteNotFoundException("Aucunne societe n'est disponible");

        return societes;

    }

    @ApiOperation(value = "Récupère une societe grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/societes/{idSociete}")
    public Optional<Societe> getSociete(@PathVariable Long idSociete) {

        Optional<Societe> societe = societeServiceImpl.findById(idSociete);

        if (!societe.isPresent())
            throw new EmploiNotFoundException("La societe correspondant à l'id " + idSociete + " n'existe pas");

        return societe;
    }

    @ApiOperation(value = "Supprimer une societe grâce à son ID à condition que celle-ci soit en base de donnée!")
    @DeleteMapping(value = "/societes/{idSociete}")
    public void supprimerSociete(@PathVariable Long idSociete) {
        societeServiceImpl.delete(idSociete);
    }

    @ApiOperation(value = "Modifier un societe excepté que la societe passé en paramètre a le même Id qu'une societe existant")
    @PutMapping(value = "/societes")
    public void updateSociete(@RequestBody Societe societe) {
        societeServiceImpl.save(societe);
    }

}
