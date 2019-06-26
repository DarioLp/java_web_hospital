package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<Turn,Long> {
}
