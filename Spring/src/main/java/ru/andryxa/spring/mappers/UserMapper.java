package ru.andryxa.spring.mappers;

import ru.andryxa.spring.DTO.UserDTO;
import ru.andryxa.spring.entity.User;

public class UserMapper {
    public UserMapper() {
    }

    public static UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        return userDTO;
    }

    public static User getUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        return user;
    }
}
