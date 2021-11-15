package com.intuit.day04jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/{name}/{age}")
    public String savePerson(@PathVariable String name, @PathVariable int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return "Person with id: " + person.getId() + " is created";
    }

    //@Async
    @DeleteMapping("/{id}")
    public HttpEntity<Void> deletePerson(@PathVariable int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            personRepository.delete(person);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/{age}")  //modify all the fields in a record except say the primary key
    @PatchMapping("/{id}/{age}") //patch work; just modify one or more fields in the record
    public HttpEntity<Void> updateAge(@PathVariable int id, @PathVariable int age) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setAge(age);
            personRepository.save(person);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    //@PostConstruct
    public void after() {
        System.out.println(personRepository.getClass().getName());
        for (Method method : personRepository.getClass().getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }
}
