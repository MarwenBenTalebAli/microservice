package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Emploi;
import com.jobs.microservice.model.Societe;
import com.jobs.microservice.service.EmploiServiceImpl;
import com.jobs.microservice.service.SocieteServiceImpl;
import com.jobs.microservice.web.exceptions.EmploiNotFoundException;
import com.jobs.microservice.web.exceptions.SocieteNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les Emplois.")
@RestController
public class EmploiController {
    private EmploiServiceImpl emploiServiceImpl;
    private SocieteServiceImpl societeServiceImpl;

    @Autowired
    public EmploiController(EmploiServiceImpl emploiServiceImpl, SocieteServiceImpl societeServiceImpl) {
        this.emploiServiceImpl = emploiServiceImpl;
        this.societeServiceImpl = societeServiceImpl;
    }

    @ApiOperation(value = "Affiche la liste de tous les emplois disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/emplois")
    public List<Emploi> getEmplois() {

        List<Emploi> emplois = emploiServiceImpl.findAll();

        if (emplois.isEmpty()) throw new EmploiNotFoundException("Aucunne emploi n'est disponible");

        return emplois;

    }

    @ApiOperation(value = "Récupère une emploi grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/emplois/{idEmploi}")
    public Optional<Emploi> getEmploi(@PathVariable Long idEmploi) {

        Optional<Emploi> emploi = emploiServiceImpl.findById(idEmploi);

        if (!emploi.isPresent())
            throw new EmploiNotFoundException("La emploi correspondant à l'id " + idEmploi + " n'existe pas");

        return emploi;
    }

    @ApiOperation(value = "Récupère la liste des emplois grâce à L'ID de societe à condition que celui-ci soit en base de donnée!")
    @PostMapping(value = "/emplois/{idSociete}")
    public Collection<Emploi> getListeEmploiByIdSociete(@PathVariable Long idSociete) {
        Optional<Societe> societe = societeServiceImpl.findById(idSociete);

        if (!societe.isPresent())
            throw new SocieteNotFoundException("La societe correspondant à l'id " + idSociete + " n'existe pas");

        return societe.get().getEmplois();
    }

    @ApiOperation(value = "Supprimer un emploi grâce à son ID à condition que celle-ci soit en base de donnée!")
    @DeleteMapping(value = "/emplois/{idEmploi}")
    public void supprimerEmploi(@PathVariable Long idEmploi) {
        emploiServiceImpl.delete(idEmploi);
    }

    @ApiOperation(value = "Modifier un emploi excepté que la emploi passé en paramètre a le même Id qu'un emploi existant")
    @PutMapping(value = "/emplois")
    public void updateEmploi(@RequestBody Emploi emploi) {
        emploiServiceImpl.save(emploi);
    }
}
