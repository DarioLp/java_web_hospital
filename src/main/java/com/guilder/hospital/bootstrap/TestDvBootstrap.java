package com.guilder.hospital.bootstrap;

import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.models.Specialty;
import com.guilder.hospital.repositories.DoctorRepository;
import com.guilder.hospital.repositories.SpecialtyRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class TestDvBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private DoctorRepository doctorRepository;
    private SpecialtyRepository specialtyRepository;

    public TestDvBootstrap(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Specialty specialty = new Specialty();

        specialty.setName("Cardiologia");
        specialty.setDescription("Especialidad que se ocupa de problemas cardiacos");
        Doctor doctor = new Doctor();
        doctor.setFistName("Nick");
        doctor.setLastName("Riviera");
        doctor.setSpecialty(specialty);
        doctor.setEnrollment("123456");

        specialtyRepository.save(specialty);
        doctorRepository.save(doctor);
    }
}
