package com.example.Service;

import com.example.Controller.FileController;
import com.example.Domain.Film;
import com.example.Domain.Person;
import com.example.Repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmService {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private PersonService personService;

    public List<Film> getAllFilms() {
        List <Film> result = filmRepo.findAll();
        Collections.sort(result,(Film A, Film B)->A.getId().compareTo(B.getId()));
        return result;
    }

    public Film getOneFilm(long film_id){
        return filmRepo.getOne(film_id);
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

    public void updateFilm(Film film){
        Film DBPer = filmRepo.getOne(film.getId());
        DBPer.setImgUrl(film.getTitle());
        DBPer.setAgeLimit(film.getAgeLimit());
        DBPer.setCountry(film.getCountry());
        DBPer.setDescription(film.getDescription());
        DBPer.setReleaseYear(film.getReleaseYear());
        DBPer.setJenre(film.getJenre());
        DBPer.setProducerId(film.getProducerId());
        filmRepo.save(DBPer);
    }

    public void deleteFilm(Film film){
        filmRepo.delete(filmRepo.getOne(film.getId()));
    }


    public int ClearFilms(){
        {
            int result = 0;
            List<Film> allFilms = this.getAllFilms();
            List<Person> allPersons = personService.getAllPersons();
            for (Film f: allFilms
            ) {
                if(!allPersons.contains(personService.getOnePerson(f.getProducerId()))) {
                    this.deleteFilm(f);
                    result++;
                }
            }
            return result;
        }
    }
}
