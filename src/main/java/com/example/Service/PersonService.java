package com.example.Service;

import com.example.Domain.Person;
import com.example.Repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public String addPerson(String fullName,String dateOfBirth, String placeOfBirth) {
        Person person = new Person();
        personRepo.save(person);
        return "OK";
    }
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }
}
