package com.guilder.hospital.controllers.assemblers;

import com.guilder.hospital.controllers.SpecialtyController;
import com.guilder.hospital.models.Specialty;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public class SpecialtyResourceAssembler implements ResourceAssembler<Specialty, Resource<Specialty>> {

    @Override
    public Resource<Specialty> toResource(Specialty specialty) {
        return new Resource<>(specialty,
                linkTo(methodOn(SpecialtyController.class).one(specialty.getId())).withSelfRel(),
                linkTo(methodOn(SpecialtyController.class).all()).withRel("specialties"));
    }
}
