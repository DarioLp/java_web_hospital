package com.guilder.hospital.controllers;

import com.guilder.hospital.exceptions.UserNotFoundException;
import com.guilder.hospital.models.User;
import com.guilder.hospital.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @GetMapping ("/api/v1/users")
    List <User> list(){
        return userRepository.findAll();
    }

    @PostMapping("/api/v1/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }


    @GetMapping("/api/v1/users/{id}")
    User one(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/api/v1/users/{id}")
    User replaceTurn(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setFistName(user.getFistName());
                    user.setLastName(user.getLastName());
                    user.setAddress(user.getAddress());
                    user.setCuil(user.getCuil());
                    user.setDni(user.getDni());
                    user.setRole(user.getRole());
                    //user.setTurns(user.getTurns());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/api/v1/users/{id}")
    void deleteTurn(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
