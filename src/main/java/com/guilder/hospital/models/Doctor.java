package com.guilder.hospital.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fistName;

    @NotNull
    private String lastName;

    @NotNull
    private String enrollment;

    @OneToOne
    @NotNull
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value ={"fistName", "lastName","address", "cuil", "dni","role", "doctor", "isBloqued", "dateBloqued", "turns"})
    private User user;


    @ManyToOne()
    @JoinColumn(name="specialty_id")
    @JsonIgnoreProperties(value ={"name", "description","doctors"})
    @NotNull
    private Specialty specialty;

    
    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties(value ={"date", "hour","attended", "doctor", "user","diagnostic"})
    private List<Turn> turns;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties(value ={"day", "hour_since","hour_to", "doctor"})
    private List<Schedule> schedules;
   
    public Doctor() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    
    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollment='" + enrollment + '\'' +
                ", user=" + user +
                ", specialty=" + specialty +
                /* ", turns=" + turns +
                ", schedules=" + schedules + */
                '}';
    }
}
