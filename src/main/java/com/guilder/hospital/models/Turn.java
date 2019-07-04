package com.guilder.hospital.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date date;

    @NotNull
    private Time hour;

    @NotNull
    private boolean attended;

    @ManyToOne
    @NotNull
    @JoinColumn(name="doctor_id")
    @JsonIgnoreProperties(value ={"fistName", "lastName","enrollment", "user", "specialty"})
    private Doctor doctor;

    @ManyToOne
    @NotNull
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties(value ={"fistName", "lastName","address", "cuil", "dni","role", "doctor", "isBloqued", "dateBloqued", "turns", "bloqued"})
    private User user;

    @OneToOne(mappedBy = "turn", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value ={"description", "turn"})
    private Diagnostic diagnostic;

    public Turn() {
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turn turn = (Turn) o;
        return Objects.equals(id, turn.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
