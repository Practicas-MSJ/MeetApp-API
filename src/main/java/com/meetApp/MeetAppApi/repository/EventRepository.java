package com.meetApp.MeetAppApi.repository;

import com.meetApp.MeetAppApi.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface EventRepository  extends CrudRepository<Event, Long> {
}
