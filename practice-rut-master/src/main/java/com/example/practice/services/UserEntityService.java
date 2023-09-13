package com.example.practice.services;

import com.example.practice.DTO.UserEntityDTO;
import com.example.practice.mappers.UserEntityMapper;
import com.example.practice.models.UserEntity;
import com.example.practice.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;

    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository, UserEntityMapper userEntityMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
    }

    public Iterable<UserEntityDTO> getAll() {
        return userEntityRepository.findAll()
                .stream()
                .map(userEntityMapper::toDTO).
                collect(Collectors.toList());
    }

    public UserEntity getUserEntityById(int id) {
        if (userEntityRepository.findById(id).isPresent())
            return userEntityRepository.findById(id).get();
        else
            throw new IllegalArgumentException("Ошибка: пользователя с таким id нет");
    }

    public UserEntityDTO editUserEntity(UserEntityDTO updatedUserEntity, int id) {
        return userEntityRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setRegistrationDate(updatedUserEntity.getRegistrationDate());
                    userEntity.setEmail(updatedUserEntity.getEmail());
                    userEntity.setNickname(updatedUserEntity.getNickname());
                    userEntity.setPassword(updatedUserEntity.getPassword());
                    return  userEntityMapper.toDTO(userEntityRepository.save(userEntity));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить пользователя, т.к. нет пользователя с таким id"));
    }

    public UserEntityDTO getUserByNickname(String nickname) {
        UserEntity user = userEntityRepository.findUserEntityByNickname(nickname);
        if (user != null) {
            return userEntityMapper.toDTO(user);
        } else {
            return null;
        }
    }

    public UserEntityDTO saveUserEntity(UserEntityDTO userEntity) {
        return userEntityMapper.toDTO(userEntityRepository.save(userEntityMapper.toEntity(userEntity)));
    }

    public void deleteUserEntity(int id) {
        userEntityRepository.deleteById(id);
    }
}
