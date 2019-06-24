package com.guilder.hospital.repositories;


import com.guilder.hospital.models.Diagnostic;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosticRepository extends CrudRepository<Diagnostic,Long> {
}
