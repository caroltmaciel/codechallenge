package com.github.caroltmaciel.codechallenge.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table
public class Client {

    @Id
    private Long id;
    private Integer phone;
    private String email;
    private String name;
    private Date birthDate;
    private String companyIdentifier;

    public Client() {
    }

    //Person Constructor
    public Client(Long id, Integer phone, String email, String name, Date birthDate) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    //Company Constructor
    public Client(Long id, Integer phone, String email, String name, String companyIdentifier) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.companyIdentifier = companyIdentifier;
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

    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public void setCompanyIdentifier(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }
}