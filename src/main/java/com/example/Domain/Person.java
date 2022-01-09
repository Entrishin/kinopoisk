package com.example.Domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;

    private String dateOfBirth;
    private String placeOfBirth;

    @Transient
    private List<Film> directedFilms;


    public Person() {}
    public Person(String fullName, String dateOfBirth, String placeOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setDirectedFilms(List<Film> DirectedFilms) {
        directedFilms = DirectedFilms;
    }

    public List<Film> getDirectedFilms() {
        return directedFilms;
    }
}
