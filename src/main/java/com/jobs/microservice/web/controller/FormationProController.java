package com.jobs.microservice.web.controller;

import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.FormationPro;
import com.jobs.microservice.service.CvServiceImpl;
import com.jobs.microservice.service.FormationProServiceImpl;
import com.jobs.microservice.web.exceptions.CvNotFoundException;
import com.jobs.microservice.web.exceptions.FormationProNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les Formations pro.")
@RestController
public class FormationProController {

    private FormationProServiceImpl formationProServiceImpl;
    private CvServiceImpl cvServiceImpl;

    @Autowired
    public FormationProController(FormationProServiceImpl formationProServiceImpl, CvServiceImpl cvServiceImpl) {
        this.formationProServiceImpl = formationProServiceImpl;
        this.cvServiceImpl = cvServiceImpl;
    }

    @ApiOperation(value = "Affiche la liste de tous les formations pro disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/formationsPro")
    public List<FormationPro> getFormationsPro() {

        List<FormationPro> formationsPro = formationProServiceImpl.findAll();

        if (formationsPro.isEmpty()) throw new FormationProNotFoundException("Aucunne formation pro n'est disponible");

        return formationsPro;

    }

    @ApiOperation(value = "Récupère une formation pro grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/formationsPro/{idFormationPro}")
    public Optional<FormationPro> getFormationPro(@PathVariable Long idFormationPro) {

        Optional<FormationPro> formationPro = formationProServiceImpl.findById(idFormationPro);

        if (!formationPro.isPresent())
            throw new FormationProNotFoundException("La formation pro correspondant à l'id " + idFormationPro + " n'existe pas");

        return formationPro;
    }

    @ApiOperation(value = "Récupère la liste des formations pro grâce à L'ID de cv à condition que celui-ci soit en base de donnée!")
    @PostMapping(value = "/formationsPro/{idCv}")
    public Collection<FormationPro> getListeFormationProByIdCv(@PathVariable Long idCv) {
        Optional<Cv> cv = cvServiceImpl.findById(idCv);

        if (!cv.isPresent())
            throw new CvNotFoundException("Le cv correspondant à l'id " + idCv + " n'existe pas");

        return cv.get().getFormationsPro();
    }

    @ApiOperation(value = "Supprimer une formation pro grâce à son ID à condition que celle-ci soit en base de donnée!")
    @DeleteMapping(value = "/formationsPro/{idFormationPro}")
    public void supprimerFormationPro(@PathVariable Long idFormationPro) {
        formationProServiceImpl.delete(idFormationPro);
    }

    @ApiOperation(value = "Modifier une formation pro excepté que la formation pro passé en paramètre a le même Id qu'une formation pro existant")
    @PutMapping(value = "/formationsPro")
    public void updateFormationPro(@RequestBody FormationPro formationPro) {
        formationProServiceImpl.save(formationPro);
    }
}
