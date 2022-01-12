package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.DTO.UserDTO;
import ru.andryxa.spring.service.impl.UserServiceImpl;
import java.util.List;

@RestController
public class UsersController {

    private final UserServiceImpl userService;

    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

   @GetMapping("/users")
    public List<UserDTO> userList() {
        return userService.getListOfUsers();
    }

    @PostMapping("/createUser")
    public UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "User with id=" + id + " has been deleted!";
    }
}
