package com.example.practice.repositories;

import com.example.practice.models.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, Integer> {
    @Query("SELECT r FROM ReviewEntity r WHERE r.user.id = :userId AND r.sendingDate >= :startDate")
    List<ReviewEntity> findReviewsByUserAndDate(@Param("userId") int userId, @Param("startDate")LocalDateTime startDate);

    List<ReviewEntity> findReviewEntityByAuthor (String author);
}
