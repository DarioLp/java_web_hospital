package com.guilder.hospital.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fistName;

    @NotNull
    private String lastName;

    private String address;

    private String cuil;

    @NotNull
    @Column(unique = true)
    private String dni;

    @NotNull
    private String password;

    /* @OneToMany(mappedBy = "user")
    private List<Turn> turns; */
    
    @ManyToOne
    @NotNull
    @JoinColumn(name="role_id")
    private Role role;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Doctor doctor;

    private boolean isBloqued;

    private Date dateBloqued;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /* public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    } */

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isBloqued() {
        return isBloqued;
    }

    public void setBloqued(boolean bloqued) {
        isBloqued = bloqued;
    }

    public Date getDateBloqued() {
        return dateBloqued;
    }

    public void setDateBloqued(Date dateBloqued) {
        this.dateBloqued = dateBloqued;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", cuil='" + cuil + '\'' +
                ", dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                /* ", turns=" + turns + */
                ", role=" + role +
                ", doctor=" + doctor +
                ", isBloqued=" + isBloqued +
                ", dateBloqued=" + dateBloqued +
                '}';
    }
}
