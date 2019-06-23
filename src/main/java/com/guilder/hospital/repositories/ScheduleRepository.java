package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule,Long> {
}
