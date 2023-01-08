package br.com.atom.juice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.atom.juice.model.Person;

@Service
public class PersonServices {

	private final AtomicLong conuter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {

		logger.info("Finding one person!");

		Person personMock = new Person();
		personMock.setId(conuter.incrementAndGet());
		personMock.setFirstname("Leando");
		personMock.setLastname("Costa");
		personMock.setAdress("Uberlandia - Minas Gerais - Brasil");
		personMock.setGender("Male");
		return personMock;

	}

	public List<Person> findAll() {

		logger.info("Finding all people!");

		List<Person> personsMock = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			personsMock.add(person);
		}

		return personsMock;
	}

	public Person create(Person person) {

		logger.info("Creating one Person!");

		return person;
	}

	public Person update(Person person) {

		logger.info("Updating one Person!");

		return person;
	}

	public void delete(String id) {

		logger.info("Deleting one Person!");

	}

	private Person mockPerson(int i) {
		Person personMock = new Person();
		personMock.setId(conuter.incrementAndGet());
		personMock.setFirstname("Person name " + i);
		personMock.setLastname("Last Name" + i);
		personMock.setAdress("Some adress in Brasil" + i);
		personMock.setGender("Male");
		return personMock;
	}

}
