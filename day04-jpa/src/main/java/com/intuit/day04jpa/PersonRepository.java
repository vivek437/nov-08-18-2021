package com.intuit.day04jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    //findBy, findAllBy

    List<Person> findAllByName(String name);
    List<Person> findAllByNameAndAge(String name, int age);
    List<Person> findAllByAgeAndName(int age, String name);
    List<Person> findAllByIdAndAge(int id, int age);
    List<Person> findAllByIdAndNameAndAge(int id, String name, int age);

    Person findByName(String name);
    Person findByNameAndAge(String name, int age);
    Person findByAgeAndName(int age, String name);
    Person findByIdAndAge(int id, int age);
    Person findByIdAndNameAndAge(int id, String name, int age);

    List<Person> findAllByAgeBetween(int start, int end);
    List<Person> findAllByAgeGreaterThan(int age);
}
