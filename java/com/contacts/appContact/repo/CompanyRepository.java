package com.contacts.appContact.repo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.contacts.appContact.model.*;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public  Company findByAdresse(String companyAdresse);
	
}
