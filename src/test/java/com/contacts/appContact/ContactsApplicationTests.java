package com.contacts.appContact;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contacts.appContact.*;

// @SpringBootTest(classes = ContactsApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
class ContactsApplicationTests {

	@Test
	void contextLoads() {
	}

}
