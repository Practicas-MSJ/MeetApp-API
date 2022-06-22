package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Category;
import com.meetApp.MeetAppApi.service.CategoryService;
import com.meetApp.MeetAppApi.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        logger.info("Prepare list for all categories");
        List<Category> categories;

        logger.info("Find all categories");
        categories = categoryService.findAllCategories();

        logger.info("End find all categories");

        return categories;
    }

    // Busca una categoría por ID
    @GetMapping("/category/{id}")
    public Category getCategories(@PathVariable long id) {
        logger.info("Find category by ID: " + id);
        Category category = categoryService.findCategory(id);

        logger.info("End search category by ID: " + id);
        return category;
    }

    // Borra una categoría
    @DeleteMapping("/categories/{id}")
    public Category deleteCategory(@PathVariable long id) {
        logger.info("Delete category with ID: " + id);
        Category category = categoryService.deleteCategory(id);

        logger.info("End delete category with ID: " + id);
        return category;
    }

    // Registra una nueva categoría
    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        logger.info("Register a new category: ", category);
        Category newCategory = categoryService.addCategory(category);

        logger.info("End register category: ", category);
        return newCategory;
    }

    // Modifica una categoría
    @PutMapping("/category/{id}")
    public Category modifyCategory(@RequestBody Category category, @PathVariable long id) {
        logger.info("Modify category with ID: " + id, category);
        Category newCategory = categoryService.modifyCategory(category, id);

        logger.info("End modify category with ID: " + id, category, newCategory);
        return newCategory;
    }
}
