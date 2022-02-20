package com.contacts.appContact.repo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.contacts.appContact.model.*;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>  {

}
