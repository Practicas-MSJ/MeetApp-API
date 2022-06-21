package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.service.EventService;
import com.meetApp.MeetAppApi.service.MessageService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private EventService eventService;

}
