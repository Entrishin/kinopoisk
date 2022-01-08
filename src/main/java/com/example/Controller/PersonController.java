package com.example.Controller;

import com.example.Domain.Person;
import com.example.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public String addPerson(@RequestParam String fullName,
                          @RequestParam String dateOfBirth,
                          @RequestParam String placeOfBirth) {
        personService.addPerson(fullName,dateOfBirth,placeOfBirth);
        return ""; // view после добавления person
    }
    @GetMapping("/persons")
    public String getAllPersons(Model model) {
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("persons", allPersons);
        return "people"; //view с отображением все persons
    }



}
