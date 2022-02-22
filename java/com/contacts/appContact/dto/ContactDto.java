package com.contacts.appContact.dto;

import java.util.HashSet;
import java.util.Set;

import com.contacts.appContact.model.ContactType;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContactDto {
	private Integer id;
    private String adresse;
    private String firstname;
    private String lastname;
    private ContactType type;
    public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	private Double tva;
    private Set<String> companies= new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public ContactType getType() {
		return type;
	}
	public void setType(ContactType type) {
		this.type = type;
	}
	public Set<String> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<String> companies) {
		this.companies = companies;
	}
    
}
