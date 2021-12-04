package com.example.Domain;

import javax.persistence.*;


@Entity
@Table(name="usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String favoriteJenre;
    private String favoriteFilm;
    private String favoriteActor;
    private String favoriteProducer;


    public User(){}
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavoriteJenre() {
        return favoriteJenre;
    }

    public void setFavoriteJenre(String favoriteJenre) {
        this.favoriteJenre = favoriteJenre;
    }

    public String getFavoriteFilm() {
        return favoriteFilm;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        this.favoriteFilm = favoriteFilm;
    }

    public String getFavoriteActor() {
        return favoriteActor;
    }

    public void setFavoriteActor(String favoriteActor) {
        this.favoriteActor = favoriteActor;
    }

    public String getFavoriteProducer() {
        return favoriteProducer;
    }

    public void setFavoriteProducer(String favoriteProducer) {
        this.favoriteProducer = favoriteProducer;
    }
}
