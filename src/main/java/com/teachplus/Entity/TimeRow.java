package com.teachplus.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "time_row")
@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler" }, allowSetters= true)
public class TimeRow {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private int timesheetRow;

    @JsonManagedReference
    @OneToMany(mappedBy = "timeRow", cascade = CascadeType.REMOVE)
    private Collection<TimeSheetData> subjectData;

    @JsonBackReference
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="timecolumn_id")
    private TimeColumn timeColumn;

    public  TimeRow() {}

    public TimeRow(long id, int timesheetRow, Collection<TimeSheetData> subjectData, TimeColumn timeColumn) {
        this.id = id;
        this.timesheetRow = timesheetRow;
        this.subjectData = subjectData;
        this.timeColumn = timeColumn;
    }

    public TimeColumn getTimeColumn() {
        return timeColumn;
    }

    public void setTimeColumn(TimeColumn timeColumn) {
        this.timeColumn = timeColumn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTimesheetRow() {
        return timesheetRow;
    }

    public void setTimesheetRow(int timesheetRow) {
        this.timesheetRow = timesheetRow;
    }

    public Collection<TimeSheetData> getSubjectData() {
        return subjectData;
    }

    public void setSubjectData(Collection<TimeSheetData> subjectData) {
        this.subjectData = subjectData;
    }
}
