package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.DTO.UserDTO;
import ru.andryxa.spring.service.UserService;
import java.util.List;

@RestController
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

   @GetMapping("/users")
    public List<UserDTO> userList() {
        return userService.getListOfUsers();
    }

    @PostMapping("/createUser")
    public UserDTO newUser(@RequestParam("name") String name,
                           @RequestParam("surname") String surname) {
        UserDTO user = new UserDTO(0, name, surname);
        userService.save(user);
        return user;
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("surname") String surname) {
        UserDTO userDTO= new UserDTO(id, name, surname);
        userService.save(userDTO);
        return userDTO;
    }

    @DeleteMapping("/deleteUser")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "User with id=" + id + " has been deleted!";
    }
}
