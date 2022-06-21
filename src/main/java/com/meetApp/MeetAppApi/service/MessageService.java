package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessages();

    Message deleteMessage(long id);

    Message addMessage(Message message);

    Message modifyMessage(Message message, long id);
}
