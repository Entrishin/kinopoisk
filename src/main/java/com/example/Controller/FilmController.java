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

import java.util.List;
import java.util.Set;

@Controller
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    private String getAllFilms(Model model){
        List<Film> allFilms = filmService.getAllFilms();
        model.addAttribute("films",allFilms);
        return "index";
    }

    @GetMapping("/mainadd")
    private String showMenuAdd(){
        return "mainadd";
    }

    @GetMapping("filmItem")
    private String getOneFilm(@RequestParam int id,Model model){
        Film findFilm = filmService.getOneFilm(id).get();
        model.addAttribute("film", findFilm);
        Person findPerson = personService.getOnePerson(findFilm.getProducerId()).get();
        model.addAttribute("director", findPerson);
        return "item";
    }

    @GetMapping("/findItem")
    private String getOneFilm(Model model){
        model.addAttribute("film2", new Film());
        return "searchitem";
    }
    @PostMapping("/findItem")
    private String getOneFilm(@ModelAttribute Film film2, Model model){
        Film findFilm = filmService.getFilmByTitle(film2.getTitle()).get();
        model.addAttribute("film", findFilm);
        return "item";
    }

    @GetMapping("/addfilm")
    private String addFilm(Model model){
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("persons", allPersons);
        model.addAttribute("film", new Film());
        return "addfilm";
    }

    @PostMapping("addFilm")
    private String addFilm(@ModelAttribute Film film, @RequestParam("file") MultipartFile file, Model model) {
        /*FileController FC = new FileController();
        film.setImgUrl(FC.uploadFile(file,"filmIMG_" + film.getTitle()));*/
        Long filmId = filmService.addFilm(film);
        return "redirect:/"; //view после добавления фильма в БД
    }

}
