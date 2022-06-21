package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Event;
import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.service.CategoryService;
import com.meetApp.MeetAppApi.service.EventService;
import com.meetApp.MeetAppApi.service.RemindService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    // Lista todos los eventos
    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events;

        events = eventService.findAllEvents();

        return events;
    }

    // Busca un evento por ID
    @GetMapping("/event/{id}")
    public Event getEvents(@PathVariable long id) {
        return eventService.findEvent(id);
    }

    // Borra un evento
    @DeleteMapping("/event/{id}")
    public Event deleteEvent(@PathVariable long id) {
        Event event = eventService.deleteEvent(id);
        return event;
    }

    // Registra un nuevo evento
    @PostMapping("/event")
    public Event addEvent(@RequestBody Event event) {
        Event newEvent = eventService.addEvent(event);
        return newEvent;
    }

    // Modifica un evento
    @PutMapping("/event/{id}")
    public Event modifyEvent(@RequestBody Event event, @PathVariable long id) {
        Event newEvent = eventService.modifyEvent(event, id);
        return newEvent;
    }



}
