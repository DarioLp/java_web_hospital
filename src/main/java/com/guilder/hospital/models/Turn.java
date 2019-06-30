package com.guilder.hospital.models;

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
    private Doctor doctor;

    @ManyToOne
    @NotNull
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(mappedBy = "turn" , fetch = FetchType.EAGER)
    private Diagnostic diagnostic;

    public Turn() {
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
