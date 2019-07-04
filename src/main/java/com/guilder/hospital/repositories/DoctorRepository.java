package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query(value ="SELECT * FROM doctor d WHERE d.specialty_id = :spacialtyId",nativeQuery = true)
    List<Doctor> findDoctorsBySpecialty(@Param("spacialtyId") Long specialtyId);

}
