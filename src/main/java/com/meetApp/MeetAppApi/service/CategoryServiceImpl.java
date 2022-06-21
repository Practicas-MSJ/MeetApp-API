package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Category;
import com.meetApp.MeetAppApi.domain.Event;
import com.meetApp.MeetAppApi.repository.CategoryRepository;
import com.meetApp.MeetAppApi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category deleteCategory(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(null);
        categoryRepository.delete(category);
        return category;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category modifyCategory(Category newCategory, long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(null);
        category.setDescription(newCategory.getDescription());
        category.setFavourite(newCategory.isFavourite());
        category.setMessage(newCategory.getMessage());
        category.setName(newCategory.getName());
        category.setPhoto(newCategory.getPhoto());
        return category;
    }
}
