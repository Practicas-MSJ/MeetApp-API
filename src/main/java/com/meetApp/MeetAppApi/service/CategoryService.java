package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();

    Category deleteCategory(long id);

    Category addCategory(Category category);

    Category modifyCategory(Category category, long id);
}
