package ru.andryxa.spring.service;

import ru.andryxa.spring.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getListOfUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    void delete(int id);
}
