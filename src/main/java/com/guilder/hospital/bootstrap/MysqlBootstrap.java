package com.guilder.hospital.bootstrap;

import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.models.Role;
import com.guilder.hospital.models.Specialty;
import com.guilder.hospital.models.User;
import com.guilder.hospital.repositories.DoctorRepository;
import com.guilder.hospital.repositories.RoleRepository;
import com.guilder.hospital.repositories.SpecialtyRepository;
import com.guilder.hospital.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"dev", "prod"})
public class MysqlBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private DoctorRepository doctorRepository;
    private SpecialtyRepository specialtyRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public MysqlBootstrap(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData(){

/*
        if (specialtyRepository.count() == 0L && doctorRepository.count() == 0L && userRepository.count() == 0L && roleRepository.count() == 0L){
            Specialty specialty = new Specialty();
            specialty.setName("Cardiologia");
            specialty.setDescription("Especialidad que se ocupa de problemas cardiacos");
            specialtyRepository.save(specialty);


            Role role = new Role();
            role.setRole("DOCTOR");
            roleRepository.save(role);



            User user = new User();
            user.setFistName("Nick");
            user.setLastName("Riviera");
            user.setDni("12345678");
            user.setPassword("1234");
            user.setRole(role);
            userRepository.save(user);

            Doctor doctor = new Doctor();
            doctor.setFistName("Nick");
            doctor.setLastName("Riviera");
            doctor.setSpecialty(specialty);
            doctor.setEnrollment("123456");
            doctor.setUser(user);

            System.out.println("LOOOOOG: " + role.toString());
            System.out.println("LOOOOOG: " + specialty.toString());
            System.out.println("LOOOOOG: " + doctor.toString());
            System.out.println("LOOOOOG: " + user.toString());
            doctorRepository.save(doctor);
        }

*/
    }


}

