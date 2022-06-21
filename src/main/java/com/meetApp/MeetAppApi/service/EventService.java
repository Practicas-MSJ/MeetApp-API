package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Event;

import java.util.List;

public interface EventService {
    List<Event> findAllEvents();

    Event deleteEvent(long id);

    Event addEvent(Event event);

    Event modifyEvent(Event event, long id);

    Event findEvent(long id);
}
