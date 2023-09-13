package com.example.practice.controllers;

import com.example.practice.DTO.UserEntityDTO;
import com.example.practice.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserEntityController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/list")
    public Iterable<UserEntityDTO> getAllUsers() {
        return userEntityService.getAll();

    }

    @GetMapping("/byNickname/{nickname}")
    public UserEntityDTO getUserByNickname(@PathVariable String nickname) {
        return userEntityService.getUserByNickname(nickname);
    }

    @PutMapping("/{id}")
    public UserEntityDTO updateUser(@PathVariable int id, @RequestBody UserEntityDTO userEntity) {
        return userEntityService.editUserEntity(userEntity, id);
    }

    @GetMapping("/{id}")
    public com.example.practice.models.UserEntity getUserEntityById(@PathVariable int id) {
        return userEntityService.getUserEntityById(id);
    }

    @PostMapping("/add")
    public UserEntityDTO addUser(@RequestBody UserEntityDTO userEntity) {
        return userEntityService.saveUserEntity(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUserEntity(@PathVariable int id) {
        userEntityService.deleteUserEntity(id);
    }

}
