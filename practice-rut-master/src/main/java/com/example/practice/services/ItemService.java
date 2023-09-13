package com.example.practice.services;

import com.example.practice.models.Item;
import com.example.practice.DTO.ItemDTO;
import com.example.practice.mappers.ItemMapper;
import com.example.practice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public Iterable<ItemDTO> getAll() {
        return itemRepository.findAll()
                .stream().map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItemDTO getItemById(int id) {
        if (itemRepository.findById(id).isPresent())
            return  itemMapper.toDTO(itemRepository.findById(id).get());
        else
            throw new IllegalArgumentException("Ошибка: прдмета с таким id нет");
    }

    public Item editItem(Item updatedItem, int id) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setQuality(updatedItem.getQuality());
                    item.setDescription(updatedItem.getDescription());
                    item.setName(updatedItem.getName());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить предмет, т.к. нет предмета с таким id"));
    }

    public List<ItemDTO> getShooterGameItems() {
        return itemRepository.findItemByShooterGame().stream()
                .map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ItemDTO> getItemsByName(String name) {
        List<ItemDTO> items = itemRepository.findItemByName(name).stream().map(itemMapper::toDTO).collect(Collectors.toList());
        return items;
    }

    public ItemDTO saveItem(ItemDTO item) {
        return itemMapper.toDTO(itemRepository.save(itemMapper.toEntity(item)));
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
