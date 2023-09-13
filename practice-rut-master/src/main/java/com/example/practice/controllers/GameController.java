package com.example.practice.controllers;

import com.example.practice.DTO.GameDTO;
import com.example.practice.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/list")
    public Iterable<GameDTO> getAllGame() {
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public GameDTO getGameById(@PathVariable int id) {
        return gameService.getGameById(id);
    }

    @PutMapping("/{id}")
    public GameDTO updateGame(@PathVariable int id, @RequestBody GameDTO game) {
        return gameService.editGame(game, id);
    }

    @GetMapping("/{userId}/reviews")
    public List<GameDTO> getGamesByUserReview(@PathVariable int userId) {
        return gameService.getGamesByUserReview(userId);
    }

    @GetMapping("/findByName/{name}")
    public List<GameDTO> getGamesByName(@PathVariable String name){
        return gameService.getGamesByName(name);
    }

    @PostMapping("/add")
    public GameDTO addGame(@RequestBody GameDTO game) {
        return gameService.saveGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }
}