package com.example.Controller;

import com.example.Domain.Person;
import com.example.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public String addPerson(@RequestParam String fullName,
                          @RequestParam String dateOfBirth,
                          @RequestParam String placeOfBirth) {
        return personService.addPerson(fullName,dateOfBirth,placeOfBirth);
    }
    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

}
