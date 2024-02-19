package br.com.leonardosr.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonardosr.data.vo.v1.PersonVO;
import br.com.leonardosr.exceptions.ResourceNotFoundException;
import br.com.leonardosr.mapper.Mapper;
import br.com.leonardosr.model.Person;
import br.com.leonardosr.repositories.PersonRepository;

@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	private PersonRepository repository;
	
	public List<PersonVO> findAll() {
		logger.info("Finding all people.");
		return Mapper.parseListObjects(repository.findAll(), PersonVO.class);	
	}
	
	public PersonVO findById(Long id) {
		logger.info("Finding one Person.");
		return Mapper.parseObject(
				repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID.")), 
				PersonVO.class) ;
	} 
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one Person.");
		var entity = Mapper.parseObject(person, Person.class);
		return Mapper.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one Person.");
		Person entity = repository.findById(person.getId())
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return Mapper.parseObject(repository.save(entity), PersonVO.class) ;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one Person.");
		
		Person entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID."));
		
		repository.delete(entity);
	}
}
