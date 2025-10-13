package com.github.caroltmaciel.codechallenge.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
public class Company {

    @Id
    private String companyIdentifier;

    public Company(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }

    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public void setCompanyIdentifier(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }
}
