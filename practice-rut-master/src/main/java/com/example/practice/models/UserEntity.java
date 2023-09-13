package com.example.practice.models;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@Table (name = "UserEntity")
public class UserEntity extends BaseEntity{

    @OneToMany(mappedBy = "user", targetEntity = ReviewEntity.class, cascade = CascadeType.MERGE)
    private List<ReviewEntity> reviews;

    @OneToMany(mappedBy = "user", targetEntity = Market.class, cascade = CascadeType.MERGE)
    private List<Market> market;

    private String email;
    private String password;
    private String nickname;
    private LocalDateTime registrationDate;

    public UserEntity(List<ReviewEntity> reviews, List<Market> market, String email, String password, String nickname, LocalDateTime registrationDate){
        this.reviews = reviews;
        this.market = market;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.registrationDate = registrationDate;
    }

    public UserEntity(){

    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public List<Market> getMarket() {
        return market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
