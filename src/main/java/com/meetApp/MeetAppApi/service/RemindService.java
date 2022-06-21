package com.meetApp.MeetAppApi.service;

import com.meetApp.MeetAppApi.domain.Reminder;

import java.util.List;

public interface RemindService {
    List<Reminder> findAllReminders();

    Reminder deleteReminder(long id);

    Reminder addReminder(Reminder reminder);

    Reminder modifyReminder(Reminder reminder, long id);

    Reminder findReminder(long id);
}
