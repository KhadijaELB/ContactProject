package com.contacts.appContact.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CompanyDto {
	private Integer id;
    private String adresse;
    private Double tva;
    private Set<Integer> contacts= new HashSet<>();
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
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public Set<Integer> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Integer> contacts) {
		this.contacts = contacts;
	}
    
    

}
