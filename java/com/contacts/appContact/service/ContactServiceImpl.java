package com.contacts.appContact.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.contacts.appContact.dto.ContactDto;
import com.contacts.appContact.model.Company;
import com.contacts.appContact.model.Contact;
import com.contacts.appContact.repo.CompanyRepository;
import com.contacts.appContact.repo.ContactRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	@Resource
    private ContactRepository contactRepository;
    @Resource
    private CompanyRepository companyRepository;
    @Transactional
    @Override
    public ContactDto addContact(ContactDto contactDto) {
        Contact contact = new Contact();
        mapDtoToEntity(contactDto, contact);
        Contact savedContact = contactRepository.save(contact);
        return mapEntityToDto(savedContact);
    }
    @Transactional
    @Override
    public ContactDto updateContact(Integer id, ContactDto contactDto) {
    	Contact cnt = contactRepository.getOne(id);
    	cnt.getCompanies().clear();
        mapDtoToEntity(contactDto, cnt);
        Contact contact = contactRepository.save(cnt);
        return mapEntityToDto(contact);
    }
    @Override
    public String deleteContact(Integer contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        if(contact.isPresent()) {
        	contact.get().removeCompanies();
        	contactRepository.deleteById(contact.get().getId());
            return "Contact with id: " + contactId + " deleted successfully!";
        }
        return null;
    }
    @Transactional
    @Override
    public String addContactToCompany(String companyAdresse, ContactDto contactDto) {
    	Company company = companyRepository.findByAdresse(companyAdresse);
    	 if(company !=null) {
    		 Set<String> cmp =contactDto.getCompanies();
    		 cmp.add(companyAdresse);
    		 contactDto.setCompanies(cmp);
    		 addContact(contactDto);
    		 return "Contact is added to the company located in : " + companyAdresse + "successfully!";
    	 }
    	return null;
    	
    }
	 private void mapDtoToEntity(ContactDto contactDto, Contact contact) {
		 
		 contact.setAdresse(contactDto.getAdresse());
		 contact.setFirstname(contactDto.getFirstname());
		 contact.setLastname(contactDto.getLastname());
		 contact.setType(contactDto.getType());
		 contact.setTva(contactDto.getTva());
	        if (null == contact.getCompanies()) {
	        	contact.setCompanies(new HashSet<>());
	        }
	        contactDto.getCompanies().stream().forEach(companyAdresse -> {
	            Company company = companyRepository.findByAdresse(companyAdresse);
	            if (null == company) {
	            	company = new Company();
	            	company.setContacts(new HashSet<>());
	            }
	            company.setAdresse(companyAdresse);
	            contact.addCompany(company);
	        });
	       }
	    
	    private ContactDto mapEntityToDto( Contact contact) {
	    	ContactDto responseDto = new ContactDto();
	    	responseDto.setTva(contact.getTva());
	    	responseDto.setType(contact.getType());
	    	responseDto.setAdresse(contact.getAdresse());
	    	responseDto.setLastname(contact.getLastname());
	        responseDto.setFirstname(contact.getFirstname());
	        responseDto.setId(contact.getId());
	        responseDto.setCompanies(contact.getCompanies().stream().map(Company::getAdresse).collect(Collectors.toSet()));
	        return responseDto;
	    }
}
