package com.github.caroltmaciel.codechallenge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
    private String companyIdentifier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Contract> contracts;

    public Client() {
    }

    //Person Constructor
    public Client(Long id, Integer phone, String email, String name, LocalDate birthDate) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public void setCompanyIdentifier(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}