package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Event;
import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event deleteEvent(long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(null);
        eventRepository.delete(event);
        return event;
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event modifyEvent(Event newEvent, long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(null);
        event.setLocation(newEvent.getLocation());
        event.setDescription(newEvent.getDescription());
        event.setDate(newEvent.getDate());
        event.setName(newEvent.getName());
        return event;
    }

    @Override
    public Event findEvent(long id) {
        return eventRepository.findById(id)
                .orElseThrow(null);
    }
}
