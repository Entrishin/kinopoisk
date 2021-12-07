package com.example.Service;

import com.example.Domain.Person;
import com.example.Repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public String addPerson(String fullName,String dateOfBirth, String placeOfBirth) {
        Person person = new Person(fullName,dateOfBirth,placeOfBirth);
        personRepo.save(person);
        return "OK";
    }
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public void updateProducerFilms(Long filmId, Long personId) {
        Person person = personRepo.findById(personId).get();
        Set<Long> producerFilmsFromDb = person.getProducerFilms();
        //если в поле producerFilms пусто, создаем новый сет, если НЕ пусто, то добавляем в уже имеющийся
        Set<Long> producerFilmsFromView;
        if (producerFilmsFromDb.isEmpty())
            producerFilmsFromView = new HashSet<>();
        else
            producerFilmsFromView = person.getProducerFilms();
        producerFilmsFromView.add(filmId);
        personRepo.updateProducerFilms(producerFilmsFromView, personId);
    }

    public void updateActorFilms(Long filmId,  Long personId) {
        Person person = personRepo.findById(personId).get();
        Set<Long> actorFilmsFromDb = person.getActorFilms();
        //если в поле producerFilms пусто, создаем новый сет, если НЕ пусто, то добавляем в уже имеющийся
        Set<Long> actorFilmsFromView;
        if (actorFilmsFromDb.isEmpty())
            actorFilmsFromView = new HashSet<>();
        else
            actorFilmsFromView = person.getActorFilms();
        actorFilmsFromView.add(filmId);
        personRepo.updateActorFilms(actorFilmsFromView, personId);
    }
}
