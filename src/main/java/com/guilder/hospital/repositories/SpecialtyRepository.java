package com.guilder.hospital.repositories;


import com.guilder.hospital.models.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
