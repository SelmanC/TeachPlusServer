package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "owner", "handler" }, allowSetters= true)
public class Note {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length=30)
    private String title;

    @NonNull
    @Column(length=30)
    private String subject;

    @NonNull
    @Column(length=250)
    private String note;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    private boolean finished;

    public  Note() {}

    public Note(Long id, String title, String subject, String note, boolean finished, User owner) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.note = note;
        this.finished = finished;
        this.owner = owner;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
