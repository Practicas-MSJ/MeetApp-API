package com.meetApp.MeetAppApi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reminders")
@Table(name = "reminders")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String description;
    @Column(name = "remind_date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference(value = "event-remind")
    private User user;

}
