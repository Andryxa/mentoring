package ru.andryxa.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andryxa.spring.DTO.UserDTO;
import ru.andryxa.spring.entity.User;
import ru.andryxa.spring.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(userDTO.getSurname());
        return userDTO;
    }

    public User getUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        return user;
    }

    public List<UserDTO> getListOfUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepo.findAll();
        for (User user : userList) {
            userDTOList.add(getUserDTO(user));
        }
        return userDTOList;
    }

    public UserDTO save(UserDTO userDTO){
        userRepo.save(getUser(userDTO));
        return userDTO;
    }

    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
