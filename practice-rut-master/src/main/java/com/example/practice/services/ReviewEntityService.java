package com.example.practice.services;

import com.example.practice.DTO.ReviewEntityDTO;
import com.example.practice.mappers.ReviewEntityMapper;
import com.example.practice.repositories.ReviewEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewEntityService {

    private final ReviewEntityRepository reviewEntityRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Autowired
    public ReviewEntityService(ReviewEntityRepository reviewEntityRepository, ReviewEntityMapper reviewEntityMapper) {
        this.reviewEntityRepository = reviewEntityRepository;
        this.reviewEntityMapper = reviewEntityMapper;
    }

    public List<ReviewEntityDTO> getAll() {
        return reviewEntityRepository.findAll()
                .stream()
                .map(reviewEntityMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReviewEntityDTO getReviewById(int id) {
        if (reviewEntityRepository.findById(id).isPresent())
            return reviewEntityMapper.toDTO(reviewEntityRepository.findById(id).get());
        else
            throw new IllegalArgumentException("Ошибка: обзора с таким id нет");
    }

    public ReviewEntityDTO editReviewEntity(ReviewEntityDTO updatedReviewEntity, int id) {
        return reviewEntityRepository.findById(id)
                .map(reviewEntity -> {
                    reviewEntity.setScore(updatedReviewEntity.getScore());
                    reviewEntity.setSendingDate(updatedReviewEntity.getSendingDate());
                    reviewEntity.setAuthor(updatedReviewEntity.getAuthor());
                    reviewEntity.setText(updatedReviewEntity.getText());
                    return reviewEntityMapper.toDTO(reviewEntityRepository.save(reviewEntity));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить обзор, т.к. нет обзора с таким id"));
    }

    public List<ReviewEntityDTO> getReviewsByUserAndDate(int userId, LocalDateTime startDate) {
        return reviewEntityRepository.findReviewsByUserAndDate(userId, startDate).stream()
                .map(reviewEntityMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewEntityDTO> getReviewsByAuthor(String author) {
        List<ReviewEntityDTO> reviews = reviewEntityRepository.findReviewEntityByAuthor(author)
                .stream()
                .map(reviewEntityMapper::toDTO)
                .collect(Collectors.toList());
        return reviews;
    }

    public ReviewEntityDTO saveReview(ReviewEntityDTO review) {
        return reviewEntityMapper.toDTO(reviewEntityRepository.save(reviewEntityMapper.toEntity(review)));
    }

    public void deleteReviewEntity(int id) {
        reviewEntityRepository.deleteById(id);
    }
}