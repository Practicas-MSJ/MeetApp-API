package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.User;
import com.meetApp.MeetAppApi.service.CategoryService;
import com.meetApp.MeetAppApi.service.MessageService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    // Lista todos los mensajes
    @GetMapping("/messages")
    public List<Message> getMessages() {
        logger.info("Prepare list for all messages");
        List<Message> messages;

        logger.info("Find all messages");
        messages = messageService.findAllMessages();

        logger.info("End find all messages");
        return messages;
    }

    // Busca un mensaje por ID
    @GetMapping("/message/{id}")
    public Message getMessages(@PathVariable long id) {
        logger.info("Get message by ID: " + id);
        Message message = messageService.findMessage(id);

        logger.info("End get message by ID: " + id);
        return message;
    }

    // Borra un mensaje
    @DeleteMapping("/message/{id}")
    public Message deleteMessage(@PathVariable long id) {
        logger.info("Delete message with ID: " + id);
        Message message = messageService.deleteMessage(id);

        logger.info("End delete message with ID: " + id);
        return message;
    }

    // Registra un nuevo mensaje
    @PostMapping("/user/{userId}/message")
    public Message addMessage(@RequestBody Message message, @PathVariable long userId) {
        logger.info("Find user name for new message");
        User user = userService.findUser(userId);

        logger.info("Register a new message", message);
        Message newMessage = messageService.addMessage(message, user);

        logger.info("End register a new message", message);
        return newMessage;
    }

    // Modifica un mensaje
    @PutMapping("/message/{id}")
    public Message modifyMessage(@RequestBody Message message, @PathVariable long id) {
        logger.info("Modify message with ID: " + id, message);
        Message newMessage = messageService.modifyMessage(message, id);

        logger.info("End modify message with ID: " + id, message, newMessage);
        return newMessage;
    }
}
