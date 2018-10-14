package pl.mpas.demo_spring.service;

import pl.mpas.demo_spring.dto.Person;

import java.util.Optional;

public interface PersonService {

    void savePerson(Person personToSave);

    Optional<Person> findPersonById(Long personId);
}
