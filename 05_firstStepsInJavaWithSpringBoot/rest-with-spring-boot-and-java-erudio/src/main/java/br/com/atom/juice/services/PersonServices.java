package br.com.atom.juice.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atom.juice.exceptions.ResouceNotFoundException;
import br.com.atom.juice.model.Person;
import br.com.atom.juice.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public Person findById(Long id) {

		logger.info("Finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));
	}

	public List<Person> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	public Person create(Person person) {

		logger.info("Creating one Person!");

		return repository.save(person);
	}

	public Person update(Person person) {

		logger.info("Updating one Person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

		entity.setFirstname(person.getFirstname());
		entity.setLastname(person.getLastname());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public void delete(Long id) {

		logger.info("Deleting one Person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

		repository.delete(entity);
	}

}
