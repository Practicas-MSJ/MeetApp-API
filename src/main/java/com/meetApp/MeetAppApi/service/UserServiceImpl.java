package com.meetApp.MeetAppApi.service;


import com.meetApp.MeetAppApi.domain.Event;
import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.User;
import com.meetApp.MeetAppApi.repository.EventRepository;
import com.meetApp.MeetAppApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(null);
        userRepository.delete(user);
        return user;

    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User modifyUser(User newUser, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(null);
        user.setName(newUser.getName());
        user.setPass(newUser.getPass());
        user.setEmail(newUser.getEmail());
        user.setPhoto(newUser.getPhoto());
        return userRepository.save(user);

    }

    @Override
    public User findUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(null);
    }
}
