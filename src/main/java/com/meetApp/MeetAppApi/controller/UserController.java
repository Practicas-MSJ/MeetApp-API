package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.User;
import com.meetApp.MeetAppApi.service.EventService;
import com.meetApp.MeetAppApi.service.MessageService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private EventService eventService;

    // Lista todos los usuarios
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users;

        users = userService.findAllUsers();

        return users;
    }

    // Busca un usuario por ID
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        User user = userService.findUser(id);
        return user;
    }

    // Borra un usuarios
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable long id) {
        User user = userService.deleteUser(id);
        return user;
    }

    // Registra un nuevo usuario
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return newUser;
    }

    // Modifica un usuario
    @PutMapping("/user/{id}")
    public User modifyUser(@RequestBody User user, @PathVariable long id) {
        User newUser = userService.modifyUser(user, id);
        return newUser;
    }
}
