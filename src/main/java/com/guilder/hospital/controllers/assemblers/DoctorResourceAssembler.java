package com.guilder.hospital.controllers.assemblers;

import com.guilder.hospital.controllers.DoctorController;
import com.guilder.hospital.models.Doctor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public class DoctorResourceAssembler implements ResourceAssembler<Doctor, Resource<Doctor>> {

    @Override
    public Resource<Doctor> toResource(Doctor doctor) {

        return new Resource<>(doctor,
                linkTo(methodOn(DoctorController.class).one(doctor.getId())).withSelfRel(),
                linkTo(methodOn(DoctorController.class).all()).withRel("doctores"));
    }
}
