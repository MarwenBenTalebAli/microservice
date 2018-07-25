package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Competence;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Experience;
import com.jobs.microservice.service.CompetenceServiceImpl;
import com.jobs.microservice.service.CvServiceImpl;
import com.jobs.microservice.web.exceptions.CompetenceNotFoundException;
import com.jobs.microservice.web.exceptions.CvNotFoundException;
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

@Api(description = "API pour les opérations CRUD sur les competences.")
@RestController
public class CompetenceController {

    private CompetenceServiceImpl competenceServiceImpl;
    private CvServiceImpl cvServiceImpl;

    @Autowired
    public CompetenceController(CompetenceServiceImpl competenceServiceImpl, CvServiceImpl cvServiceImpl) {
        this.competenceServiceImpl = competenceServiceImpl;
        this.cvServiceImpl = cvServiceImpl;
    }

    @ApiOperation(value = "Ajouter une competence.")
    @PostMapping(value = "/competences")
    public ResponseEntity<Void> addCompetence(@RequestBody Competence competence) {

        Competence competence1 = competenceServiceImpl.save(competence);

        if (competence == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idCompetence}")
                .buildAndExpand(competence1.getIdCompetence())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "Affiche la liste de tous les competences disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/competences")
    public List<Competence> getCompetences() {

        List<Competence> competences = competenceServiceImpl.findAll();

        if (competences.isEmpty()) throw new CompetenceNotFoundException("Aucunne competence n'est disponible");

        return competences;

    }

    @ApiOperation(value = "Récupère la liste des competences grâce à L'ID de cv à condition que celui-ci soit en base de donnée!")
    @PostMapping(value = "/competences/{idCv}")
    public Collection<Competence> getListeCompetenceByIdCv(@PathVariable Long idCv) {
        Optional<Cv> cv = cvServiceImpl.findById(idCv);

        if (!cv.isPresent())
            throw new CvNotFoundException("Le cv correspondant à l'id " + idCv + " n'existe pas");

        return cv.get().getCompetences();
    }

    @ApiOperation(value = "Récupère une competence grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/competences/{idCompetence}")
    public Optional<Competence> getCompetence(@PathVariable Long idCompetence) {

        Optional<Competence> competence = competenceServiceImpl.findById(idCompetence);

        if (!competence.isPresent())
            throw new CompetenceNotFoundException("La competence correspondant à l'id " + idCompetence + " n'existe pas");

        return competence;
    }

    @ApiOperation(value = "Supprimer une competence grâce à son ID à condition que celui-ci soit en base de donnée!")
    @DeleteMapping(value = "/competences/{idCompetence}")
    public void supprimerCompetence(@PathVariable Long idCompetence) {
        competenceServiceImpl.delete(idCompetence);
    }

    @ApiOperation(value = "Modifier une competence excepté que le candidat passé en paramètre a le même Id qu'une competence existant")
    @PutMapping(value = "/competences")
    public void updateCompetence(@RequestBody Competence competence) {
        competenceServiceImpl.save(competence);
    }
}