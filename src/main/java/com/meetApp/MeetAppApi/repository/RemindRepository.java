package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.Reminder;
import com.meetApp.MeetAppApi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RemindRepository extends CrudRepository<Reminder, Long> {
    List<Reminder> findAll();
}
