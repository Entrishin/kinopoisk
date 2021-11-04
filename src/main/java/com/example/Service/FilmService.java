package com.example.Service;

import com.example.Domain.Film;
import com.example.Repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FilmService {
    @Autowired
    private FilmRepo filmRepo;

    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }
    public String addFilm(String title, String jenre, String description, int releaseYear, String country, Long producerId, Set<Long> actorsId, int ageLimit) {
        Film film = new Film(title,jenre,description,releaseYear,country,producerId,actorsId,ageLimit);
        filmRepo.save(film);
        return "OK";
    }
}
