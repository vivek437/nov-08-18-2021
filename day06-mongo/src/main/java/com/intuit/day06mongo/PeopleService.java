package com.intuit.day06mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    @Autowired
    private PersonRepository personRepository;

    public void savePerson(String firstName, String lastName, int age) {
        Person person = new Person();
        person.setAge(age);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        personRepository.save(person);
    }

    public List<Person> loadAllPersons() {
        return personRepository.getAll();
    }

    public void updateAge(String id, int age) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setAge(age);
            personRepository.save(person);
        }
    }

    public void delete(String id) {
        personRepository.deleteById(id);
    }

}
