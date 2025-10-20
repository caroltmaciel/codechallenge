package com.github.caroltmaciel.codechallenge.dto;

import com.github.caroltmaciel.codechallenge.domain.Person;

import java.util.Date;

public class PersonDto {
    private Long id;
    private Integer phone;
    private String email;
    private String name;
    private Date birthDate;

    public PersonDto() {
    }

    public PersonDto(Person obj) {
        id = obj.getId();
        phone = obj.getPhone();
        email = obj.getEmail();
        name = obj.getName();
        birthDate = obj.getBirthDate();
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
