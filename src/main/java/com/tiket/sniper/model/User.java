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

    public String nama;

    @Column(unique = true, length = 150)
    public String email;

    @Column(length = 50)
    public String level;

    private String password;

}
