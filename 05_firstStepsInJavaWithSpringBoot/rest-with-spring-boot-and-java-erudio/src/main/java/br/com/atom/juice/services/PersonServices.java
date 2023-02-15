package br.com.atom.juice.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atom.juice.data.vo.v1.PersonVO;
import br.com.atom.juice.data.vo.v2.PersonVOV2;
import br.com.atom.juice.exceptions.ResouceNotFoundException;
import br.com.atom.juice.mapper.DozerMapper;
import br.com.atom.juice.mapper.custom.PersonMapper;
import br.com.atom.juice.model.Person;
import br.com.atom.juice.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;

	
	public PersonVO findById(Long id) {

		logger.info("Finding one person!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO create(PersonVO person) {

		logger.info("Creating one Person!");

		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 person) {

		logger.info("Creating one Person with v2!");

		var entity = mapper.convertVOToEntity(person);

		var vo = mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {

		logger.info("Updating one Person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one Person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("No records found for this ID"));

		repository.delete(entity);
	}

}
