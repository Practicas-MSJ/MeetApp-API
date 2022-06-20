package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.Reminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RemindRepository extends CrudRepository<Reminder, Long> {
}
