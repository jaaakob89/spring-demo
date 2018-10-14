package pl.mpas.demo_spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.demo_spring.dao.AddressDao;
import pl.mpas.demo_spring.dao.PersonDao;
import pl.mpas.demo_spring.dto.Address;
import pl.mpas.demo_spring.dto.Person;
import pl.mpas.demo_spring.service.PersonService;

import java.util.Optional;

@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String showPersonData(Model model) {

        logger.info("showPersonData()");

        // 1 zapis
        Address address = new Address("Warsaw", "Nieznana", 10L);
        Person personToSave = new Person("Mariusz", "P");
        personToSave.setAddress(address);

        logger.info("Person before save: {}", personToSave);

        personService.savePerson(personToSave);

        logger.info("Person after save: {}", personToSave);

        Optional<Person> maybePerson = personService.findPersonById(personToSave.getId());
        maybePerson.ifPresent(person -> {
            logger.info("Person read from db: {}", person);
            model.addAttribute("data", person);
        });

        return "persons/osoby";
    }
}
