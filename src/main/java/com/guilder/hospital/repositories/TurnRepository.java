package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurnRepository extends JpaRepository<Turn,Long> {

    @Query(value ="SELECT * FROM turn t inner join doctor d on t.doctor_id = d.id where d.specialty_id= :spacialtyId and t.date = :date order by t.hour ASC",nativeQuery = true)
    List<Turn> findTurnsReserved(@Param("spacialtyId") Long specialtyId, @Param("date") String date);

    @Query(value ="SELECT * FROM turn t inner join doctor d on t.doctor_id = d.id where d.id= :doctorId and t.date = :date order by t.hour ASC",nativeQuery = true)
    List<Turn> findTurnsReservedWithDoctor(@Param("doctorId") Long doctorId, @Param("date") String date);

}
