package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "absenceData")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "owner", "handler" }, allowSetters= true)
public class AbsenceData {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Integer day;

    @NonNull
    private Integer month;

    @Column(length=250)
    private String comment;

    @Column(length = 5)
    private String type;


    @Column(length = 5)
    private String minutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    private User student;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "absence_list_id")
    private AbsenceList absenceList;

    public AbsenceData() {}

    public AbsenceData(Long id, Integer day, Integer month, String comment, String type, AbsenceList absenceList, User student, String minutes) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.comment = comment;
        this.type = type;
        this.absenceList = absenceList;
        this.student = student;
        this.minutes = minutes;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AbsenceList getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(AbsenceList absenceList) {
        this.absenceList = absenceList;
    }
}
