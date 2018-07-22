package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Candidat;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Formation;
import com.jobs.microservice.service.CandidatServiceImpl;
import com.jobs.microservice.service.CvServiceImpl;
import com.jobs.microservice.service.FormationServiceImpl;
import com.jobs.microservice.web.exceptions.CandidatNotFoundException;
import com.jobs.microservice.web.exceptions.CvNotFoundException;
import com.jobs.microservice.web.exceptions.FormationNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Api( description="API pour les opérations CRUD sur les Formations.")
@RestController
public class FormationController {

    private FormationServiceImpl formationServiceImpl;
    private CvServiceImpl cvServiceImpl;

    public FormationController(FormationServiceImpl formationServiceImpl, CvServiceImpl cvServiceImpl) {
        this.formationServiceImpl = formationServiceImpl;
        this.cvServiceImpl = cvServiceImpl;
    }

    @ApiOperation(value = "Affiche la liste de tous les formations disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/formations")
    public List<Formation> getFormations() {

        List<Formation> formations = formationServiceImpl.findAll();

        if (formations.isEmpty()) throw new FormationNotFoundException("Aucunne formation n'est disponible");

        return formations;

    }

    @ApiOperation(value = "Récupère une formation grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/formations/{idFormation}")
    public Optional<Formation> getFormation(@PathVariable Long idFormation) {

        Optional<Formation> formation = formationServiceImpl.findById(idFormation);

        if (!formation.isPresent())
            throw new FormationNotFoundException("La formation correspondant à l'id " + idFormation + " n'existe pas");

        return formation;
    }

    @ApiOperation(value = "Récupère la liste des formations grâce à L'ID de cv à condition que celui-ci soit en base de donnée!")
    @PostMapping(value = "/formations/{idCv}")
    public Collection<Formation> getListeFormationByIdCv(@PathVariable Long idCv) {
        Optional<Cv> cv = cvServiceImpl.findById(idCv);

        if (!cv.isPresent())
            throw new CvNotFoundException("Le cv correspondant à l'id " + idCv + " n'existe pas");

        return cv.get().getFormations();
    }

    @ApiOperation(value = "Supprimer une formation grâce à son ID à condition que celle-ci soit en base de donnée!")
    @DeleteMapping(value = "/formations/{idFormation}")
    public void supprimerFormation(@PathVariable Long idFormation) {
        formationServiceImpl.delete(idFormation);
    }

    @ApiOperation(value = "Modifier une formation excepté que la formation passé en paramètre a le même Id qu'une formation existant")
    @PutMapping(value = "/formations")
    public void updateFormation(@RequestBody Formation formation) {
        formationServiceImpl.save(formation);
    }
}
