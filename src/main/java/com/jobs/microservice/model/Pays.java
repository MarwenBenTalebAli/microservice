package com.jobs.microservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
public class Pays {
    @Id
    @GeneratedValue
    private Long idPays;
    @OneToMany(mappedBy = "pays")
    private Set<Region> regions;
}
