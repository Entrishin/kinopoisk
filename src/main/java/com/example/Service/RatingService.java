package com.example.Service;

import com.example.Domain.Film;
import com.example.Domain.Rating;
import com.example.Domain.User;
import com.example.Repos.FilmRepo;
import com.example.Repos.RatingRepo;
import com.example.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    FilmRepo filmRepo;

    public void addRating(Long userId, Long filmId, Double rate) {
        Rating rating = new Rating();
        rating.setUserId(userId);
        rating.setFilmId(filmId);
        rating.setRating(rate);
        ratingRepo.save(rating);
    }

    public void updateFavoriteFilm(Long userId) {
        List<Rating> userFavorites = ratingRepo.findAllByUserId(userId);
        String favoriteFilm = "";

        if (userFavorites!= null) {

            //мапа фильм - оценка
            Map<Long,Double> filmRateMap = new TreeMap<>();
            for (Rating userFavorite : userFavorites) {
                filmRateMap.put(userFavorite.getFilmId(), userFavorite.getRating());
            }
            //берем самый первый элемент из сортированной мапы - это фильм с самой большой оценки
            Map.Entry<Long,Double> entry = filmRateMap.entrySet().iterator().next();

            favoriteFilm += filmRepo.findById(entry.getKey()).get().getTitle();
            userRepo.updateFavoriteFilmById(userId, favoriteFilm);

        }
    }

    public void updateFavoriteJenre(Long userId) {


    }
}
