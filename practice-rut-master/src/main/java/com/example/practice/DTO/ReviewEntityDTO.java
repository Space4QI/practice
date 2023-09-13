package com.example.practice.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.practice.models.UserEntity;

import java.time.LocalDateTime;

public class ReviewEntityDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("author")
    private String author;

    @JsonProperty("text")
    private String text;

    @JsonProperty("score")
    private int score;

    @JsonProperty("sendingDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendingDate;

    @JsonProperty("user")
    @JsonIgnore
    private UserEntityDTO user;

    public ReviewEntityDTO() {
    }

    public ReviewEntityDTO(int id, int userId, LocalDateTime sendingDate, String author, String text, int score, UserEntityDTO user){
        this.id = id;
        this.userId = userId;
        this.sendingDate = sendingDate;
        this.author = author;
        this.text = text;
        this.score = score;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(LocalDateTime sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UserEntityDTO getUser() {
        return user;
    }

    public void setUser(UserEntityDTO user) {
        this.user = user;
    }

}
