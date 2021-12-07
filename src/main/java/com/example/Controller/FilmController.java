package com.example.Controller;

import com.example.Domain.Film;
import com.example.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    private String getAllFilms(Model model){
        List<Film> allFilms = filmService.getAllFilms();
        model.addAttribute("films",allFilms);
        return "index";
    }

    /*@GetMapping("getAllFilms")
    private List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }*/

    @GetMapping("filmItem")
    private String getOneFilm(@RequestParam int id,Model model){
        Film findFilm = filmService.getOneFilm(id).get();
        model.addAttribute("film", findFilm);
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

    @PostMapping("addFilm")
    private String addFilm(@RequestParam String title,
                           @RequestParam String jenre,
                           @RequestParam String description,
                           @RequestParam int releaseYear,
                           @RequestParam String country,
                           @RequestParam Long producerId,
                           @RequestParam Set<Long> actorsId,
                           @RequestParam int ageLimit) {
        return filmService.addFilm(title, jenre, description, releaseYear, country, producerId, actorsId, ageLimit);
    }

    /*@PostMapping("addFilm2")
    private Object addFilm2(@RequestBody Object test) {
        return test;
    }*/


}
