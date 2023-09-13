package com.example.practice.repositories;

import com.example.practice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("SELECT i FROM Item i WHERE i.game.genre = 'Шутер'")
    List<Item> findItemByShooterGame();

    List<Item> findItemByName(String name);
}
