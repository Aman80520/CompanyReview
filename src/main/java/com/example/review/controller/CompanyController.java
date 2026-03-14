package com.example.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.review.model.Company;
import com.example.review.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // CREATE
    @PostMapping
    public String addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return "Company added successfully!!!!";
    }

    // READ - get all companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // READ - get company by ID
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateCompany(@PathVariable int id, @RequestBody Company updatedCompany) {
        boolean updated = companyService.updateCompany(id, updatedCompany);
        return updated ? "Company updated successfully!" : "Company not found!";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable int id) {
        boolean deleted = companyService.deleteCompany(id);
        return deleted ? "Company deleted successfully!" : "Company not found!";
    }
}
