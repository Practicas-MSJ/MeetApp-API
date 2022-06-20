package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
