package com.jobs.microservice.web.controller;


import com.jobs.microservice.model.Cv;
import com.jobs.microservice.model.Experience;
import com.jobs.microservice.service.CvServiceImpl;
import com.jobs.microservice.service.ExperienceServiceImpl;
import com.jobs.microservice.web.exceptions.CvNotFoundException;
import com.jobs.microservice.web.exceptions.ExperienceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD sur les Experiences.")
@RestController
public class ExperienceController {
    private ExperienceServiceImpl experienceServiceImpl;
    private CvServiceImpl cvServiceImpl;

    @Autowired
    public ExperienceController(ExperienceServiceImpl experienceServiceImpl, CvServiceImpl cvServiceImpl) {
        this.experienceServiceImpl = experienceServiceImpl;
        this.cvServiceImpl = cvServiceImpl;
    }

    @ApiOperation(value = "Affiche la liste de tous les experiences disponibles à condition qu'ils sont en base de donnée!")
    @GetMapping(value = "/experiences")
    public List<Experience> getExperiences() {

        List<Experience> experiences = experienceServiceImpl.findAll();

        if (experiences.isEmpty()) throw new ExperienceNotFoundException("Aucunne experience n'est disponible");

        return experiences;

    }

    @ApiOperation(value = "Récupère une experience grâce à son ID à condition que celui-ci soit en base de donnée!")
    @GetMapping(value = "/experiences/{idExperience}")
    public Optional<Experience> getExperience(@PathVariable Long idExperience) {

        Optional<Experience> experience = experienceServiceImpl.findById(idExperience);

        if (!experience.isPresent())
            throw new ExperienceNotFoundException("L' experience correspondant à l'id " + idExperience + " n'existe pas");

        return experience;
    }

    @ApiOperation(value = "Récupère la liste des experiences grâce à L'ID de cv à condition que celui-ci soit en base de donnée!")
    @PostMapping(value = "/experiences/{idCv}")
    public Collection<Experience> getListeExperienceByIdCv(@PathVariable Long idCv) {
        Optional<Cv> cv = cvServiceImpl.findById(idCv);

        if (!cv.isPresent())
            throw new CvNotFoundException("Le cv correspondant à l'id " + idCv + " n'existe pas");

        return cv.get().getExperiences();
    }

    @ApiOperation(value = "Supprimer une experience grâce à son ID à condition que celle-ci soit en base de donnée!")
    @DeleteMapping(value = "/experiences/{idExperience}")
    public void supprimerExperience(@PathVariable Long idExperience) {
        experienceServiceImpl.delete(idExperience);
    }

    @ApiOperation(value = "Modifier une experience excepté que l'experience passé en paramètre a le même Id qu'une experience existant")
    @PutMapping(value = "/experiences")
    public void updateFormation(@RequestBody Experience experience) {
        experienceServiceImpl.save(experience);
    }
}
