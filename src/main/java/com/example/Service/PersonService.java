package com.example.Service;

import com.example.Controller.FileController;
import com.example.Domain.Film;
import com.example.Domain.Person;
import com.example.Repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private FilmService filmService;

    public Long addPerson(String fullName,String dateOfBirth, String placeOfBirth) {
        Person person = new Person(fullName,dateOfBirth,placeOfBirth);
        personRepo.save(person);
        return person.getId();
    }

    public Long addPerson(Person person) {
        personRepo.save(person);
        return person.getId();
    }


    public List<Person> getAllPersons() {
        List <Person> result = personRepo.findAll();
        Collections.sort(result,(Person A, Person B)->A.getId().compareTo(B.getId()));
        //return personRepo.findAll();
        return result;
    }

    public Person getOnePerson(long person_id) {
        return personRepo.getOne(person_id);
    }

    public void updatePerson(Person person){
        Person DBPer = personRepo.getOne(person.getId());
        DBPer.setFullName(person.getFullName());
        DBPer.setDateOfBirth(person.getDateOfBirth());
        DBPer.setPlaceOfBirth(person.getPlaceOfBirth());
        DBPer.setImgUrl(person.getImgUrl());
        personRepo.save(DBPer);
    }

    public void deletePerson(Person person){
        List<Film> films = filmService.getFilmsByDirector(person.getId());
        for (Film f: films
             ) {
            filmService.deleteFilm(f);
        }
        personRepo.delete(personRepo.getOne(person.getId()));
    }

}
