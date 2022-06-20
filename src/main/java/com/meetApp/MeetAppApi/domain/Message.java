package com.meetApp.MeetAppApi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-message")
    private User user;

    @OneToMany(mappedBy ="message")
    private List<Category> categories;



}
