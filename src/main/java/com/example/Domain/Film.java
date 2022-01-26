package com.example.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String jenre;
    private String description;
    private int releaseYear;
    private String country;
    private Long producerId;
    private String imgUrl;
    private int ageLimit;
    private double rating;



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Film(){}

    public Film(String title, String jenre, String description, int releaseYear, String country, Long producerId, int ageLimit, String imgUrl) {
        this.title = title;
        this.jenre = jenre;
        this.description = description;
        this.releaseYear = releaseYear;
        this.country = country;
        this.producerId = producerId;
        this.ageLimit = ageLimit;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }


    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getJenre() {
        return jenre;
    }

    public void setJenre(String jenre) {
        this.jenre = jenre;
    }
}
