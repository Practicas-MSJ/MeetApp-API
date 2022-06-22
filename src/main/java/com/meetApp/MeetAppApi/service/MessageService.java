package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.User;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessages();

    Message deleteMessage(long id);

    Message addMessage(Message message, User user);

    Message modifyMessage(Message message, long id);

    Message findMessage(long id);
}
