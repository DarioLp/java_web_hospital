package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TurnRepository extends JpaRepository<Turn,Long> {

}
