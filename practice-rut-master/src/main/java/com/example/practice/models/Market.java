package com.example.practice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Market")
public class Market extends BaseEntity{

    @ManyToOne
    @JoinColumn (name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn (name = "game_id")
    private Game game;

    public Market(){

    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
