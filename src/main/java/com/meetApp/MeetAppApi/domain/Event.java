package com.meetApp.MeetAppApi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "events")
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String location;
    @Column
    private String description;
    @Column(name = "event_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @Column
    private String name;

    @ManyToMany
    private List<User> users;

    @ManyToMany
    private List<Reminder> reminders;


}
