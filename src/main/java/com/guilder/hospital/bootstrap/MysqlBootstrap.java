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
        if(roleRepository.count() == 0L){
            Role user = new Role();
            user.setRole("ROLE_USER");

            Role admin = new Role();
            admin.setRole("ROLE_ADMIN");

            roleRepository.save(user);
            roleRepository.save(admin);
        }

    }


}

