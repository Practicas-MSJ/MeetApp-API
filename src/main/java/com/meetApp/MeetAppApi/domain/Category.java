package com.meetApp.MeetAppApi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private boolean favourite;
    @Column
    private Byte[] photo;

    @ManyToOne
    @JoinColumn(name = "message_id")
    @JsonBackReference(value = "message-category")
    private Message message;

}
