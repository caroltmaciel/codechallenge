package com.github.caroltmaciel.codechallenge.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table
public class Person {

    @Id
    private Long id;
    private Integer phone;
    private String email;
    private String name;
    private Date birthDate;

    public Person() {
    }

    public Person(Integer phone, String email, String name, Date birthDate) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(Long id, String name, String email) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
