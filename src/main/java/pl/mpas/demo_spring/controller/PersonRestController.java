package pl.mpas.demo_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mpas.demo_spring.dto.Address;
import pl.mpas.demo_spring.dto.Person;
@RestController
public class PersonRestController {

    @GetMapping("/person-as-rest")
    public Person getPersonAsJson(){

        Address address = new Address("Warsaw", "Nieznana", 10L);
        Person person = new Person("Mariusz", "P");
        person.setAddress(address);

        return person;

    }

}
