package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "timesheet_data")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class TimeSheetData {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id")
    User teacher;

    @JsonBackReference
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="timerow_id")
    TimeRow timeRow;

    @NonNull
    @Column(length=30)
    String room;

    @NonNull
    @Column(length=30)
    String subject;

    @Column(length=30)
    String color;

    public TimeSheetData() {}

    public TimeSheetData(long id, User teacher, String room, String subject, TimeRow timeRow, String color) {
        this.id = id;
        this.teacher = teacher;
        this.room = room;
        this.subject = subject;
        this.timeRow = timeRow;
        this.color = color;
    }

    public TimeRow getTimeRow() {
        return timeRow;
    }

    public void setTimeRow(TimeRow timeRow) {
        this.timeRow = timeRow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
