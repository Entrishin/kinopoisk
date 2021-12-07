package com.example.Controller;

import com.example.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping("/") //подставить нужный адрес
    public String addFilmRate(@RequestParam Long userId,
                              @RequestParam Long filmId,
                              @RequestParam Double rate) {
        ratingService.addRating(userId, filmId, rate);

        //метод для просчета полей favoriteFilm favoriteJenre favoriteActor favoriteProducer в таблице User исходя из его оценок
        //после каждой проставленной оценки поля будут пересчитываться

        ratingService.updateFavoriteFilm(userId);
        //ratingService.updateFavoriteJenre(userId);
        //ratingService.updateFavoriteActor(userId);
        //ratingService.updateFavoriteProducer(userId);

        return ""; //вернуть нужную view
    }

}
