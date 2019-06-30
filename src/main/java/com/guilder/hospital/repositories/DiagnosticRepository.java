package com.guilder.hospital.repositories;


import com.guilder.hospital.models.Diagnostic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosticRepository extends CrudRepository<Diagnostic,Long> {

    @Query(value ="SELECT * FROM diagnostic d LEFT OUTER Join turn t on d.turn_id=t.id where t.user_id= :user_id ",nativeQuery = true)
    List<Diagnostic> findDiagnosticsByUser(@Param("user_id") Long user_id);
}
