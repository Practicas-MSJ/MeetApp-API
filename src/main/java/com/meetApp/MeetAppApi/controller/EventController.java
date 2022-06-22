package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Event;
import com.meetApp.MeetAppApi.service.EventService;
import com.meetApp.MeetAppApi.service.RemindService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private RemindService remindService;

    // Lista todos los eventos
    @GetMapping("/events")
    public List<Event> getEvents() {
        logger.info("Prepare list for all events");
        List<Event> events;

        logger.info("Find all events");
        events = eventService.findAllEvents();

        logger.info("End find all events");
        return events;
    }

    // Busca un evento por ID
    @GetMapping("/event/{id}")
    public Event getEvents(@PathVariable long id) {
        logger.info("Find event by ID: " + id);
        Event event = eventService.findEvent(id);

        logger.info("Enda find event by ID: " + id);
        return event;
    }

    // Borra un evento
    @DeleteMapping("/events/{id}")
    public Event deleteEvent(@PathVariable long id) {
        logger.info("Delete event with ID: " + id);
        Event event = eventService.deleteEvent(id);

        logger.info("End delete event with ID: " + id);
        return event;
    }

    // Registra un nuevo evento
    @PostMapping("/event")
    public Event addEvent(@RequestBody Event event) {
        logger.info("Register a new event", event);
        Event newEvent = eventService.addEvent(event);

        logger.info("End register a new event", event);
        return newEvent;
    }

    // Modifica un evento
    @PutMapping("/event/{id}")
    public Event modifyEvent(@RequestBody Event event, @PathVariable long id) {
        logger.info("Modify event with ID: " + id, event);
        Event newEvent = eventService.modifyEvent(event, id);

        logger.info("End modify event with ID: " + id, event, newEvent);
        return newEvent;
    }



}
