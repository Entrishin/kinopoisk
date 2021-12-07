package com.example.Repos;

import com.example.Domain.Film;
import com.example.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {

    @Modifying
    @Transactional
    @Query("update Person p set p.producerFilms = :producerFilms where p.id = :producerId")
    int updateProducerFilms(@Param("producerFilms") Set<Long> producerFilms,
                           @Param("producerId") Long producerId);

    @Modifying
    @Transactional
    @Query("update Person p set p.actorFilms = :actorFilms where p.id = :producerId")
    int updateActorFilms(@Param("actorFilms") Set<Long> actorFilms,
                            @Param("producerId") Long producerId);

}
