package com.example.Service;

import com.example.Domain.Film;
import com.example.Domain.Person;
import com.example.Repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmService {
    @Autowired
    private FilmRepo filmRepo;

    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    public Optional<Film> getOneFilm(long film_id){
        List <Film> all = getAllFilms();
        Optional<Film> result = all.stream().filter(film ->( film.getId().equals(film_id))).findFirst();

        return result;
    }

    public List<Film> getFilmsByDirector(long directorId){
        List <Film> all = getAllFilms();
        List <Film> result = all.stream().filter(film ->( film.getProducerId().equals(directorId))).collect(Collectors.toList());
        return result;
    }

    public Optional<Film> getFilmByTitle(String film_title){
        List <Film> all = getAllFilms();
        Optional<Film> result = all.stream().filter(film ->( film.getTitle().equals(film_title))).findFirst();

        return result;
    }

    public Long addFilm(String title, String jenre, String description, int releaseYear, String country, Long producerId, Set<Long> actorsId, int ageLimit, String imgUrl) {
        Film film = new Film(title,jenre,description,releaseYear,country,producerId,actorsId,ageLimit,imgUrl);
        filmRepo.save(film);
        return film.getId();
    }
    public Long addFilm(Film film) {
        filmRepo.save(film);
        return film.getId();
    }
}
