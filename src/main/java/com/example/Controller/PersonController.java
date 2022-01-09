package com.example.Controller;

import com.example.Domain.Film;
import com.example.Domain.Person;
import com.example.Service.FilmService;
import com.example.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private FilmService FilmService;

    @GetMapping("/addPerson")
    private String personForm(Model model){
        model.addAttribute("person", new Person());
        return "addperson";
    }
    @PostMapping("/addPerson")
    public String addPerson(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        personService.addPerson(person);
        return "redirect:/persons"; // view после добавления person
    }

    @GetMapping("/persons")
    public String getAllPersons(Model model) {
        List<Person> allPersons = personService.getAllPersons();
        for(Person p : allPersons){
            p.setDirectedFilms(FilmService.getFilmsByDirector(p.getId()));
        }
        model.addAttribute("persons", allPersons);
        return "people"; //view с отображением все persons
    }



}
