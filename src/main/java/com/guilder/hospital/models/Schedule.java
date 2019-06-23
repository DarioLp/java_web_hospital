package com.guilder.hospital.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day;
    private Date hour_since;
    private Date hour_to;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getHour_since() {
        return hour_since;
    }

    public void setHour_since(Date hour_since) {
        this.hour_since = hour_since;
    }

    public Date getHour_to() {
        return hour_to;
    }

    public void setHour_to(Date hour_to) {
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
}
