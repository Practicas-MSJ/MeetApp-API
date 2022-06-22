package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Reminder;
import com.meetApp.MeetAppApi.service.RemindService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemindController {

    private final Logger logger = LoggerFactory.getLogger(RemindController.class);

    @Autowired
    private RemindService remindService;

    @Autowired
    private UserService userService;


    // Lista todos los recordatorios
    @GetMapping("/reminders")
    public List<Reminder> getReminders() {
        logger.info("Prepare list for all reminders");
        List<Reminder> reminders;

        logger.info("Find all reminders");
        reminders = remindService.findAllReminders();

        logger.info("End find all reminders");
        return reminders;
    }

    // Busca un recordatorio por ID
    @GetMapping("/reminder/{id}")
    public Reminder getReminder(@PathVariable long id) {
        logger.info("Find reminder by ID: " + id);
        Reminder reminder = remindService.findReminder(id);

        logger.info("End find reminder by ID: " + id);
        return reminder;
    }

    // Borra un recordatorio
    @DeleteMapping("/reminders/{id}")
    public Reminder deleteReminder(@PathVariable long id) {
        logger.info("Delete reminder with ID: " + id);
        Reminder reminder = remindService.deleteReminder(id);

        logger.info("End delete reminder with ID: " + id);
        return reminder;
    }

    // Registra un nuevo recordatorio
    @PostMapping("/reminder")
    public Reminder addReminder(@RequestBody Reminder reminder) {
        logger.info("Register a new reminder", reminder);
        Reminder newReminder = remindService.addReminder(reminder);

        logger.info("End register a new reminder", reminder);
        return newReminder;
    }

    // Modifica un recordatorio
    @PutMapping("/reminder/{id}")
    public Reminder modifyReminder(@RequestBody Reminder reminder, @PathVariable long id) {
        logger.info("Modify reminder with ID: " + id, reminder);
        Reminder newReminder = remindService.modifyReminder(reminder, id);

        logger.info("End modify reminder with ID: " + id, reminder, newReminder);
        return newReminder;
    }

}
