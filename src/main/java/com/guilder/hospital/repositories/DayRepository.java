package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day,Long> {
}
