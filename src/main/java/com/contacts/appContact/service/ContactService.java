package com.contacts.appContact.service;

import com.contacts.appContact.dto.ContactDto;

public interface ContactService {
	public ContactDto addContact(ContactDto contactDto);
    public ContactDto updateContact(Integer contactId, ContactDto contact);
    public String deleteContact(Integer contactId);
    public String addContactToCompany(String adresseCompany, ContactDto contact);
}
