package com.tiket.sniper.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Table(name = "user_login")
@Entity
public class User {

    @Id
    @Column(length = 50)
    public Integer nik;

    @Column(length = 100)
    public String name;

    @Column(unique = true, length = 150)
    public String email;

    @Column(length = 50)
    public String level;

    private String password;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
