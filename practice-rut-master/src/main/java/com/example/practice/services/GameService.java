package com.example.practice.services;

import com.example.practice.DTO.GameDTO;
import com.example.practice.mappers.GameMapper;
import com.example.practice.mappers.ReviewEntityMapper;
import com.example.practice.repositories.GameRepository;
import com.example.practice.repositories.ReviewEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.practice.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final ReviewEntityRepository reviewEntityRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Autowired
    public GameService(GameRepository gameRepository, GameMapper gameMapper, ReviewEntityRepository reviewEntityRepository, ReviewEntityMapper reviewEntityMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
        this.reviewEntityRepository = reviewEntityRepository;
        this.reviewEntityMapper = reviewEntityMapper;
    }

    public List<GameDTO> getAll() {
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GameDTO getGameById(int id) {
        if (gameRepository.findById(id).isPresent())
            return gameMapper.toDTO(gameRepository.findById(id).get());
        else
            throw new IllegalArgumentException("Ошибка: игры с таким id нет");
    }

    public GameDTO editGame(GameDTO updatedGame, int id) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setPrice(updatedGame.getPrice());
                    game.setName(updatedGame.getName());
                    game.setDescription(updatedGame.getDescription());
                    game.setGenre(updatedGame.getGenre());
                    return  gameMapper.toDTO(gameRepository.save(game));
                })
                .orElseThrow(() -> new EntityNotFoundException("Ошибка: невозможно обновить игру, т.к. нет игры с таким id"));
    }

    public List<GameDTO> getGamesByUserReview(int userId) {
        return gameRepository.findGamesByUserReview(userId).stream()
                .map(gameMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<GameDTO> getGamesByName(String name) {
        List<GameDTO> games = gameRepository.findGameByName(name).stream().map(gameMapper::toDTO).collect(Collectors.toList());
        return games;
    }

    public GameDTO saveGame(GameDTO game) {
        return gameMapper.toDTO(gameRepository.save(gameMapper.toEntity(game)));
    }

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }
}