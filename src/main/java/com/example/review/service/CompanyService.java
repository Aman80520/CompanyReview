package com.example.review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.review.model.Company;


@Service
public class CompanyService {
	
	public CompanyService() {
	 companyList.add(new Company(1, "Capgemini", "Noida", "IT Services"));
     companyList.add(new Company(2, "Infosys", "Bengaluru", "Consulting"));
     companyList.add(new Company(3, "TCS", "Mumbai", "Software Development"));
     companyList.add(new Company(4, "HDFC Bank", "Delhi", "Finance"));
     companyList.add(new Company(5, "Reliance Industries", "Mumbai", "Manufacturing"));
 }


    private List<Company> companyList = new ArrayList<>();

    // CREATE
    public void addCompany(Company company) {
        companyList.add(company);
    }

    // READ - get all companies
    public List<Company> getAllCompanies() {
        return new ArrayList<>(companyList);
    }

    // READ - get company by ID
    public Company getCompanyById(int id) {
        for (Company company : companyList) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }

    // UPDATE - update fields
    public boolean updateCompany(int id, Company updatedCompany) {
        for (Company company : companyList) {
            if (company.getId() == id) {
                company.setName(updatedCompany.getName());
                company.setLocation(updatedCompany.getLocation());
                company.setCompanyType(updatedCompany.getCompanyType());
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteCompany(int id) {
        return companyList.removeIf(company -> company.getId() == id);
    }
}