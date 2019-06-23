package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
