package com.meetApp.MeetAppApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "messages")
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String text;
    @Column(name = "message_date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @Column
    private boolean favourite;
    @Column
    private Byte[] image;

}
