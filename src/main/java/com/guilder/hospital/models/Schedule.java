package com.guilder.hospital.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name="day_id")
    @JsonIgnore
    @NotNull
    private Day day;

    @NotNull
    private Time hour_since;

    @NotNull
    private Time hour_to;

    @ManyToOne
    @NotNull
    @JoinColumn(name="doctor_id")
    @JsonIgnoreProperties(value ={"fistName", "lastName","enrollment", "user", "specialty"})
    private Doctor doctor;

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Time getHour_since() {
        return hour_since;
    }

    public void setHour_since(Time hour_since) {
        this.hour_since = hour_since;
    }

    public Time getHour_to() {
        return hour_to;
    }

    public void setHour_to(Time hour_to) {
        this.hour_to = hour_to;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
