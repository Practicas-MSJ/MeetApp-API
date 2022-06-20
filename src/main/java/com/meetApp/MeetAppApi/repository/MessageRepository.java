package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface MessageRepository extends CrudRepository<Message, Long> {
}
