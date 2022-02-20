package com.contacts.appContact.service;

import com.contacts.appContact.dto.CompanyDto;
import com.contacts.appContact.dto.ContactDto;

public interface CompanyService {
	public CompanyDto addCompany(CompanyDto companyDto);
    public CompanyDto updateCompany(Integer companyId, CompanyDto company);

}
