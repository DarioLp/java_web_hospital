package com.guilder.hospital.repositories;

import com.guilder.hospital.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
