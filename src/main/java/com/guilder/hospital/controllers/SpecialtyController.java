package com.guilder.hospital.controllers;


import com.guilder.hospital.controllers.assemblers.SpecialtyResourceAssembler;
import com.guilder.hospital.exceptions.SpecialtyNotFoundException;
import com.guilder.hospital.models.Specialty;
import com.guilder.hospital.repositories.SpecialtyRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
public class SpecialtyController {

    private final SpecialtyRepository repository;

    private final SpecialtyResourceAssembler assembler;

    public SpecialtyController(SpecialtyRepository specialtyRepository, SpecialtyResourceAssembler assembler){
        this.repository = specialtyRepository;
        this.assembler = assembler;
    }


    @GetMapping("/api/v1/specialties")
    public Resources<Resource<Specialty>> all(){
        List<Resource<Specialty>> specialties = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(specialties,
                linkTo(methodOn(SpecialtyController.class).all()).withSelfRel());
    }

    @PostMapping("/api/v1/specialties")
    Specialty newSpecialty(@RequestBody Specialty newSpecialty) {
        return repository.save(newSpecialty);
    }


    @GetMapping("/api/v1/specialties/{id}")
    public Resource<Specialty> one(@PathVariable Long id) {

        Specialty specialty = repository.findById(id)
                .orElseThrow(() -> new SpecialtyNotFoundException(id));
        return assembler.toResource(specialty);
    }

    @PutMapping("/api/v1/specialties/{id}")
    Specialty replaceSpecialty(@RequestBody Specialty s, @PathVariable Long id) {

        return repository.findById(id)
                .map(specialty -> {
                    if (s.getDescription() != null) specialty.setDescription(s.getDescription());
                    if (s.getName() != null) specialty.setName(s.getName());
                    if (s.getDoctors() != null) specialty.setDoctors(s.getDoctors());
                    return repository.save(specialty);
                })
                .orElseGet(() -> {
                    s.setId(id);
                    return repository.save(s);
                });
    }

    @DeleteMapping("/api/v1/specialties/{id}")
    void deleteSpecialty(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
