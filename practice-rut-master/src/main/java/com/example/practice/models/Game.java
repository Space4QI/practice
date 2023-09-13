package com.example.practice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table (name = "Game")
public class Game extends BaseEntity {

    @OneToMany(mappedBy = "game", targetEntity = ReviewEntity.class, cascade = CascadeType.MERGE)
    private List<ReviewEntity> reviews;

    @OneToMany(mappedBy = "game", targetEntity = Item.class, cascade = CascadeType.MERGE)
    private List<Item> item;

    @OneToMany(mappedBy = "game", targetEntity = Market.class, cascade = CascadeType.MERGE)
    private List<Market> market;

    private String name;
    private String description;
    private Double price;
    private String genre;

    public Game(List<ReviewEntity> reviews, List<Item> item, List<Market> market, String name,String description, Double price, String genre){
        this.reviews = reviews;
        this.item = item;
        this.market = market;
        this.name = name;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }

    public Game(){

    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Market> getMarket() {
        return market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
