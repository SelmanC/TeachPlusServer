package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "absences")
@JsonIgnoreProperties(value={ "absenceData", "teacher", "hibernateLazyInitializer", "owner", "handler" }, allowSetters= true)
public class AbsenceList {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length=30)
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="class_id")
    private Group groupClass;

    @NonNull
    @Column(length=30)
    private String subject;

    @ManyToMany
    @JoinTable(name = "absenceTeacher", joinColumns = {
            @JoinColumn(name = "absenceList", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "teacher", referencedColumnName = "id", nullable = false)})
    private List<User> teacher;

    @OneToMany(mappedBy = "absenceList")
    private List<AbsenceData> absenceData;

    public AbsenceList() {}

    public AbsenceList(Long id, String name, Group groupClass, String subject, List<User> teacher, List<AbsenceData> absenceData) {
        this.id = id;
        this.name = name;
        this.groupClass = groupClass;
        this.subject = subject;
        this.teacher = teacher;
        this.absenceData = absenceData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(Group groupClass) {
        this.groupClass = groupClass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<User> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<User> teacher) {
        this.teacher = teacher;
    }

    public List<AbsenceData> getAbsenceData() {
        return absenceData;
    }

    public void setAbsenceData(List<AbsenceData> absenceData) {
        this.absenceData = absenceData;
    }
}
