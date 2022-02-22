package com.contacts.appContact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.appContact.dto.ContactDto;
import com.contacts.appContact.model.ContactType;
import com.contacts.appContact.service.ContactService;

@RestController
public class ContactController {
	@Autowired
    private ContactService contactService;
   
    @PostMapping("/contact")
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) throws Exception {
    	if(contactDto.getType().equals(ContactType.FREELANCER) && contactDto.getTva()==null)throw new Exception("Freelancer should have a tva number"); 
    	ContactDto ctd = contactService.addContact(contactDto);
        return new ResponseEntity<>(ctd, HttpStatus.CREATED);
        
    }
    @PutMapping("/contact/{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable(name = "id") Integer id,
            @RequestBody ContactDto contact) {
    	ContactDto ctd = contactService.updateContact(id, contact);
        return new ResponseEntity<>(ctd, HttpStatus.CREATED);
    }
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable(name = "id") Integer contactId) {
        String message = contactService.deleteContact(contactId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/contactToCompnay/{adresse}")
    public ResponseEntity<String> addContactToCompany(@PathVariable(name = "adresse") String adresse,
            @RequestBody ContactDto contact) throws Exception {
    	String message = contactService.addContactToCompany(adresse, contact);
    	if (message == null)throw new Exception("company doesn't exist, it should be added before");
    	return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
