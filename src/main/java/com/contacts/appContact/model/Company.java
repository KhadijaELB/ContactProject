package com.contacts.appContact.model;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class Company {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    @SequenceGenerator(name = "company_sequence", sequenceName = "company_sequence")
    private Integer id;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "tva")
    private Double tva;
    @ManyToMany(mappedBy = "companies")
    @JsonIgnore
    private Set<Contact> contacts;
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
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	 public void addContact(Contact contact) {
	        this.contacts.add(contact);
	        contact.getCompanies().add(this);
	    }

}
