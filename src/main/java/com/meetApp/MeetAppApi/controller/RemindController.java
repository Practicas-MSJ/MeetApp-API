package com.meetApp.MeetAppApi.controller;

import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.Reminder;
import com.meetApp.MeetAppApi.domain.User;
import com.meetApp.MeetAppApi.service.MessageService;
import com.meetApp.MeetAppApi.service.RemindService;
import com.meetApp.MeetAppApi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemindController {

    private final Logger logger = LoggerFactory.getLogger(RemindController.class);

    @Autowired
    private RemindService remindService;

    // Lista todos los recordatorios
    @GetMapping("/reminders")
    public List<Reminder> getReminders() {
        List<Reminder> reminders;

        reminders = remindService.findAllReminders();

        return reminders;
    }

    // Busca un recordatorio por ID
    @GetMapping("/reminder/{id}")
    public Reminder getReminder(@PathVariable long id) {
        Reminder reminder = remindService.findReminder(id);
        return reminder;
    }

    // Borra un recordatorio
    @DeleteMapping("/reminder/{id}")
    public Reminder deleteReminder(@PathVariable long id) {
        Reminder reminder = remindService.deleteReminder(id);
        return reminder;
    }

    // Registra un nuevo recordatorio
    @PostMapping("/reminder")
    public Reminder addReminder(@RequestBody Reminder reminder) {
        Reminder newReminder = remindService.addReminder(reminder);
        return newReminder;
    }

    // Modifica un recordatorio
    @PutMapping("/reminder/{id}")
    public Reminder modifyReminder(@RequestBody Reminder reminder, @PathVariable long id) {
        Reminder newReminder = remindService.modifyReminder(reminder, id);
        return newReminder;
    }

}
