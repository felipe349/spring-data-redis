package br.com.felipe.redislearn.repository;

import br.com.felipe.redislearn.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {

    @Override
    List<Person> findAll();
}


