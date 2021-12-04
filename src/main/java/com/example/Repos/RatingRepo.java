package com.example.Repos;

import com.example.Domain.Film;
import com.example.Domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Long> {

}
