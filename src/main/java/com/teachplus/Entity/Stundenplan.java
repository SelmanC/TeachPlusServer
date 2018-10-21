package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teachplus.Entity.Group;
import com.teachplus.Entity.GroupMember;
import com.teachplus.Entity.TimeColumn;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "stundenplan")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class Stundenplan {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(length=30)
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="class_id")
    private Group groupClass;

    @OneToMany(mappedBy = "timeSheet", cascade = CascadeType.REMOVE)
    private Collection<TimeColumn> timeColumns;

    public Stundenplan() {}

    public Stundenplan(long id, String name, Group groupClass, Collection<TimeColumn> timeColumns) {
        this.id = id;
        this.name = name;
        this.groupClass = groupClass;
        this.timeColumns = timeColumns;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Collection<TimeColumn> getTimeColumns() {
        return timeColumns;
    }

    public void setTimeColumns(Collection<TimeColumn> timeColumns) {
        this.timeColumns = timeColumns;
    }
}
