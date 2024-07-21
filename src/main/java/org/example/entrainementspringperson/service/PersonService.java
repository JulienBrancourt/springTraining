package org.example.entrainementspringperson.service;

import org.example.entrainementspringperson.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private List<Person> persons;

    public PersonService() {
        this.persons = new ArrayList<Person>();

        Person person1 = Person
                .builder()
                .id(UUID.randomUUID())
                .name("John")
                .age(18)
                .build();

        Person person2 = Person
                .builder()
                .id(UUID.randomUUID())
                .name("Jane")
                .age(22)
                .build();

        Person person3 = Person
                .builder()
                .id(UUID.randomUUID())
                .name("Mike")
                .age(16)
                .build();

        Person person4 = Person
                .builder()
                .id(UUID.randomUUID())
                .name("Robert")
                .age(54)
                .build();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Person> getPersonsByName(String name) {
         List<Person> personToFindName = persons
                 .stream()
                 .filter(p -> name.equals(p.getName()))
                 .toList();
         return personToFindName;
    }

    public List<Person> getPersonsById(UUID id) {
        List<Person> personToFindId = persons.stream().filter(p -> id.equals(p.getId())).toList();
        return personToFindId;
    }
}
