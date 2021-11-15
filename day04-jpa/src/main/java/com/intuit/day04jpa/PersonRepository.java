package com.intuit.day04jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select p from Person p where p.age between :p1 and :p2")
    List<Person> getPersonsWithAgeInRange(@Param("p1") int start, @Param("p2") int end);

    @Modifying
    @Query("update Person p set p.age= :p2 where p.id = :p1")
    void updateAge(@Param("p1") int id, @Param("p2") int age);

    @Query(value = "select * from persons p where p.age between :p1 and :p2", nativeQuery = true)
    List<Person> getPersonsWithAgeBetween(@Param("p1") int start, @Param("p2") int end);

    //findBy, findAllBy, getAllBy, getBy

    List<Person> findAllByNameInAndAgeIn(List<String> names, List<Integer> ages);
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
