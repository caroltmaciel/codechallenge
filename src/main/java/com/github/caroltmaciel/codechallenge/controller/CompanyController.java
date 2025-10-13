package com.github.caroltmaciel.codechallenge.controller;

import com.github.caroltmaciel.codechallenge.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/companies")
@RestController
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }
}
