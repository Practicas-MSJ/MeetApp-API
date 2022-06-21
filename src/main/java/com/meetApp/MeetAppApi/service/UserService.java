package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User deleteUser(long id);

    User addUser(User user);

    User modifyUser(User user, long id);
}
