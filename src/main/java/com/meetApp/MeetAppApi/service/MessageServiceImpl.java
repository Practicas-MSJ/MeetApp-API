package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.User;
import com.meetApp.MeetAppApi.repository.MessageRepository;
import com.meetApp.MeetAppApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message deleteMessage(long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(null);
        messageRepository.delete(message);
        return message;
    }

    @Override
    public Message addMessage(Message message, User user) {
        message.setUser(user);
        return messageRepository.save(message);
    }

    @Override
    public Message modifyMessage(Message newMessage, long id) {
        Message mess = messageRepository.findById(id)
                .orElseThrow(null);
        mess.setText(newMessage.getText());
        mess.setDate(newMessage.getDate());
        mess.setFavourite(newMessage.isFavourite());
        mess.setUser(newMessage.getUser());
        mess.setCategory(newMessage.getCategory());

        return messageRepository.save(mess);
    }

    @Override
    public Message findMessage(long id) {
        return messageRepository.findById(id)
                .orElseThrow(null);
    }
}
