package com.contacts.appContact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.appContact.dto.CompanyDto;
import com.contacts.appContact.dto.ContactDto;
import com.contacts.appContact.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
    private CompanyService companyService;
   
    @PostMapping("/company")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
    	CompanyDto cmp = companyService.addCompany(companyDto);
        return new ResponseEntity<>(cmp, HttpStatus.CREATED);
        
    }
    @PutMapping("/company/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable(name = "id") Integer id,
            @RequestBody CompanyDto company) {
    	CompanyDto cmp = companyService.updateCompany(id, company);
        return new ResponseEntity<>(cmp, HttpStatus.CREATED);
    }
    
    
}
