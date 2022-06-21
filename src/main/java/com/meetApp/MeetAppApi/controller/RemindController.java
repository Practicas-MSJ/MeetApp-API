package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.service.MessageService;
import com.meetApp.MeetAppApi.service.RemindService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemindController {

    private final Logger logger = LoggerFactory.getLogger(RemindController.class);

    @Autowired
    private RemindService remindService;

    @Autowired
    private UserService userService;

}
