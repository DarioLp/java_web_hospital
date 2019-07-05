package com.guilder.hospital.repositories;

import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(value ="SELECT * FROM role r WHERE r.role LIKE %:role%",nativeQuery = true)
    Role getRole(@Param("role") String role);
}
