package br.com.leonardosr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leonardosr.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
