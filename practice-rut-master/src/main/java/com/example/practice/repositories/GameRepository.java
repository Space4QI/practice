package com.example.practice.repositories;

import com.example.practice.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query("SELECT DISTINCT g FROM Game g JOIN g.reviews r WHERE r.user.id = :userId")
    List<Game> findGamesByUserReview(@Param("userId") int userId);

    List<Game> findGameByName(String name);
}
