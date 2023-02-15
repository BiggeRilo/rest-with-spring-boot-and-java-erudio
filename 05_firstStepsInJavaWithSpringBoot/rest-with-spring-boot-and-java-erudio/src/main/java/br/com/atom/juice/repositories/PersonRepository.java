package br.com.atom.juice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atom.juice.data.vo.v1.PersonVO;
import br.com.atom.juice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
