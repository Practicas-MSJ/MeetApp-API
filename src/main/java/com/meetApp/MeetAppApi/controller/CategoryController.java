package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Category;
import com.meetApp.MeetAppApi.service.CategoryService;
import com.meetApp.MeetAppApi.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MessageService  messageService;

}
