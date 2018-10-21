package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vertretungen")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class Vertretung {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(length=30)
    private String title;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_class_id")
    private Group groupClass;

    @NonNull
    private Date date;

    @NonNull
    @Column(length=30)
    private String subject;


    @NonNull
    @Column(length=5)
    private String hour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "substitute_id")
    private User substitute;

    @Column(length=5)
    private String delay;

    @Column(length=15)
    private String room;

    @Column(length=200)
    private String comment;

    public Vertretung() {}

    public Vertretung(long id, String title, Group groupClass, Date date, String subject, String hour, User substitute, String delay, String room, String comment) {
        this.id = id;
        this.title = title;
        this.groupClass = groupClass;
        this.date = date;
        this.subject = subject;
        this.hour = hour;
        this.substitute = substitute;
        this.delay = delay;
        this.room = room;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Group getGroupClass() {
        return groupClass;
    }

    public String getGroupClassName() {
        return groupClass != null ? groupClass.getName() : "";
    }

    public void setGroupClass(Group groupClass) {
        this.groupClass = groupClass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getSubstitute() {
        return substitute;
    }

    public void setSubstitute(User substitute) {
        this.substitute = substitute;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
