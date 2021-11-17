package com.intuit.day06mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    //findAll, find, getAll, get
    List<Person> findAllByFirstName(String firstName);
    List<Person> findAllByFirstNameAndLastName(String firstName, String lastName);
    Person findByAge(int age);
    Person findByAgeBetween(int start, int end);

    @Query(value = "{}", fields = "{'firstName': 1, 'lastName': 1, 'id': 0, 'age': 1}")
    List<Person> getAll();

    @Query(value = "{'firstName': $0}", fields = "{'firstName': 1, 'lastName': 1, 'id': 0, 'age': 0}")
    List<Person> getAllPersonsWithFirstName(String firstName);

    @Query(value = "{$gte: $0, $lt: 1}")
    List<Person> getPersonsInAgeRange(int start, int end);

}
