package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "time_column")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class TimeColumn {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private int timesheetColumn;

    @Column(length=10)
    private String startTime;

    @Column(length=10)
    private String endTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "timeColumn", cascade = CascadeType.REMOVE)
    private Collection<TimeRow> rows;

    @JsonBackReference
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stundenplan_id")
    private Stundenplan timeSheet;

    public TimeColumn() {}

    public TimeColumn(long id, int timesheetColumn, String startTime, String endTime, Collection<TimeRow> rows, Stundenplan timeSheet) {
        this.id = id;
        this.timesheetColumn = timesheetColumn;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rows = rows;
        this.timeSheet = timeSheet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTimesheetColumn() {
        return timesheetColumn;
    }

    public void setTimesheetColumn(int timesheetColumn) {
        this.timesheetColumn = timesheetColumn;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Collection<TimeRow> getRows() {
        return rows;
    }

    public void setRows(Collection<TimeRow> rows) {
        this.rows = rows;
    }

    public Stundenplan getTimeSheet() {
        return timeSheet;
    }

    public void setTimeSheet(Stundenplan timeSheet) {
        this.timeSheet = timeSheet;
    }
}
