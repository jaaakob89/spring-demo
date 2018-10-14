package pl.mpas.demo_spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mpas.demo_spring.dao.AddressDao;
import pl.mpas.demo_spring.dao.PersonDao;
import pl.mpas.demo_spring.dto.Person;
import pl.mpas.demo_spring.service.PersonService;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private PersonDao personDao;
    private AddressDao addressDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, AddressDao addressDao) {
        this.personDao = personDao;
        this.addressDao = addressDao;
    }

    @Override
    public void savePerson(Person personToSave) {

        logger.info("savePerson() with argument: {}", personToSave);
        personDao.save(personToSave);
    }

    @Override
    public Optional<Person> findPersonById(Long personId) {

        logger.info("Trying to find person of id: {}", personId);
        return personDao.findById(personId);
    }
}
