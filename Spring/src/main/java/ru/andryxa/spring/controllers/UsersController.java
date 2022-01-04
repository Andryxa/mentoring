package ru.andryxa.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.andryxa.spring.entity.Users;
import ru.andryxa.spring.repo.UserRepo;

@RestController
public class UsersController {

    private final UserRepo userRepo;

    @Autowired
    public UsersController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public Iterable<Users> home() {
        return userRepo.findAll();
    }

    @DeleteMapping("/deleteUser")
    public String delete(@RequestParam("id") int id) {
        userRepo.deleteById(id);
        return "deleted";
    }

    @PostMapping("/createUser")
    public String newUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname) {
        Users user = new Users();
        user.setName(name);
        user.setSurname(surname);
        userRepo.save(user);
        return "add new user";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("surname") String surname) {

        Users user = userRepo.findById(id);
        user.setName(name);
        user.setSurname(surname);
        userRepo.save(user);
        return "Updated!!!";
    }
}
