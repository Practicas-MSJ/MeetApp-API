package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findAll();
}
