package com.example.Controller;

import com.example.Domain.Film;
import com.example.Domain.Person;
import com.example.Service.FilmService;
import com.example.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String addPerson(@ModelAttribute Person person, @RequestParam("file") MultipartFile file, Model model) {
        FileController FC = new FileController();
        personService.addPerson(person);
        person.setImgUrl(FC.uploadFile(file, "personIMG_" + person.getFullName() + person.getId()));
        personService.updatePerson(person);
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

    @GetMapping("/personItem")
    public  String getOnePerson(@RequestParam int id,Model model){
        Person person = personService.getOnePerson(id);
        person.setDirectedFilms(FilmService.getFilmsByDirector(id));
        model.addAttribute("person", person);
        return "directorItem";
    }

    @GetMapping("/updatePerson")
    public String updatePersonForm(@RequestParam int id,Model model){
        Person person = personService.getOnePerson(id);
        model.addAttribute("person", person);
        return "updateDirForm";
    }

    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute Person person, @RequestParam("file") MultipartFile file, Model model){
        //добавить логику
        if (!file.isEmpty()) {
            FileController FC = new FileController();
            person.setImgUrl(FC.uploadFile(file, "personIMG_" + person.getFullName() + person.getId()));
        }
        personService.updatePerson(person);
        return "redirect:/personItem?id="+person.getId();  //переделать на personItem?Id=person.id
    }

    @PostMapping("/deletePerson")
    public String deletePerson(@ModelAttribute Person person, Model model){
        model.addAttribute("person", person);
        personService.deletePerson(person);
        return "redirect:/persons";
    }

}
