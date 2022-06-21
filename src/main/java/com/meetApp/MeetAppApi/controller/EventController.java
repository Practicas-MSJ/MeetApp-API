package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.service.CategoryService;
import com.meetApp.MeetAppApi.service.EventService;
import com.meetApp.MeetAppApi.service.RemindService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private RemindService remindService;



}
