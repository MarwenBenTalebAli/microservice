package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Candidat;
import com.jobs.microservice.model.Cv;
import com.jobs.microservice.service.CandidatServiceImpl;
import com.jobs.microservice.service.CvServiceImpl;
import com.jobs.microservice.web.exceptions.CandidatNotFoundException;
import com.jobs.microservice.web.exceptions.CvNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;


@Api(description = "API pour les opérations CRUD sur les cvs.")
@RestController
public class CvController {

    private CvServiceImpl cvServiceImpl;
    private CandidatServiceImpl candidatServiceImpl;

    @Autowired
    public CvController(CvServiceImpl cvServiceImpl, CandidatServiceImpl candidatServiceImpl) {
        this.cvServiceImpl = cvServiceImpl;
        this.candidatServiceImpl = candidatServiceImpl;
    }

    @ApiOperation(value = "Ajouter un cv.")
    @PostMapping(value = "/cvs")
    public ResponseEntity<Void> addCv(@RequestBody Cv cv) {

        Cv cv1 = cvServiceImpl.save(cv);

        if (cv == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cv1.getIdCv())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @ApiOperation(value = "Récupère la liste des cvs grâce à L'ID de candidat à condition que celui-ci soit en base de donnée!")
    @PostMapping(value = "/cvs/{idCandidat}")
    public Collection<Cv> getListeCvByIdCandidat(@PathVariable Long idCandidat) {

        Optional<Candidat> candidat = candidatServiceImpl.findById(idCandidat);

        if (!candidat.isPresent())
            throw new CandidatNotFoundException("Le candidat correspondant à l'id " + idCandidat + " n'existe pas");

        return candidat.get().getCvs();

    }

    @ApiOperation(value = "Récupère un cv grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/cvs/{idCv}")
    public Optional<Cv> getCvById(@PathVariable Long idCv) {

        Optional<Cv> cv = cvServiceImpl.findById(idCv);

        if (!cv.isPresent())
            throw new CvNotFoundException("Le cv correspondant à l'id " + idCv + " n'existe pas");

        return cv;
    }

    @ApiOperation(value = "Supprimer un cv grâce à son ID à condition que celui-ci soit en base de donnée!")
    @DeleteMapping(value = "/cvs/{idCv}")
    public void supprimerCv(@PathVariable Long idCv) {
        cvServiceImpl.delete(idCv);
    }

    @ApiOperation(value = "Modifier un cv excepté que le cv passé en paramètre a le même Id qu'un cv existant")
    @PutMapping(value = "/Cvs")
    public void updateCv(@RequestBody Cv cv) {
        cvServiceImpl.save(cv);
    }
}
