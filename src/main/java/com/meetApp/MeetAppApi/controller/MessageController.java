package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.service.CategoryService;
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
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    // Lista todos los mensajes
    @GetMapping("/messages")
    public List<Message> getMessages() {
        List<Message> messages;

        messages = messageService.findAllMessages();

        return messages;
    }

    // Busca un mensaje por ID
    @GetMapping("/message/{id}")
    public Message getMessages(@PathVariable long id) {
        Message message = messageService.findMessage(id);
        return message;
    }

    // Borra un mensaje
    @DeleteMapping("/message/{id}")
    public Message deleteMessage(@PathVariable long id) {
        Message message = messageService.deleteMessage(id);
        return message;
    }

    // Registra un nuevo mensaje
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        Message newMessage = messageService.addMessage(message);
        return newMessage;
    }

    // Modifica un mensaje
    @PutMapping("/message/{id}")
    public Message modifyMessage(@RequestBody Message message, @PathVariable long id) {
        Message newMessage = messageService.modifyMessage(message, id);
        return newMessage;
    }
}
