package com.guilder.hospital.controllers;

import com.guilder.hospital.Exceptions.DoctorNotFoundException;
import com.guilder.hospital.controllers.assemblers.DoctorResourceAssembler;
import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.repositories.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
public class DoctorController {

    private final DoctorRepository doctorRepository;

    private final DoctorResourceAssembler assembler;

    public DoctorController(DoctorRepository doctorRepository, DoctorResourceAssembler assembler){
        this.doctorRepository = doctorRepository;
        this.assembler = assembler;
    }


    @GetMapping ("/api/v1/doctors")
    public Resources<Resource<Doctor>> all(){
        List<Resource<Doctor>> doctors = doctorRepository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(doctors,
                linkTo(methodOn(DoctorController.class).all()).withSelfRel());

    }

    @PostMapping("/api/v1/doctors")
    Doctor newDoctor(@RequestBody Doctor newDoctor) {
        return doctorRepository.save(newDoctor);
    }


    @GetMapping("/api/v1/doctors/{id}")
    public Resource<Doctor> one(@PathVariable Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        return assembler.toResource(doctor);
    }

    @PutMapping("/api/v1/doctors/{id}")
    Doctor replaceDoctor(@RequestBody Doctor d, @PathVariable Long id) {

        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setFistName(d.getFistName());
                    doctor.setLastName(d.getLastName());
                    doctor.setEnrollment(d.getEnrollment());
                    doctor.setSpecialty(d.getSpecialty());
                    doctor.setSchedules(d.getSchedules());
                    doctor.setTurns(d.getTurns());
                    return doctorRepository.save(doctor);
                })
                .orElseGet(() -> {
                    d.setId(id);
                    return doctorRepository.save(d);
                });
    }

    @DeleteMapping("/api/v1/doctors/{id}")
    void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }

}
