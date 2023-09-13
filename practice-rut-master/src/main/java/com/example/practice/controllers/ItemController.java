package com.example.practice.controllers;

import com.example.practice.DTO.ItemDTO;
import com.example.practice.models.Item;
import com.example.practice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public Iterable<ItemDTO> getAllItem() { return itemService.getAll(); }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable int id) {return itemService.getItemById(id);}

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item) {
        return itemService.editItem(item, id);
    }

    @GetMapping("/shooter")
    public List<ItemDTO> getShooterGameItems() {
        return itemService.getShooterGameItems();
    }

    @GetMapping("/findByName/{name}")
    public List<ItemDTO> getItemsByName(@PathVariable String name){
        return itemService.getItemsByName(name);
    }

    @PostMapping("/add")
    public ItemDTO addItem(@RequestBody ItemDTO item) {
        return itemService.saveItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {itemService.deleteItem(id);
    }
}