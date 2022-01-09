package com.example.Service;

import com.example.Domain.Person;
import com.example.Repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public Long addPerson(String fullName,String dateOfBirth, String placeOfBirth) {
        Person person = new Person(fullName,dateOfBirth,placeOfBirth);
        personRepo.save(person);
        return person.getId();
    }

    public Long addPerson(Person person) {
        personRepo.save(person);
        return person.getId();
    }


    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public Optional<Person> getOnePerson(long person_id) {
        List<Person> all = getAllPersons();
        Optional<Person> result = all.stream().filter(person -> (person.getId().equals(person_id))).findFirst();

        return result;
    }

}
