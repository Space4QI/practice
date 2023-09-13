package com.example.practice.controllers;

import com.example.practice.DTO.ReviewEntityDTO;
import com.example.practice.services.ReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewEntityController {

    private final ReviewEntityService reviewEntityService;

    @Autowired
    public ReviewEntityController(ReviewEntityService reviewEntityService) {
        this.reviewEntityService = reviewEntityService;
    }

    @GetMapping("/list")
    public Iterable<ReviewEntityDTO> getAllReviews() {
        return reviewEntityService.getAll();
    }

    @GetMapping("/{id}")
    public ReviewEntityDTO getReviewById(@PathVariable int id) {
        return reviewEntityService.getReviewById(id);
    }

    @PutMapping("/{id}")
    public ReviewEntityDTO updateReview(@PathVariable int id, @RequestBody ReviewEntityDTO reviewEntity) {
        return reviewEntityService.editReviewEntity(reviewEntity, id);
    }

    @GetMapping("/{userId}/{startDate}")
    public List<ReviewEntityDTO> getReviewsByUserAndDate(@PathVariable int userId, @PathVariable LocalDateTime startDate){
        return reviewEntityService.getReviewsByUserAndDate(userId, startDate);
    }

    @GetMapping("/byAuthor/{author}")
    public List<ReviewEntityDTO> getReviewsByAuthor(@PathVariable String author) {
        return reviewEntityService.getReviewsByAuthor(author);
    }

    @PostMapping("/add")
    public ReviewEntityDTO addReview(@RequestBody ReviewEntityDTO reviewEntity) {
        return reviewEntityService.saveReview(reviewEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewEntityService.deleteReviewEntity(id);
    }
}
