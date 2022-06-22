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
        logger.info("Prepare a list for all users");
        List<User> users;

        logger.info("Find all users");
        users = userService.findAllUsers();

        logger.info("End find all users");
        return users;
    }

    // Busca un usuario por ID
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        logger.info("Find user by ID: " + id);
        User user = userService.findUser(id);

        logger.info("End find user by ID: " +id);
        return user;
    }

    // Borra un usuarios
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable long id) {
        logger.info("Delete user with ID: " + id);
        User user = userService.deleteUser(id);

        logger.info("End delete user with ID: " + id);
        return user;
    }

    // Registra un nuevo usuario
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        logger.info("Register a new user", user);
        User newUser = userService.addUser(user);

        logger.info("End register a new user", user);
        return newUser;
    }

    // Modifica un usuario
    @PutMapping("/user/{id}")
    public User modifyUser(@RequestBody User user, @PathVariable long id) {
        logger.info("Modify a user with ID: " + id, user);
        User newUser = userService.modifyUser(user, id);

        logger.info("End modify a user with ID: " + id, user, newUser);
        return newUser;
    }
}
