package com.example.Controller;

import com.example.Domain.Film;
import com.example.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("getAllFilms")
    private List<Film> getAllFilms(){
        return filmService.getAllFilms();
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

    @PostMapping("addFilm2")
    private Object addFilm2(@RequestBody Object test) {
        return test;
    }


}
