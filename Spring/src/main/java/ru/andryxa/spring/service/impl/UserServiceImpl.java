package ru.andryxa.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.andryxa.spring.dto.UserDTO;
import ru.andryxa.spring.entity.User;
import ru.andryxa.spring.repo.UserRepo;
import ru.andryxa.spring.service.UserService;
import ru.andryxa.spring.mappers.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDTO> getListOfUsers() {
        return userRepo.findAll().stream().map(UserMapper::getUserDTO).toList();
    }

    public UserDTO createUser(UserDTO userDTO) {
        User userSaved = userRepo.save(UserMapper.getUser(userDTO));
        return UserMapper.getUserDTO(userSaved);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepo.findById(userDTO.getId()).orElseThrow();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        return UserMapper.getUserDTO(userRepo.save(user));
    }

    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
