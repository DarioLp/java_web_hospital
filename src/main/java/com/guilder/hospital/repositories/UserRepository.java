package com.guilder.hospital.repositories;

import com.guilder.hospital.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value ="SELECT * FROM user u WHERE u.dni = :dni",nativeQuery = true)
    User findByDni(@Param("dni") String dni);

    @Query(value ="SELECT count(*) FROM user u WHERE u.dni = :dni",nativeQuery = true)
    int countByDni(@Param("dni") String dni);

    @Query(value ="SELECT count(*) FROM user u  " +
            "INNER JOIN turn t ON t.user_id = u.id " +
            "WHERE u.dni = :dni " +
            "AND t.date <= :date " +
            "AND t.hour < :hour",nativeQuery = true)
    int countDidNotAttendByDni(@Param("dni") String dni,@Param("date") String date,@Param("hour") String hour);
}
