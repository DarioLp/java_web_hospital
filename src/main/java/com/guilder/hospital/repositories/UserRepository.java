package com.guilder.hospital.repositories;

import com.guilder.hospital.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
