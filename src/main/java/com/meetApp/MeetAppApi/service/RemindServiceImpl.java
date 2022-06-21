package com.meetApp.MeetAppApi.service;


import com.meetApp.MeetAppApi.domain.Message;
import com.meetApp.MeetAppApi.domain.Reminder;
import com.meetApp.MeetAppApi.repository.MessageRepository;
import com.meetApp.MeetAppApi.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemindServiceImpl implements RemindService{

    @Autowired
    private RemindRepository remindRepository;

    @Override
    public List<Reminder> findAllReminders() {
        return remindRepository.findAll();
    }

    @Override
    public Reminder deleteReminder(long id) {
        Reminder reminder = remindRepository.findById(id)
                .orElseThrow(null);
        remindRepository.delete(reminder);
        return reminder;
    }

    @Override
    public Reminder addReminder(Reminder reminder) {
        return remindRepository.save(reminder);
    }

    @Override
    public Reminder modifyReminder(Reminder newReminder, long id) {
        Reminder reminder = remindRepository.findById(id)
                .orElseThrow(null);
        reminder.setDescription(newReminder.getDescription());
        reminder.setDate(newReminder.getDate());
        reminder.setName(newReminder.getName());
        reminder.setUser(newReminder.getUser());

        return remindRepository.save(reminder);
    }

    @Override
    public Reminder findReminder(long id) {
        return remindRepository.findById(id)
                .orElseThrow(null);
    }
}
