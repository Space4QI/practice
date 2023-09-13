package com.example.practice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table (name = "Item")
public class Item extends BaseEntity{

    private String name;
    private String description;
    private String quality;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Item(String name, String description, String quality){
        this.name = name;
        this.description = description;
        this.quality = quality;
    }

    public Item(){

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

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
