package com.example.practice.mappers;

import com.example.practice.DTO.ReviewEntityDTO;
import com.example.practice.models.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {

    private final ModelMapper reviewEntityMap;

    @Autowired
    public ReviewEntityMapper(ModelMapper reviewEntityMap){
        this.reviewEntityMap = reviewEntityMap;
    }

    public ReviewEntityDTO toDTO(ReviewEntity input){
        return reviewEntityMap.map(input, ReviewEntityDTO.class);
    }

    public ReviewEntity toEntity(ReviewEntityDTO input) {
        return reviewEntityMap.map(input, ReviewEntity.class);
    }


}
