package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<User, Long> {
}
