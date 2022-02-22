package com.contacts.appContact.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contacts.appContact.dto.CompanyDto;
import com.contacts.appContact.dto.ContactDto;
import com.contacts.appContact.model.Company;
import com.contacts.appContact.model.Contact;
import com.contacts.appContact.repo.CompanyRepository;
import com.contacts.appContact.repo.ContactRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Resource
    private ContactRepository contactRepository;
    @Resource
    private CompanyRepository companyRepository;
    private ContactServiceImpl contactService;
    @Transactional
    @Override
    public CompanyDto addCompany(CompanyDto companyDto) {
        Company company = new Company();
        mapDtoToEntity(companyDto, company);
        Company savedCompany = companyRepository.save(company);
        return mapEntityToDto(savedCompany);
    }
    @Transactional
    @Override
    public CompanyDto updateCompany(Integer id, CompanyDto companyDto) {
    	Company cnt = companyRepository.getOne(id);
    	cnt.getContacts().clear();
        mapDtoToEntity(companyDto, cnt);
        Company company = companyRepository.save(cnt);
        return mapEntityToDto(company);
    }
    
    private void mapDtoToEntity(CompanyDto companyDto, Company company) {
		 
    	company.setAdresse(companyDto.getAdresse());
    	company.setTva(companyDto.getTva());
	        if (null == company.getContacts()) {
	        	company.setContacts(new HashSet<>());
	        }
	        companyDto.getContacts().stream().forEach(contactIdentifier -> {
	            Contact contact = contactRepository.getOne(contactIdentifier);
	            if (null == contact) {
	            	contact = new Contact();
	            	contact.setCompanies(new HashSet<>());
	            }
	            //contact.setAdresse(companyAdresse);
	            company.addContact(contact);
	        });
	       }
	    
	    private CompanyDto mapEntityToDto( Company company) {
	    	CompanyDto responseDto = new CompanyDto();
	    	responseDto.setTva(company.getTva());
	    	responseDto.setAdresse(company.getAdresse());
	        responseDto.setId(company.getId());
	        responseDto.setContacts(company.getContacts().stream().map(Contact::getId).collect(Collectors.toSet()));
	        return responseDto;
	    }
}
