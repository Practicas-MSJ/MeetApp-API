package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Category;
import com.meetApp.MeetAppApi.domain.Event;
import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.service.CategoryService;
import com.meetApp.MeetAppApi.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MessageService  messageService;

    // Lista todas las categorías
    @GetMapping("/categories")
    public List<Category> getCategories() {
        List<Category> categories;

        categories = categoryService.findAllCategories();

        return categories;
    }

    // Busca una categoría por ID
    @GetMapping("/category/{id}")
    public Category getCategories(@PathVariable long id) {
        Category category = categoryService.findCategory(id);
        return category;
    }

    // Borra una categoría
    @DeleteMapping("/categories/{id}")
    public Category deleteCategory(@PathVariable long id) {
        Category category = categoryService.deleteCategory(id);
        return category;
    }

    // Registra una nueva categoría
    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        Category newCategory = categoryService.addCategory(category);
        return newCategory;
    }

    // Modifica una categoría
    @PutMapping("/category/{id}")
    public Category modifyCategory(@RequestBody Category category, @PathVariable long id) {
        Category newCategory = categoryService.modifyCategory(category, id);
        return newCategory;
    }
}
