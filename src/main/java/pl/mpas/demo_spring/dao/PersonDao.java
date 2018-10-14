package pl.mpas.demo_spring.dao;

import org.springframework.data.repository.CrudRepository;
import pl.mpas.demo_spring.dto.Person;

public interface PersonDao extends CrudRepository<Person, Long> {
}
