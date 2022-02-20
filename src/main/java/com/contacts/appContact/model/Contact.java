package com.contacts.appContact.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CONTACT")
public class Contact {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_sequence")
    @SequenceGenerator(name = "contact_sequence", sequenceName = "contact_sequence")
    private Integer id;
	@Column(name = "adresse")
    private String adresse;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "type")
    @Enumerated(EnumType.STRING )
    private ContactType type;
    @Column(name = "tva")
    private Double tva;
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "CONTACT_COMPANY", joinColumns = { @JoinColumn(name = "CONTACT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "COMPANY_ID") })
    private Set<Company> companies;
    public void addCompany(Company company) {
        this.companies.add(company);
        company.getContacts().add(this);
    }
    public void removeCompany(Company company) {
        this.getCompanies().remove(company);
        company.getContacts().remove(this);
    }
    public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public void removeCompanies() {
        for (Company company : new HashSet<>(companies)) {
            removeCompany(company);
        }
    }
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
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
    
  
}
